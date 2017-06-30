package com.bnade.wow.client.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by liufeng0103@163.com on 2017/6/30.
 */
public class IOUtilsTest {

    @Test
    public void inputStreamToStringTest() throws Exception {
        InputStream is = new ByteArrayInputStream("测试".getBytes("utf-8"));
        Assert.assertEquals("测试", IOUtils.inputStreamToString(is, "utf-8"));
    }

}