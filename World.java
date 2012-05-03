import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class World {
	
	private ArrayList<GraphicsObject> graphicsobjects = new ArrayList<GraphicsObject>(0); // Initial capacity defaults to 10
	private Background background;
	private Dimension worldDimension;
	private Katt katten;
	private Camera camera;
	private Ramp rampen;
	private Pool poolen;

	
	public World(String bgPath) {
		background = new Background(bgPath);
		worldDimension = new Dimension((int)background.getSpriteWidth(), (int)background.getSpriteHeight());
		camera = new Camera(new Dimension(1200, 600));
		camera.setLimits(worldDimension);
		
		katten = new Katt("katt.png");
		katten.setLimits(worldDimension);
		katten.moveTo(0, worldDimension.getHeight());
		
		rampen = new Ramp(200, 100);
		rampen.setPosX(800);
		rampen.setPosY(worldDimension.getHeight());
		
		poolen = new Pool("pool.png");
		poolen.moveTo(500,500);
		
		camera.setTarget(poolen);
		camera.animateTo(katten, 300);
		
		graphicsobjects.add(background);
		graphicsobjects.add(rampen);
		graphicsobjects.add(katten);
		graphicsobjects.add(poolen);
		
		System.out.println(graphicsobjects);
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < graphicsobjects.size(); i++) {
			g.translate(getScreenCoords(graphicsobjects.get(i))[0], getScreenCoords(graphicsobjects.get(i))[1]);
				graphicsobjects.get(i).render(g);
			g.translate(-getScreenCoords(graphicsobjects.get(i))[0], -getScreenCoords(graphicsobjects.get(i))[1]);
		}
	}
	
	public void update(Controller controller) {
		katten.setControllable(camera.isAnimationDone());
		camera.update();
		
		for(GraphicsObject go : graphicsobjects) {
			go.update(controller);
		}
	}
	
	public Dimension getCameraDimension() {
		return camera.getDimension();
	}
	
	/**
	 * Returns the actual coordinates on screen.
	 * By subtracting the camera position from given GOs position
	 */
	public double[] getScreenCoords(GraphicsObject go) {
		double[] screenCoords = new double[2];
		screenCoords[0]	= go.getPosX() - camera.getPosX();
		screenCoords[1] = go.getPosY() - camera.getPosY();
		
		return screenCoords;
	}
}
