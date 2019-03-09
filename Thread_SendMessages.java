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
			file.createNewFile();										//此处为什么要用createnewFile函数？？？？？？？？？？？？？     
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
			while(!(str = in.nextLine()).equalsIgnoreCase("结束")){
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
				new TCPServerThread_Send(file,ss);                      //把连接放入多线程中，会造成address被重复使用那就需要把Socket对象只申请一次然后传给多线程的run方法																			     
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		Thread_SendMessages tsm = new Thread_SendMessages();
		tsm.CreateFile();                                              //文件为什么会自动清空
		tsm.Write();
		tsm.Thread_Send();
		
	}

}
