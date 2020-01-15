import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class MyFrame extends JFrame{
	MyToolbar myPanel1;
	MyCanvas myPanel2;
	MyFrame(){
		super("Frame Title");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
		
	}
	private void addComponents() {
		//panel and components for north 
		 myPanel1 = new MyToolbar(this);
		
		//panel and components for center		
		myPanel2 = new MyCanvas(this);
		
		//panel and components for south
		MyControlPanel myPanel3 = new MyControlPanel(this);
		
		//adding Panels
		this.add(myPanel1,BorderLayout.NORTH);
		add(myPanel2,BorderLayout.CENTER);
		add(myPanel3,BorderLayout.SOUTH);
		
	}
}
