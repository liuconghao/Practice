package test1;
 import java.util.*;
public class Tanxz {
	
	int score,score2;
	int num_score=0;
	int num_score2=0;
	void play()
	{
		while(true)
		{
			/*玩家的回合*/
			while(score<100)
			{
	{System.out.println("玩家的回合");
	int score=(int)(Math.random()*6+1);
	if(score!=1)
	{  
		/*r 重掷，h 保留*/
		Scanner chioce=new Scanner(System.in);
		String c=chioce.next();
		char s=c.charAt(0);
		if(s=='r') 
		{
			System.out.println("玩家选择再掷一次，请再掷一次");
			continue;
		}
		else if(s=='h')
		{
			num_score=num_score+score;
			System.out.println("玩家选择保留得分，当前的分数总和为："+num_score);
		}
		}
	else
		break;
	}
	
	}
		/*计算机的回合*/
			while(score2<100){
		System.out.println("计算机的回合");
		int score2=(int)(Math.random()*6+1);
		if(score2!=1)
		{
			int sum = 0;
			sum=score2+sum;
		 if(sum>=20)
			 {num_score2=sum+num_score2;
				System.out.println("计算机本回合已结束，当前得分为："+num_score2);}
		 else if(score2==1)break;
		}
		else break;	
			}
			
		if(score>=100||score2>=100)break;
	}
		if(score>=100)
			System.out.println("玩家 获胜");
		if(score2>=100)
			System.out.println("计算机获胜");
			
			
}
}
   




