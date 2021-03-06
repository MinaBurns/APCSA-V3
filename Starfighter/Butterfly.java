import java.io.File;
import java.net.URL;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Butterfly extends MovingThing {
	private int speed;
	//private int width;
	//private int Xpos;
	private Image image;

	public Butterfly()
	{
		this(0,0,30,30,0);
	}

	public Butterfly(int x, int y)
	{
		
		super(x,y);
		//Xpos=x;
	}

	public Butterfly(int x, int y, int s)
	{
		
		
		this(x,y,30, 40, s);
		speed = s;
		//Xpos = x;
		//width = 30;
	}

	public Butterfly(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		//Xpos = x;
		//width = w;
		try
		{
			//URL url = getClass().getResource("src/alien.jpg");
			//image = ImageIO.read(url);
			image = ImageIO.read(new File("C:\\Users\\burnsc6389\\Desktop\\APCSA-V3\\Starfighter\\butterfly.png"));
		}
		catch(Exception e)
		{
			System.out.println("error in Butterfly");
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
	
	
	public boolean collision(Ship ship, Graphics window)
	{
		boolean collide =false;
		/*	
		if( ((ship.getX() >= this.getX() && ship.getX() <=this.getX() + 45) 
					|| (ship.getX() +50 <=this.getY() && ship.getX()+50 <=this.getX()+45)) 
					&& (( ship.getY()+55 >=this.getY() && ship.getY() +55 <= this.getY()+50) 
					|| (this.getY() <=ship.getY() && ship.getY()<=this.getY()+50)))
			*/
		if(ship.getX() >= this.getX() && ship.getX() <=this.getX() + 45 && ship.getY() <=this.getY() +70)	
		{
				collide = true;
			}
		
		return collide;
	}
	
	public void clearscreen(Graphics window)
	{
		window.clearRect(0, 0, 800, 600);
		//window.setColor(Color.black);
		window.drawString("Sorry, you lost!", 400, 300);
	}

	public String toString()
	{
		return "";
	}
}
