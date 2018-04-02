//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;
   private int xPos;
   private int yPos;
   private int width;
   private int height;
   
   private Color color;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }

 //x, y, wid, ht, color, ySpd
   //add the other Paddle constructors

   public Paddle(int x, int y)
   {
	   xPos = x;
	   yPos = y;
	   width = 1;
	   height = 1;
	   color = Color.black;
	   speed = 1;
   }

   public Paddle(int x, int y, int wid)
   {
	   xPos = x;
	   yPos = y;
	   width = wid;
	   height = 1;
	   color = Color.black;
	   speed = 1;
   }
   
   public Paddle(int x, int y, int wid, int ht, int spd)
   {
	   xPos = x;
	   yPos = y;
	   width = wid;
	   height = ht;
	   color = Color.black;
	   speed = spd;
   }
   
   public Paddle(int x, int y, int wid, int ht, Color col, int spd)
   {
	   xPos = x;
	   yPos = y;
	   width = wid;
	   height = ht;
	   color = Color.black;
	   speed = spd;
   }

   public int getX()
   {
	   return xPos;
   }
   
   public int getY()
   {
	   return yPos;
   }
   
   public int getWidth()
   {
	   return width;
   }
   
   public int getHeight()
   {
	   return height;
   }
   
   public Color getColor()
   {
	   return color;
   }
   
   public int getSpeed()
   {
	   return speed;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   setY(getY()-getSpeed());
	   draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   setY(getY()+getSpeed());
	   draw(window);

   }
   
   public boolean equals(Paddle other)
   {
	   if(xPos == other.getX() && yPos == other.getY() && width == other.getWidth() && height == other.getHeight() && speed == other.getSpeed() && color == other.getColor())
	   {
		   return true;
	   }
	   return false;
   }
   

   public String toString()
   {
	   String output = "";
	   output += "x pos: " + getX() + "\n";
	   output += "y pos: " + getY() + "\n";
	   output += "height: " + getHeight() + "\n";
	   output += "width: " + getWidth() + "\n";
	   output += "color: " + getColor() + "\n";
	   output += "speed: " + getSpeed() + "\n";
	   return output;
   }
}