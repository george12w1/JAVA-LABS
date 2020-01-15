import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
public class MyMemory {
	List<NodeShape> nodeShapeList = new ArrayList<NodeShape>();
	File f;
	public void addNodeToList(NodeShape nodeShapeParameter) {
		nodeShapeList.add(nodeShapeParameter);
	}
	public void saveImage() {
		BufferedImage bufferedImage = new BufferedImage( 
                500, 500, BufferedImage.TYPE_INT_ARGB );
		Graphics2D g2 = (Graphics2D)bufferedImage.getGraphics();
				
		for(NodeShape node : nodeShapeList) {
			g2.setColor(node.getColor());
			g2.setStroke(new BasicStroke(node.getStroke()));
			g2.draw(node);
		}
		f = new File("MyFile.png");
		try {
			ImageIO.write(bufferedImage,"PNG",f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveNodeList() {
		File file = new File("nodeList.txt");
		try {
			FileWriter writer = new FileWriter(file);
			for(NodeShape node : nodeShapeList) {
				if(nodeShapeList.indexOf(node)==nodeShapeList.size()-1)
					writer.write(node.toString());
				else writer.write(node.toString() + System.lineSeparator());
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	public void loadNodeList() {
		nodeShapeList.clear();
		try {
			
			Stream<String> stream = Files.lines(Paths.get("nodeList.txt"));
		    stream.forEach(node->{
		    	String[] parts = node.toString().split(",");
		    	double xCoord = Double.parseDouble(parts[0]);
		    	double yCoord = Double.parseDouble(parts[1]);
		    	double radius = Double.parseDouble(parts[2]);
		    	int stroke = Integer.parseInt((parts[4]));
		    	//System.out.println(parts[3]);
		    	//System.out.println(node);
		    	switch(parts[3]) {
			    	case "RED":
			    		MyColor redColor= new MyColor(255,0,0);
			    		NodeShape newNode = new NodeShape(
						    			xCoord,
						    			yCoord,
						    			radius,
						    			redColor,
						    			stroke);
			    				System.out.println(newNode.getColor().toString());
			    				nodeShapeList.add(newNode);
			    				break;
				
			    	case "GREEN":
			    		MyColor greenColor= new MyColor(0,255,0);	
			    		NodeShape newNode1 = new NodeShape(
						    			xCoord,
						    			yCoord,
						    			radius,
						    			greenColor,
						    			stroke);
			    		System.out.println(newNode1.getColor().toString());
			    				nodeShapeList.add(newNode1);
			    				break;
			    				
			    	case "BLUE":
			    		MyColor blueColor= new MyColor(0,0,255);	
			    		NodeShape newNode2 = new NodeShape(
						    			xCoord,
						    			yCoord,
						    			radius,
						    			blueColor,
						    			stroke);
			    		System.out.println(newNode2.getColor().toString());
			    				nodeShapeList.add(newNode2);
			    				break;
			    	default: System.out.println("Problem"); break;
		    	}				
		    });
		}catch(Exception e) {
			e.printStackTrace();
		};
	}
		
	public BufferedImage loadImage() {
		
		BufferedImage bufferedImage =  new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
		
		File loadFile = new File("MyFile.png");
		try {
			bufferedImage = ImageIO.read(loadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}
}
