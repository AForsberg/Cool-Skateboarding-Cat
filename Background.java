import java.io.IOException;
import javax.imageio.ImageIO;

public class Background extends GraphicsObject {
	
	public Background(String spritePath) {
		
		posX = posY = 0;
		
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Controller control) {
		// Background is not moving relative to world,
		// so this method will NEVER be used.
	}
}
