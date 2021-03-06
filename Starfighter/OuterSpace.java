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

import javax.swing.JFrame;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	//private AlienHorde alienOne;
	//private Alien alienTwo;
	private Butterfly butterfly;
	
   private AlienHorde horde;

	private Bullets shots = new Bullets();
	//private boolean game;
	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace(JFrame par)
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(350, 450, 80, 80, 2);
		horde = new AlienHorde(5);
		shots = new Bullets();
		butterfly = new Butterfly(500, 100, 80, 80, 3);
		//alienTwo = new Alien(200, 100, 13);
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
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

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,getWidth(),getHeight());
		
		
		ship.draw(graphToBack);
		//shots.cleanEmUp(graphToBack);
		//alienTwo.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		butterfly.draw(graphToBack);
		horde.drawEmAll(graphToBack);
		shots.moveEmAll();
		
		shots.cleanEmUp(graphToBack);
		horde.removeDeadOnes(shots.getList());
		
		boolean game =true;
		
		
		
		if(butterfly.collision(ship, graphToBack) == true)
		{
			game = false;
		}

		if(horde.Win())
		{
			graphToBack.clearRect(0, 0, 800, 600);
			//window.setColor(Color.black);
			graphToBack.setColor(Color.CYAN);
			graphToBack.drawString("You win!", 400, 300);
		}
		
		if(game == true)
		{
			horde.moveEmAll();
			//shots.moveEmAll();
			butterfly.move("DOWN");
		} 
		
		if(game==false)
		{
			graphToBack.clearRect(0, 0, 800, 600);
			//window.setColor(Color.black);
			graphToBack.setColor(Color.CYAN);
			graphToBack.drawString("Sorry, you lost!", 400, 300);
		} 
		
		
		
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		
		if(keys[1]==true)
		{
			ship.move("RIGHT");
		}
		
		if(keys[2]==true)
		{
			ship.move("DOWN");
		}
		if(keys[3]==true)
		{
			ship.move("UP");
		}
		if(keys[4]==true)
		{
			shots.add(new Ammo(ship.getX()+(ship.getWidth()/2), ship.getY(), 8));
			keys[4]=false;
		}
		//add code to move Ship, Alien, etc.
		
		
		
		twoDGraph.drawImage(back, null, 0,0);
		back = null;
		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship

	}


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
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

