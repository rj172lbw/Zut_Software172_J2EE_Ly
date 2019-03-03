package J2EE小组项目尝试1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Auther: LBW
 * @Date: 2019/3/3
 * @Description: J2EE小组项目尝试1
 * @version: 1.0
 */
public class ClientThread
{
    private Socket s;
    BufferedReader br = null;
    public ClientThread(Socket s)throws IOException
    {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    public void main()throws IOException
    {
        try{
            String content = null;
            while((content = br.readLine())!= null)
            {
                System.out.println(content);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
