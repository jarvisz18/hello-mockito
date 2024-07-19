package com.ixan.example.test.util;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date 2024/7/19 下午9:23
 * @description message format test
 */
public class MessageFormatTest {

    @Test
    public void test_format_fail() {
        String pattern = "can't open vd#{0}";
        String result = MessageFormat.format(pattern, "2399");
        System.out.println(result);
        Assert.assertEquals("cant open vd#{0}", result);
    }

    @Test
    public void test_format_success() {
        String pattern = "can not open vd#{0}";
        String result = MessageFormat.format(pattern, "2399");
        System.out.println(result);
        Assert.assertEquals("can not open vd#2399", result);
    }
}
