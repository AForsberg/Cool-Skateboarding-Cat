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
		worldDimension = new Dimension(background.sprite.getWidth(null), background.sprite.getHeight(null));
		
		katten = new Katt("katt.png");
		katten.setPosX(10);
		katten.setPosY(worldDimension.getHeight()-10);
		
		camera = new Camera(new Dimension(800, 600));
		camera.setTarget(katten);
	}
	
	public void render(Graphics2D g) {
		background.render(g);
		
		g.translate(camera.getPosX(), camera.getPosY());
		katten.render(g);
		g.translate(-camera.getPosX(), -camera.getPosY());
	}
	
	public void update(Controller controller) {
		katten.update(controller);
		camera.update();
	}
}
