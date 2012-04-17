import java.awt.Color;
import java.awt.Graphics2D;

public class Katt extends GraphicsObject {

	private double posX;
	private double posY;
	private double speedX;
	private double speedY;
	

	public Katt() {
		
	}	
	
	@Override
	public void render(Graphics2D g) {
		g.translate(this.posX, this.posY);
				
		g.setColor(Color.RED);
		
		g.translate(-this.posX, -this.posY);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
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

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
}
