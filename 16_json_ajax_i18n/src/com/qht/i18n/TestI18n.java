package com.qht.i18n;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestI18n {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 得到我们需要的 Locale 对象
        Locale locale = Locale.CHINA;
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println(new String(bundle.getString("regist").getBytes("ISO-8859-1"),"UTF-8"));
    }
    @Test
    public void testI18n()  {
// 得到我们需要的 Locale 对象
        Locale locale = Locale.US;
// 通过指定的 basename 和 Locale 对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);



        System.out.println("username：" + bundle.getString("username"));
        System.out.println("password：" + bundle.getString("password"));
        System.out.println("Sex：" + bundle.getString("sex"));
        System.out.println("age：" + bundle.getString("age"));
    }
}
