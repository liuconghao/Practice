/**
 * 输出某年某月日历页，main函数传参
 */
package ch07;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author lau
 * @version 1.0
 */
public class Ch07_1 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入年份和日期，请用空格隔开");
		int year = reader.nextInt();
		int month  = reader.nextInt()-1;
		reader.close();
		cale(year,month);
	}
	
	public static void cale(int a,int b) {
		Calendar cale = Calendar.getInstance();
		cale.set(a,b,1);
		int days;
		b+=1;
		int weekday = cale.get(Calendar.DAY_OF_WEEK)-1;
		if(b==1||b==3||b==5||b==7||b==8||b==10||b==12) {
			days=weekday+31;
		}
		else if(b==2) {
			days=weekday+28;
			if (a%4==0) days++;
		}
		else days=weekday+30;
		String[] s = new String[days];
		for(int i=0;i<weekday;i++)  s[i]=" ";
		for(int i=weekday,n=1;i<days;i++) 
		{
			s[i]=String.valueOf(n);
			n++;
		}
		System.out.println(a+"年"+b+"月的日历为");
		System.out.println("  Sun  Mon  Tue  Wed  Thur  Fri  Sat");
		for(int i=0;i<s.length;i++) {
			if (i%7==0&&i!=0) System.out.printf("\n");
			System.out.printf("%5s",s[i]);
		}
	}

}
