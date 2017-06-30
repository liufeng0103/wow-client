package com.bnade.wow.client.util;

import org.junit.Test;

/**
 * HttpUtils测试
 * Created by liufeng0103@163.com on 2017/6/30.
 */
public class HttpUtilsTest {

    @Test
    public void getHeaderFieldsTest() throws Exception {
        String url = "http://auction-api-cn.worldofwarcraft.com/auction-data/aaaff45cf244c3cdfecc06db745dcc30/auctions.json";
        System.out.println(HttpUtils.getHeaderFields(url));
    }

    @Test
    public void getTest() throws Exception {
        String url = "https://www.baidu.com/";
        System.out.println(HttpUtils.get(url));
    }

}