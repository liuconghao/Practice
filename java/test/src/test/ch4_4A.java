package test;

public class ch4_4A{
	//�������
		int f(int a,int b){    
			while(a!=b) {
				if (a>b) a=a-b;
				else b=b-a;				
			}
			return a;
		}
}
