
package ch05;

/**
 * @author lau
 * @date 2019年5月12日
 * @version 1.0
 */
public class Min extends Max{
	public int f(int a,int b) {
		int c=a*b/super.f(a, b);
		System.out.println("最大公因数为"+super.f(a, b));
		return c;
	}

}
