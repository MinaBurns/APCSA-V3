//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.*;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball five;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
		five = new Ball(100,100,30,50,Color.BLUE,2,2);
		five.equals(five);
		
		/*
		five.setxPos(250);
		out.println(five);
		
		five.setyPos(250);
		out.println(five);
		
		five.setWidth(80);
		out.println(five);
		
		five.setHeight(75);
		out.println(five);
		
		five.setxPos(4);
		out.println(five);
		
		five.setyPos(2);
		out.println(five);
		   
		five.setColor(Color.green);
		out.println(five);
		//test the Ball thoroughly
		

		//test all constructors
		 */


		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		five.moveAndDraw(window);

		if(!(five.getX()>=10 && five.getX()<=550))
		{
			five.setXSpeed(-five.getXSpeed());
		}

		if(!(five.getY()>=10 && five.getY()<=450))
		{
			five.setYSpeed(-five.getYSpeed());
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}