//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	//private int width;
	//private int Xpos;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		
		super(x,y);
		//Xpos=x;
	}

	public Alien(int x, int y, int s)
	{
		
		
		this(x,y,30, 40, s);
		speed = s;
		//Xpos = x;
		//width = 30;
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		//Xpos = x;
		//width = w;
		try
		{
			//URL url = getClass().getResource("src/alien.jpg");
			//image = ImageIO.read(url);
			image = ImageIO.read(new File("C:\\Users\\burnsc6389\\Desktop\\APCSA-V3\\Starfighter\\alien.JPG"));
		}
		catch(Exception e)
		{
			System.out.println("error in Alien");
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}
	

	public int getSpeed()
	{
	   return speed;
	}
/*
	public void setX(int x)
	{
		super.setX(x);
	}
	
	public void setY(int y)
	{
		super.setY(y);
	}
	*/
	/*
	
	public int getWidth()
	{
		return width;
	}
	
	public int getX()
	{
		return Xpos;
	}
	*/
	
   public void move(String direction)
	{
	   /*
	   if (direction.equals("LEFT"))
		{
			setX(super.getX()-speed);
		}
		if (direction.equals("RIGHT"))
		{
			setX(super.getX()+speed);
		}
		if (direction.equals("UP"))
		{
			setY(super.getY()+speed);
		}
		if (direction.equals("DOWN"))
		{
			setY(super.getY()-speed);
			
		}
		*/
	   if(direction.equals("DOWN"))
	   {
		   //System.out.println("moving alien");
		   //System.out.println("Alien pos:" + getX() + " " + 800);
		   if(getX() > 800 || getX()<20)
		   {
			   //System.out.println("alien with bound to move");
			   speed = -speed;
			   setY(getY()+25);
		   }
		   
		setX(getX()+getSpeed());
		//System.out.println("alien X coord and speed: " + getX() + " " + getSpeed());
	   }
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
   	//System.out.println("Drawing alien" + getX() + getY());
	}
	

	public String toString()
	{
		return "";
	}
}
