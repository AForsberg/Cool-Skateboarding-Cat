import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {
	
	private Background background;
	private Dimension worldDimension;
	private Katt katten;
	private Camera camera;
	private Ramp rampen;
	private Pool poolen;

	
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
		
		poolen = new Pool("pool.png");
		poolen.moveTo(worldDimension.getWidth()-poolen.getSpriteWidth(), worldDimension.getHeight());
		
		camera.setTarget(poolen);
		camera.animateTo(katten, 500);
	}
	
	public void render(Graphics2D g) {
		g.translate(getScreenCoords(background)[0], getScreenCoords(background)[1]);
			background.render(g);
		g.translate(-getScreenCoords(background)[0], -getScreenCoords(background)[1]);
		
		g.translate(getScreenCoords(katten)[0], getScreenCoords(katten)[1]);
			katten.render(g);
		g.translate(-getScreenCoords(katten)[0], -getScreenCoords(katten)[1]);
		
		g.translate(getScreenCoords(rampen)[0], getScreenCoords(rampen)[1]);
			rampen.render(g);
		g.translate(-getScreenCoords(rampen)[0], -getScreenCoords(rampen)[1]);
		
		g.translate(getScreenCoords(poolen)[0], getScreenCoords(poolen)[1]);
			poolen.render(g);
		g.translate(-getScreenCoords(poolen)[0], -getScreenCoords(poolen)[1]);
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
