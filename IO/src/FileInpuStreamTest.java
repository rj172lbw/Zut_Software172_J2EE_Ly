import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInpuStreamTest {

	public static void main(String[] args) throws IOException {
		File file = new File(".test1.txt");
		if(file.createNewFile()) {
			
			System.out.println("�ļ������ɹ�!");
			System.out.println("�ļ����ƣ� "+file.getName());
			System.out.println("�ļ�·���� "+file.getAbsolutePath());
			//file.delete();
			}
		else
			System.out.println("�ļ��Ѵ��ڣ�");
		FileInputStream fis = new FileInputStream("test1.txt");     //������ļ����������ļ���·��
		byte[] hasRead = new byte[2];
		int m = 0;
		if(fis.read()==-1)
			System.out.println("�ļ�����Ϊ�գ�");
		while((m = fis.read(hasRead))>0) {
			System.out.println(new String(hasRead,0,m));           //���������ԭ���ļ�������õ���GBK���룬һ������ռ�����ֽ�
		}  														   //��ֵ��ȡ���ĵ�һ���ֽ��ǽ�����������������
		fis.close();                                               //�ո�ռ��һ���ֽڣ��س�Ҳ�ǣ��ַ�һ���ֽڣ�
	}
}
