import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {
	
	private Background background;
	
	public World(String bgPath, Dimension windowDimension, GraphicsObject toFollow) {
		background = new Background(bgPath, windowDimension, toFollow);
	}
	
	public void render(Graphics2D g) {
		background.render(g);
	}
	
	public void update(Controller controller) {
		background.update(controller);
	}
}
