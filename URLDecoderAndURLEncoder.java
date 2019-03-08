import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderAndURLEncoder {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s1 = URLEncoder.encode("https://book.douban.com/subject/10344307/","GBK");
		String s2 = URLDecoder.decode("https%3A%2F%2Fbook.douban.com%2Fsubject%2F10344307%2F", "utf-8");
		System.out.println(s1);
		System.out.println(s2);
	}

}