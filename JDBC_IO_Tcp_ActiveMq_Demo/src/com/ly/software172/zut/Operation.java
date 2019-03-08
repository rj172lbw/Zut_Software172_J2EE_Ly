package com.ly.software172.zut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {
    private static Connection getConn() {
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/test";
        String USERNAME = "root";
        String PASSWORD = "123456";
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int insert(Message message) {
        Connection connection = getConn();
        int i = 0;
        String sql = "insert into messages (txt,date) values(?,?)";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, message.getTxt());
            preparedStatement.setString(2, message.getDate());
            i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static String getAll() {
        Connection conn = getConn();
        String sql = "select * from messages";
        PreparedStatement preparedStatement;
        String txt = null, date = null;
        List list = new ArrayList();
        try {
            preparedStatement = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            System.out.println("----------------------------");
            while(resultSet.next()) {

                txt = resultSet.getString(2);
                date = resultSet.getString(3);
                //Map map = new HashMap(col);
                for(int i = 1; i <= col; i++) {
                    //System.out.print(resultSet.getString(i) + "\t");

                    //map.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
                }
                /*list.add(map);
                System.out.println();*/
            }
            /*System.out.println(list.size());
            System.out.println(list.get(list.size() - 1));
            System.out.println(txt);
            System.out.println(date);
            System.out.println("---------------------------");*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return txt + "(" + date + ")";
    }
    public static Integer getNumber() {
        Connection conn = getConn();
        String sql = "select * from messages";
        PreparedStatement preparedStatement;
        Integer number = 0;
        try {
            preparedStatement = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                number++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }
    /*
    public static void main(String[] args) {
        System.out.print("Please input a txt:");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(calendar.getTime());
        Operation.insert(new Message(string, date));
        Operation.getAll();
        System.out.println(getNumber());
    }
    */
}
/*
在上述对数据库进行增删改查的过程中，可以发现其共性部分，即通用的流程：

　　(1)创建Connection对象、SQL查询命令字符串；

　　(2)对Connection对象传入SQL查询命令，获得PreparedStatement对象；

　　(3)对PreparedStatement对象执行executeUpdate()或executeQurey()获得结果；

　　(4)先后关闭PreparedStatement对象和Connection对象。

　　可见，使用JDBC时，最常打交道的是Connection、PreparedStatement这两个类，以及select中的ResultSet类。查阅Java API手册可以了解其具体的意义和方法。
 */