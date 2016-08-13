import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
//import javax.swing.JPanel;
public class enemy implements entityB {
	
	public boolean collided=false;
	public Graphics2D g2d;
	int xe,ye;
	int speed = 1;
	
	private String alien1=("/images/alien.gif");
	private String alien2=("/images/explosion.jpeg");
	public enemy(int x)
	{
		xe=x;
		ye=0;
	}
	public void tick()
	{
		ye+=speed;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Image GetshotImage()
	{
		ImageIcon i=new ImageIcon(getClass().getResource(alien1));
		return i.getImage();
	}
	
	public void draw(Graphics2D g2d)
	{	if(collided)
		{g2d.drawImage(GetshotImage1(), xe, ye, null);}
		else
		{g2d.drawImage(GetshotImage(), xe,ye,null);}
		
	
	}
	public Image GetshotImage1()
	{
		ImageIcon i=new ImageIcon(getClass().getResource(alien2));
		return i.getImage();
	}
	
	
	
	public Rectangle getBounds()
	{
		return new Rectangle((int) xe,(int) ye,32,32);
	}
	public int getx() {
	
		return xe;
	}

	public int gety() {
		
		return ye;
	}
	public boolean getcollision()
	{
		return collided;
		
	}
	public void setcollision(boolean b)
	{
		this.collided=b;
		
	}
}
