package com.qht.test;

import com.qht.dao.UserDao;
import com.qht.dao.impl.UserDaoImpl;
import com.qht.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao u = new UserDaoImpl();
        System.out.println(u.queryUserByUsername("林修"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao u = new UserDaoImpl();
        System.out.println(u.queryUserByUsernameAndPassword("qht","qht"));
    }

    @Test
    public void saveUser() {
        UserDao u = new UserDaoImpl();
        User user = new User(null,"林w","010515qht.","linxiu@lx.xx");
        System.out.println(u.saveUser(user));
    }
}