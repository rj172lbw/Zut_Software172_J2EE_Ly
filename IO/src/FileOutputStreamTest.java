import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fis= new FileInputStream("D:\\java\\eclipse-workspace\\IO\\src\\FileOutputStreamTest.java");
			FileOutputStream fos = new FileOutputStream("D:\\java\\eclipse-workspace\\IO\\.test.txt");
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while((hasRead = fis.read(bbuf))>0) {
				fos.write(bbuf, 0, bbuf.length);
			}
			System.out.println("文件复制完毕！");
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
