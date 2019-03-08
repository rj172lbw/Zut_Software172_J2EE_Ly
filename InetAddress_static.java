import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_static {

	public static void main(String[] args) throws UnknownHostException {


		String host = "DESKTOP-NLO2OD6";
		String host1 = "www.baidu.com";
		InetAddress inet1 = InetAddress.getByName(host);              //主机名称  ->  InetAddress对象
		byte[] addr1 = {(byte) 10,(byte) 133,(byte)250,(byte)249};     //byte[] 范围是-128 - 127  WLAN ip地址
		byte[] addr2 = {(byte) 192,(byte) 168,(byte) 137,1};           //两个ip地址                                        本地         ip地址
		InetAddress inet2 = InetAddress.getByAddress(addr2);           //IP地址    ->  InetAddress对象
		InetAddress inet3 = InetAddress.getByName(host1);
		
		System.out.println("主机名称: "+inet1.getHostName());            //若是WALN的对象，getHostName()返回的是WLAN IP地址
		System.out.println("ip地址: "+inet1.getHostAddress());
		System.out.println("百度   主机名称: "+inet3.getHostName());
		System.out.println("百度   ip地址: "+inet3.getHostAddress());
		//System.out.println("全限定域名:    "+inet3.getCanonicalHostName());    //????
		
		InetAddress inet4 = InetAddress.getLocalHost();
		System.out.println("主机名称: "+inet4.getHostName());
		System.out.println("ip地址: "+inet4.getHostAddress());
	}

}
