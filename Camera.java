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

	/**
	 * Make the camera follow this GraphicsObject
	 * @param target
	 */
	public void setTarget(GraphicsObject target) {
		this.target = target;
	}
	
	/**
	 * Move to given position, but stay inside limitations set with setLimits
	 * @param x
	 * @param y
	 */
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
	
	public void animateTo(double x, double y, int duration) {
		if(duration == 0) {
			moveTo(x, y);
		} else {
			
		}
	}
			
	/**
	 * If there is a target to follow, move to its position.
	 */
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

	/**
	 * This WorldObject will not be able to move outside these limits
	 */
	@Override
	public void setLimits(Dimension limits) {
		minX = 0;
		maxX = limits.getWidth() - size.getWidth();
		minY = 0;
		maxY = limits.getHeight() - size.getHeight();
	}
}
