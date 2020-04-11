/**
 * 元素定义
 */
package CommodityLeasingManagement;
import java.util.ArrayList;
/**
 * @author lau
 * @version 1.0
 */

public abstract class ElementList extends ArrayList<node>{
	private static final long serialVersionUID = 1L;
	String title;
	/**设置关键字
	 * @param s 读入的列表名
	 * **/
	public void settitle(String s) {
		this.title=s;
	}
	/**租赁方法
	 * @param name 物品名
	 * @throws ItemException 未找到项目异常
	 * **/
	protected abstract void Lease(String name) throws ItemException;
	/**归还方法
	 * @param name 物品名
	 * **/
	protected abstract void revert(String name);
	/**添加方法
	 * @param name 物品名
	 * @param num 数量
	 * **/
	protected abstract void appened(String name, int num);
	/**删除方法
	 * @param name 物品名
	 * **/
	protected abstract void server(String name);
	/**显示方法
	 * TODO 打印某类型的所有项目
	 * **/
	protected abstract void print();
	/**查找方法
	 * @param name 物品名
	 * @return isget 指示器，指示是否找到
	 * **/
	protected abstract boolean find(String name);
	/**管理员查看方法
	 * TODO 显示所有类型及对应项目的详细信息
	 * **/
	protected abstract void diaplay();
}

/**异常类：项目未找到时抛出此异常**/
class ItemException extends Exception{

	private static final long serialVersionUID = 1L;
	String message;
	ItemException(){
		message="item not found";
	}
	public String getmessage() {
		return message;
	}
}