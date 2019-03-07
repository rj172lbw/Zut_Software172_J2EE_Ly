import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient{
	//变量
	private Socket s = null;
	private OutputStreamWriter osw = null;
	private Scanner in = null;
	private String str = null;
	//连接服务器
	public void Connection() {
		try {
			s = new Socket("127.0.0.1",8080);
			if(s!=null)
				System.out.println("与Server连接成功！");
			osw = new OutputStreamWriter(s.getOutputStream());
			osw.write("来自客户端的问候！");
			//s.close();                                 //此处关闭s会报错？？？？？
			osw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//向服务器发送信息
	public void Writer() throws IOException {
		
		while(true) {
			s = new Socket("127.0.0.1",8080);                                 //s并没有别关闭
			osw = new OutputStreamWriter(s.getOutputStream());            //osw已经关闭，需要重新连接
			System.out.print("这里发送信息：");
			in = new Scanner(System.in);
			str = in.nextLine();
			System.out.println("发向服务器： "+str);
			osw.write(str);                                         
			if(str.equalsIgnoreCase("再见")||str.equalsIgnoreCase("88")) {
				in.close();
				s.close();
				System.out.println("通话结束！");
				break;
			}
			osw.close(); 												//osw关闭会导致socket关闭吗？？？？？不关闭会造成阻塞
			s.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		TCPClient client = new TCPClient();
		client.Connection();
		client.Writer();
	}
}

/*
 * 调用shutdown()函数来关闭该socket。该函数允许你只停止在某个方向上的数据传输，
 * 而一个方向上的数据传输继续进行。如你可以关闭某socket的写操作而允许继续在该socket 上接受数据，直至读入所有数据。
 */