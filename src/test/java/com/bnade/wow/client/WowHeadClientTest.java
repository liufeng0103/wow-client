package com.bnade.wow.client;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * WowHeadClient测试
 * Created by liufeng0103@163.com on 2017/6/30.
 */
public class WowHeadClientTest {

    @Test
    public void getInstanceTest() throws Exception {
        WowHeadClient wowHeadClient = WowHeadClient.getInstance();
        WowHeadClient wowHeadClient1 = WowHeadClient.getInstance();
        Assert.assertEquals(true, wowHeadClient == wowHeadClient1);
    }

    @Test
    public void getItemTest() throws Exception {
        System.out.println(WowHeadClient.getInstance().getItem(124105));
    }

}