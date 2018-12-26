package com.guolic.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guolic.library.constants.Constants;
import com.guolic.library.controller.base.AbstractBaseServlet;
import com.guolic.library.emtity.History;
import com.guolic.library.emtity.User;
import com.guolic.library.service.UserService;
import com.guolic.library.service.realize.UserServiceRealize;
import com.guolic.library.util.StringUtil;
import com.guolic.library.util.TransactionProxyUtil;
import com.guolic.library.util.UUIDUtil;

@WebServlet("/user")
public class UserOperateServlet extends AbstractBaseServlet{
    private UserService userService = TransactionProxyUtil.generateProxy(new UserServiceRealize());
    public String borrowOneBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        History history = new History();
        String bid = req.getParameter("bid");
        User user = (User)req.getSession().getAttribute("user");
        String uid = user.getId();
        history.setId(UUIDUtil.generateUUID());
        history.setBid(bid);
        history.setUid(uid);
        history.setBorrow_time(StringUtil.generateDateString(new Date()));
        try {
            userService.borrow(history);
            resp.getWriter().write(Constants.SUCCESS);
        } catch (Exception e) {
            resp.getWriter().write(Constants.FAIL);
        }
        return null;
        
    }
    
    public String showMyHistory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user =(User) req.getSession().getAttribute("user");
        String uid = user.getId();
        List<History> historys = userService.queryAllHistoryByUserId(uid);
        req.setAttribute("historys", historys);
        return "f:myHistorys";
        
    }
    
    public String returnBack(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String bid = req.getParameter("bid");
        String hid = req.getParameter("hid");
        try {
            userService.returnBook(hid, bid, StringUtil.generateDateString(new Date()));
            resp.getWriter().write(Constants.SUCCESS);
        } catch (Exception e) {
            resp.getWriter().write(Constants.FAIL);
            e.printStackTrace();
        }
        return null;
        
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        return null;
    }

}
