import java.util.LinkedList;


public class physics 
{
	static int id;
	public  static boolean Collision(entityA enta,LinkedList<entityB> entb)
	{
		for(int i=0;i<entb.size();i++)
		{
			if(enta.getBounds().intersects(entb.get(i).getBounds())){
				id=i;
				return true;
				
			}
			
			
		}
		return false;
	}
	
	public static int getID()
	{
		return id;
	}
	
	


}
