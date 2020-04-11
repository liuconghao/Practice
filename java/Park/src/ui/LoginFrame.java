/*
 * ��ui��������ʾ��¼����
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

	//����д��Ŀ����Ϊ�˲������ݿ⣬��ʦд����Ȼ�ã����Ƕ��ڲ������ݿⲢ������
	public LoginFrame() {
		super();
		final BorderLayout borderLayout = new BorderLayout();	//�������ֹ�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//���ùرհ�ť�����¼�
		borderLayout.setVgap(10);								//�������֮�䴹ֱ����			
		getContentPane().setLayout(borderLayout);				//ʹ�ò��ֹ�����
		setTitle("ͣ��������ϵͳ");							//���ô������

		setSize(289, 167);//���ô����С
		setLocation(550, 350);

		final JPanel mainPanel = new JPanel();					//���������
		mainPanel.setLayout(new BorderLayout());				//���ñ߿򲼾�
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));		//���ñ߿�Ϊ0
		getContentPane().add(mainPanel);						//�ڴ����м��������

		final JPanel centerPanel = new JPanel();				//����һ���������	
		final GridLayout gridLayout = new GridLayout(3, 2);		//�������񲼾ֹ�����
		centerPanel.setLayout(gridLayout);						//ʹ�ò��ֹ�����
		mainPanel.add(centerPanel);//���ӵ������

		JLabel zhanwei1 = new JLabel();	//�������ű�ǩ
		centerPanel.add(zhanwei1);				//���ӵ��������
		JLabel zhanwei2 = new JLabel();	//�������ű�ǩ
		centerPanel.add(zhanwei2);				//���ӵ��������

		final JLabel tips = new JLabel();				//����һ����ǩ
		tips.setHorizontalAlignment(SwingConstants.CENTER);//���ö��뷽ʽ
		tips.setPreferredSize(new Dimension(0, 0));	//���������С
		tips.setMinimumSize(new Dimension(0, 0));		//���������С�Ĵ�С
		centerPanel.add(tips);							//���ӵ��������
		tips.setText("���¼���������룩��");						//���ñ�ǩ�ı�

		final JLabel passwordLabel = new JLabel();					//����һ����ǩ
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);//���ö��뷽ʽ
		centerPanel.add(passwordLabel);								//���ӵ��������
		//passwordLabel.setText("��      �룺");							//���ñ�ǩ�ı�
		password = new JPasswordField(20);							//���������	
		//password.setDocument(new MyDocument(6));					//�������볤��Ϊ6
		password.setEchoChar('*');									//���������Ļ����ַ�
		centerPanel.add(password);									//���ӵ��������

		final JPanel southPanel = new JPanel();//����һ���ײ����
		southPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.add(southPanel, BorderLayout.SOUTH);				//���ӵ��������
		login = new JButton();
		login.addActionListener(new LoginAction());				//���Ӽ�����
		login.setText("��¼");										//���ð�ť�ı�
		southPanel.add(login);										//�Ѱ�ť���ӵ��ײ����
		setVisible(true);											//���ô����ɼ�
		setResizable(false);										//���ô��岻�ɸı��С
	}

	class ResetAction implements ActionListener {//ʵ�����ð�ť�ļ���
		public void actionPerformed(final ActionEvent e){

			password.setText("");//�������������Ϊ��

		}
	}

	class LoginAction implements ActionListener {//ʵ�ֵ�½��ť�ļ���
		manager m= new manager();
		public void actionPerformed(final ActionEvent e) {
			if(m.login().equals(String.valueOf(password.getPassword()))) {
					@SuppressWarnings("unused")
					MdiFrame frame1 = new MdiFrame();//����һ��������
					//frame1.setEnabled(true);//������ɼ�
					LoginFrame.this.setVisible(false);//���õ�¼����Ϊ����ʾ
			}else {
				JOptionPane.showMessageDialog(null,"��������ȷ���û��������룡");//������ʾ��
				password.setText("");//�������������Ϊ��
			}
				
		}
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
}






