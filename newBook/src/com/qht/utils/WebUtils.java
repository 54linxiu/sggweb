package com.qht.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public abstract class WebUtils {

    public static <T> T copyParamToBean(Map map, T bean){

        try {
            System.out.println("注入之前"+bean);

            BeanUtils.populate(bean,map);

            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            System.out.println(strInt+"parse NO");
//            e.printStackTrace();
        }
        return defaultValue;
    }

}
