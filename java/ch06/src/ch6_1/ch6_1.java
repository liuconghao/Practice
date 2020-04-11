/**
 * ÊäÈë×Ö·û´®£¬Êä³öÓë[24680]A[13579]{2}Æ¥ÅäµÄ×Ó×Ö·û´®
 */
package ch6_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lau
 * @version 1.0
 */
public class ch6_1 {

	public static void main(String[] args) {
		Pattern p = null;
		Matcher m;
		Scanner reader=new Scanner(System.in);
		String s=reader.nextLine();
		String regex="[24680]A[13579]{2}";
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