package com.medicine.action;
import com.medicine.biz.UserBiz;
import com.medicine.bean.User;

import javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/user.let")
public class UserServlet extends HttpServlet {
    UserBiz userBiz=new UserBiz();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        String method=req.getParameter("type");
        switch(method){
            case"login":
                String name=req.getParameter("name");
                String pwd=req.getParameter("pwd");
                User user=userBiz.getUser(name,pwd);
                if(user==null){
                    out.println("<script>alert('用户名或密码不存在');location.href='login.html';</script>");
                }else{
                    out.println("<script>alert('登陆成功');location.href='index.jsp';</script>");
                }
                break;

        }
    }
}
