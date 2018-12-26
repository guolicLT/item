package com.guolic.library.controller.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guolic.library.util.EmptyUtil;
import com.guolic.library.util.PropertiesUtil;

public abstract class AbstractBaseServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(EmptyUtil.isEmpty(method)) {
            method = "execute";
        }
        /*
         * 反射调用method方法: 获取子类对象的class对象 获取名为method的方法 调用
         */
        try {
            Method method2 = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            Object resultObject = method2.invoke(this, req,resp);
         // 解析返回值判断是否为空以及是否为String实例；
            if(resultObject instanceof String) {
                String view = (String) resultObject;
                String logicView  = view.split(":")[1];
             // 根据逻辑视图去查找实际的视图，需要去views-mapping的文件中找
                String value = PropertiesUtil.getValue(logicView);
                String contextPath = getServletContext().getContextPath();
                String path=contextPath+ value;
                // 如果是以f:
                if (view.startsWith("f:")) {
                    req.getRequestDispatcher(value).forward(req, resp);
                } else {
                    resp.sendRedirect(path);
                }

                
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      
        }
    }
    public abstract String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
}



