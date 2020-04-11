/**
 * 编写三个线程，使它们有更多的共享单元
 */
package ch08;

/**
 * @author lau
 * @version 1.0
 */
class Threads extends Thread{
	int n=0;
	Count count = new Count(); 
	Threads(String s,int n){
		setName(s);		
		this.n=n;
	}
	public void run() {
		for(int i=0;i<8;i++) {
			System.out.println("I'm "+getName()+". 第"+count.count()+"次调用");	
			try {sleep(n);}
			catch(InterruptedException e) {}
		}
	}
}
class Count {
	private Integer countNum=0;
	public int count() {     
		countNum++;
		return countNum;  
	}  
}
public class Ch08_3 {

	public static void main(String[] args) {
		Threads a,b,c;
		a=new Threads ("Apple",100);
		b=new Threads ("Microsoft",200);
		c=new Threads ("Google",300);
		a.start();
		b.start();
		c.start();
	}

}
