/**
 * 初始化及程序入口
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
		System.out.println("欢迎使用商品租赁系统");
		System.out.println("");
		System.out.println("请按照指示完成操作");
		manage();
	}
	public static void manage() {
		while(true) {
			System.out.println();
			System.out.println("1.展示  2.搜索  3.归还  4.退出");//后台管理选项未显示（5.添加物品  6.删除物品  7.库存显示）
			System.out.println();
			System.out.println("请输入序号：");
			int n = getNum();		
			switch(n) {
			
			case 1://展示
				System.out.println("库存内容类型:");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.print(j+1+"."+s.itemList.get(j).title+" ");
				}
				System.out.println();
				System.out.println("查看具体内容？请输入类型序号：");
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
					}break;//展示物品
			
			case 2://搜索
				System.out.println("请输入要搜索的物品名：");
				String name=getName();
				for(int i=0;i<s.itemList.size();i++) {
					boolean isfind=s.itemList.get(i).find(name);
					if(isfind) {	
						System.out.println("是否租赁（y/n)");
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
			case 3://归还
				System.out.println("请输入要归还的物品名：");
				String na=getName();
				for(int i=0;i<s.itemList.size();i++) {
					for(int j=0;j<s.itemList.size();j++) {
					if(s.itemList.get(i).find(na)) {
						s.itemList.get(i).revert(na);break;
						}
					}
			}break;
			case 4:System.out.println("感谢使用");System.exit(0);
			case 5:{//添加
				System.out.println("添加物品:");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.print(j+1+"."+s.itemList.get(j).title+" ");
				}
				System.out.println();
				System.out.println("选择类型（输入序号）");
				switch(getNum()){
				case 1:
					System.out.println("请输入物品名和数量，空格隔开");
					s.itemList.get(0).appened(getName(),getNum());break;
				case 2:
					System.out.println("请输入物品名和数量，空格隔开");
					s.itemList.get(1).appened(getName(),getNum());break;
				case 3:
					System.out.println("请输入物品名和数量，空格隔开");
					s.itemList.get(2).appened(getName(),getNum());break;
				case 4:
					System.out.println("请输入物品名和数量，空格隔开");
					s.itemList.get(3).appened(getName(),getNum());break;
				case 5:
					System.out.println("请输入物品名和数量，空格隔开");
					s.itemList.get(4).appened(getName(),getNum());break;
				}  
			}break;
			case 6:{//删除
				System.out.println("删除物品:");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.print(j+1+"."+s.itemList.get(j).title+" ");
				}
				System.out.println();
				System.out.println("选择类型（输入序号）");
				switch(getNum()){
				case 1:
					System.out.println("请输入物品名");
					s.itemList.get(0).server(getName());break;
				case 2:
					System.out.println("请输入物品名");
					s.itemList.get(1).server(getName());break;
				case 3:
					System.out.println("请输入物品名");
					s.itemList.get(2).server(getName());break;
				case 4:
					System.out.println("请输入物品名");
					s.itemList.get(3).server(getName());break;
				case 5:
					System.out.println("请输入物品名");
					s.itemList.get(4).server(getName());break;
				} 
			}break;
			case 7://显示库存信息
				System.out.println("库存物品详细信息：");
				for(int j=0;j<s.itemList.size();j++) {
					System.out.println(j+1+"."+s.itemList.get(j).title+":");
					s.itemList.get(j).diaplay();
				}break;
			}
		}
	}
}