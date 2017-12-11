package Project;

import java.awt.Point;

public class SnowObject {
	private Point point;
	public int snow_size;
	
	
	public SnowObject(Point point, int size) {
		// TODO Auto-generated constructor stub
		this.point=point;
		this.snow_size=size;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public Point getPoint() {
		return point;
	}
	
}