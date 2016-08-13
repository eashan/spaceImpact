import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
//import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
//import java.awt.event.KeyListener;

public  class game extends JPanel implements ActionListener
{	
	private static final long serialVersionUID=1L;
	//Thread th=new Thread(this);
	//boolean running=false;
	Timer gamelooptimer;
	public LinkedList<entityA> ea;
	public LinkedList<entityB> eb;
	private int timeCounter = 0;
	private int score = 0;
	JLabel scoreLabel = new JLabel("Score: "+score);
	JLabel info=new JLabel("Press P to pause and R to resume");
	player p=new player(200,200,this);
	controller c=new controller(this);
	

	
	public game()
	{   
		setLayout(null);
		scoreLabel.setBounds(420, 20, 200, 25);
		scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
		info.setBounds(420, 50, 200, 300);
		info.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 11));
		add(scoreLabel);
		add(info);
		addKeyListener(new keylogger(this));
		setFocusable(true);
	   
		ea=c.getEntityA();
		eb=c.getEntityB();
		System.out.println("GAME");
		gamelooptimer=new Timer(10,this);
		gamelooptimer.start();			
	}
	

	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	
	
	public void paint(Graphics g)
	{	
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.drawImage(GetbackgroundImage(),0,0,400, 400, null);
		g2d.setColor(Color.WHITE);
		scoreLabel.setText("Score: "+score);
		c.render(g2d);
		p.draw(g2d);
		//start();
	}

	public Image GetbackgroundImage()
	{
		ImageIcon i=new ImageIcon(getClass().getResource("/images/background.jpg"));
		return i.getImage();
	}
	public void actionPerformed(ActionEvent e) 
	{	c.tick();
		
		timeCounter++;
		if(p.tick()){
			gamelooptimer.stop();
			 int reply = JOptionPane.showConfirmDialog(null, "Press Yes For New Game", "Game Over!", JOptionPane.YES_NO_OPTION);
		     if (reply == JOptionPane.YES_OPTION) {
		    	 p=new player(200,200,this);
				 ea.clear();
				 eb.clear(); 
				 gamelooptimer.start();
				 score = 0;
		     }
		     else {
		         System.exit(0);
		     }
		}
		repaint();	
		if(timeCounter % 60 == 0){
			int Randno=(int)(Math.random()*370);
			c.addenemy(new enemy(Randno));
		}
				
	}
	
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()){
		case KeyEvent.VK_LEFT:
		{
			p.vx=-1;
			//System.out.println("left");
			break;
		}
		case KeyEvent.VK_RIGHT:
		{
			p.vx=1;
			//System.out.println("right");
			break;
		}
		case KeyEvent.VK_UP:
		{
			p.vy=-1;
			//System.out.println("up");
			
			break;
		}
		case KeyEvent.VK_DOWN:
		{
			p.vy=1;			
			break;
		}
		case KeyEvent.VK_SPACE:
		{
			
			c.addshot(new shot(p.xpos+8,p.ypos,this));
			break;
		}
		case KeyEvent.VK_P:
		{
			gamelooptimer.stop();
			break;
		}
		case KeyEvent.VK_R:
		{
			gamelooptimer.start();
			break;
		}
		}
		
		}

		public void keyReleased(KeyEvent e) 
		{
			switch (e.getKeyCode()){
			case KeyEvent.VK_LEFT:
			{
				p.vx=0;
				break;
			}
			case KeyEvent.VK_RIGHT:
			{
				p.vx=0;
				break;
			}
			case KeyEvent.VK_UP:
			{
				p.vy=0;
				break;
			}
			case KeyEvent.VK_DOWN:
			{
				p.vy=0;
				break;
			}
			
			}
		
			
		
			
}
		
		
}
