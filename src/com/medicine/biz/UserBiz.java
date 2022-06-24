package com.medicine.biz;

import com.medicine.bean.User;
import com.medicine.dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    UserDao userDao=new UserDao();
    public User getUser(String name, String pwd){
        User user=null;
        try {
            user=userDao.getUser(name,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
}
