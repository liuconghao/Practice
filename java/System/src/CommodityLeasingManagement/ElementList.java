/**
 * Ԫ�ض���
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
	/**���ùؼ���
	 * @param s ������б���
	 * **/
	public void settitle(String s) {
		this.title=s;
	}
	/**���޷���
	 * @param name ��Ʒ��
	 * @throws ItemException δ�ҵ���Ŀ�쳣
	 * **/
	protected abstract void Lease(String name) throws ItemException;
	/**�黹����
	 * @param name ��Ʒ��
	 * **/
	protected abstract void revert(String name);
	/**��ӷ���
	 * @param name ��Ʒ��
	 * @param num ����
	 * **/
	protected abstract void appened(String name, int num);
	/**ɾ������
	 * @param name ��Ʒ��
	 * **/
	protected abstract void server(String name);
	/**��ʾ����
	 * TODO ��ӡĳ���͵�������Ŀ
	 * **/
	protected abstract void print();
	/**���ҷ���
	 * @param name ��Ʒ��
	 * @return isget ָʾ����ָʾ�Ƿ��ҵ�
	 * **/
	protected abstract boolean find(String name);
	/**����Ա�鿴����
	 * TODO ��ʾ�������ͼ���Ӧ��Ŀ����ϸ��Ϣ
	 * **/
	protected abstract void diaplay();
}

/**�쳣�ࣺ��Ŀδ�ҵ�ʱ�׳����쳣**/
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