/*
 * ��ui��������ʾ��ѯ�˵���ļƷѱ�׼�˵���
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



	//���췽��
	public  ChargeFrame() {
		super("�Ʒѱ�׼");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(206,76,331,300));

		JPanel Panel1 = new JPanel();//�����������
		Panel1.setLayout(new GridLayout(6,2));//���ò���
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));//���ñ߿�
		getContentPane().add(Panel1);

		JLabel bigjlabel1 = new JLabel();//������λ��Ԫ/h����ǩ
		bigjlabel1.setText("��λ��Ԫ/h����");//���ñ�ǩ�ı�
		Panel1.add(bigjlabel1);	//���ӵ��������
		bigjtextfield1 = new JLabel();//������ǩ
		Panel1.add(bigjtextfield1);//���ӵ��������

		JLabel smalljlabel1 = new JLabel();//���������λ��Ԫ/h����ǩ
		smalljlabel1.setText("�����λ��Ԫ/h����");//���ñ�ǩ�ı�
		Panel1.add(smalljlabel1);//���ӵ��������
		smalljtextfield1 = new JLabel();//������ǩ
		Panel1.add(smalljtextfield1);//���ӵ��������

		manager m=new manager();
	
		String a1 = String.valueOf(m.price());
		bigjtextfield1.setText(a1);
		String a2 ="0.0";
		smalljtextfield1.setText(a2);

		setVisible(true);// ��ʾ����ɼ�	
	}		
}