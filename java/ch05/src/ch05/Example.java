
package ch05;

/**
 * @author lau
 * @date 2019年5月12日
 * @version 1.0							
 */
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a=15,b=12;
		System.out.println("a="+a+" b="+b);
		Min min =new Min();
		int c=min.f(a, b);
		System.out.println("最小公倍数为"+c);
	}

}
