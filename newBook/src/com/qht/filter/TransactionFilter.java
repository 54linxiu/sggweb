package com.qht.filter;

import com.qht.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JDBCUtils.commitAndClose();// 提交事务
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();//回滚
            e.printStackTrace();
            throw new RuntimeException(e);// 把异常抛给 Tomcat
        }
    }

    @Override
    public void destroy() {

    }
}
