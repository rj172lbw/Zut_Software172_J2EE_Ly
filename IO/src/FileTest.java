import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		//file 的对象是目录或者文件
		File file = new File("D:\\java\\eclipse-workspace\\IO\\.");
		System.out.println("返回绝对经:： "+file.getAbsolutePath());
		System.out.println("返回最后一级子路径名： "+file.getName());
		System.out.println("返回file对象路径名： "+file.getPath());
		System.out.println("返回getName的父路径名： "+file.getParent());
		System.out.println("返回对象的绝对路径： "+file.getAbsoluteFile());
		
		System.out.println("\n创建新的file对象");
		File file1 = new File(".");
		System.out.println("这种情况会出错： "+file1.getParent());
		System.out.println("这种方式解决："+file1.getAbsoluteFile().getParent()+'\n');
		
		//若File对象对应的文件不存在，创建一个新的文件
		File file2 = new File("D:\\java\\eclipse-workspace\\IO\\.test.txt");
		if(file2.createNewFile()) {
			System.out.println("新文件创建成功！");
		}
		else System.out.println("该文件已存在！\n");
		//创建新的文件，并且在JVM退出时删除文件
		//file2.delete();
		
		//以系统时间为名字创建一个文件
		File newFile = new File(System.currentTimeMillis()+" ");
		newFile.createNewFile();
		
		
		//输出当前路径下的所有文件和路径(返回该路径下所有的文件名)
		File file3 = new File("D:\\java\\eclipse-workspace");
		String[] fileList = file3.list();    //只能是路径，而不是当前文件下的所有路径和文件(返回该路径下所有的文件名)
		for(String fileName : fileList) {
			System.out.println(fileName+'\n');
		}
		
		//ListRoots()静态方法 获得所有磁盘的跟路径
		File[] roots = File.listRoots();
		for(File root : roots) {
			System.out.println(root);
		}
	}

}
