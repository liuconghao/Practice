/**
 * 
 */
package ch5_2;

/**
 * @author lau
 * @date 2019Äê5ÔÂ12ÈÕ
 * @version 1.0
 */
public abstract class Root {
	public abstract void f(int x);
	public abstract void g(int x,int y);
	public abstract double h(double x);
}

class S extends Root{
	int x=2,y=3;
	double z=2.1;
	public void f(int x) {
		System.out.println(x);
	}
	public void g(int x,int y) {
		x=x*y;
		System.out.println(x);
	}
	public double h(double x) {
		x=x*x;
		return x;
	}
}
class X extends Root{
	public void f(int x) {
		x=2*x;
	}

	public void g(int x, int y) {
		y=2*x+y;
	}

	public double h(double x) {
		x=3*x/2;
		return x;
	}
	
}
class Y extends Root{

	public void f(int x) {
		x=x/2;
	}

	public void g(int x, int y) {
		if(x!=y) x=y;
	}

	public double h(double x) {
		return x+2;
	}
	
}