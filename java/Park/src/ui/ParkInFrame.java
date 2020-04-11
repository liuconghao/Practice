/*
 * 该ui类用于实现车辆管理菜单下的车辆入场菜单项
 * */
package ui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import park.manager;

public class ParkInFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField carnumberjtextfield;
	private JButton ensurejbutton;

	//构造方法
	public ParkInFrame() {
		super("车辆入场");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(136, 107, 428, 214);
		JPanel mainPanel = new JPanel();			//创建中心面板
		GridBagLayout gridbag = new GridBagLayout();//创建表格布局管理器
		mainPanel.setLayout(gridbag);		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		JLabel carnumberjlabel = new JLabel();	//创建标签
		carnumberjlabel.setText("车牌号：");//设置标签文本
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(carnumberjlabel,c);				//添加到中心面板
		carnumberjtextfield = new JTextField();//创建文本框
		carnumberjtextfield.setColumns(10);//设置文本框长度
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(carnumberjtextfield,c);
	
		ensurejbutton = new JButton();//创建保存按钮
		ensurejbutton.addActionListener(new parkActionListener());//注册监听器
		ensurejbutton.setText("确认入场");//设置按钮文本
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(ensurejbutton,c);//添加到中心面板
		JButton backjbutton = new JButton();//创建返回按钮
		backjbutton.addActionListener(new CloseActionListener());//注册监听器
		backjbutton.setText("返回");//设置按钮文本
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(backjbutton,c);//添加到中心面板
		setVisible(true);											// 显示窗体可见
	}

	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class parkActionListener implements ActionListener {	
		// 添加确认入场按钮的事件监听器
		manager m=new manager();
		public void actionPerformed(final ActionEvent e) {
			String a3 = carnumberjtextfield.getText();
			try {
				m.parking(a3);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "入场成功！");	

		}
	}
}



