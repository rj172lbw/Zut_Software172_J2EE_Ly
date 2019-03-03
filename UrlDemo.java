package pers.hyh.demo1.urlDemo;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL Aurl=new URL("https://github.com");
		URL tuto=new URL(Aurl,"hyh12261998");
		System.out.println("protocol="+tuto.getProtocol());            //获取此 URL的协议名称。
		System.out.println("host="+tuto.getHost());                    //获取此 URL的主机名
		System.out.println("filename="+tuto.getFile());                //获取此 URL的文件名
		System.out.println("port="+tuto.getPort());                    //获取此 URL的端口号。
		System.out.println("ref="+tuto.getRef());                      //获取此的锚定（也称为“参考”） URL
		System.out.println("query="+tuto.getQuery());                  //获取此 URL的查询部分
		System.out.println("path="+tuto.getPath());                    //获取此 URL的路径部分
		System.out.println("UserInfo="+tuto.getUserInfo());            
		System.out.println("Authority="+tuto.getAuthority());          //获取此的授权部分 URL 
		
	}

}
