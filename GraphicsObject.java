import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class GraphicsObject {
	
	protected double posX = 0;
	protected double posY = 0;
	protected double minX = 0;
	protected double maxX = 0;
	protected double minY = 0;
	protected double maxY = 0;
	protected double accelX = 0;
	protected double accelY = 0;
	protected double velocX = 0;
	protected double velocY = 0;
	protected int directionX = 1; // 1 is right, -1 is left
	protected int directionY = 1; // 1 is down, -1 is up
	protected Image sprite; // Could be made in into a HashSet to support animation
	
	
	public GraphicsObject() {
		
	}
	
	public abstract void update(Controller control);

	public void render(Graphics2D g) {
		g.drawImage(sprite, 0, 0, null);
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	public double getSpriteWidth() {
		return sprite.getWidth(null);
	}
	
	public double getSpriteHeight() {
		return sprite.getHeight(null);
	}
	
	public void setLimits(Dimension limits) {
		minX = 0 + sprite.getWidth(null)/2;
		maxX = limits.getWidth() - sprite.getWidth(null)/2;
		minY = 0 + sprite.getHeight(null)/2;
		maxY = limits.getHeight() - sprite.getHeight(null)/2;
	}
}
