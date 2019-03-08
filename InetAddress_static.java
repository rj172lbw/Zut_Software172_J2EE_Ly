import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_static {

	public static void main(String[] args) throws UnknownHostException {


		String host = "DESKTOP-NLO2OD6";
		String host1 = "www.baidu.com";
		InetAddress inet1 = InetAddress.getByName(host);              //��������  ->  InetAddress����
		byte[] addr1 = {(byte) 10,(byte) 133,(byte)250,(byte)249};     //byte[] ��Χ��-128 - 127  WLAN ip��ַ
		byte[] addr2 = {(byte) 192,(byte) 168,(byte) 137,1};           //����ip��ַ                                        ����         ip��ַ
		InetAddress inet2 = InetAddress.getByAddress(addr2);           //IP��ַ    ->  InetAddress����
		InetAddress inet3 = InetAddress.getByName(host1);
		
		System.out.println("��������: "+inet1.getHostName());            //����WALN�Ķ���getHostName()���ص���WLAN IP��ַ
		System.out.println("ip��ַ: "+inet1.getHostAddress());
		System.out.println("�ٶ�   ��������: "+inet3.getHostName());
		System.out.println("�ٶ�   ip��ַ: "+inet3.getHostAddress());
		//System.out.println("ȫ�޶�����:    "+inet3.getCanonicalHostName());    //????
		
		InetAddress inet4 = InetAddress.getLocalHost();
		System.out.println("��������: "+inet4.getHostName());
		System.out.println("ip��ַ: "+inet4.getHostAddress());
	}

}
