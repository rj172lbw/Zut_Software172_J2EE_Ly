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
		URLConnection urlCon=url.openConnection();                     //��������
		System.out.println("���ݴ�С��"+urlCon.getContentLength());        //������Ӵ�С
		System.out.println("�������ͣ�"+urlCon.getContentType());          //ȡ����������

	}

}
