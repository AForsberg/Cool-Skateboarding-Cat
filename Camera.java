import java.awt.Dimension;

public class Camera implements WorldObject {
	
	private double posX;
	private double posY;
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;
	private Dimension size;
	private GraphicsObject target = null;
	
	public Camera(Dimension d) {
		size = d;
	}

	public void setTarget(GraphicsObject target) {
		this.target = target;
	}
	
	public void moveTo(double x, double y) {
		posX = x - size.getWidth()/2;
		if(posX < minX)
			posX = minX;
		else if(posX > maxX)
			posX = maxX;
		
		posY = y - size.getHeight()/2;
		if(posY < minY)
			posY = minY;
		else if(posY > maxY)
			posY = maxY;
	}
			
	public void update() {
		if(target != null) {
			moveTo(target.getPosX(), target.getPosY());
		}
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	
	public Dimension getDimension() {
		return size;
	}

	@Override
	public void setLimits(Dimension limits) {
		minX = 0 + size.getWidth()/2;
		maxX = limits.getWidth() - size.getWidth()/2;
		minY = 0 + size.getHeight()/2;
		maxY = limits.getHeight() - size.getHeight()/2;
		
		System.out.println(limits.toString());
	}
}
