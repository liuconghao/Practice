/*
 * 该ui类是主窗口
 * */
package ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;


public class MdiFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//关键！MDIDesktopPane(该类实际继承了 JDesktopPane) 用来容纳子窗体
	//即使子窗体最大化也仅仅限制在该容器的范围之内
	private MDIDesktopPane desktop = new MDIDesktopPane();
	//菜单条
	private JMenuBar menuBar = new JMenuBar();
	//菜单
	private JMenu mnuPark = new JMenu("车场管理");
	private JMenu mnuQuery = new JMenu("信息查询");
	private JMenu mnuManSes = new JMenu("系统管理");
	//菜单项
	private JMenuItem munParkIn = new JMenuItem("车辆入场");
	private JMenuItem mnuParkOut = new JMenuItem("车辆出场");
	private JMenuItem munCharge = new JMenuItem("计费标准");
	private JMenuItem mnuNowInfo = new JMenuItem("当前在场信息");
	private JMenuItem mnuManIdentity = new JMenuItem("密码修改");
	private JMenuItem mnuduichu = new JMenuItem("退出");
	private JScrollPane scrollPane = new JScrollPane();
	
	//主窗体构造方法
	public MdiFrame() {
		desktop.setOpaque(false);  //JPanel 透明模式
		ImageIcon img = new ImageIcon("C:\\Users\\lau\\Pictures\\Camera Roll\\渼陂湖\\P1030290.jpg");  //创建一个图片路径
		JLabel background = new JLabel(img);  //创建个带背景图片的JLabel
		background.setIcon(img);
		this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		desktop.add(background);
		setMenu();
		setTitle("停车场管理系统");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(280,119,800, 600);
		this.setVisible(true);
	}

	/**
	 * 为窗体添加菜单并注册监听器
	 * 只写了部分菜单
	 */
	private void setMenu(){
		//车场管理菜单
		mnuPark.add(munParkIn);
		munParkIn.addActionListener(this);
		mnuPark.add(mnuParkOut);
		mnuParkOut.addActionListener(this);
		//信息查询菜单
		mnuQuery.add(munCharge);
		munCharge.addActionListener(this);
		mnuQuery.add(mnuNowInfo);
		mnuNowInfo.addActionListener(this);

				//信息维护菜单

		//系统管理菜单

		mnuManSes.add(mnuManIdentity);
		mnuManIdentity.addActionListener(this);
	
		mnuManSes.add(mnuduichu);
		mnuduichu.addActionListener(this);
		
		//添加到菜单栏
		menuBar.add(mnuPark);
		menuBar.add(mnuQuery);
		menuBar.add(mnuManSes);
		//菜单栏添加到主窗体
		setJMenuBar(menuBar);
	}

		//点击菜单项出现相应的子窗体
	public void actionPerformed(ActionEvent ae) {

		//如果允许同时打开多个子窗口，可以用该方法获得所有子窗口对象数组
		@SuppressWarnings("unused")
		JInternalFrame[] jiFrame = desktop.getAllFrames();  

		//如果只允许同时打开一个，可以用该方法移除现有窗口
		//desktop.removeAll();  

		//获得点击的菜单名称
		String mnuName = ae.getActionCommand();

		//根据菜单名称决定显示的子窗口，可以按下面的格式为每一个子菜单指定显示的子窗口
		if(mnuName.equals("车辆入场")) {
			//MdiFrame.addIFrame(new ParkInFrame(),BorderLayout.CENTER);
			desktop.add(new ParkInFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("车辆出场")) {
			desktop.add(new ParkOutFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("计费标准")) {
			desktop.add(new ChargeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("当前在场信息")) {
			desktop.add(new NowInfoFrame(),BorderLayout.CENTER);
		}
		
	
		else if(mnuName.equals("密码修改")) {
			desktop.add(new GengGaiMiMa(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("退出")) {
			System.exit(0);
		}
	}		
	
}
