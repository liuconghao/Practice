/**
 * ����д���в˵��Ĵ��ڣ����������ı���������˵��С����ļ����ĵ������õ���ʱ��ʹ������������ָ���ļ���hello.text)�����ݵ��ı��С�
 */
package ch10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

/**
 * @author lau
 * @version 1.0
 */
public class Ch10_4 {

	public static void main(String[] args) {
		new Window("�ı�����");
	}
}
class Window extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;//ȱʡ�汾��ʶ
	public JTextPane textPane = new JTextPane();
	JMenu menu;
	JMenuBar menubar;	
	JMenuItem item;
	public Window(String s){		
			super(s);
			JMenu menu=new JMenu("�ļ�");
			menubar=new JMenuBar();	
			item = new JMenuItem("���ļ�");
			menubar.add(menu);
			menu.add(item);
			setJMenuBar(menubar);
			Container container=getContentPane();				
			container.add(textPane, BorderLayout.CENTER);				
			setSize(1000,800);	
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			validate();
			item.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent e){			
		try{
			File f = new File("C:\\Users\\lau\\Desktop\\somefiles\\hello.txt");
			FileInputStream in=new FileInputStream(f);					
			textPane.read(in, "d");		//���ﲻ̫����Ϊʲô�ļ������ǡ�D����������ʱ�����ģ�����ôд�ˡ�
		}
		catch(Exception ex){
			ex.printStackTrace();
			}			
	}		
		
} 


