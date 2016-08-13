import javax.swing.JFrame;

public class MainClass {
	 
	
	public static void main(String args[]){
		
		
		 JFrame frame=new JFrame("Space impact");
		 frame.pack();
		 frame.setSize(600,400);
		 frame.setResizable(false);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 game g= new game();
		 frame.add(g);
		// g.start();
		 
		 
		 
		 frame.setVisible(true);
	}

}
