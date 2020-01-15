import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

public class NodeShape extends Ellipse2D.Double {
	
	private double radius;
	private int stroke;
	private MyColor color;
	private double xCoord,yCoord;
	
    public NodeShape(double x0, double y0, double radiusParameter,MyColor colorParameter,int strokeParametre) {
        super(x0 - radiusParameter / 2, y0 - radiusParameter / 2, radiusParameter, radiusParameter);
        this.radius=radiusParameter;
        this.color=colorParameter;
        this.stroke=strokeParametre;
        this.xCoord=x0;
        this.yCoord=y0;
    }
 
	public double getRadius() {
		return radius;
	}
	public int getStroke() {
		return stroke;
	}
	public MyColor getColor() {
		return color;
	}

	@Override
	public String toString() {
		
		return xCoord + "," + yCoord + "," + radius + "," + color + "," + stroke;
	}
}