import java.sql.*;
import  java.lang.ClassNotFoundException;
public class Main{
    public static void main(String[] args) {
        try {
            //建立连接
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc" ,"root","123456" );
            //增加
            Statement st=conn.createStatement();
            String sql="insert into test_jdbc (name) values('zzz')";
            st.execute(sql);
            //删除
            String sql1="delete from test_jdbc where name='cui'";
            st.execute(sql1);
            //查找
            String sql2="select * from test_jdbc where name='zhang'";
            st.execute(sql2);
            //修改
            String sql3="update  test_jdbc set name ='liu' where name='li'";
            st.execute(sql3);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
