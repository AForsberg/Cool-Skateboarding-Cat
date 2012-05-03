import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Katt extends GraphicsObject {
	
	private double angle;
	
	public Katt(String spritePath) {
		
		velocX = 10;
		velocY = 0;
		
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		int startX = directionX*(sprite.getWidth(null)-sprite.getWidth(null)/2);
		int endX = -directionX*sprite.getWidth(null)/2;
	
		g.rotate(angle);
		
		// Draw the image so that katten is looking left if directionX is -1 and looking right if directionX is 1
		g.drawImage(
			sprite,
			startX, -sprite.getHeight(null)/2, endX, sprite.getHeight(null)/2,
			0, 0, sprite.getWidth(null), sprite.getHeight(null),
			null
		);
		
		g.rotate(-angle);
	}

	@Override
	public void update(Controller controller) {		
		if(isControllable) {
			setVelocX(getVelocX() + getAccelX());
			setVelocY(getVelocY() + getAccelY());
		} else {
			this.setVelocX(0);
		}
		
		this.posX += this.velocX;
		
		// Keep this in world if it isn't controllable
		if(posX < minX) posX = minX;
		else if(posX > maxX) posX = maxX;
		if(posY < minY) posY = minY;
		else if(posY > maxY) posY = maxY;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public double[] getReferencePoint() {
		double[] points = new double[2];
		points[0] = this.getPosX() - this.getSpriteWidth()/2;
		points[1] = this.getPosY() - this.getSpriteHeight()/2;
		
		return points;
	}
}
