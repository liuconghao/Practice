/*
 * 该ui类用于显示查询菜单里的计费标准菜单项
 * 
 * */
package ui;

import java.awt.GridLayout;
import java.awt.Rectangle;



import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;


import javax.swing.border.EmptyBorder;
import park.manager;

public class ChargeFrame extends JInternalFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;





	private static JLabel bigjtextfield1;

	private static JLabel smalljtextfield1;



	//构造方法
	public  ChargeFrame() {
		super("计费标准");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(206,76,331,300));

		JPanel Panel1 = new JPanel();//创建中心面板
		Panel1.setLayout(new GridLayout(6,2));//设置布局
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));//设置边框
		getContentPane().add(Panel1);

		JLabel bigjlabel1 = new JLabel();//创建车位（元/h）标签
		bigjlabel1.setText("车位（元/h）：");//设置标签文本
		Panel1.add(bigjlabel1);	//添加到中心面板
		bigjtextfield1 = new JLabel();//创建标签
		Panel1.add(bigjtextfield1);//添加到中心面板

		JLabel smalljlabel1 = new JLabel();//创建便道车位（元/h）标签
		smalljlabel1.setText("便道车位（元/h）：");//设置标签文本
		Panel1.add(smalljlabel1);//添加到中心面板
		smalljtextfield1 = new JLabel();//创建标签
		Panel1.add(smalljtextfield1);//添加到中心面板

		manager m=new manager();
	
		String a1 = String.valueOf(m.price());
		bigjtextfield1.setText(a1);
		String a2 ="0.0";
		smalljtextfield1.setText(a2);

		setVisible(true);// 显示窗体可见	
	}		
}
