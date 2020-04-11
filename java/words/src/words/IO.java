/*
 * @author: Lau
 * @version: V1.1
 * @since: 25 April 2019
 * update_log: V1.1 add function
 *             V1.0 created
 */
package words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**用于读取数据且对数据进行处理的类**/
public class IO {
	/**创建缓冲对象**/
	Item tmp = new Item(null);
	/**读取数据进行处理并输出。 **/
	public void io() {
		/**由于可能会出现文件不在目标目录的情况，因此需要捕获并处理异常.**/
		/**@param wd Data instances.**/
		try{
			/**载入目标文件**/
			FileReader input = new FileReader("D:/words.txt");
			/**分行读取目标文件**/
			BufferedReader ipt = new BufferedReader(input);
			/**当缓冲区不为空时，进行读取**/
			while (ipt.readLine()!=null) { 	
				/**创建并实例化读入的数据**/
				Item wd = new Item(ipt.readLine());
				wd.num=sum(wd.word);
				/**对数据进行选择保留**/
				comp(tmp,wd);
			}
			/**关闭输入流**/
			ipt.close();
			/**控制台输出**/
			System.out.println("出现重复字母对最多的单词为"+tmp.word+"，有"+tmp.num+"个重复字母对");
			/**创建“捕获”文件**/
			FileWriter output = new FileWriter("D:/catch.txt");
			/**写入数据**/
			output.write(tmp.word);
			/**关闭输出流**/
			output.close();		
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	/**将缓冲对象与读入的数据进行比对，保留重复字母对数量多的数据**/
	private void comp(Item a ,Item b) {
		if (a.num<b.num) {
			a.num=b.num;
			a.word=b.word;}
	}

	/**用于计算重复字母对数的函数**/
	private int sum(String a) {
		int count = 0;//TODO 计数器
		int i;
		char[]c=a.toCharArray();//将拿到的String类型数据装换位char数组待用
		for (i=0;i<a.length()-1;i++) {
			if(c[i+1]==c[i]) {
				count++;
				c[i+1]='@';
				c[i]='!';
			}
		}
	
		return count;
	}

}

