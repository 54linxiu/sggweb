package com.qht.test;

import com.qht.pojo.User;
import com.qht.service.UserService;
import com.qht.service.impl.UserServiceImp;
import org.junit.Test;

public class UserServiceTest {

    UserService us = new UserServiceImp();

    @Test
    public void registUser() {
        us.registUser(new User(null,"海老名","qwer","qiekenoao@q.c"));
    }

    @Test
    public void login() {
        if(us.login(new User(null,"海老名","qwer","qiekenoao@q.c")) != null){
            System.out.println("登陆成功");
        }else{
            System.out.println("账号或密码错误");
        }
    }


    @Test
    public void existsUserUsername() {
        if(us.existsUserUsername("海名")){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名不存在");
        }
    }
}