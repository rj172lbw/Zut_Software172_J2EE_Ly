import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("D:\\java\\eclipse-workspace\\IO\\.test5.txt");  //File���Դ����ļ�
			fw.write("�����\r\n");
			fw.write("����ѧϰ�� \r\n");
			fw.write("java��\r\n");
			System.out.println("�ļ�д����ϣ�");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
