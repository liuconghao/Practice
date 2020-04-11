/**
 * �������ڲ�ʵ�ֹ���
 * */
package wordSort;
/**
 * @author: lau
 * @version: 1.0
 * */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PatternWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextArea inputText,showText;
	JTextField pattrernText;
	JButton sort,clean;
	/**���ڳ�ʼ��**/
	PatternWindow(){
		setTitle("������");
		inputText =new JTextArea();
		showText =new JTextArea();
		sort =new JButton("�ֵ�����");
		clean =new JButton("���");
		JPanel panel =new JPanel();		/**�ı���**/
		JPanel pane=new JPanel();       /**��ť**/
        BoxLayout layout=new BoxLayout(pane, BoxLayout.X_AXIS);// ˮƽ�ĺв���
        pane.setLayout(layout);         
        pane.add(Box.createGlue()); // ��ռ�������ռ�
        pane.add(sort);
        sort.addActionListener(this);
        pane.add(Box.createHorizontalStrut(20));// ��ť֮���ˮƽ����
        pane.add(clean);
        clean.addActionListener(this);
        pane.add(Box.createGlue()); // ��ռ�����Ҳ�ռ� 
        
		panel.setLayout(new GridLayout(1,2));
		panel.add(new JScrollPane(inputText));
		panel.add(new JScrollPane(showText));
		add(panel, BorderLayout.CENTER);
		add(pane,BorderLayout.SOUTH);
		validate();
		inputText.setLineWrap(true);
		showText.setWrapStyleWord(true);
		setBounds(240,240,480,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	/**��ť����**/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sort)
			hangdleText();
		else if(e.getSource()==clean) {
			inputText.setText(null);
			showText.setText(null);
		}
	}

	/**��ȡ�������������**/
	public void hangdleText() {
		// TODO �Զ����ɵķ������
		showText.setText(null);
		String s=inputText.getText();
		ArrayList<String> list = new ArrayList<String>();
        StringTokenizer tokens=new StringTokenizer(s);
         //ʹ��Ĭ�ϵķָ������ϣ��ո񡢻��С�Tab���ϻس����ָ���
         int n=tokens.countTokens(),i,j;
         for(i=0;i<=n-1;i++){
            String temp=tokens.nextToken();//���ı���ȡ��һ������
            list.add(temp);
         } 
		 Collections.sort(list, new SpellComparator());
		 for (j = 0; j < list.size(); j++) {
		   showText.append(list.get(j)+"\n");
		  }
	}
	
	/**��д�Ƚ���**/
	class SpellComparator implements Comparator<Object> {
	 public int compare(Object o1, Object o2) {
	  try {
	   // ȡ�ñȽ��ַ���
	   String s1 = new String(o1.toString());
	   String s2 = new String(o2.toString());
	   // ����String��� compareTo������������������бȽ�
	   return s1.compareTo(s2);
	  } 
	  catch (Exception e) {e.printStackTrace();}
	  return 0;
	 }
	}
}

