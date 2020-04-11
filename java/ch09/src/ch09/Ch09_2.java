/**
 * 将从键盘输入的十行文本存入指定文件
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
			/**创建“捕获”文件**/
			FileWriter output = new FileWriter("C:\\Users\\lau\\Desktop\\somefiles\\catch.txt");
			/**实例化Scanner**/
			Scanner reader=new Scanner(System.in);
			/**当有存在下一行时进行操作**/
			for(int i=1;i<11;i++) { 
			System.out.println("请输入第"+i+"行的文本");
			/**读取**/		
			in[i-1]=reader.nextLine();		
			}
			/**写入数据**/
			for (int i=0;i<10;i++) output.write(in[i]+"\n");		
			/**关闭输入流**/
			reader.close();
			/**关闭输出流**/
			output.close();		
		}
		catch (IOException e) {System.out.println(e);}
	
	}

}
