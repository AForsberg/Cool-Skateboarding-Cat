import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {
	
	private Background background;
	private Dimension worldDimension;
	private Katt katten;
	private Camera camera;

	
	public World(String bgPath) {
		background = new Background(bgPath);
		camera = new Camera(new Dimension(800, 600));
		worldDimension = new Dimension(background.sprite.getWidth(null), background.sprite.getHeight(null));
		katten = new Katt("katt.png");
		
		background.moveTo(0, background.getSpriteHeight());
		
		katten.setPosX(worldDimension.getWidth()/2);
		katten.setPosY(worldDimension.getHeight()/2);
		
		camera.moveTo(katten.getPosX(), katten.getPosY());
		//camera.setTarget(katten);
	}
	
	public void render(Graphics2D g) {
		background.render(g);
		katten.render(g);
	}
	
	public void update(Controller controller) {
		katten.update(controller);
		//camera.update();
		background.update(controller);
	}
	
	public Dimension getCameraDimension() {
		return camera.getDimension();
	}
	
	public double[] getScreenCoords(GraphicsObject go) {
		double[] screenCoords = new double[2];
		screenCoords[1]	= go.getPosX() - camera.getPosX();
		screenCoords[2] = go.getPosY() - camera.getPosY();
		
		return screenCoords;
	}
}
