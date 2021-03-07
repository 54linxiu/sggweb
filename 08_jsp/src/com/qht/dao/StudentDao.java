package com.qht.dao;

import com.qht.pojo.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 模糊查询 学生信息
     * @param name
     * @return
     */
    public List<Student> getLikestu(String name);
}
