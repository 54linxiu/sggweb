package com.qht.dao;

import com.qht.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null 说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 查询用户根据用户名跟密码
     * @param name
     * @param password
     * @return 如果返回null 说明用户或密码错误
     */
    public User queryUserByUsernameAndPassword(String name,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 如果返回-1 操作失败
     */
    public int saveUser(User user);

}
