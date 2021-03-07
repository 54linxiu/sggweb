package com.qht.test;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("login");
    }
    public void regist(){
        System.out.println("regist");
    }
    public void updete(){
        System.out.println("updete");
    }

    public static void main(String[] args){
        String action = "regist";

        try {
            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);
            declaredMethod.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
