import java.awt.Dimension;

public class Camera {
	
	private double posX;
	private double posY;
	private Dimension size;
	private GraphicsObject target;
	
	public Camera(Dimension d) {
		size = d;
	}

	public void setTarget(GraphicsObject target) {
		this.target = target;
	}
	
	public void moveTo(double x, double y) {
		posX = x;
		posY = y;
	}
	
	public void update() {
		moveTo(target.getPosX()-size.width/2, target.getPosY()-size.height/2);
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
}
