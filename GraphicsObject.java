import java.awt.Graphics2D;
import java.awt.Image;

public abstract class GraphicsObject {
	
	protected double posX = 0;
	protected double posY = 0;
	protected double accelX = 0;
	protected double accelY = 0;
	protected double velocX = 0;
	protected double velocY = 0;
	protected int directionX = 1; // 1 is right, -1 is left
	protected int directionY = 1; // 1 is down, -1 is up
	protected Image sprite; // Could be made in into a HashSet to support animation
	
	
	public void GraphicsObject(double x, double y) {
		this.posX = x;
		this.posY = y;
	}
	
	public abstract void update(Controller control);

	public abstract void render(Graphics2D g);
}
