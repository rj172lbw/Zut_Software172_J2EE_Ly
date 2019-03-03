package model;

import java.sql.*;

public class DBHelper {
    private Connection connection;
    private Statement statement;

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String userName = "root";
    private static final String password = "123456";
    private static final String sDropDB = "drop datebase if exists userdbHelper";
    private static final String sCreateDB = "creat datebase userdbHelper";
    private static final String sUserDB = "use userdbHelper";
    private static final String sDropTb = "drop table if exists user";
    private static final String sCreatTb = "create table user (account carchar(20), password varchar(20))";
    private static final String sInsert = "insert into user valuer('admin', '123456')";

    public  DBHelper() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
            statement.execute(sDropDB);
            statement.execute(sCreateDB);
            statement.execute(sUserDB);

            statement.execute(sDropTb);
            statement.execute(sCreatTb);
            statement.execute(sInsert);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //查询某用户是否存在
    public Boolean Query(User user) throws SQLException {
        ResultSet resultSet = null;
        resultSet = statement.executeQuery("select * from user where account='" + user.getAccount() + "' and password='" + user.getPassword() + "'");
        return resultSet.next();
    }
}
