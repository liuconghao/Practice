/*
 * ��ui������ʵ�ֲ�ѯ�˵��µ�ǰ�ڳ���Ϣ����ʾ
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

	

	//���췽��
	public NowInfoFrame() {
		super("��ǰ�ڳ���Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(142,106,449,279));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		String [] nowin = {"���ƺ�","�Ƿ��ڳ�λ��ͣ��", "ͣ��ʱ��"};
		Object[][] results=m.show();
		JTable table = new JTable(results,nowin);
		JScrollPane scroll = new JScrollPane(table);
		mainPanel.add(scroll,BorderLayout.CENTER);		//�����������뵽����
		setVisible(true);
	}
}
















