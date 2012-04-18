import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background extends GraphicsObject {

	private Dimension containerDimension;
	private GraphicsObject toFollow;
	
	public Background(String spritePath, Dimension d, GraphicsObject toFollow) {
		// Load Bakground from given URL
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		containerDimension = d;
		this.toFollow = toFollow;
		posX = -sprite.getWidth(null);
		posY = -sprite.getHeight(null);
	}
	
	@Override
	public void update(Controller control) {
		posX = -toFollow.getPosX();
		posY = -toFollow.getPosY();
	}

	@Override
	public void render(Graphics2D g) {
		g.translate(posX, posY);
			g.drawImage(sprite, 0, (int) ((int)-sprite.getHeight(null)+containerDimension.getHeight()), null);
		g.translate(-posX, -posY);
	}
}
