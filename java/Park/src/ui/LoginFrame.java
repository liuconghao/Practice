/*
 * 该ui类用于显示登录窗口
 * */
package ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import park.manager;


public class LoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField password;
	private JButton login;

	//这样写的目的是为了操作数据库，老师写的虽然好，但是对于操作数据库并不方便
	public LoginFrame() {
		super();
		final BorderLayout borderLayout = new BorderLayout();	//创建布局管理器
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//设置关闭按钮处理事件
		borderLayout.setVgap(10);								//设置组件之间垂直距离			
		getContentPane().setLayout(borderLayout);				//使用布局管理器
		setTitle("停车场管理系统");							//设置窗体标题

		setSize(289, 167);//设置窗体大小
		setLocation(550, 350);

		final JPanel mainPanel = new JPanel();					//创建主面板
		mainPanel.setLayout(new BorderLayout());				//设置边框布局
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));		//设置边框为0
		getContentPane().add(mainPanel);						//在窗体中加入主面板

		final JPanel centerPanel = new JPanel();				//添加一个中心面板	
		final GridLayout gridLayout = new GridLayout(3, 2);		//创建网格布局管理器
		centerPanel.setLayout(gridLayout);						//使用布局管理器
		mainPanel.add(centerPanel);//添加到主面板

		JLabel zhanwei1 = new JLabel();	//创建卡号标签
		centerPanel.add(zhanwei1);				//添加到中心面板
		JLabel zhanwei2 = new JLabel();	//创建卡号标签
		centerPanel.add(zhanwei2);				//添加到中心面板

		final JLabel tips = new JLabel();				//创建一个标签
		tips.setHorizontalAlignment(SwingConstants.CENTER);//设置对齐方式
		tips.setPreferredSize(new Dimension(0, 0));	//设置组件大小
		tips.setMinimumSize(new Dimension(0, 0));		//设置组件最小的大小
		centerPanel.add(tips);							//添加到中心面板
		tips.setText("请登录（输入密码）：");						//设置标签文本

		final JLabel passwordLabel = new JLabel();					//创建一个标签
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);//设置对齐方式
		centerPanel.add(passwordLabel);								//添加到中心面板
		//passwordLabel.setText("密      码：");							//设置标签文本
		password = new JPasswordField(20);							//创建密码框	
		//password.setDocument(new MyDocument(6));					//设置密码长度为6
		password.setEchoChar('*');									//设置密码框的回显字符
		centerPanel.add(password);									//添加到中心面板

		final JPanel southPanel = new JPanel();//新增一个底部面板
		southPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.add(southPanel, BorderLayout.SOUTH);				//添加到主面板中
		login = new JButton();
		login.addActionListener(new LoginAction());				//添加监听器
		login.setText("登录");										//设置按钮文本
		southPanel.add(login);										//把按钮添加到底部面板
		setVisible(true);											//设置创建可见
		setResizable(false);										//设置窗体不可改变大小
	}

	class ResetAction implements ActionListener {//实现重置按钮的监听
		public void actionPerformed(final ActionEvent e){

			password.setText("");//设置密码输入框为空

		}
	}

	class LoginAction implements ActionListener {//实现登陆按钮的监听
		manager m= new manager();
		public void actionPerformed(final ActionEvent e) {
			if(m.login().equals(String.valueOf(password.getPassword()))) {
					@SuppressWarnings("unused")
					MdiFrame frame1 = new MdiFrame();//创建一个主窗体
					//frame1.setEnabled(true);//设置其可见
					LoginFrame.this.setVisible(false);//设置登录窗体为不显示
			}else {
				JOptionPane.showMessageDialog(null,"请输入正确的用户名和密码！");//弹出提示框
				password.setText("");//设置密码输入框为空
			}
				
		}
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
}







