package com.medicine.dao;

import com.medicine.bean.User;
import com.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author:深渊
 * Date：2022/6/24  15:50
 */
public class UserDao {
    QueryRunner runner=new QueryRunner();
    public User getUser(String name, String pwd) throws SQLException {
        Connection coon=DBHelper.getConnection();
        String sql="select *from user where name=? and pwd=? and state=1";
        User user=runner.query(coon,sql,new BeanHandler<User>(User.class),name,pwd);
        coon.close();
        return user;

    }

    public static void main(String[] args) throws SQLException {
        User user=new UserDao().getUser("super","123456");
        System.out.println(user);
    }
}
