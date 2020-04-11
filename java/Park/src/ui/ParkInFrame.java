/*
 * ��ui������ʵ�ֳ�������˵��µĳ����볡�˵���
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

	//���췽��
	public ParkInFrame() {
		super("�����볡");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(136, 107, 428, 214);
		JPanel mainPanel = new JPanel();			//�����������
		GridBagLayout gridbag = new GridBagLayout();//������񲼾ֹ�����
		mainPanel.setLayout(gridbag);		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		JLabel carnumberjlabel = new JLabel();	//������ǩ
		carnumberjlabel.setText("���ƺţ�");//���ñ�ǩ�ı�
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(carnumberjlabel,c);				//��ӵ��������
		carnumberjtextfield = new JTextField();//�����ı���
		carnumberjtextfield.setColumns(10);//�����ı��򳤶�
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(carnumberjtextfield,c);
	
		ensurejbutton = new JButton();//�������水ť
		ensurejbutton.addActionListener(new parkActionListener());//ע�������
		ensurejbutton.setText("ȷ���볡");//���ð�ť�ı�
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(ensurejbutton,c);//��ӵ��������
		JButton backjbutton = new JButton();//�������ذ�ť
		backjbutton.addActionListener(new CloseActionListener());//ע�������
		backjbutton.setText("����");//���ð�ť�ı�
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(backjbutton,c);//��ӵ��������
		setVisible(true);											// ��ʾ����ɼ�
	}

	class CloseActionListener implements ActionListener {			// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class parkActionListener implements ActionListener {	
		// ���ȷ���볡��ť���¼�������
		manager m=new manager();
		public void actionPerformed(final ActionEvent e) {
			String a3 = carnumberjtextfield.getText();
			try {
				m.parking(a3);
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "�볡�ɹ���");	

		}
	}
}



