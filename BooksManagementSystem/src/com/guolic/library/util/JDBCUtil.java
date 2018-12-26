package com.guolic.library.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

    private JDBCUtil() {
        // TODO Auto-generated constructor stub
    }
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    
    /**
     * 获取数据库连接
     * 从ThreadLocal中获取
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        Connection connection=threadLocal.get();
        if(connection==null) {
            connection=dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    
    
    /**
     * 获取数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
    
    
}
