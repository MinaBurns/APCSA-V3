//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class BlockTestTwo extends Canvas
{
	public BlockTestTwo()
	{
		setBackground(Color.WHITE);
	}

	public void paint(Graphics window)
	{
		//two.draw(window, Color.white);
		Block one = new Block(5, 50, 30, 300);
		one.draw(window);

		Block two = new Block(500,50,30,300);
		two.draw(window);
		

		//Block three = new Block(350,350,15,15,Color.RED);
		//three.draw(window);

		//Block four = new Block(450,50,20,60, Color.GREEN);
		//four.draw(window);
		
		//add more test cases			
	}
}