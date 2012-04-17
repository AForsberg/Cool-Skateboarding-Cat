import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Katt extends GraphicsObject {

	private double posX;
	private double posY;
	private double speedX = 10;
	private double speedY = 10;
	private Image sprite;
	

	public Katt(String spritePath) {
		
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	@Override
	public void render(Graphics2D g) {
		g.translate(posX, posY);
			g.drawImage(sprite, -sprite.getWidth(null)/2, -sprite.getHeight(null)/2, null);
		g.translate(-posX, -posY);
	}

	@Override
	public void update(Controller controller) {
		// Movement along Y-axis
		if(controller.keys[KeyEvent.VK_UP]) {
			posY -= speedY;
		} else if(controller.keys[KeyEvent.VK_DOWN]) {
			posY += speedY;
		}
		
		// Movement along Y-axis
		if(controller.keys[KeyEvent.VK_LEFT]) {
			posX -= speedX;
		} else if(controller.keys[KeyEvent.VK_RIGHT]) {
			posX += speedX;
		}
		
		
		System.out.println(posX);
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
