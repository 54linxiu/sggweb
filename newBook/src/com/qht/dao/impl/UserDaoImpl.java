package com.qht.dao.impl;

import com.qht.dao.UserDao;
import com.qht.pojo.User;

public class UserDaoImpl extends BaseDAO implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `username`,`password`,`email` from t_user where `username` = ?";
        User user = queryForOne(User.class, sql, username);
        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String name, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username` = ? and `password` = ?";
        User user = queryForOne(User.class, sql, name,password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        int update = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }
}
