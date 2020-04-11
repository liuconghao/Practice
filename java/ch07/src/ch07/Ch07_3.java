/**
 * BigInterger计算大整数的阶乘
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
		System.out.println("请输入一个正整数：");
		BigInteger n=reader.nextBigInteger();
		reader.close();
		BigInteger mul = factorial(n);
		System.out.println(n+"的阶乘为："+mul);
	}
	public static BigInteger factorial(BigInteger a) {
		if(a==BigInteger.ONE||a==BigInteger.ZERO)
			return BigInteger.ONE;
		/**递归调用**/
        return a.multiply(factorial(a.subtract(BigInteger.ONE)));
	}

}
