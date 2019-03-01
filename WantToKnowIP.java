import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * @Auther: LBW
 * @Date: 2019/3/1
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class WantToKnowIP
{
    public static void main(String []args)
    {
        try
        {
            InetAddress ip;
            ip = InetAddress.getLocalHost();
            String localname = ip.getHostName();
            String localip = ip.getHostAddress();
            System.out.println("主机名称" + localname);
            System.out.println("主机IP地址" + localip);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
