import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
//import javax.swing.JPanel;


public class shot implements entityA {
	
	Graphics2D g2d;
	int xs,ys;
	game game;
	
	private String shot=("/images/shot.gif");
	public shot(int x,int y,game g)
	{
		xs=x;
		ys=y;
		game=g;
	}
	public boolean tick()
	{
		ys-=2;
		
		
		if(physics.Collision(this,game.eb))
		{
			game.setScore(game.getScore()+1);
			int id=physics.id;
			game.eb.get(id).setcollision(true);
			//game.eb.remove(id);
			
			return true;
		}
		return false;
	}
	
	public Image GetshotImage()
	{
		ImageIcon i=new ImageIcon(getClass().getResource(shot));
		return i.getImage();
	}
	public void draw(Graphics2D g2d)
	{	
		g2d.drawImage(GetshotImage(), xs, ys, null);
	
	}
	public static shot get(int i) {
		
		return null;
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int) xs,(int) ys,32,32);
	}
	public int getx() {
		
		return xs;
	}

	public int gety() {
		
		return ys;
	}
	

}
