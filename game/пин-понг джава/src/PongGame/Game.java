package PongGame;
//запускай
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH * 9/16;
	
	Ball ball;
	Paddle paddle1;
	Paddle paddle2;
	
	public static boolean running = false;
	private Thread gameThread;

	public static void main(String[] args) {
		
		new Game();
		
	}
	
	public Game() {
		
		canvasSetup();
		initialize();
		new Window("Meghna's Pong",this);
		this.addKeyListener(new KeyInput(paddle1, paddle2));
		this.setFocusable(true);
	}

	private void initialize() {
		// initialize ball
		ball = new Ball();
		
		// initialize paddles
		paddle1 = new Paddle(Color.CYAN, true);
		paddle2 = new Paddle(Color.ORANGE, false);
		
	}

	private void canvasSetup() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
	}

	@Override
	public void run() {
		
		this.requestFocus();
		
		//game timer
		long lastTime = System.nanoTime();
		double  maxFPS = 60.0;
		double frameTime = 1000000000/maxFPS;
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/frameTime;
			lastTime = now;
			if(delta>=1) {
				update();
				delta--;
				draw();
			}
		}
		stop();
		
		
	}

	private void draw() {
		// initialize drawing tools
		BufferStrategy buffer = this.getBufferStrategy();
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();
		
		// draw background
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw ball
		ball.draw(g);
		
		// draw paddles
		paddle1.draw(g);
		paddle2.draw(g);
		
		// dispose all on screen
		g.dispose();
		buffer.show();
		
	}

	private void update() {
		// update ball
		ball.update(paddle1, paddle2);
		
		// update paddles
		paddle1.update(ball);
		paddle2.update(ball);
		
	}

	public void start() {
		
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
		
	}
	
	public void stop() {
		
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int sign(double d) {
		
		if (d>=0) {return 1;}
		else {return -1;}
	}

}
