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
			/*��ҵĻغ�*/
			while(score<100)
			{
	{System.out.println("��ҵĻغ�");
	int score=(int)(Math.random()*6+1);
	if(score!=1)
	{  
		/*r ������h ����*/
		Scanner chioce=new Scanner(System.in);
		String c=chioce.next();
		char s=c.charAt(0);
		if(s=='r') 
		{
			System.out.println("���ѡ������һ�Σ�������һ��");
			continue;
		}
		else if(s=='h')
		{
			num_score=num_score+score;
			System.out.println("���ѡ�����÷֣���ǰ�ķ����ܺ�Ϊ��"+num_score);
		}
		}
	else
		break;
	}
	
	}
		/*������Ļغ�*/
			while(score2<100){
		System.out.println("������Ļغ�");
		int score2=(int)(Math.random()*6+1);
		if(score2!=1)
		{
			int sum = 0;
			sum=score2+sum;
		 if(sum>=20)
			 {num_score2=sum+num_score2;
				System.out.println("��������غ��ѽ�������ǰ�÷�Ϊ��"+num_score2);}
		 else if(score2==1)break;
		}
		else break;	
			}
			
		if(score>=100||score2>=100)break;
	}
		if(score>=100)
			System.out.println("��� ��ʤ");
		if(score2>=100)
			System.out.println("�������ʤ");
			
			
}
}
   




