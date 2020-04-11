package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import elements.Car;
import elements.LinkedList;

public class In {
	LinkedList<Car>list=new LinkedList<Car>();
	public void input() throws FileNotFoundException {
		/* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\\\Users\\\\lau\\\\Desktop\\\\data.txt")),
                                                                         "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {//数据以逗号分隔
                String[] item = lineTxt.split(",");
                Boolean info=Boolean.valueOf(item[1]);
                long time=Long.parseLong(item[2]);
                Car tmp=new Car(item[0],info,time);
                list.add(tmp);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
	}
	public  LinkedList<Car> back() {
		return list;
	}
}
