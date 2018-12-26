package com.guolic.library.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import com.guolic.library.annotation.Transactional;


public class TransactionProxyUtil {
    private TransactionProxyUtil() {
        // TODO Auto-generated constructor stub
    }
    public static <T> T generateProxy(T t) {
       @SuppressWarnings("unchecked")
    T instance = (T)Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new InvocationHandler() {
                    Object result = null;
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                      //只有被注解修饰的方法才增强
                     // 如果方法上有@Transactional注解
                        if(method.isAnnotationPresent(Transactional.class)) {
                         // 开启事务
                            Connection connection = JDBCUtil.getConnection();
                            //关闭自动提交
                            connection.setAutoCommit(false);
                            try {
                                result = method.invoke(t, args);
                                connection.commit();
                            } catch (Exception e) {
                                connection.rollback();
                                throw new SQLException();
                            }finally {
                                //将事务设置状态还原
                                connection.setAutoCommit(true);
                            }
                        }else {
                           result = method.invoke(t, args);
                        }
                        return result;
                    }
                });
        return instance;
        
    }
}
