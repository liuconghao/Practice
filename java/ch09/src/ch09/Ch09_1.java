/**
 * ��ȡ�ı��ļ�����,��������½��ļ�
 */
package ch09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




/**
 * @author lau
 * @version 1.0
 */
public class Ch09_1 {

	public static void main(String[] args) {
		try{
			/**����Ŀ���ļ�**/
			FileReader input = new FileReader("C:\\Users\\lau\\Desktop\\somefiles\\old.txt");
			/**��ȡĿ���ļ�**/
			BufferedReader ipt = new BufferedReader(input);			
			/**����������Ϊ��ʱ�����з��ж�ȡ**/
			while (ipt.readLine()!=null) { 	
				/**������ʵ�������������**/
				String in=ipt.readLine();
				/**��ӡ����**/
				System.out.println(in);;	
			}
			/**�ر�������**/
			ipt.close();	
		}
		catch (IOException e) {System.out.println(e);}
	}
}
