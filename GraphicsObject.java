import java.awt.Graphics2D;

public abstract class GraphicsObject {
	
	private double x = 0;
	private double y = 0;
	private double accelX = 0;
	private double accelY = 0;
	private double velocX = 0;
	private double velocY = 0;
	
	
	public void GraphicsObject(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();

	public abstract void render(Graphics2D g);
}
