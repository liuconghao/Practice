/**
 * BigInterger����������Ľ׳�
 */
package ch07;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author lau
 * @version 1.0
 */
public class Ch07_3 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		System.out.println("������һ����������");
		BigInteger n=reader.nextBigInteger();
		reader.close();
		BigInteger mul = factorial(n);
		System.out.println(n+"�Ľ׳�Ϊ��"+mul);
	}
	public static BigInteger factorial(BigInteger a) {
		if(a==BigInteger.ONE||a==BigInteger.ZERO)
			return BigInteger.ONE;
		/**�ݹ����**/
        return a.multiply(factorial(a.subtract(BigInteger.ONE)));
	}

}
