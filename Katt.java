import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Katt extends GraphicsObject {

	private double posX;
	private double posY;
	private double speedX = 4;
	private double speedY = 4;
	private int directionX = 1; // 1 is right, -1 is left
	private int directionY = 1; // 1 is down, -1 is up
	private Image sprite; // Could be made in into a HashSet to support animation
	

	public Katt(String spritePath) {
		
		// Load Katt-sprite from given URL
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	@Override
	public void render(Graphics2D g) {
		g.translate(posX, posY);
			
			// Draw the image so that katten is looking left if directionX is -1 and looking right if directionX is 1
			g.drawImage(
				sprite,
				directionX*(sprite.getWidth(null)-sprite.getWidth(null)/2), 0, -directionX*sprite.getWidth(null)/2, sprite.getWidth(null),
				0, 0, sprite.getWidth(null), sprite.getHeight(null),
				null
			);
			
		g.translate(-posX, -posY);
	}

	@Override
	public void update(Controller controller) {
		
		// TODO Make the katt accelerate smoothly instead of just adding the speed
		
		// Movement along Y-axis
		if(controller.keys[KeyEvent.VK_UP]) {
			posY -= speedY;
			directionY = -1;
		} else if(controller.keys[KeyEvent.VK_DOWN]) {
			posY += speedY;
			directionY = 1;
		}
		
		// Movement along X-axis
		if(controller.keys[KeyEvent.VK_LEFT]) {
			posX -= speedX;
			directionX = -1;
		} else if(controller.keys[KeyEvent.VK_RIGHT]) {
			posX += speedX;
			directionX = 1;
		}
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
