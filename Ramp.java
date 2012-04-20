import java.awt.Color;
import java.awt.Graphics2D;


public class Ramp extends GraphicsObject {

	public Ramp() {
		
	}
	
	@Override
	public void update(Controller controller) {
		// Ramp can't move.
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 100, 100);
	}

}
