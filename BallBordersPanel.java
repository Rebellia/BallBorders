import javax.swing.*; //To use JPanel
import java.awt.event.*; //To have event listeners
import java.awt.*; //For Graphics and Colors


public class BallBordersPanel extends JPanel
{
	//instance variables
	private Timer ballTimer;
	private int circEnd; //bottom of circle
	private int circX; //x-coordinate of circle
	private int circY; //y-coordinate of circle
	private int ballDiameter;
	private int ballCenter;
	
	private int stepX; //increment by which the ball will move
	private int stepY;
	

	
	
	private char letter = 'Q';
	
	//constructor
	public BallBordersPanel()
	{
		circEnd = circX + ballDiameter;
		ballDiameter = 30;
		ballCenter = ballDiameter/2;
		circX = 50;
		circY = 50;
		ballTimer = new Timer(10, new BallListener());
		ballTimer.start();
		
		
		
		stepX = 5;
		stepY = 5;
	
	}
	//accessor for timer
	
	//paintcomponent
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		setBackground(Color.black);//changes background color to black
		
		//ball
		page.setColor(Color.yellow);
		page.fillOval(circX, circY, ballDiameter, ballDiameter);
		
		
		
	}//end of paintComponent
	
	
	
	//listenerclass
	private class BallListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			circX+=stepX; //moves the ball to the left
			circY+=stepY; //moves the ball down

			
			//if hits bottom or top border: y * -1
			if ((circY <= 0) || ((circY + ballDiameter) >= getHeight()))
			{
				stepY = stepY * -1;
			}
			//if hits left or right border: x * -1
			if ((circX <= 0) || ((circX + ballDiameter) >= getWidth()))
			{
				stepX = stepX * -1;
			}

			
			repaint(); //calls the paint method indirectly
		}
	}//end of BallListener class
	

}