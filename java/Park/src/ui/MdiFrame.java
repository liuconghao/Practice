/*
 * ��ui����������
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
	//�ؼ���MDIDesktopPane(����ʵ�ʼ̳��� JDesktopPane) ���������Ӵ���
	//��ʹ�Ӵ������Ҳ���������ڸ������ķ�Χ֮��
	private MDIDesktopPane desktop = new MDIDesktopPane();
	//�˵���
	private JMenuBar menuBar = new JMenuBar();
	//�˵�
	private JMenu mnuPark = new JMenu("��������");
	private JMenu mnuQuery = new JMenu("��Ϣ��ѯ");
	private JMenu mnuManSes = new JMenu("ϵͳ����");
	//�˵���
	private JMenuItem munParkIn = new JMenuItem("�����볡");
	private JMenuItem mnuParkOut = new JMenuItem("��������");
	private JMenuItem munCharge = new JMenuItem("�Ʒѱ�׼");
	private JMenuItem mnuNowInfo = new JMenuItem("��ǰ�ڳ���Ϣ");
	private JMenuItem mnuManIdentity = new JMenuItem("�����޸�");
	private JMenuItem mnuduichu = new JMenuItem("�˳�");
	private JScrollPane scrollPane = new JScrollPane();
	
	//�����幹�췽��
	public MdiFrame() {
		desktop.setOpaque(false);  //JPanel ͸��ģʽ
		ImageIcon img = new ImageIcon("C:\\Users\\lau\\Pictures\\Camera Roll\\�����\\P1030290.jpg");  //����һ��ͼƬ·��
		JLabel background = new JLabel(img);  //������������ͼƬ��JLabel
		background.setIcon(img);
		this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		desktop.add(background);
		setMenu();
		setTitle("ͣ��������ϵͳ");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(280,119,800, 600);
		this.setVisible(true);
	}

	/**
	 * Ϊ������Ӳ˵���ע�������
	 * ֻд�˲��ֲ˵�
	 */
	private void setMenu(){
		//��������˵�
		mnuPark.add(munParkIn);
		munParkIn.addActionListener(this);
		mnuPark.add(mnuParkOut);
		mnuParkOut.addActionListener(this);
		//��Ϣ��ѯ�˵�
		mnuQuery.add(munCharge);
		munCharge.addActionListener(this);
		mnuQuery.add(mnuNowInfo);
		mnuNowInfo.addActionListener(this);

				//��Ϣά���˵�

		//ϵͳ����˵�

		mnuManSes.add(mnuManIdentity);
		mnuManIdentity.addActionListener(this);
	
		mnuManSes.add(mnuduichu);
		mnuduichu.addActionListener(this);
		
		//��ӵ��˵���
		menuBar.add(mnuPark);
		menuBar.add(mnuQuery);
		menuBar.add(mnuManSes);
		//�˵�����ӵ�������
		setJMenuBar(menuBar);
	}

		//����˵��������Ӧ���Ӵ���
	public void actionPerformed(ActionEvent ae) {

		//�������ͬʱ�򿪶���Ӵ��ڣ������ø÷�����������Ӵ��ڶ�������
		@SuppressWarnings("unused")
		JInternalFrame[] jiFrame = desktop.getAllFrames();  

		//���ֻ����ͬʱ��һ���������ø÷����Ƴ����д���
		//desktop.removeAll();  

		//��õ���Ĳ˵�����
		String mnuName = ae.getActionCommand();

		//���ݲ˵����ƾ�����ʾ���Ӵ��ڣ����԰�����ĸ�ʽΪÿһ���Ӳ˵�ָ����ʾ���Ӵ���
		if(mnuName.equals("�����볡")) {
			//MdiFrame.addIFrame(new ParkInFrame(),BorderLayout.CENTER);
			desktop.add(new ParkInFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("��������")) {
			desktop.add(new ParkOutFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("�Ʒѱ�׼")) {
			desktop.add(new ChargeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("��ǰ�ڳ���Ϣ")) {
			desktop.add(new NowInfoFrame(),BorderLayout.CENTER);
		}
		
	
		else if(mnuName.equals("�����޸�")) {
			desktop.add(new GengGaiMiMa(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("�˳�")) {
			System.exit(0);
		}
	}		
	
}
