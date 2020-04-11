package test;

public class ch4_2 {
	
	public void print() {
		int n=64;
		while(++n<=90) {
			int m=Character.toLowerCase((char)n);
			System.out.printf("%c%c ",n,m);

		}
	}
}