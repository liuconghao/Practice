/*
 * @author:Lau
 * @version:V1.2 
 * @since:30 April 2019
 * update_log:V1.2 Splitting up class Game 
 *            V1.1 Change function;
 *            V1.0 Create code.
 * 
 * */

class Game 	{
	/**游戏主体**/
	void run(){
		// TODO Auto-run
		//Return no value
		int score_player=0;
		int score_computer=0;
		int count=1;
		Player p=new Player(score_player);
		Computer c=new Computer(score_computer);
		while(true){
			System.out.println("第"+count+"回合");			
			score_player=p.play();
			score_computer=c.play();
			System.out.println("你的得分为;"+score_player+",计算机的得分为："+score_computer);
			if(score_computer>=100||score_player>=100)break;
			count++;
			}
		if (score_computer>=100)System.out.println("hhh,我赢了！");
		else System.out.println("GDX,你赢了！");}		
}
