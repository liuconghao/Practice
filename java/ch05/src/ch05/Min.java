
package ch05;

/**
 * @author lau
 * @date 2019��5��12��
 * @version 1.0
 */
public class Min extends Max{
	public int f(int a,int b) {
		int c=a*b/super.f(a, b);
		System.out.println("�������Ϊ"+super.f(a, b));
		return c;
	}

}
