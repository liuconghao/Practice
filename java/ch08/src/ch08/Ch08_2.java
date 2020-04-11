/**
 * 编写三个线程，分别在控制台输出信息
 */
package ch08;

/**
 * @author lau
 * @version 1.0
 */
class WriteWordThread extends Thread{
	int n=0;
	WriteWordThread(String s,int n){
		setName(s);
		this.n=n;
	}
	public void run() {
		for(int i=0;i<8;i++) {
			System.out.println("I'm "+getName());
			try {sleep(n);}
			catch(InterruptedException e) {}
		}
	}
}
public class Ch08_2 {

	public static void main(String[] args) {
		WriteWordThread a,b,c;
		a=new WriteWordThread ("Apple",100);
		b=new WriteWordThread ("Microsoft",200);
		c=new WriteWordThread ("Google",300);
		a.start();
		b.start();
		c.start();
	}

}
