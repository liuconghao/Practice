/**
 * ������һ����Ŀ�б�����á����б���ΪitemList�����������������������̵�����������Ŀ��
 */
package CommodityLeasingManagement;

import java.util.ArrayList;

/**
 * @author lau
 * @version 1.0
 */
public class store {
	ArrayList<ElementList> itemList =new ArrayList<ElementList>(5);
	/**���캯��������һ��itemlist���ٷֱ𴴽�ElementList���󣬽������itemList�У�����ElementList�ṩ��ʼ����**/
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
		Magazine.appened("���ҵ���", 3);
		DVD.appened("��ѧӢ��4", 1);
		Blurays.appened("����������4�վ�֮ս", 1);
		MusicCD.appened("lemon", 4);
	}
}
