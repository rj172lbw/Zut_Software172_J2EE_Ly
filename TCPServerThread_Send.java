import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerThread_Send extends Thread{

	Scanner in = null;
	private String str = null;
	private ServerSocket ss = null;
	private Socket s = null;
	private OutputStreamWriter osw = null;
	private FileInputStream fis = null;
	private File file = null;
	private int has = 0;
	private byte[] bbuf = null;
	
//	public TCPServerThread_Send(String str) {
//		super();           //�޴�super()ϵͳҲ��Ĭ�����
//		this.str = str;
//		start();        //��ǰ����Ķ��߳�����
//	}
	
	public TCPServerThread_Send(File file,ServerSocket ss) throws FileNotFoundException {
		super();           //�޴�super()ϵͳҲ��Ĭ�����
		fis = new FileInputStream(file);
		this.ss = ss;
		//this.fis = fis;    //δ��this.fis����ռ䣬�Ƿ��ܹ���ֵ������������
		start();        //��ǰ����Ķ��߳�����
	}
	
	public void run() {
		
		try {
			System.out.println("���Ѿ�������:");
			while(true) {
				s = ss.accept();
				osw = new OutputStreamWriter(s.getOutputStream());
				bbuf = new byte[1024];
				while((has = fis.read(bbuf))!=-1) {
					str = new String(bbuf);
					osw.write(str+"\n");
					if(str.equalsIgnoreCase("�ټ�")||str.equalsIgnoreCase("88")) 
						break;
				}
				osw.close();
				s.close();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		

	}

}
