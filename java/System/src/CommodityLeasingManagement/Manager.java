/**
 * �û�����
 */
package CommodityLeasingManagement;

/**
 * @author lau
 * @version 1.0
 */
public class Manager extends ElementList{

	private static final long serialVersionUID = 1L;
	/**�����Ʒ**/
	public void appened(String a,int b) {
		node n=new node(a,b);
		this.add(n);
	}
	/**ɾ����Ʒ**/
	public void server(String a) {
		for (int i = 0; i < this.size(); i++) {
            if(this.get(i).name.equals(a)){
            	this.remove(i);
            }
        }
	}
	
	/**������Ʒ**/
	public void Lease(String a) throws ItemException{
		boolean isget=false;
		for (int i = 0; i < this.size(); i++) {
        if(this.get(i).name.equals(a)){
        	if (this.get(i).quatity>0) {
            		this.get(i).quatity--;
            		this.get(i).Leased++;
            		isget=true;break;
            	}
            	else {
            		ItemException e=new ItemException();
            		System.out.println(e.getmessage());
            	}
            }
        }
		if(isget==true)System.out.println("���޳ɹ�");
		//else System.out.println("δ�ҵ�ָ����Ʒ��������");
	}
	/**�黹��Ʒ**/
	public void revert(String a) {
		boolean isget=false;
		for (int i = 0; i < this.size(); i++) {
            if(this.get(i).name.equals(a)){
            	isget=true;
            	this.get(i).quatity++;
            	this.get(i).Leased--;
            	System.out.println("�黹�ɹ�");break;
            }
        }
		if(isget!=true)System.out.println("δ�ҵ���ǰ��Ʒ��������");
	}

	/**������Ʒ
	 * @return isget**/
	public boolean find(String a) {
		boolean isget=false;
		for (int i = 0; i < this.size(); i++) {
			String name=this.get(i).name;
				if(name.equals(a)){
            	isget=true;
            	System.out.println("���ҵ�"+a+",���Ϊ��"+this.get(i).quatity);
            	break;
            }
        }
		//if(isget!=true)System.out.println("δ�ҵ�ָ����Ʒ��������");
		return isget;
	}	
	/**��ӡ��Ʒ���Ƽ�ʣ������**/
	public void print() {
		for(int i = 0; i < this.size(); i++)
			System.out.println( this.get(i).name+"  *"+this.get(i).quatity);
			}
	/**��ʾ�����ϸ��Ϣ**/
	public void diaplay() {
		// TODO �Զ����ɵķ������
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).name+" ���"+this.get(i).quatity+" ���"+this.get(i).Leased);	
	}
	}
}


