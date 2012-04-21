import java.awt.Color;
import java.awt.Graphics2D;


public class Ramp extends GraphicsObject {

	private int[] xpoints = new int[4];
	private int[] ypoints = new int[4];
	
	public Ramp(int width, int height) {
		xpoints[0] = 0;
		xpoints[1] = width;
		xpoints[2] = width;
		xpoints[3] = 0;
		
		ypoints[0] = 0;
		ypoints[1] = -height;
		ypoints[2] = 0;
		ypoints[3] = 0;
	}
	
	@Override
	public void update(Controller controller) {
		// Ramp can't move.
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillPolygon(xpoints, ypoints, 4);
	}

}
