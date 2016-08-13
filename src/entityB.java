import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public interface entityB {
	
	public boolean getcollision();
	public void setcollision(boolean b);
	public void tick();
	public void draw(Graphics2D g2d);
	//public boolean collided=true;
	//public void draw1(Graphics2D g2d);
	public Rectangle getBounds();
	public void setSpeed(int speed);
	public int getSpeed();
	public int getx();
	public int gety();
	
	

}
