package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Out {
	File f = new File("C:\\Users\\lau\\Desktop\\data.txt");

	public void clear() {
		f.delete();
		f = new File("C:\\Users\\lau\\Desktop\\data.txt");
	}

	public void output(String str) throws IOException {
		// 将写入转化为流的形式
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\lau\\Desktop\\data.txt"));
		// 一次写一行
		bw.append(str);
		bw.newLine(); // 换行用

		// 关闭流
		bw.close();

	}
}
