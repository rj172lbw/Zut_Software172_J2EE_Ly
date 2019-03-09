import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPCilent1 {
	//变量
	private Socket s = null;
	private InputStreamReader isr = null;
	private char[] cbuf = null;
	private int has = 0;
	private String str = null;
	
	//连接服务器并读取信息
	public void ConnectionAndRead() throws UnknownHostException, IOException {
		while(true) {
			s = new Socket("127.0.0.1",1998);
			isr = new InputStreamReader(s.getInputStream());
			cbuf = new char[1024];
			str = new String();
			System.out.println("输出流是否准备就绪："+isr.ready());
			if(isr != null && isr.ready())
				System.out.println("cilent1与服务器连接完成！");
			while( (has = isr.read(cbuf)) != -1) {
				str = new String(cbuf);
				System.out.println(str);
			}
			isr.close();
			s.close();
			if(has == -1)
				break;
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		TCPCilent1 c1 = new TCPCilent1();
		c1.ConnectionAndRead();
	}

}
