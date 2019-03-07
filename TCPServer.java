import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer{
	//变量
	private ServerSocket ss= null;
	private Socket s = null;
	private static InputStreamReader isr = null;
	private static OutputStreamWriter osw = null;
	private static char[] cbuf = null;
	private static int has = 0;
	private String str = null;
	
	//与客户端进行连接
	public void Connection() throws IOException {
		System.out.println("等待客户端连接...");
		ss = new ServerSocket(8080);
		//下面的只负责连接与读取第一条希连接情况
			//服务器产生一个对应的Socket
			s = ss.accept();
			isr = new InputStreamReader(s.getInputStream());  
			cbuf = new char[1024];
			System.out.println("读取流是否做好准备："+isr.ready());   //需要byte[]分配空间
			if(s!=null && isr.ready())
				System.out.println("与Client连接成功！");
			while((has = isr.read(cbuf)) !=-1)                 //是否能通过缓冲区来解决socket阻塞现象
				System.out.println("客户端： "+cbuf);             //为什么此处接受的信息乱码
			isr.close();
			s.close();                                     //s关闭后，TCPServerThread_GetMessage(s, isr)传过去的参数有用没？？？？
			
	}
	
	public void GetMessage() throws IOException {
		//ss = new ServerSocket(8080);         //ss队形并没有被关闭
		str = new String("");
		while(true) {
			s = ss.accept();
			cbuf = new char[1024];
			isr = new InputStreamReader(s.getInputStream());
			if(s!=null) {                 //&&isr.ready()
				while( (has = isr.read(cbuf)) != -1) {             //read好像出现阻塞
					System.out.println("来自客户端的信息："+cbuf);
					str = new String(cbuf);
					if(str.equalsIgnoreCase("再见")||str.equalsIgnoreCase("88"))
						break;
				}	
			}
			isr.close();
			s.close();
		}
	}
	
	//读取Socket中的信息
	/*
	 * public static class Reader extends Thread { private int hasRead; private
	 * String str = null;
	 * 
	 * public void run() { while(true) { try { while((hasRead = isr.read(cbuf))!=-1)
	 * { str = new String(cbuf);
	 * System.out.println("来自"+currentThread().getName()+"的消息"+str);
	 * if(str.equalsIgnoreCase("再见")||str.equalsIgnoreCase("88")) { isr.close(); } }
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } } }
	 * 
	 * //向Client中Write信息 public static class Writer extends Thread { Scanner in =
	 * null; private String str = null;
	 * 
	 * public void run() { try { in = new Scanner(System.in);
	 * System.out.println("请输入： "); str = in.nextLine();
	 * osw.write("来自"+currentThread().getName()+"的信息： "+str);
	 * if(str.equalsIgnoreCase("再见")||str.equalsIgnoreCase("88")) { in.close();
	 * osw.close(); } } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 */
	public static void main(String[] args) throws IOException {
		TCPServer server = new TCPServer();
		server.Connection();
		server.GetMessage();
	}
}