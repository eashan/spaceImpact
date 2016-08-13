import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;


public class player  implements entityA 
{int xpos,ypos;
int vx=0;
int vy=0;
//shot s=new shot();
game game;
	public player(int x, int y,game g)
	{
		xpos=x;
		ypos=y;
		game=g;		
	}
	public boolean tick()
	{
		xpos=(xpos+vx+370)%370;
		ypos=ypos+vy;
		if(ypos >= 350){
			ypos = 350;;
		}
		if(physics.Collision(this,game.eb))
		{
			return true;
		}
		return false;
	}
	
	private String playerimage=("/images/ship.gif");
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(GetPlayerImage(), xpos, ypos, null);
	}
	public Image GetPlayerImage()
	{
		ImageIcon i=new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int) xpos,(int) ypos,32,32);
	}
	public int getx() {
	
		return xpos;
	}

	public int gety() {
		
		return ypos;
	}



}
