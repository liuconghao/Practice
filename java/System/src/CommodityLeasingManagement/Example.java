/**
 * ��ʼ�����������
 */
package CommodityLeasingManagement;

import java.util.Scanner;


/**
 * @author lau
 * @version 1.0
 */
public class Example {
	static store s=new store();
	static Scanner  input =new Scanner(System.in);
	public static void main(String[] args) {
		welcome();
	}

	public static String getName() {
		String a = null;
		a=input.next();
		return a;
	}
	public static String getCmd(){
		String a = null;
		a = input.next();
		return a;
	}

	public static int getNum() {
		int a = 0;
		String s1 =  input.next();
		a = Integer.parseInt(s1);
		return a;
	}
	public static void welcome() {
		System.out.println("��ӭʹ����Ʒ����ϵͳ");
		System.out.println("");
		System.out.println("�밴��ָʾ��ɲ���");
		manage();
	}
	public static void manage() {
		while(true) {
			System.out.println();
			System.out.println("1.չʾ  2.����  3.�黹  4.�˳�");//��̨����ѡ��δ��ʾ��5.�����Ʒ  6.ɾ����Ʒ  7.�����ʾ��
			System.out.println();
			System.out.println("��������ţ�");
			int n = getNum();		
			switch(n) {
			
			case 1://չʾ
				System.out.println("�����������:");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.print(j+1+"."+s.itemList.get(j).title+" ");
				}
				System.out.println();
				System.out.println("�鿴�������ݣ�������������ţ�");
					switch(getNum()){
					case 1:
						s.itemList.get(0).print();break;
					case 2:
						s.itemList.get(1).print();break;
					case 3:
						s.itemList.get(2).print();break;
					case 4:
						s.itemList.get(3).print();break;
					case 5:
						s.itemList.get(4).print();break;
					}break;//չʾ��Ʒ
			
			case 2://����
				System.out.println("������Ҫ��������Ʒ����");
				String name=getName();
				for(int i=0;i<s.itemList.size();i++) {
					boolean isfind=s.itemList.get(i).find(name);
					if(isfind) {	
						System.out.println("�Ƿ����ޣ�y/n)");
						char[] a=getCmd().toCharArray();
						if(a[0]=='y'||a[0]=='Y') {
							try {
								s.itemList.get(i).Lease(name);
							} 
							catch (ItemException e) {e.printStackTrace();}
						}break;
					}
					else continue;
				}break;
			case 3://�黹
				System.out.println("������Ҫ�黹����Ʒ����");
				String na=getName();
				for(int i=0;i<s.itemList.size();i++) {
					for(int j=0;j<s.itemList.size();j++) {
					if(s.itemList.get(i).find(na)) {
						s.itemList.get(i).revert(na);break;
						}
					}
			}break;
			case 4:System.out.println("��лʹ��");System.exit(0);
			case 5:{//���
				System.out.println("�����Ʒ:");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.print(j+1+"."+s.itemList.get(j).title+" ");
				}
				System.out.println();
				System.out.println("ѡ�����ͣ�������ţ�");
				switch(getNum()){
				case 1:
					System.out.println("��������Ʒ�����������ո����");
					s.itemList.get(0).appened(getName(),getNum());break;
				case 2:
					System.out.println("��������Ʒ�����������ո����");
					s.itemList.get(1).appened(getName(),getNum());break;
				case 3:
					System.out.println("��������Ʒ�����������ո����");
					s.itemList.get(2).appened(getName(),getNum());break;
				case 4:
					System.out.println("��������Ʒ�����������ո����");
					s.itemList.get(3).appened(getName(),getNum());break;
				case 5:
					System.out.println("��������Ʒ�����������ո����");
					s.itemList.get(4).appened(getName(),getNum());break;
				}  
			}break;
			case 6:{//ɾ��
				System.out.println("ɾ����Ʒ:");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.print(j+1+"."+s.itemList.get(j).title+" ");
				}
				System.out.println();
				System.out.println("ѡ�����ͣ�������ţ�");
				switch(getNum()){
				case 1:
					System.out.println("��������Ʒ��");
					s.itemList.get(0).server(getName());break;
				case 2:
					System.out.println("��������Ʒ��");
					s.itemList.get(1).server(getName());break;
				case 3:
					System.out.println("��������Ʒ��");
					s.itemList.get(2).server(getName());break;
				case 4:
					System.out.println("��������Ʒ��");
					s.itemList.get(3).server(getName());break;
				case 5:
					System.out.println("��������Ʒ��");
					s.itemList.get(4).server(getName());break;
				} 
			}break;
			case 7://��ʾ�����Ϣ
				System.out.println("�����Ʒ��ϸ��Ϣ��");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.println(j+1+"."+s.itemList.get(j).title+":");
					s.itemList.get(j).diaplay();
				}break;
			}
		}
	}
}