package elements;

public class Car {
	public String number;
	public boolean info;
	public long time;
	public Car(String str){
		this.number=str;
		this.time=System.currentTimeMillis();
		}
	public Car(String str,Boolean a,long b) {
		this.number=str;
		this.info=a;
		this.time=b;
	}
	public void info() {
		this.info=true;
	}
	public void time() {
		this.time=System.currentTimeMillis();
	}
		public String tostring() {
			return number+","+info+","+time;
		}

}
