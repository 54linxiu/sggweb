package com.qht.service;

import com.qht.pojo.User;

public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void registUser(User user);

    /**
     * 登陆
     * @param user
     * @return 存在返回true 不存在返回false
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 存在返回true 不存在返回false
     */
    public boolean existsUserUsername(String username);
}
