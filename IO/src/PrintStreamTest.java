import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos);
			ps.print("使用PrintStream处理流包装底层流进行文件的输出！");
			System.out.println("文件写入完成！");
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
