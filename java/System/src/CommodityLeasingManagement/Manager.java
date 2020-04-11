/**
 * 用户功能
 */
package CommodityLeasingManagement;

/**
 * @author lau
 * @version 1.0
 */
public class Manager extends ElementList{

	private static final long serialVersionUID = 1L;
	/**添加物品**/
	public void appened(String a,int b) {
		node n=new node(a,b);
		this.add(n);
	}
	/**删除物品**/
	public void server(String a) {
		for (int i = 0; i < this.size(); i++) {
            if(this.get(i).name.equals(a)){
            	this.remove(i);
            }
        }
	}
	
	/**租赁物品**/
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
		if(isget==true)System.out.println("租赁成功");
		//else System.out.println("未找到指定物品，请重试");
	}
	/**归还物品**/
	public void revert(String a) {
		boolean isget=false;
		for (int i = 0; i < this.size(); i++) {
            if(this.get(i).name.equals(a)){
            	isget=true;
            	this.get(i).quatity++;
            	this.get(i).Leased--;
            	System.out.println("归还成功");break;
            }
        }
		if(isget!=true)System.out.println("未找到当前物品，请重试");
	}

	/**查找物品
	 * @return isget**/
	public boolean find(String a) {
		boolean isget=false;
		for (int i = 0; i < this.size(); i++) {
			String name=this.get(i).name;
				if(name.equals(a)){
            	isget=true;
            	System.out.println("已找到"+a+",库存为："+this.get(i).quatity);
            	break;
            }
        }
		//if(isget!=true)System.out.println("未找到指定物品，请重试");
		return isget;
	}	
	/**打印物品名称及剩余数量**/
	public void print() {
		for(int i = 0; i < this.size(); i++)
			System.out.println( this.get(i).name+"  *"+this.get(i).quatity);
			}
	/**显示库存详细信息**/
	public void diaplay() {
		// TODO 自动生成的方法存根
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).name+" 库存"+this.get(i).quatity+" 借出"+this.get(i).Leased);	
	}
	}
}


