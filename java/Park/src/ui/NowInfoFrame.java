/*
 * 该ui类用于实现查询菜单下当前在场信息的显示
 * */
package ui;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;																		
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import park.manager;



public class NowInfoFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	manager m=new manager();

	

	//构造方法
	public NowInfoFrame() {
		super("当前在场信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(142,106,449,279));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		String [] nowin = {"车牌号","是否在车位中停放", "停放时间"};
		Object[][] results=m.show();
		JTable table = new JTable(results,nowin);
		JScrollPane scroll = new JScrollPane(table);
		mainPanel.add(scroll,BorderLayout.CENTER);		//将中心面板加入到窗体
		setVisible(true);
	}
}

















