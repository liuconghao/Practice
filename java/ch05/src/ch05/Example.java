
package ch05;

/**
 * @author lau
 * @date 2019��5��12��
 * @version 1.0							
 */
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int a=15,b=12;
		System.out.println("a="+a+" b="+b);
		Min min =new Min();
		int c=min.f(a, b);
		System.out.println("��С������Ϊ"+c);
	}

}
