import java.awt.Dimension;
import java.awt.List;

public class Camera implements WorldObject {
	
	private double posX;
	private double posY;
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;
	private Dimension size;
	private GraphicsObject target = null;
	private boolean isAnimating = false;
	private double animationTargetX;
	private double animationTargetY;
	private int animationDuration;
	private double animationStepX;
	private double animationStepY;
	
	
	public Camera(Dimension d) {
		size = d;
	}

	/**
	 * Make the camera follow GraphicsObject
	 * @param target
	 */
	public void setTarget(GraphicsObject target) {
		this.target = target;
		posX = target.getPosX();
		posY = target.getPosY();
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
			animationTargetX = x;
			animationTargetY = y - size.getHeight();
			animationStepX = (x - this.posX) / duration;
			animationStepY = (y - this.posY) / duration;
			animationDuration = duration;
			isAnimating  = true;
		}
	}
	
	// Helper method
	public void animateTo(GraphicsObject go, int duration) {
		this.animateTo(go.getPosX(), go.getPosY(), duration);
		target = go;
	}
	
	public boolean isAnimationDone() {
		if(isAnimating) {
			boolean isDone = (posX == animationTargetX && posY == animationTargetY);
			return isDone;
		} else {
			return true;
		}
	}
			
	/**
	 * If there is a target to follow, move to its position.
	 */
	public void update() {
		if(isAnimating) {
			moveTo(posX+animationStepX+size.getWidth()/2, posY+animationStepY+size.getHeight()/2);
			isAnimating = !isAnimationDone();
			System.out.println(isAnimating);
		} else if(target != null) {
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
