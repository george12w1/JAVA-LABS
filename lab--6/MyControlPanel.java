import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyControlPanel extends JPanel implements ActionListener{
	MyFrame myFrame;
	JButton btn1 = new JButton("LOAD");
	JButton btn2 = new JButton("SAVE");
	JButton btn3 = new JButton("RESET");
	MyControlPanel(MyFrame myFrameParameter){
		this.myFrame=myFrameParameter;
		setLayout(new GridLayout(1,3));
		init();
	}
	public void init() {
		setLayout(new GridLayout(1,3));
		setBackground(Color.GRAY);

		
		add(btn1);
		btn1.addActionListener(this);
		add(btn2);
		btn2.addActionListener(this);
		add(btn3);
		btn3.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2) myFrame.myPanel2.myMemory.saveNodeList();
		if(e.getSource()==btn1) myFrame.myPanel2.activateLoadCommand();
		if(e.getSource()==btn3) System.out.println("RESET");
	}
}
