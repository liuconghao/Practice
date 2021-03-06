package park;


import java.io.IOException;
import elements.Car;
import elements.LinkedList;
import elements.Stack;
import io.Out;

public class park {
	Stack<Car> place = new Stack<Car>();
	LinkedList<Car> road = new LinkedList<Car>();
	Out output = new Out();
	static private int s_max = 3;
	static private int s_count = 0;
	static private int r_count = 0;
	static private int count = 0;
	public int smax() {
		return s_max;
	}
	public int scount() {
		return s_count;
	}
	public int count() {
		return count;
	}

	void change_smax(int a) {
		park.s_max = a;
	}

	int size() {
		return count;
	}

/*	void file_in() {
		In in = new In();
		try {
			in.input();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (in.back().size() > 0) {
			for (int i = 0; i < in.back().size(); i++) {
				if (i < s_max) {
					place.add(in.back().get(i));
					s_count++;
				} else {
					road.add(in.back().get(i));
					count++;
				}
			}
			count += s_count;
		}
	}
*/
	void in(String str) throws IOException {
		Car tmp = new Car(str);
		if (s_count < s_max) {
			tmp.info();
			place.add(tmp);
			s_count++;
			output.output(place.peek().tostring());
		} else {
			road.add(tmp);
			r_count++;
			output.output(road.get(count - s_count - 1).tostring());
		}
		count=s_count+r_count;

	}

	@SuppressWarnings("unused")
	public String out(String str) {
		String infomation = "提车成功";
		if(count!=0) {
			for(int i=0;i<count - s_count;i++) {
				if(road.get(i).number.equals(str)) {
					road.remove(i);
					r_count--;
					count--;
				return infomation;
				}
			}
			Stack<Car>tmp=new Stack<Car>();
			for(int j=s_count-1;j>=0;j--) {
				if(place.get(j).number.equals(str)) {
					place.pop();
					s_count--;
					count--;
				}
				else {
					tmp.push(place.pop());
					s_count--;
				}
			}
			while(!tmp.isEmpty()) {
				place.push(tmp.pop());
				s_count++;
			}
			if(s_count==s_max) return infomation="未找到该车辆";
			else if(r_count>0&&s_count<s_max) {
				Car item=road.remove();
				item.info();
				item.time();
				place.push(item);
				s_count++;
				r_count--;
			}
		}else {
			infomation="车位中未停放车辆";
		}
		return infomation;
	}
	public Car search(String str) {
		if (count!=0) {
			for(int i=0;i<count-s_count;i++)
				if(road.get(i).number.equals(str))
					return road.get(i);
			for(int j =0;j<s_count;j++)
				if(place.get(j).number.equals(str))
					return place.get(j);
			return null;
		}
		return null;
	}
	
}
