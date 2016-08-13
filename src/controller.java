import java.awt.Graphics2D;
import java.util.LinkedList;


public class controller {

	private LinkedList<entityA> ea =new LinkedList<entityA>();
	private LinkedList<entityB>eb=new LinkedList<entityB>();
	game game;
	player p;

	public controller(game game)
	{	
		this.game=game;
		//addshot(new shot(200,300,game));
	}
	entityA enta;
	entityB entb;
	
	entityB temp;
	
		
	int count=0;
	public void tick()
	{
		for(int i=0;i<ea.size();i++)
		{
			//tempshot=ea.get(i);
			enta=ea.get(i);
			if(enta.tick()){
				ea.remove(i);
			};
			
		}
		for(int j=0;j<eb.size();j++)
		{
	  		entb=eb.get(j);
			if(game.getScore() > 30 && eb.get(j).getSpeed()<2){
				eb.get(j).setSpeed(eb.get(j).getSpeed()+1);
			}
			
			if(entb.getcollision())
			{
				eb.remove(j);
			}
			entb.tick();
			
		}
	}
	public void render(Graphics2D g2d)
	{

		for(int i=0;i<ea.size();i++)
		{
			//tempshot=s.get(i);
			enta=ea.get(i);
			enta.draw(g2d);
			
		}
		for(int j=0;j<eb.size();j++)
		{
			//tempenemy=e.get(j);
			entb=eb.get(j);
			
			entb.draw(g2d);
		}
	
		
	}
	
	public void addshot(shot block)
	{
		ea.add(block);
	}
	public void removeshot(shot block)
	{
		ea.remove(block);
	}
	public void addenemy(enemy block)
	{
		eb.add(block);
	}
	public void removeenemy(int i)
	{
		
		entb=eb.remove(i);
		
	}
	public LinkedList<entityA> getEntityA()
	{
		return ea;
		
	}
	public LinkedList<entityB> getEntityB()
	{
		return eb;
		
	}
}

