import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Katt extends GraphicsObject {

	public Katt(String spritePath) {
		
		velocX = velocY = 4;
		
		// Load Katt-sprite from given URL
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
	
		// Draw the image so that katten is looking left if directionX is -1 and looking right if directionX is 1
		g.drawImage(
			sprite,
			startX, -sprite.getHeight(null)/2, endX, sprite.getHeight(null)/2,
			0, 0, sprite.getWidth(null), sprite.getHeight(null),
			null
		);
	}

	@Override
	public void update(Controller controller) {
		
		// TODO Make the katt accelerate smoothly instead of just adding the speed
		
		// Movement along X-axis
		if(controller.keys[KeyEvent.VK_LEFT]) {
			posX -= velocX;
			directionX = -1;
		} else if(controller.keys[KeyEvent.VK_RIGHT]) {
			posX += velocX;
			directionX = 1;
		}
		
		System.out.println(posX);
	}
	
	public double getSpeedX() {
		return velocX;
	}

	public void setSpeedX(double speedX) {
		this.velocX = speedX;
	}

	public double getSpeedY() {
		return velocY;
	}

	public void setSpeedY(double speedY) {
		this.velocY = speedY;
	}
}
