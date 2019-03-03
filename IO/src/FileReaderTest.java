import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		File file = new File("D:\\java\\eclipse-workspace\\IO\\src\\FileReaderTest.java");
		System.out.println(file.exists());
		try {
			
			FileReader fr = new FileReader(file);
			char[] cbuf = new char [3];     //字节属于字符，不会出现乱码的现象
			int hasRead = 0;
			while((hasRead = fr.read(cbuf))>0) {
				System.out.print(cbuf);
			}
			//System.out.println(fr.markSupported());    不知其mark
//			fr.mark(hasRead);
//			hasRead = fr.read(cbuf, 0, 3);
//			System.out.print(cbuf);
//			hasRead += fr.read(cbuf);
//			System.out.println(cbuf);
//			System.out.println(hasRead);
//			fr.reset();
//			fr.read(cbuf);
//			System.out.print(cbuf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
