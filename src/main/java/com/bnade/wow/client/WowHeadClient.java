package com.bnade.wow.client;

import com.bnade.wow.client.util.HttpUtils;
import com.bnade.wow.client.model.XItem;
import com.bnade.wow.client.model.XWowHead;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;

/**
 * 基于<a href="www.wowhead.com">wowhead</a>开放的API封装的java客户端
 * 由于国服的战网api关闭，为了获取新物品的信息，主要是为了物品的中文名，写了wowhead的客户端来获取物品信息
 *
 * Created by liufeng0103@163.com on 2017/6/30.
 */
public class WowHeadClient {

    private static WowHeadClient wowHeadClient;

    private WowHeadClient() {}

    public static WowHeadClient getInstance() {
        return wowHeadClient == null ? wowHeadClient = new WowHeadClient() : wowHeadClient;
    }

    /**
     * 通过物品ID获取物品信息
     * wowhead提供 http://cn.wowhead.com/item=124311&xml 接口查询某个物品，结果是xml格式
     * 这个方法主要将xml转化成javabean
     *
     * @param itemId 物品ID
     * @return 物品信息
     */
    public XItem getItem(Integer itemId) {
        XItem item;
        if (itemId == null) {
            return null;
        } else {
            try {
                String xml = getItemXmlByItemId(itemId);
                item = convertXmlToJavaBean(xml, XWowHead.class).getItem();
            } catch (IOException | JAXBException e) {
                throw new WowHeadClientException("通过wowhead api获取物品信息出错", e);
            }
        }
        return item;
    }

    /**
     * 通过itemId获取wowhead api的物品信息，xml格式
     * @param itemId 物品ID
     * @return xml
     * @throws IOException 网络连接异常
     */
    private String getItemXmlByItemId(Integer itemId) throws IOException {
        String url = "http://cn.wowhead.com/item=" + itemId + "&xml";
        /*
          	解析XML文件时，会碰到程序发生以下一些异常信息：
            在 CDATA 节中找到无效的 XML 字符 (Unicode: 0x1f)。
            或者：
            An invalid XML character (Unicode: 0x1f) was found in the CDATA section.
            这些错误的发生是由于一些不可见的特殊字符的存在，而这些字符对于XML文件来说又是非法的，所以XML解析器在解析时会发生异常，官方定义了XML的无效字符分为三段：
            0x00 - 0x08
            0x0b - 0x0c
            0x0e - 0x1f
            解决方法是：在解析之前先把字符串中的这些非法字符过滤掉即可， 不会影响原来文本的内容。
            即：string.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "")
            另外：这些字符即使放在CDATA中仍然解析不了，所以最好的办法是过滤掉。
         */
        return HttpUtils.get(url).replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
    }

    /**
     * Xml转化成javabean
     * @param xml xml
     * @param c 需要转化的javabean的class
     * @param <T> 同c类型
     * @return javabean
     * @throws JAXBException 转化异常
     */
    private <T> T convertXmlToJavaBean(String xml, Class<T> c) throws JAXBException {
        return (T) JAXBContext.newInstance(c).createUnmarshaller().unmarshal(new StringReader(xml));
    }

}
