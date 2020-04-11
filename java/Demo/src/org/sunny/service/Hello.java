package org.sunny.service;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
@WebService//不能少
public class Hello {

	public String say(String name) {
		return "Hello "+name+",this is HelloService!";
	}
	public static void main(String[] args) {
		// 第一个参数是url，9091为任意不占用的端口
		Endpoint.publish("http://localhost:2333/service/Hello", new Hello());
        System.out.println("Service success!");
	}
}
