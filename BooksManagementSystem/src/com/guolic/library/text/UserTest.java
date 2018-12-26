package com.guolic.library.text;

import org.junit.Test;

import com.guolic.library.emtity.User;
import com.guolic.library.service.UserService;
import com.guolic.library.service.realize.UserServiceRealize;
import com.guolic.library.util.UUIDUtil;

public class UserTest {
    private UserService userService = new UserServiceRealize();
    
    @Test
    public void AllUserByAccount() throws Exception {
        String account = "秦始皇";
       System.out.println( userService.queryOneUserByAccount(account));
    }
    
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setId(UUIDUtil.generateUUID());
        user.setAccount("荆轲");
        user.setPassword("123456");
        userService.addOneUser(user);
    }
    @Test
    public void deleteUser() throws Exception {
        String account = "荆轲";
        String password = "123456";
        userService.removeOneUserByAccountAndPassword(account, password);
    }
    @Test
    public void queryOneUserByAccountAndPassword() throws Exception {
        String account = "荆轲";
        String password = "123456";
        System.out.println(userService.queryOneUserByAccountAndPassword(account, password));
    }
}
