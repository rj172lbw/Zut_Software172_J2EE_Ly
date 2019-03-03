<%--
  Created by IntelliJ IDEA.
  User: 研哥哥
  Date: 2019/3/3
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>表单</title>
  </head>

  <body>
  <h1>用户登陆</h1>
  <form action="/LoginCL" method="post">
    账号 <input type="text" name="account"/>
    <br>
    密码 <input type="password" name="password"/>
    <br>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
