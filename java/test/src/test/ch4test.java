package test;
import java.util.Scanner;
public class ch4test {

	static void f() {//字母表
		ch4_2 a = new ch4_2();
		a.print();
	}
	static void g() {//最小公倍数，最大公约数
		ch4_4A a=new ch4_4A();
		Scanner reader = new Scanner(System.in);
		int m=reader.nextInt();
		int n=reader.nextInt();	
		reader.close();
		int x=a.f( m, n);
		ch4_4B b=new ch4_4B(a);
		int y=b.g(m, n);
		System.out.println("最大公约数为："+x+" "+"最大公倍数为："+y);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//f();
		g();

	}
}
