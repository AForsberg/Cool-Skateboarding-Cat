import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class World {
	
	private HashSet<GraphicsObject> graphicsobjects = new HashSet<GraphicsObject>();
	private Background background;
	private Dimension worldDimension;
	private Katt katten;
	private Camera camera;
	private Ramp rampen;

	
	public World(String bgPath) {
		
		background = new Background(bgPath);
	
		camera = new Camera(new Dimension(1200, 600));
		
		worldDimension = new Dimension((int)background.getSpriteWidth(), (int)background.getSpriteHeight());
		
		katten = new Katt("katt.png");
		katten.setLimits(worldDimension);
		
		katten.moveTo(0, worldDimension.getHeight());
		
		camera.setLimits(worldDimension);
		
		rampen = new Ramp(200, 100);
		rampen.setPosX(800);
		rampen.setPosY(worldDimension.getHeight());
		
		camera.setTarget(katten);
		
		graphicsobjects.add(background);
		graphicsobjects.add(katten);
		graphicsobjects.add(rampen);
	}
	
	public void render(Graphics2D g) {
		// Looping thru all GOs
		for(GraphicsObject go : graphicsobjects) {
			g.translate(getScreenCoords(go)[0], getScreenCoords(go)[1]);
				go.render(g);
			g.translate(-getScreenCoords(go)[0], -getScreenCoords(go)[1]);
		}
	}
	
	public void update(Controller controller) {
		katten.update(controller);
		camera.update();
		background.update(controller);
	}
	
	public Dimension getCameraDimension() {
		return camera.getDimension();
	}
	
	/**
	 * Returns the actual coordinates on screen.
	 * By subtracting the camera position from given GOs position
	 * @param go
	 * @return
	 */
	public double[] getScreenCoords(GraphicsObject go) {
		double[] screenCoords = new double[2];
		screenCoords[0]	= go.getPosX() - camera.getPosX();
		screenCoords[1] = go.getPosY() - camera.getPosY();
		
		return screenCoords;
	}
}
