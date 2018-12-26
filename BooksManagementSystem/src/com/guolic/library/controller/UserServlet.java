package com.guolic.library.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guolic.library.constants.Constants;
import com.guolic.library.controller.base.AbstractBaseServlet;
import com.guolic.library.emtity.User;
import com.guolic.library.service.UserService;
import com.guolic.library.service.realize.UserServiceRealize;
import com.guolic.library.util.EmptyUtil;
import com.guolic.library.util.UUIDUtil;
@WebServlet("/user.do")
public class UserServlet extends AbstractBaseServlet{
    private UserService userService = new UserServiceRealize();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        return null;
    }
    public String registry(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = new User();
        user.setId(UUIDUtil.generateUUID());
        user.setAccount(account);
        user.setPassword(password);
        userService.addOneUser(user);
        return null;
        
    }

    public String checkName(HttpServletRequest req, HttpServletResponse resp)  throws Exception {
        String name = req.getParameter("name");
        if(name == null) {
            resp.getWriter().write(Constants.NAME_EXIST);
            return null;
        }
        User user = userService.queryOneUserByAccount(name);
        if(user!=null) {
            resp.getWriter().write(Constants.NAME_EXIST);
        }else {
            resp.getWriter().write(Constants.NAME_NOT_EXIST);
        }
        return null;
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if(!EmptyUtil.isEmpty(account) && !EmptyUtil.isEmpty(password)) {
           User user = userService.queryOneUserByAccountAndPassword(account, password);
           if(user == null) {
               resp.getWriter().write(Constants.FAIL);
           }else {
               //登录成功
               req.getSession().setAttribute("user", user);
               String autoLogin = req.getParameter("autoLogin");
               if(!EmptyUtil.isEmpty(autoLogin)) {
                   Cookie cookie = new Cookie("autoLogin", URLEncoder.encode(account + "#" + password, "utf-8"));
                   cookie.setMaxAge(Constants.THREE_DAYS);
                   resp.addCookie(cookie);
               }
               resp.getWriter().write(Constants.SUCCESS);
        
           }
        }
        
    }
    public String logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.getSession().invalidate();
        //删除Cookie autoLogin
        Cookie cookie=new Cookie("autoLogin", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        return "f:home";
    }
    
}
