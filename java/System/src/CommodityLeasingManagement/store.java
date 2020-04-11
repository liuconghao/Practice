/**
 * 保存了一个项目列表的引用。该列表（称为itemList）的类型是链表，它包含了商店里面所有项目。
 */
package CommodityLeasingManagement;

import java.util.ArrayList;

/**
 * @author lau
 * @version 1.0
 */
public class store {
	ArrayList<ElementList> itemList =new ArrayList<ElementList>(5);
	/**构造函数，创建一个itemlist，再分别创建ElementList对象，将其加入itemList中，并给ElementList提供初始数据**/
	store() {
		Manager Book=new Manager();
		Book.settitle("Book");
		Manager Magazine=new Manager();
		Magazine.settitle("Magazine");
		Manager DVD=new Manager();
		DVD.settitle("DVD");
		Manager Blurays=new Manager();
		Blurays.settitle("Blurays");
		Manager MusicCD=new Manager();
		MusicCD.settitle("MusicCD");
		itemList.add(Book);
		itemList.add(Magazine);
		itemList.add(DVD);
		itemList.add(Blurays);
		itemList.add(MusicCD);	
		Book.appened( "Java", 1);
		Book.appened( "C++", 2);
		Magazine.appened("国家地理", 3);
		DVD.appened("大学英语4", 1);
		Blurays.appened("复仇者联盟4终局之战", 1);
		MusicCD.appened("lemon", 4);
	}
}
