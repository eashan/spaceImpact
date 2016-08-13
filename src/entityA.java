import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public interface entityA 
{
	public boolean tick();
	public void draw(Graphics2D g2d);
	public Rectangle getBounds();
	
	public int getx();
	public int gety();
	
	

}
