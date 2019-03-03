package J2EE小组项目尝试1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Auther: LBW
 * @Date: 2019/3/3
 * @Description: J2EE小组项目尝试1
 * @version: 1.0
 */
public class ServerThread
{
    Socket so =null;
    BufferedReader br = null;
    public ServerThread(Socket so)throws IOException
    {
        this.so = so;
        br = new BufferedReader(new InputStreamReader(so.getInputStream()));
    }
    private  String readFromClient()
    {
        try
        {
            return br.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();   //
        }
        return null;
    }
    public void run()throws IOException
    {
        String content = null;
        while((content = readFromClient()) != null )
        {
            for(Socket s : MyServer.socketList)
            {
                PrintStream ps = new PrintStream(so.getOutputStream());
                ps.println(content);
            }
        }
    }
}
