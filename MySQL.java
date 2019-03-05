package JDBC;


import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class MySQL {
    private static String url="jdbc:mysql://localhost::3306/book";
    private static String username="root";
    private static String password="liu200045.";
    private static String driverName="com.mysql.jdbc.Driver";
    static{
        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }
    public static void release(ResultSet rs, Statement st,Connection conn){
        try{
            if(rs!=null)
                rs.close();
            if(st!=null)
                st.close();
            if(conn!=null)
                conn.close();
        }
        catch (SQLException e)
        {
        }
    }
}
