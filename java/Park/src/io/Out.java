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
		// ��д��ת��Ϊ������ʽ
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\lau\\Desktop\\data.txt"));
		// һ��дһ��
		bw.append(str);
		bw.newLine(); // ������

		// �ر���
		bw.close();

	}
}