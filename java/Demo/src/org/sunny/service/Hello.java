package org.sunny.service;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
@WebService//������
public class Hello {

	public String say(String name) {
		return "Hello "+name+",this is HelloService!";
	}
	public static void main(String[] args) {
		// ��һ��������url��9091Ϊ���ⲻռ�õĶ˿�
		Endpoint.publish("http://localhost:2333/service/Hello", new Hello());
        System.out.println("Service success!");
	}
}
