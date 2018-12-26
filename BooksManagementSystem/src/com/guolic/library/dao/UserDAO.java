package com.guolic.library.dao;

import java.sql.SQLException;

import com.guolic.library.emtity.History;
import com.guolic.library.emtity.User;


public interface UserDAO {
    void addOne(User user) throws SQLException,Exception;
    void removeOneUserByAccountAndPassword(String account, String password) throws Exception;
    User queryOneUserByAccount(String account) throws SQLException ;
    User queryOneByAccountAndPassword(String name, String password) throws SQLException;
}
