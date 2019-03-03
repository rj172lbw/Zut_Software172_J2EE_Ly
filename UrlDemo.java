package pers.hyh.demo1.urlDemo;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL Aurl=new URL("https://github.com");
		URL tuto=new URL(Aurl,"hyh12261998");
		System.out.println("protocol="+tuto.getProtocol());            //��ȡ�� URL��Э�����ơ�
		System.out.println("host="+tuto.getHost());                    //��ȡ�� URL��������
		System.out.println("filename="+tuto.getFile());                //��ȡ�� URL���ļ���
		System.out.println("port="+tuto.getPort());                    //��ȡ�� URL�Ķ˿ںš�
		System.out.println("ref="+tuto.getRef());                      //��ȡ�˵�ê����Ҳ��Ϊ���ο����� URL
		System.out.println("query="+tuto.getQuery());                  //��ȡ�� URL�Ĳ�ѯ����
		System.out.println("path="+tuto.getPath());                    //��ȡ�� URL��·������
		System.out.println("UserInfo="+tuto.getUserInfo());            
		System.out.println("Authority="+tuto.getAuthority());          //��ȡ�˵���Ȩ���� URL 
		
	}

}
