package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.SQLException;

@WebServlet(name = "LoginCLServlet")
public class LoginCLServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginCLServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        //接收用户提交的用户名和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        //创建用户
        User user = new User(account, password);
        try {
            if(user.isExist()) {
                response.sendRedirect("/Welcome");
            } else {
                response.sendRedirect("/Error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
