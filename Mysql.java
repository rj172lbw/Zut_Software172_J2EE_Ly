package J2EE小组项目尝试1;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Auther: LBW
 * @Date: 2019/3/4
 * @Description: J2EE小组项目尝试1
 * @version: 1.0
 */
public class Mysql
{
     public static void main(String []args)throws ClassNotFoundException , SQLException
        {
            int i = 0;
            Class.forName("com.mysql.jdbc.Driver");          //加载驱动
            String url = "jdbc:mysql://127.0.0.1:3306/mysql";
            String username = "root";
            String password = "123456";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();          //添加语句
            Scanner in = new Scanner(System.in);
            String string = in.nextLine();
            String sql = "insert into J2EEMySQL3(Message) values(?)";
            PreparedStatement pstmt;      //表示预编译的 SQL 语句的对象。
            try
            {
                String str = new String("hello I love U!");
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setString(1, str);
                //pstmt.setString(2, student.getSex());
                //pstmt.setString(3, student.getAge());
                i = pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            System.out.println("已经成功将数据添加到《J2EEMySQL3》中！");
            conn.close();
        }
    }

