/**
 * �κ���5.1����дһ���������F������f: �����Լ��)��Ȼ���д���������࣬Ҫ����дF����,����С��������
 */
package ch05;

/**
 * @author lau
 * @date 2019��5��12��
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
