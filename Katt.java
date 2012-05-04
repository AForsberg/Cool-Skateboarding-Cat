import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Katt extends GraphicsObject {
	
	private double velocMaxX = 8;
	private double angle;
	private boolean isJumping = false;
	
	public Katt(String spritePath) {
		accelX = 0.2;
		accelY = 0;
		
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
			// Movement x-wise
			if(controller.keys[KeyEvent.VK_LEFT]) {
				this.velocX -= this.accelX;
				directionX = -1;
			}
			if(controller.keys[KeyEvent.VK_RIGHT]) {
				this.velocX += this.accelX;			
				directionX = 1;
			}
			
			if(velocX < 0 && Math.abs(velocX) > velocMaxX) {
				this.posX += -this.velocMaxX;
				this.velocX = -this.velocMaxX;
			} else if(velocX > velocMaxX) {
				this.posX += velocMaxX;
				this.velocX = this.velocMaxX;
			} else {
				this.posX += this.velocX;
			}
			
			
			// Jump when Space pressed
			if(!isJumping  && controller.keys[KeyEvent.VK_SPACE]) {
				this.jump();
			}
			
			// This prevents multi-jumping. I think.
			isJumping = controller.keys[KeyEvent.VK_SPACE];
			
			// isJumping is TRUE if in air, else FALSE
			isJumping = (this.posY < this.maxY) ? true : false;
			
			// Movement y-wise
			this.velocY += this.accelY;
			this.posY += velocY;
			this.accelY = 0;
		}
		
		// Keep This within limits
		if(posX < minX) posX = minX;
		else if(posX > maxX) posX = maxX;
		if(posY < minY) posY = minY;
		else if(posY > maxY) posY = maxY;
	}
	
	private void jump() {
		this.accelY -= 20;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public boolean isJumping() {
		return isJumping;
	}

	@Override
	public double[] getReferencePoint() {
		double[] points = new double[2];
		points[0] = this.getPosX() - this.getSpriteWidth()/2;
		points[1] = this.getPosY() - this.getSpriteHeight()/2;
		
		return points;
	}
}
