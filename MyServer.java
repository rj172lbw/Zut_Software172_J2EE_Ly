package J2EE小组项目尝试1;

import J2EE小组相关.JDBCTrying2;
import J2EE小组相关.Server;
import J2EE小组相关.ServerThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/3/2
 * @Description: J2EE小组项目尝试1
 * @version: 1.0
 */
public class MyServer
{
    JDBCTrying2 Database;
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());//将服务端的监听设置为多线程的集合
    public static void main(String []args)throws ClassNotFoundException , SQLException
      {
          byte[] by = null;

          try
          {

              ServerSocket sso = new ServerSocket(30000);
              while(true)
              {
                  Socket so = sso.accept();
                  socketList.add(so);
                  new Thread(new ServerThread(so)).start();
              }
          }
          catch(IOException e)
          {
              e.printStackTrace();
          }
      }
}
