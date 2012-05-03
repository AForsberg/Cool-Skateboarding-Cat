import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Pool extends GraphicsObject {

	public Pool(String spritePath) {
		
		velocX = velocY = 0;
		
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(sprite, 0, -sprite.getHeight(null), null);
	}
	
	@Override
	public double[] getReferencePoint() {
		double[] points = new double[2];
		points[0] = this.getPosX();
		points[1] = this.getPosY() - this.getSpriteHeight();
		
		return points;
	}
}
