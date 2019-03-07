import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient{
	//����
	private Socket s = null;
	private OutputStreamWriter osw = null;
	private Scanner in = null;
	private String str = null;
	//���ӷ�����
	public void Connection() {
		try {
			s = new Socket("127.0.0.1",8080);
			if(s!=null)
				System.out.println("��Server���ӳɹ���");
			osw = new OutputStreamWriter(s.getOutputStream());
			osw.write("���Կͻ��˵��ʺ�");
			//s.close();                                 //�˴��ر�s�ᱨ����������
			osw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�������������Ϣ
	public void Writer() throws IOException {
		
		while(true) {
			s = new Socket("127.0.0.1",8080);                                 //s��û�б�ر�
			osw = new OutputStreamWriter(s.getOutputStream());            //osw�Ѿ��رգ���Ҫ��������
			System.out.print("���﷢����Ϣ��");
			in = new Scanner(System.in);
			str = in.nextLine();
			System.out.println("����������� "+str);
			osw.write(str);                                         
			if(str.equalsIgnoreCase("�ټ�")||str.equalsIgnoreCase("88")) {
				in.close();
				s.close();
				System.out.println("ͨ��������");
				break;
			}
			osw.close(); 												//osw�رջᵼ��socket�ر��𣿣����������رջ��������
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
 * ����shutdown()�������رո�socket���ú���������ֹֻͣ��ĳ�������ϵ����ݴ��䣬
 * ��һ�������ϵ����ݴ���������С�������Թر�ĳsocket��д��������������ڸ�socket �Ͻ������ݣ�ֱ�������������ݡ�
 */