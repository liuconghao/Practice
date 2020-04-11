package org.sunny.client;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;
import org.sunny.client.config.Hello;
import org.sunny.client.config.HelloService;
@WebServiceClient//����
public class Client {

	public static void main(String[] args) {
		// ����1
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
		//��������ͨ��HelloService��getHelloPort()������Hello�ӿ�
		Hello SayHello = new HelloService().getHelloPort();
		String result = SayHello.say("SUNNY");
		System.out.println(result);
	}

}
