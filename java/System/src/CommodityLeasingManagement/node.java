package CommodityLeasingManagement;

public class node {
	/** 节点类定义 **/
	int quatity; // 总数量
	int Leased = 0; // 借出数量
	String name; // 物品名称

	node(String a, int b) {
		this.name = a;
		this.quatity = b;
	}
}
