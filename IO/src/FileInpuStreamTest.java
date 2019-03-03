import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInpuStreamTest {

	public static void main(String[] args) throws IOException {
		File file = new File(".test1.txt");
		if(file.createNewFile()) {
			
			System.out.println("文件创建成功!");
			System.out.println("文件名称： "+file.getName());
			System.out.println("文件路径： "+file.getAbsolutePath());
			//file.delete();
			}
		else
			System.out.println("文件已存在！");
		FileInputStream fis = new FileInputStream("test1.txt");     //输入的文件名，不是文件的路径
		byte[] hasRead = new byte[2];
		int m = 0;
		if(fis.read()==-1)
			System.out.println("文件内容为空！");
		while((m = fis.read(hasRead))>0) {
			System.out.println(new String(hasRead,0,m));           //出现乱码的原因，文件保存采用的是GBK编码，一个中文占两个字节
		}  														   //当值读取中文的一个字节是将会出啊先乱码的现象
		fis.close();                                               //空格占用一个字节，回车也是（字符一个字节）
	}
}
