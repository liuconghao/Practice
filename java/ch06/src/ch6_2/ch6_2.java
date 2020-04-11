/**
 * 输入带有数字的字符串，输出全部数字字符
 */
package ch6_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lau
 * @version 1.0
 */
public class ch6_2 {

	public static void main(String[] args) {
		Pattern p = null;
		Matcher m;
		Scanner reader=new Scanner(System.in);
		String s=reader.nextLine();
		String regex="\\d+";
		reader.close();
		if (s!=null) {
			p=p.compile(regex);
			m=p.matcher(s);
			while(m.find())
			{
				String str=m.group();
				System.out.println(str);
			}
		}

	}

}


