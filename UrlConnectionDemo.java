package pers.hyh.demo1.urlconnectiondemo;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url=new URL("https://github.com/hyh12261998");
		URLConnection urlCon=url.openConnection();                     //建立连接
		System.out.println("内容大小："+urlCon.getContentLength());        //输出连接大小
		System.out.println("内容类型："+urlCon.getContentType());          //取得连接类型

	}

}
