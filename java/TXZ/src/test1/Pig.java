package test1;

import java.util.Random;
import java.util.Scanner;

public class Pig 	{
	void play(){
		int score1=0;
		int score2=0;
		int i=1;
		while(true){
			System.out.println("��"+i+"�غ�");
			//player
			System.out.println("��Ļغ�");
			while(score1<100){
			Random rand = new Random();
			int num =rand.nextInt(6)+1;	//���ɴ�1��6�������
			if(num==1){
				System.out.println("��ĵ���Ϊ1�����غϽ���");
				break;}
			else {
				System.out.println("��ǰ�غϵ÷�Ϊ"+num);
				System.out.println("������ָ���r������  h:����÷�)");
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
			System.out.println("�ҵĻغ�");
			while(score2<100)//computer
				{	
				Random rand2 = new Random();
				int num2 =rand2.nextInt(6)+1;//���ɴ�1��6�������
				if (num2==1)break;
				else 	{
					tmp+=num2;	
					if(tmp>=20){
						score2+=tmp;
						break;}
					}
				};
			System.out.println("��ĵ÷�Ϊ;"+score1+",�ҵĵ÷�Ϊ��"+score2);
			if(score2>=100||score1>=100)break;
			i++;}
		if (score2>=100)System.out.println("hhh,��Ӯ�ˣ�");
		else System.out.println("GDX,��Ӯ�ˣ�");}		
}


	
	


	

