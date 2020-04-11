/*
 * ��ui������ʵ�ֳ��������˵��µĳ��������˵���
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
	private JTextField carnumberjtextfield;//�����ı���
	private JLabel sumparkjtextfield ;//�����ı���
	private JLabel feejtextfield ;//�����ı���

	//���췽��
	public ParkOutFrame() {
		super("��������");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		JPanel mainPanel = new JPanel();			//�����������
		GridLayout gridLayout = new GridLayout(4,1);//�������񲼾ֹ�����
		gridLayout.setVgap(20);					//�������֮�䴹ֱ����
		gridLayout.setHgap(10);					//�������֮��ƽ�о���
		mainPanel.setLayout(gridLayout);		//���ò���
		mainPanel.setBorder(new EmptyBorder(30, 10, 20, 10));		//���ñ߿�
		getContentPane().add(mainPanel);		//�����������뵽����
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
		xiaofeijbutton.setText("��ѯ");
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
		enjbutton.addActionListener(new enActionListener());//ע�������
		enjbutton.setText("ȷ�ϳ���");//���ð�ť�ı�
		Panel4.add(new JLabel());
		Panel4.add(enjbutton);
		Panel4.add(new JLabel());
		JLabel carnumberjlabel = new JLabel();	//������ǩ
		carnumberjlabel.setText("���ƺţ�");			//���ñ�ǩ�ı�
		Panel1.add(carnumberjlabel);				
		carnumberjtextfield = new JTextField();//���������ı���
		carnumberjtextfield.setColumns(12);//�����ı��򳤶�
		Panel1.add(carnumberjtextfield);
		
		JLabel sumparkjlabel = new JLabel();	
		sumparkjlabel.setText("ͣ��ʱ�䣨h����");			
		Panel2.add(sumparkjlabel);			
		sumparkjtextfield = new JLabel();
		//sumparkjtextfield.setColumns(12);
		sumparkjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(sumparkjtextfield);
		JLabel feejlabel = new JLabel();	
		feejlabel.setText("Ӧ�շ��ã�Ԫ����");			
		Panel2.add(feejlabel);				
		feejtextfield = new JLabel();
		feejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(feejtextfield);
		setVisible(true);											
	}

	class enActionListener implements ActionListener {			// ����ȷ�ϳ������¼�������
		public void actionPerformed(final ActionEvent e) {
			manager m=new manager();
			String str=carnumberjtextfield.getText();
			m.leaving(str);
			JOptionPane.showMessageDialog(null,"�ɷѳɹ�����ӭ�´ι���");
			doDefaultCloseAction();
		}
	}

	class xiaofeiActionListener implements ActionListener {	
		// ���Ӳ�ѯ���¼�������
		manager m=new manager();
		public void actionPerformed(final ActionEvent e) {
			String str=carnumberjtextfield.getText();
			double fee=m.fee(str);
			String time=m.usedtime(str);
				sumparkjtextfield.setText(time);
				feejtextfield.setText(String.valueOf(fee));
				JOptionPane.showMessageDialog(null,"��ɷ�");
		}
	}	
}