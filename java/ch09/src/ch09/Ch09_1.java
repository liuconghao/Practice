/**
 * 读取文本文件内容,并输出到新建文件
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
			/**载入目标文件**/
			FileReader input = new FileReader("C:\\Users\\lau\\Desktop\\somefiles\\old.txt");
			/**读取目标文件**/
			BufferedReader ipt = new BufferedReader(input);			
			/**当缓冲区不为空时，进行分行读取**/
			while (ipt.readLine()!=null) { 	
				/**创建并实例化读入的数据**/
				String in=ipt.readLine();
				/**打印数据**/
				System.out.println(in);;	
			}
			/**关闭输入流**/
			ipt.close();	
		}
		catch (IOException e) {System.out.println(e);}
	}
}
