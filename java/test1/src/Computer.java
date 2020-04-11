/*
 * @author:Lau
 * @version:V1.0 
 * @since:30 April 2019
 * update_log: V1.0 Create code.
 * 
 * */

import java.util.Random;

class Computer {
	int score_computer=0;

	Computer(int score){
		/**Constructor
		 * @param score has been preserved by Class Game.
		 * @param score_computer has been preserved at last.
		 * **/
		score_computer=score;
	}

	int play(){
		/**@param tmp data cache.
		 * @param num2 which come from random.
		 * @return score_computer
		 * */
		int tmp=0;
		System.out.println("计算机的决策");
		while(true){
			Random rand2 = new Random();//实例化随机数类
			int num2 =rand2.nextInt(6)+1;//生成从1到6的随机数
			System.out.println("计算机当前掷出的点数为"+num2);
			if (num2==1) {
				System.out.println("计算机当前决策结束");
				break;}
			else 	{
				tmp+=num2;	
				if(tmp>=20){
					score_computer+=tmp;
					System.out.println("计算机当前掷出的点数累计已满20,已保存，决策结束");
					break;}
			}
		}
		return score_computer;
	}
}