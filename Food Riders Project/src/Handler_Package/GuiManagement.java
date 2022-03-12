package Handler_Package;

import java.awt.Point;

import javax.swing.JFrame;

public interface GuiManagement {


	public static  Point getLatestFrameLocationCoordinates(JFrame aFrame) {
		
		int lastX = aFrame.getX();
		int lastY = aFrame.getY();
		
		return new Point(lastX,lastY);
		
	}
	
	public static  Point moveFrameOnXAxis(JFrame aFrame, int relocationCoordinateX ) {
		
		int lastX = aFrame.getX();
		int lastY = aFrame.getY();
		
		return new Point(lastX+relocationCoordinateX,lastY);
		
	}
	
}
