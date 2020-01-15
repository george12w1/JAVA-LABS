import java.awt.*;
import javax.swing.*;

public class MyToolbar extends JPanel {
	MyFrame myFrame;
	JSpinner sizeSpinner;
	JSpinner strokeSpinner;
	JComboBox<Color> colorComboBox;
	MyToolbar(MyFrame myFrameParameter){
		this.myFrame = myFrameParameter;
		setLayout(new GridLayout(0,2));
		init();
	}
	public void init() {
		JLabel sizeLabel= new JLabel("Size");
		
		sizeLabel.setFont(new Font("Arial",0,15));
		sizeSpinner = new JSpinner(new SpinnerNumberModel(30, 1, 100, 1));
		sizeSpinner.setPreferredSize(new Dimension(60,20));
		
		JLabel strokeLabel= new JLabel("Stroke");
		strokeLabel.setFont(new Font("Arial",0,15));
		strokeSpinner = new JSpinner(new SpinnerNumberModel(4, 1, 100, 1));
		strokeSpinner.setPreferredSize(new Dimension(60,20));
		
		JLabel colorLabel= new JLabel("Color");
		colorComboBox = new JComboBox<Color>();
		MyColor redColor= new MyColor(255,0,0);
		MyColor greenColor= new MyColor(0,255,0);
		MyColor blueColor= new MyColor(0,0,255);
		colorComboBox.addItem(redColor);
		colorComboBox.addItem(greenColor);
		colorComboBox.addItem(blueColor);
		add(sizeLabel);
		add(sizeSpinner);
		add(strokeLabel);
		add(strokeSpinner);
		
		add(colorLabel);
		add(colorComboBox);
		
		
	}
}
