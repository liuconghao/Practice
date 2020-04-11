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
		System.out.println("������ľ���");
		while(true){
			Random rand2 = new Random();//ʵ�����������
			int num2 =rand2.nextInt(6)+1;//���ɴ�1��6�������
			System.out.println("�������ǰ�����ĵ���Ϊ"+num2);
			if (num2==1) {
				System.out.println("�������ǰ���߽���");
				break;}
			else 	{
				tmp+=num2;	
				if(tmp>=20){
					score_computer+=tmp;
					System.out.println("�������ǰ�����ĵ����ۼ�����20,�ѱ��棬���߽���");
					break;}
			}
		}
		return score_computer;
	}
}