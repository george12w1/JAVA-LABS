import java.awt.Color;

public class MyColor extends Color{
	
	int rC,gC,bC;
	public MyColor(int r, int g, int b) {
		super(r, g, b);
		this.rC=r;
		this.gC=g;
		this.bC=b;
	}
	public String toString() {
		
	 if(rC==255) return "RED";
	 else if(gC==255) return "GREEN";
	 else return "BLUE";
	}

	
}
