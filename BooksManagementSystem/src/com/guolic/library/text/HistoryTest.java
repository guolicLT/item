package com.guolic.library.text;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.guolic.library.dao.HistoryDAO;
import com.guolic.library.dao.realize.HistoryDAOImpl;
import com.guolic.library.emtity.History;
import com.guolic.library.service.UserService;
import com.guolic.library.service.realize.UserServiceRealize;
import com.guolic.library.util.StringUtil;
import com.guolic.library.util.UUIDUtil;

public class HistoryTest {
    private HistoryDAO historyDAO = new HistoryDAOImpl();
    private UserService userService = new UserServiceRealize();
    @Test
    public void addOne() throws SQLException {
        History  history = new History(UUIDUtil.generateUUID(),
                                "2568f28fc166416da2606d2c0e53a209",
                                "4c147b83838a40a09bedd1491745c288",
                                StringUtil.generateDateString(new Date())
                                );
        historyDAO.addOne(history);
    }
    @Test
    public void queryAllHistory() throws Exception {
        System.out.println(userService.queryAllHistoryByUserId("8ef56ea33af8444f84362f43e6752054"));
    }
    @Test
    public void updateReturnTime() throws SQLException {
        historyDAO.updateReturnTime("76c207e7f90c4ecfa913e6ee16f95f54", StringUtil.generateDateString(new Date()));
        
    }
 
}
