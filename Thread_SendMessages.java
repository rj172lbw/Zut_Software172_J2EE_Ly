import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Thread_SendMessages {

	private File file= null;
	private FileInputStream fis = null;
	private FileOutputStream fos = null;
	private Scanner in = null;
	private String str = null;
	private byte[] bbuf = null;
	
	public void ReadFile() {

			try {
				file = new File("Middle.txt"); 
				file.createNewFile();											//此处为什么要用createnewFile函数？？？？？？？？？？？？？         
				
				//new TCPServerThread_Send(file);
				System.out.println("Does the file exist? "+file.exists());
				System.out.println("Please write to the file: ");
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
				new TCPServerThread_Send(file);
				new TCPServerThread_Send(file);                               //把连接放入多线程中，会造成address被重复使用
																			  //那就需要把Socket对象只申请一次然后传给多线程的run方法
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(file.getAbsolutePath());
			//fis = new FileInputStream(file);
			
	
	}
	
	public static void main(String[] args) {
		Thread_SendMessages tsm = new Thread_SendMessages();
		tsm.ReadFile();                                           //文件为什么会自动清空
		
	}

}
