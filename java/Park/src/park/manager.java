package park;

import java.io.IOException;

public class manager {
	private String pwd="";
	private double price=1.0;
	static park p= new park();
	public manager(){
		this.pwd="123456";
	}
	public void change_pwd(String NEW) {
		pwd=NEW;
	}
	public void chenge_max(int a) {
		p.change_smax(a);
	}
	public void parking(String str) throws IOException {
		p.in(str);
	}
	public String leaving(String str) {
		return p.out(str);
	}
	public double price() {
		return price;
	}
	public String usedtime(String str) {
		if (p.search(str).info) {
			long endtime = System.currentTimeMillis();
			long usedtime = (endtime - p.search(str).time) / (1000 * 60);
			return String.valueOf(usedtime);
		}
		else return null;		
	}
	public double fee(String str) {
		double fee=0.0;
		if (p.search(str).info) {
			long endtime = System.currentTimeMillis();
			long usedtime = (endtime - p.search(str).time) / (1000 * 60);
			if (usedtime  > 0) {
				fee = usedtime * price;
			} 
		}
		return fee;
	}
	public String login() {
		return pwd;
	}

	public Object[][] show() {
		Object[][] s = new Object[p.count()][3];
		long endtime = System.currentTimeMillis();
		for (int i = 0; i < p.scount(); i++) {
			s[i][0] = p.place.get(i).number;
			s[i][1] = p.place.get(i).info;
			s[i][2] = (endtime-p.place.get(i).time)/(1000*60);
		}
		for(int j=0;j<p.count()-p.scount();j++) {
			s[p.scount()+j][0] = p.road.get(j).number;
			s[p.scount()+j][1] = p.road.get(j).info;
			s[p.scount()+j][2] = (endtime-p.road.get(j).time)/(1000*60);	
		}
		return s;
}
}
