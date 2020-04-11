/**
 * 
 */
package ch5_3;

/**
 * @author lau
 * @date 2019Äê5ÔÂ13ÈÕ
 * @version 
 */
interface Aa {
	public abstract void f(int x);
	public abstract void g(int x,int y);
	public abstract double h(double x);
}

class B implements Aa{
	public void f(int x) {
		x++;
	}


	public void g(int x, int y) {
		int tmp=x;
		x=y;
		y=tmp;
	}


	public double h(double x) {
		x=x/2;
		return x;
	}
	
}
public class A{
	public static void main(String args[]) {
		int x=2,y=3;
		double z=2.3;
		Aa a = new B();
		a.f(x);
		a.g(x, y);
		a.h(z);
	}
}