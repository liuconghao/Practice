/**
 * ���Ӽ��������ʮ���ı�����ָ���ļ�
 */
package ch09;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author lau
 * @version 1.0
 */
public class Ch09_2 {

	public static void main(String[] args) {
		try{
			String []in=new String[10];
			/**�����������ļ�**/
			FileWriter output = new FileWriter("C:\\Users\\lau\\Desktop\\somefiles\\catch.txt");
			/**ʵ����Scanner**/
			Scanner reader=new Scanner(System.in);
			/**���д�����һ��ʱ���в���**/
			for(int i=1;i<11;i++) { 
			System.out.println("�������"+i+"�е��ı�");
			/**��ȡ**/		
			in[i-1]=reader.nextLine();		
			}
			/**д������**/
			for (int i=0;i<10;i++) output.write(in[i]+"\n");		
			/**�ر�������**/
			reader.close();
			/**�ر������**/
			output.close();		
		}
		catch (IOException e) {System.out.println(e);}
	
	}

}
