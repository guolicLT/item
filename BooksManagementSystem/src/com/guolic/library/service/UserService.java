package com.guolic.library.service;


import java.util.List;

import com.guolic.library.emtity.History;
import com.guolic.library.emtity.User;


public interface UserService {
    void addOneUser(User user) throws Exception;
    void removeOneUserByAccountAndPassword(String account, String password)throws Exception;
    User queryOneUserByAccount(String name) throws Exception;
    User queryOneUserByAccountAndPassword(String account, String password)throws Exception;
    void borrow(History history)throws Exception;
    List<History> queryAllHistoryByUserId(String uid)throws Exception;
    void returnBook(String hid, String bid, String returnTime)throws Exception ;
}
