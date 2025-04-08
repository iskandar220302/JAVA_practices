package PongGame;
//покажи
import javax.swing.JFrame;//создай окно

public class Window {
	
	public Window(String title, Game game) {
		
		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
		
	}

}
