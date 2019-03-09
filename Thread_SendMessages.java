import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Thread_SendMessages {

	private File file= null;
	private FileInputStream fis = null;
	private FileOutputStream fos = null;
	private Scanner in = null;
	private String str = null;
	private byte[] bbuf = null;
	
	public void CreateFile() {
		try {
			file = new File("Middle.txt");	
			file.createNewFile();										//�˴�ΪʲôҪ��createnewFile������������������������������     
			System.out.println("Does the file exist? "+file.exists());
			System.out.println("Please write to the file: ");
		} catch (IOException e) {
			e.printStackTrace();
		}											  
	}
	
	public void Write() {
		try {
			fos = new FileOutputStream(file);
			in = new Scanner(System.in);
			str = new String();
			bbuf = new byte[1024];
			while(!(str = in.nextLine()).equalsIgnoreCase("����")){
				bbuf = str.getBytes();
				fos.write(bbuf, 0, bbuf.length);
				fos.write("\n".getBytes());
			}
			in.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Thread_Send() {
			try {
				ServerSocket ss = new ServerSocket(1998);
				new TCPServerThread_Send(file,ss);
				new TCPServerThread_Send(file,ss);                      //�����ӷ�����߳��У������address���ظ�ʹ���Ǿ���Ҫ��Socket����ֻ����һ��Ȼ�󴫸����̵߳�run����																			     
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		Thread_SendMessages tsm = new Thread_SendMessages();
		tsm.CreateFile();                                              //�ļ�Ϊʲô���Զ����
		tsm.Write();
		tsm.Thread_Send();
		
	}

}
