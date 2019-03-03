import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		//file �Ķ�����Ŀ¼�����ļ�
		File file = new File("D:\\java\\eclipse-workspace\\IO\\.");
		System.out.println("���ؾ��Ծ�:�� "+file.getAbsolutePath());
		System.out.println("�������һ����·������ "+file.getName());
		System.out.println("����file����·������ "+file.getPath());
		System.out.println("����getName�ĸ�·������ "+file.getParent());
		System.out.println("���ض���ľ���·���� "+file.getAbsoluteFile());
		
		System.out.println("\n�����µ�file����");
		File file1 = new File(".");
		System.out.println("������������ "+file1.getParent());
		System.out.println("���ַ�ʽ�����"+file1.getAbsoluteFile().getParent()+'\n');
		
		//��File�����Ӧ���ļ������ڣ�����һ���µ��ļ�
		File file2 = new File("D:\\java\\eclipse-workspace\\IO\\.test.txt");
		if(file2.createNewFile()) {
			System.out.println("���ļ������ɹ���");
		}
		else System.out.println("���ļ��Ѵ��ڣ�\n");
		//�����µ��ļ���������JVM�˳�ʱɾ���ļ�
		//file2.delete();
		
		//��ϵͳʱ��Ϊ���ִ���һ���ļ�
		File newFile = new File(System.currentTimeMillis()+" ");
		newFile.createNewFile();
		
		
		//�����ǰ·���µ������ļ���·��(���ظ�·�������е��ļ���)
		File file3 = new File("D:\\java\\eclipse-workspace");
		String[] fileList = file3.list();    //ֻ����·���������ǵ�ǰ�ļ��µ�����·�����ļ�(���ظ�·�������е��ļ���)
		for(String fileName : fileList) {
			System.out.println(fileName+'\n');
		}
		
		//ListRoots()��̬���� ������д��̵ĸ�·��
		File[] roots = File.listRoots();
		for(File root : roots) {
			System.out.println(root);
		}
	}

}
