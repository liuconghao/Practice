/**
 * 课后题5.1，编写一个类包含发F方法（f: 求最大公约数)，然后编写这个类的子类，要求重写F方法,求最小公倍数。
 */
package ch05;

/**
 * @author lau
 * @date 2019年5月12日
 * @version 1.0
 */
public class Max {
	public int f(int a,int b) {
		while (a != b) {
			if(a>b)a=a-b;
			else b=b-a;
		}
		return a;
	}
}
