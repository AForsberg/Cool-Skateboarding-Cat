import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


@SuppressWarnings("serial") // Varför varnar Eclipse för det här?

public class Skateboardspel extends Canvas implements Runnable {
	
	private static JFrame frame = new JFrame();
	private static Dimension d;
	private static Controller controller = new Controller();
	private boolean running;
	private World world;
	private Katt katten;
	private Pool poolen;
	private Ramp rampen;
	
	public Skateboardspel() {
		// RUN SKATEBOARDSPELET
		
		// Setting up static size of window.
		d = new Dimension(800, 600);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		
		// Setting up listeners for mouse and keyboard
		addMouseListener(controller);
		addMouseMotionListener(controller);
		addKeyListener(controller);
		
		katten = new Katt("katt.png", d);
		world = new World("background.jpg", d, katten);
	}


	@Override
	public void run() {
		while(running) {
			update();
			render();
			
			// Make this method not running to often
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				running = false;
			}
		}
	}
	
	public void start() {
		if(!running) {
			Thread t = new Thread(this);
			createBufferStrategy(3);
			running = true;
			t.start();
		}
	}
	
	private void render() {
		BufferStrategy strategy = getBufferStrategy();
		
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			world.render(g);
			
			katten.render(g);
		
		strategy.show();
	}
	
	private void update() {
		world.update(controller);
		katten.update(controller);
	}
	
	
	public static void main(String[] args) {
		Skateboardspel game = new Skateboardspel();
		frame = new JFrame("SKATEBOARDSPELET");
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		game.start();
	}
}
