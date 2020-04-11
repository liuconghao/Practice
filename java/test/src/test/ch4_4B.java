package test;

public class ch4_4B {
	private ch4_4A a;
	ch4_4B(ch4_4A a){
		this.a=a;
	}
	int g(int m,int n) {
		n=m*n/a.f(m, n);
		return n;
		
	}
}
