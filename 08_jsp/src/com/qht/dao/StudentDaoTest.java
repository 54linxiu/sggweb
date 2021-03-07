package com.qht.dao;

import com.qht.dao.imp.StudentImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoTest {
    private StudentDao d= new StudentImp();

    @Test
    public void getLikestu() {
        System.out.println(d.getLikestu("张"));
    }
}