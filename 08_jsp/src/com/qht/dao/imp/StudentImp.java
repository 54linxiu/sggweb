package com.qht.dao.imp;

import com.qht.dao.StudentDao;
import com.qht.pojo.Student;

import java.util.List;

public class StudentImp extends BaseDAO implements StudentDao {
    @Override
    public List<Student> getLikestu(String name) {

        String sql = "SELECT * FROM students WHERE NAME LIKE ?";
        return queryForList(Student.class,sql,name+"%");
    }
}
