/*
 * @author:Lau
 * @version:V1.0 
 * @since:30 April 2019
 * update_log: V1.0 Create code.
 * 
 * */


import java.util.Random;
import java.util.Scanner;

 class Player {
	Player(int score1){
		/**@param score1 has been preserved by Class Game.
		 * Constructor
		 * **/
		score=score1;
	}
	int score=0;/**@param score the score at this moment**/
	int play(){
		System.out.println("你的决策是？");
		while(true){
			Random rand = new Random();
			int num =rand.nextInt(6)+1;	//生成从1到6的随机数
			if(num==1){
				System.out.println("你的点数为1，当前决策结束");
				break;}
			else {
				System.out.println("你当前掷出的点数为"+num);
				System.out.println("请输入指令：（r：重掷  h:保存得分)");
				Scanner conmmand=new Scanner(System.in);
				String cmd1=conmmand.next();
				/**@param cmd1 command by input.
				 * @param cmd After change String to Char.
				 **/
				char cmd=cmd1.charAt(0);
				if (cmd=='r')continue;
				else if (cmd=='h'){
					score+=num;
					break;}
				conmmand.close();}
		}
		return score;
	}
}
