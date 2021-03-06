import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Katt extends GraphicsObject {

	public Katt(String spritePath) {
		
		velocX = velocY = 10;
		
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
		if(controller.keys[KeyEvent.VK_LEFT]) {
			posX -= velocX;
			posX = (posX < minX) ? minX : posX;
			
			directionX = -1;
		} else if(controller.keys[KeyEvent.VK_RIGHT]) {
			posX += velocX;
			posX = (posX > maxX) ? maxX : posX;
			
			directionX = 1;
		}
		
		if(controller.keys[KeyEvent.VK_UP]) {
			posY -= velocY;
			posY = (posY < minY) ? minY : posY;
			
			directionY = -1;
		} else if(controller.keys[KeyEvent.VK_DOWN]) {
			posY += velocY;
			posY = (posY > maxY) ? maxY : posY;
			
			directionY = 1;
		}
	}
	
	/**
	 * Move the katt to given position
	 * @param x
	 * @param y
	 */
	public void moveTo(double x, double y) {
		posX = x;
		posY = y;
	}
}
