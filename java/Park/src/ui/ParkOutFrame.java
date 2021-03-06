/*
 * 该ui类用于实现车辆管理菜单下的车辆出场菜单项
 * */
package ui;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import park.manager;

public class ParkOutFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField carnumberjtextfield;//创建文本框
	private JLabel sumparkjtextfield ;//创建文本框
	private JLabel feejtextfield ;//创建文本框

	//构造方法
	public ParkOutFrame() {
		super("车辆出场");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		JPanel mainPanel = new JPanel();			//创建中心面板
		GridLayout gridLayout = new GridLayout(4,1);//创建表格布局管理器
		gridLayout.setVgap(20);					//设置组件之间垂直距离
		gridLayout.setHgap(10);					//设置组件之间平行距离
		mainPanel.setLayout(gridLayout);		//设置布局
		mainPanel.setBorder(new EmptyBorder(30, 10, 20, 10));		//设置边框
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		setBounds(186,40,329,360);		
		JPanel Panel1 = new JPanel();			
		GridLayout gridLayout1 = new GridLayout(2,2);
		Panel1.setLayout(gridLayout1);
		mainPanel.add(Panel1);
		JPanel Panel3 = new JPanel();			
		Panel3.setLayout(new FlowLayout());		
		Panel3.setBorder(new EmptyBorder(10, 10, 20, 10));		
		mainPanel.add(Panel3);	
		JButton xiaofeijbutton = new JButton();
		xiaofeijbutton.addActionListener(new xiaofeiActionListener());
		xiaofeijbutton.setText("查询");
		Panel3.add(xiaofeijbutton);
		JPanel Panel2 = new JPanel();			
		GridLayout gridLayout2 = new GridLayout(2,2);
		Panel2.setLayout(gridLayout2);
		mainPanel.add(Panel2);
		JPanel Panel4 = new JPanel();			
		Panel4.setLayout(new FlowLayout());		
		Panel4.setBorder(new EmptyBorder(10, 10, 20, 10));		
		mainPanel.add(Panel4);	
		JButton enjbutton = new JButton();
		enjbutton.addActionListener(new enActionListener());//注册监听器
		enjbutton.setText("确认出场");//设置按钮文本
		Panel4.add(new JLabel());
		Panel4.add(enjbutton);
		Panel4.add(new JLabel());
		JLabel carnumberjlabel = new JLabel();	//创建标签
		carnumberjlabel.setText("车牌号：");			//设置标签文本
		Panel1.add(carnumberjlabel);				
		carnumberjtextfield = new JTextField();//创建卡号文本框
		carnumberjtextfield.setColumns(12);//设置文本框长度
		Panel1.add(carnumberjtextfield);
		
		JLabel sumparkjlabel = new JLabel();	
		sumparkjlabel.setText("停车时间（h）：");			
		Panel2.add(sumparkjlabel);			
		sumparkjtextfield = new JLabel();
		//sumparkjtextfield.setColumns(12);
		sumparkjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(sumparkjtextfield);
		JLabel feejlabel = new JLabel();	
		feejlabel.setText("应收费用（元）：");			
		Panel2.add(feejlabel);				
		feejtextfield = new JLabel();
		feejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(feejtextfield);
		setVisible(true);											
	}

	class enActionListener implements ActionListener {			// 添加确认出场的事件监听器
		public void actionPerformed(final ActionEvent e) {
			manager m=new manager();
			String str=carnumberjtextfield.getText();
			m.leaving(str);
			JOptionPane.showMessageDialog(null,"缴费成功，欢迎下次光临");
			doDefaultCloseAction();
		}
	}

	class xiaofeiActionListener implements ActionListener {	
		// 添加查询的事件监听器
		manager m=new manager();
		public void actionPerformed(final ActionEvent e) {
			String str=carnumberjtextfield.getText();
			double fee=m.fee(str);
			String time=m.usedtime(str);
				sumparkjtextfield.setText(time);
				feejtextfield.setText(String.valueOf(fee));
				JOptionPane.showMessageDialog(null,"请缴费");
		}
	}	
}