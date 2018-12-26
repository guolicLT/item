package com.guolic.library.service.realize;

import java.sql.SQLException;
import java.util.List;

import com.guolic.library.constants.Constants;
import com.guolic.library.dao.BookDAO;
import com.guolic.library.dao.HistoryDAO;
import com.guolic.library.dao.UserDAO;
import com.guolic.library.dao.realize.BookDAORealize;
import com.guolic.library.dao.realize.HistoryDAOImpl;
import com.guolic.library.dao.realize.UserDAORealize;
import com.guolic.library.emtity.History;
import com.guolic.library.emtity.User;
import com.guolic.library.service.UserService;

public class UserServiceRealize implements UserService{
    private BookDAO bookDAO = new BookDAORealize();
    private UserDAO userDAO = new UserDAORealize();
    private HistoryDAO historyDAO = new HistoryDAOImpl();
    public UserServiceRealize() {
        
    }

    @Override
    public void addOneUser(User user) throws Exception {
        userDAO.addOne(user);
    }

    @Override
    public User queryOneUserByAccount(String name) throws SQLException {
        return userDAO.queryOneUserByAccount(name);
    }

    @Override
    public void removeOneUserByAccountAndPassword(String account, String password) throws Exception {
       userDAO.removeOneUserByAccountAndPassword(account, password);
        
    }

    @Override
    public User queryOneUserByAccountAndPassword(String account, String password) throws Exception {
        return userDAO.queryOneByAccountAndPassword(account, password);
        
    }

    @Override
    public void borrow(History history) throws SQLException {
        /*
         * 注意：为了保证两个dao在执行借阅操作时，能够使用同一个connection并且在同一个事务中
         *  理论上说，我可以就在这个方法，获取连接，然后将连接传入到dao中的方法中。
         *  但是，这样写是非常有问题的。因为我们既然分层了，那么service就不应该出现任何jdbc的接口类。所以说，这种方案pass。
         *  
         * 解决方案
         *  1)解决不传connection给dao，但是能保证两个dao拿到同一个connection
         *      ThreadLocal
         *  2)事务的开启和提交，回滚代码等在哪做?
         *      理想中是这样的
         *      try{
         *          执行第一条sql
         *          执行第二条sql
         *      }catch{
         *          回滚
         *      }
         *  
         *      动态代理
         *      
         */
        // 将书的状态改为不可借
        bookDAO.updateIsBorrowByBookId(history.getBid(), Constants.CANNOT_BORROW);
        // 在历史表中插入借阅记录
        historyDAO.addOne(history); 
    }

    @Override
    public List<History> queryAllHistoryByUserId(String uid) throws SQLException {
        // TODO Auto-generated method stub
        return historyDAO.queryAllHistoryByUid(uid);
    }

    @Override
    public void returnBook(String hid, String bid, String returnTime) throws Exception{
        bookDAO.updateIsBorrowByBookId(bid, Constants.CAN_BORROW);
        historyDAO.updateReturnTime(hid, returnTime);
    }

}
