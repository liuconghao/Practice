/**
 * 并编写含有菜单的窗口，窗口中有文本区组件。菜单有“打开文件”的单项，点击该单项时，使用输入流导入指定文件（hello.text)的内容到文本中。
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
		new Window("文本窗口");
	}
}
class Window extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;//缺省版本标识
	public JTextPane textPane = new JTextPane();
	JMenu menu;
	JMenuBar menubar;	
	JMenuItem item;
	public Window(String s){		
			super(s);
			JMenu menu=new JMenu("文件");
			menubar=new JMenuBar();	
			item = new JMenuItem("打开文件");
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
			textPane.read(in, "d");		//这里不太懂，为什么文件描述是“D”，查资料时看到的，就这么写了。
		}
		catch(Exception ex){
			ex.printStackTrace();
			}			
	}		
		
} 


