import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos);
			ps.print("ʹ��PrintStream��������װ�ײ��������ļ��������");
			System.out.println("�ļ�д����ɣ�");
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
