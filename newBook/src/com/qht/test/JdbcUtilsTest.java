package com.qht.test;

import com.qht.utils.JDBCUtils;
import org.junit.Test;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        System.out.println(JDBCUtils.getConnection());//获取资源记得释放
    }
}
