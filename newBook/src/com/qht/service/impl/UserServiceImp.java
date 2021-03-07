package com.qht.service.impl;

import com.qht.dao.UserDao;
import com.qht.dao.impl.UserDaoImpl;
import com.qht.pojo.User;
import com.qht.service.UserService;

public class UserServiceImp implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUserUsername(String username) {
        if(userDao.queryUserByUsername(username) != null){
            return true;
        }else{
            return false;
        }
    }
}
