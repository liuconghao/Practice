package test;
import java.util.Scanner;
public class ch4test {

	static void f() {//��ĸ��
		ch4_2 a = new ch4_2();
		a.print();
	}
	static void g() {//��С�����������Լ��
		ch4_4A a=new ch4_4A();
		Scanner reader = new Scanner(System.in);
		int m=reader.nextInt();
		int n=reader.nextInt();	
		reader.close();
		int x=a.f( m, n);
		ch4_4B b=new ch4_4B(a);
		int y=b.g(m, n);
		System.out.println("���Լ��Ϊ��"+x+" "+"��󹫱���Ϊ��"+y);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//f();
		g();

	}
}
