import java.awt.*; 
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MyCanvas extends JPanel {
	MyFrame myFrame;
	MyMemory myMemory = new MyMemory();
	double xCoor;
	double yCoor;
	private boolean load;
	MyCanvas(MyFrame myFrameParameter){
		this.myFrame = myFrameParameter;
		this.load = false;
		setLayout(new GridLayout(1,1));
		init();
	}
	public void init() {
		setBackground(Color.WHITE);
	
    this.addMouseListener(new MouseAdapter() {
        private Color background;

        @Override
        public void mousePressed(MouseEvent e) {
            xCoor=e.getX();
            yCoor=e.getY();
            createTheNode();
            
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            setBackground(background);
        }
    });
	}
	public void createTheNode() {
		NodeShape node1 = new NodeShape(
				(double)xCoor,
				(double)yCoor,
				(int)myFrame.myPanel1.sizeSpinner.getValue(),
				(MyColor)myFrame.myPanel1.colorComboBox.getSelectedItem(),
				(int)myFrame.myPanel1.strokeSpinner.getValue()
				);
		myMemory.addNodeToList(node1);
		//System.out.println(((MyColor)myFrame.myPanel1.colorComboBox.getSelectedItem()).toString());
	}
	public void activateLoadCommand() {
		this.load=true;
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =  (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(load==false) {
			for(NodeShape node :myMemory.nodeShapeList) {
				g2.setColor(node.getColor());
				g2.setStroke(new BasicStroke(node.getStroke()));
				g2.draw(node);
			}
		}else {
			//Image loadedImage = myMemory.loadImage();
			//g2.drawImage(loadedImage,0,0,this);
			myMemory.loadNodeList();
			MyColor colorLoadNode;
			for(NodeShape node :myMemory.nodeShapeList) {
				switch(node.getColor().toString()) {
					case "RED": g2.setColor(Color.RED);break;
					
					case "GREEN": g2.setColor(Color.GREEN);break;
					case "BLUE": g2.setColor(Color.BLUE);break;
				}
				g2.setStroke(new BasicStroke(node.getStroke()));
				g2.draw(node);
			}
			load=false;
		}
	}
}
