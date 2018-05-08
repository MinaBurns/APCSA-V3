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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	//private Paddle rightPaddle;
	//private Tile aboveTile1;
	//private Tile aboveTile2;
	//private Tile rightTile1;
	//private Tile rightTile2;
	//private Tile leftTile1;
	//private Tile leftTile2;
	//private Tile belowTile1;
	//private Tile belowTile2;
	private ArrayList<Tile> aboveTiles;
	private ArrayList<Tile> belowTiles;
	private ArrayList<Tile> leftTiles;
	private ArrayList<Tile> rightTiles;
	private boolean[] keys;
	private BufferedImage back;
	private int leftPoints = 0;
	private int rightPoints = 0;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(10,100,10,10, Color.blue,2, 1);
		leftPaddle = new Paddle(50,150,80,80, Color.GREEN,5);
		//rightPaddle = new Paddle(750, 150, 20, 80, Color.green,5);
		aboveTiles = new ArrayList<Tile>();
		belowTiles = new ArrayList<Tile>();
		leftTiles = new ArrayList<Tile>();
		rightTiles = new ArrayList<Tile>();
		for(int i = 0; i<800; i+=40)
		{
			aboveTiles.add(new Tile(i, 0, 38, 10, Color.blue));
			aboveTiles.add(new Tile(i, 11, 38, 10, Color.CYAN));
			belowTiles.add(new Tile(i, 550, 38, 10, Color.magenta));
			belowTiles.add(new Tile(i, 538, 38, 10, Color.ORANGE));
		}
		
		
		for(int j = 20; j<540; j+=40)
		{
			leftTiles.add(new Tile(0, j, 10, 38, Color.GREEN));
			leftTiles.add(new Tile(11, j, 10, 38, Color.RED));
			rightTiles.add(new Tile (775, j, 10, 38, Color.pink));
			rightTiles.add(new Tile(763, j, 10, 38, Color.yellow));
		}
		

		

		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		for(Tile one: aboveTiles)
		{
			one.draw(graphToBack);
		}
		
		for(Tile one: belowTiles)
		{
			one.draw(graphToBack);
		}
		
		
		for(Tile one: leftTiles)
		{
			one.draw(graphToBack);
		}
		
		for(Tile one: rightTiles)
		{
			one.draw(graphToBack);
		}
		
		
		graphToBack.setColor(Color.red);
		graphToBack.drawString("Left Player: "+leftPoints, 200, 500);
		//graphToBack.drawString("Right Player: " + rightPoints, 300, 500);

		
		//see if ball hits left wall or right wall
		if(!(ball.getX()>10 && ball.getX()+ball.getWidth()<getWidth()))
		{
			ball.moveAndDraw(window);

			if(!(ball.getX()>=1 && ball.getX()<=780))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}

			if(!(ball.getY()>=1 && ball.getY()<=599))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
			ball.draw(graphToBack, Color.WHITE);
			ball.setXSpeed(-(ball.getXSpeed()));
			ball.setYSpeed(-(ball.getYSpeed()));
			//ball = new Ball(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), ball.getColor(), -(ball.getXSpeed()), -(ball.getYSpeed()));
			ball.moveAndDraw(graphToBack);
			/*
			if(ball.getXSpeed() >0)
			{
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Right Player: " + rightPoints, 300, 500);
				rightPoints++;
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("Right Player: " + rightPoints, 300, 500);
			}
			*/
			if(ball.getXSpeed()<0)
			{
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left Player: " + leftPoints, 200, 500);
				leftPoints++;
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("Left Player: " + leftPoints, 200, 500);
			}
			
			

		}

		
		
		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=0 && ball.getY()<=getHeight()))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		//see if the ball hits the left paddle
		/*
		if(ball.getX()-ball.getWidth() == leftPaddle.getX()+leftPaddle.getWidth())
		{
		ball.setXSpeed(-(ball.getXSpeed()));
		ball.setYSpeed(-(ball.getYSpeed()));
		}
		*/

/*   
   if(ball.getX()>=leftPaddle.getX()-leftPaddle.getWidth() && ball.getY()==leftPaddle.getY() && (ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()))
	{
	}
	*/
		
		//see if the ball hits the right paddle
		/*
		if(ball.getX()>=rightPaddle.getX()-rightPaddle.getWidth() && ball.getY()==rightPaddle.getY() && (ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()))
		{
			if(ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth() + Math.abs(ball.getXSpeed()))
			{
			ball.setXSpeed(-(ball.getXSpeed()));
			ball.setYSpeed(-(ball.getYSpeed()));
			}
		}
		*/
		
		if(ball.didCollideLeft(leftPaddle)||ball.didCollideRight(leftPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}
		else if (ball.didCollideTop(leftPaddle) ||ball.didCollideBottom(leftPaddle))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
		
		for(Tile one: aboveTiles)
		{
			if(ball.didCollideLeft(one)||ball.didCollideRight(one))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
			else if (ball.didCollideTop(one) ||ball.didCollideBottom(one))
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
		}
		
		for(Tile one: belowTiles)
		{
			if(ball.didCollideLeft(one)||ball.didCollideRight(one))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
			else if (ball.didCollideTop(one) ||ball.didCollideBottom(one))
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
		}
		for(Tile one: rightTiles)
		{
			if(ball.didCollideLeft(one)||ball.didCollideRight(one))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
			else if (ball.didCollideTop(one) ||ball.didCollideBottom(one))
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
		}
		
		for(Tile one: leftTiles)
		{
			if(ball.didCollideLeft(one)||ball.didCollideRight(one))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
			else if (ball.didCollideTop(one) ||ball.didCollideBottom(one))
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
		}


		//see if the paddles need to be moved
		
			if (keys[0]==true)
			{
				leftPaddle.moveLeftAndDraw(graphToBack);
				//leftPaddle.setY((leftPaddle.getY()+10));
			}
			if(keys[1]==true)
			{
				leftPaddle.moveRightAndDraw(graphToBack);
				//leftPaddle.setY((leftPaddle.getY()-10));
			}
			if(keys[2]==true)
			{
				leftPaddle.moveUpAndDraw(graphToBack);
				//rightPaddle.setY((rightPaddle.getY()+10));
			}
			if(keys[3]==true)
			{
				leftPaddle.moveDownAndDraw(graphToBack);
				//rightPaddle.setY((rightPaddle.getY()-10));
			}
		
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
/*
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'I' : keys[0]=false; break;
			case 'K' : keys[1]=false; break;
			case 'L' : keys[2]=false; break;
			KeyEvent.VK_LEFT : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	*/
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}

 
   
}