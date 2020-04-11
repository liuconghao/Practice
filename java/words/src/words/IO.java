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
/**���ڶ�ȡ�����Ҷ����ݽ��д������**/
public class IO {
	/**�����������**/
	Item tmp = new Item(null);
	/**��ȡ���ݽ��д�������� **/
	public void io() {
		/**���ڿ��ܻ�����ļ�����Ŀ��Ŀ¼������������Ҫ���񲢴����쳣.**/
		/**@param wd Data instances.**/
		try{
			/**����Ŀ���ļ�**/
			FileReader input = new FileReader("D:/words.txt");
			/**���ж�ȡĿ���ļ�**/
			BufferedReader ipt = new BufferedReader(input);
			/**����������Ϊ��ʱ�����ж�ȡ**/
			while (ipt.readLine()!=null) { 	
				/**������ʵ�������������**/
				Item wd = new Item(ipt.readLine());
				wd.num=sum(wd.word);
				/**�����ݽ���ѡ����**/
				comp(tmp,wd);
			}
			/**�ر�������**/
			ipt.close();
			/**����̨���**/
			System.out.println("�����ظ���ĸ�����ĵ���Ϊ"+tmp.word+"����"+tmp.num+"���ظ���ĸ��");
			/**�����������ļ�**/
			FileWriter output = new FileWriter("D:/catch.txt");
			/**д������**/
			output.write(tmp.word);
			/**�ر������**/
			output.close();		
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	/**������������������ݽ��бȶԣ������ظ���ĸ�������������**/
	private void comp(Item a ,Item b) {
		if (a.num<b.num) {
			a.num=b.num;
			a.word=b.word;}
	}

	/**���ڼ����ظ���ĸ�����ĺ���**/
	private int sum(String a) {
		int count = 0;//TODO ������
		int i;
		char[]c=a.toCharArray();//���õ���String��������װ��λchar�������
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

