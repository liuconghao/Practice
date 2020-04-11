/**
 * 创建窗口并实现功能
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
	/**窗口初始化**/
	PatternWindow(){
		setTitle("排序器");
		inputText =new JTextArea();
		showText =new JTextArea();
		sort =new JButton("字典排序");
		clean =new JButton("清空");
		JPanel panel =new JPanel();		/**文本区**/
		JPanel pane=new JPanel();       /**按钮**/
        BoxLayout layout=new BoxLayout(pane, BoxLayout.X_AXIS);// 水平的盒布局
        pane.setLayout(layout);         
        pane.add(Box.createGlue()); // 挤占窗口左侧空间
        pane.add(sort);
        sort.addActionListener(this);
        pane.add(Box.createHorizontalStrut(20));// 按钮之间的水平距离
        pane.add(clean);
        clean.addActionListener(this);
        pane.add(Box.createGlue()); // 挤占窗口右侧空间 
        
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
	/**按钮监听**/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sort)
			hangdleText();
		else if(e.getSource()==clean) {
			inputText.setText(null);
			showText.setText(null);
		}
	}

	/**获取、处理并输出数据**/
	public void hangdleText() {
		// TODO 自动生成的方法存根
		showText.setText(null);
		String s=inputText.getText();
		ArrayList<String> list = new ArrayList<String>();
        StringTokenizer tokens=new StringTokenizer(s);
         //使用默认的分隔符集合：空格、换行、Tab符合回车作分隔符
         int n=tokens.countTokens(),i,j;
         for(i=0;i<=n-1;i++){
            String temp=tokens.nextToken();//从文本区取下一个数据
            list.add(temp);
         } 
		 Collections.sort(list, new SpellComparator());
		 for (j = 0; j < list.size(); j++) {
		   showText.append(list.get(j)+"\n");
		  }
	}
	
	/**重写比较器**/
	class SpellComparator implements Comparator<Object> {
	 public int compare(Object o1, Object o2) {
	  try {
	   // 取得比较字符串
	   String s1 = new String(o1.toString());
	   String s2 = new String(o2.toString());
	   // 运用String类的 compareTo（）方法对两对象进行比较
	   return s1.compareTo(s2);
	  } 
	  catch (Exception e) {e.printStackTrace();}
	  return 0;
	 }
	}
}

