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
//		//InputStream is = new InputStream(System.in);   in��������InputStream�����
//		InputStreamReader isr = new InputStreamReader(System.in);
//		System.out.println("������ɣ�");
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
		String line = null; // ��������ÿ�ж�ȡ������ 
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = bufferedreader.readLine();
			System.out.println("line= "+line);
			System.out.println("111");
			while (line != null) { // ��� line Ϊ��˵�������� 
				System.out.println("222");
				buffer.append(line); // ��������������ӵ� buffer �� 
				System.out.println("333");
				buffer.append("\n"); // ��ӻ��з� 
				line = bufferedreader.readLine(); // ��ȡ��һ�� 
				System.out.println("line= "+line);
				if(line == null)
					System.in.close();
			} 
			bufferedreader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ��ȡ��һ�� 
		
		//inputstream.close(); //������ buffer �е�����д���� 
		System.out.print(buffer) ;
	}
}
