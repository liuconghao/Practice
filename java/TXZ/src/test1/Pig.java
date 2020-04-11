package test1;

import java.util.Random;
import java.util.Scanner;

public class Pig 	{
	void play(){
		int score1=0;
		int score2=0;
		int i=1;
		while(true){
			System.out.println("第"+i+"回合");
			//player
			System.out.println("你的回合");
			while(score1<100){
			Random rand = new Random();
			int num =rand.nextInt(6)+1;	//生成从1到6的随机数
			if(num==1){
				System.out.println("你的点数为1，本回合结束");
				break;}
			else {
				System.out.println("当前回合得分为"+num);
				System.out.println("请输入指令：（r：重掷  h:保存得分)");
				Scanner conmmand=new Scanner(System.in);
			    String cmd1=conmmand.next();
			    char cmd=cmd1.charAt(0);
				if (cmd=='r')continue;
				else if (cmd=='h'){
					score1+=num;
					break;}
				conmmand.close();}
			};
			int tmp=0;
			System.out.println("我的回合");
			while(score2<100)//computer
				{	
				Random rand2 = new Random();
				int num2 =rand2.nextInt(6)+1;//生成从1到6的随机数
				if (num2==1)break;
				else 	{
					tmp+=num2;	
					if(tmp>=20){
						score2+=tmp;
						break;}
					}
				};
			System.out.println("你的得分为;"+score1+",我的得分为："+score2);
			if(score2>=100||score1>=100)break;
			i++;}
		if (score2>=100)System.out.println("hhh,我赢了！");
		else System.out.println("GDX,你赢了！");}		
}


	
	


	

