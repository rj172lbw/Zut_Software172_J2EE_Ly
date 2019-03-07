import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer{
	//����
	private ServerSocket ss= null;
	private Socket s = null;
	private static InputStreamReader isr = null;
	private static OutputStreamWriter osw = null;
	private static char[] cbuf = null;
	private static int has = 0;
	private String str = null;
	
	//��ͻ��˽�������
	public void Connection() throws IOException {
		System.out.println("�ȴ��ͻ�������...");
		ss = new ServerSocket(8080);
		//�����ֻ�����������ȡ��һ��ϣ�������
			//����������һ����Ӧ��Socket
			s = ss.accept();
			isr = new InputStreamReader(s.getInputStream());  
			cbuf = new char[1024];
			System.out.println("��ȡ���Ƿ�����׼����"+isr.ready());   //��Ҫbyte[]����ռ�
			if(s!=null && isr.ready())
				System.out.println("��Client���ӳɹ���");
			while((has = isr.read(cbuf)) !=-1)                 //�Ƿ���ͨ�������������socket��������
				System.out.println("�ͻ��ˣ� "+cbuf);             //Ϊʲô�˴����ܵ���Ϣ����
			isr.close();
			s.close();                                     //s�رպ�TCPServerThread_GetMessage(s, isr)����ȥ�Ĳ�������û��������
			
	}
	
	public void GetMessage() throws IOException {
		//ss = new ServerSocket(8080);         //ss���β�û�б��ر�
		str = new String("");
		while(true) {
			s = ss.accept();
			cbuf = new char[1024];
			isr = new InputStreamReader(s.getInputStream());
			if(s!=null) {                 //&&isr.ready()
				while( (has = isr.read(cbuf)) != -1) {             //read�����������
					System.out.println("���Կͻ��˵���Ϣ��"+cbuf);
					str = new String(cbuf);
					if(str.equalsIgnoreCase("�ټ�")||str.equalsIgnoreCase("88"))
						break;
				}	
			}
			isr.close();
			s.close();
		}
	}
	
	//��ȡSocket�е���Ϣ
	/*
	 * public static class Reader extends Thread { private int hasRead; private
	 * String str = null;
	 * 
	 * public void run() { while(true) { try { while((hasRead = isr.read(cbuf))!=-1)
	 * { str = new String(cbuf);
	 * System.out.println("����"+currentThread().getName()+"����Ϣ"+str);
	 * if(str.equalsIgnoreCase("�ټ�")||str.equalsIgnoreCase("88")) { isr.close(); } }
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } } }
	 * 
	 * //��Client��Write��Ϣ public static class Writer extends Thread { Scanner in =
	 * null; private String str = null;
	 * 
	 * public void run() { try { in = new Scanner(System.in);
	 * System.out.println("�����룺 "); str = in.nextLine();
	 * osw.write("����"+currentThread().getName()+"����Ϣ�� "+str);
	 * if(str.equalsIgnoreCase("�ټ�")||str.equalsIgnoreCase("88")) { in.close();
	 * osw.close(); } } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 */
	public static void main(String[] args) throws IOException {
		TCPServer server = new TCPServer();
		server.Connection();
		server.GetMessage();
	}
}