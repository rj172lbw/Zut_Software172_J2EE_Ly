import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("D:\\java\\eclipse-workspace\\IO\\.test5.txt");  //File可以创建文件
			fw.write("邢朋举\r\n");
			fw.write("正在学习： \r\n");
			fw.write("java！\r\n");
			System.out.println("文件写入完毕！");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
