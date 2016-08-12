import javax.swing.*; //to use JApplet

public class BallBorders extends JApplet
{
	public void init()
	{
		getContentPane().add(new BallBordersPanel());
		setSize(500,300);
	}
}