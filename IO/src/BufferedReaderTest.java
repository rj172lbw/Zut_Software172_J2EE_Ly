import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class BufferedReaderTest {
//
//	public static void main(String[] args) throws IOException {
//		//InputStream is = new InputStream(System.in);   in方法就是InputStream定义的
//		InputStreamReader isr = new InputStreamReader(System.in);
//		System.out.println("输入完成！");
//		BufferedReader bf = new BufferedReader(isr);
//		StringBuffer str = new StringBuffer();
//		String s =new String();
//		while(bf.readLine()!=null){
//			str.append(bf.readLine());
//		}
//		System.out.println(str);
//		
//		bf.close();isr.close();
//	}
//
//}





public class BufferedReaderTest{
	public static void main(String[] args) {
		//FileInputStream inputstream = new FileInputStream(System.in); 
		StringBuffer buffer = new StringBuffer(); 
		String line = null; // 用来保存每行读取的内容 
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = bufferedreader.readLine();
			System.out.println("line= "+line);
			System.out.println("111");
			while (line != null) { // 如果 line 为空说明读完了 
				System.out.println("222");
				buffer.append(line); // 将读到的内容添加到 buffer 中 
				System.out.println("333");
				buffer.append("\n"); // 添加换行符 
				line = bufferedreader.readLine(); // 读取下一行 
				System.out.println("line= "+line);
				if(line == null)
					System.in.close();
			} 
			bufferedreader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 读取第一行 
		
		//inputstream.close(); //将读到 buffer 中的内容写出来 
		System.out.print(buffer) ;
	}
}
