
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class keylogger extends KeyAdapter  {
	
	game game;
	public keylogger(game g)
	{this.game=g;
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
	game.keyPressed(e);
	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
