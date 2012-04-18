import java.io.IOException;
import javax.imageio.ImageIO;

public class Background extends GraphicsObject {
	
	public Background(String spritePath) {
		
		posX = posY = 0;
		
		// Load Bakground from given URL
		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Controller control) {
		// TODO Auto-generated method stub
	}
}
