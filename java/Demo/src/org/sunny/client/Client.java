package org.sunny.client;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;
import org.sunny.client.config.Hello;
import org.sunny.client.config.HelloService;
@WebServiceClient//必须
public class Client {

	public static void main(String[] args) {
		// 方法1
		try {
			URL url= new URL("http://localhost:2333/service/Hello?wsdl");
			QName qname = new QName("http://service.sunny.org/","HelloService");
			Service service = Service.create(url,qname);
			Hello SayHello = service.getPort(Hello.class);
			String result = SayHello.say("Sunny");
			System.out.println(result);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//方法二，通过HelloService的getHelloPort()方法的Hello接口
		Hello SayHello = new HelloService().getHelloPort();
		String result = SayHello.say("SUNNY");
		System.out.println(result);
	}

}
