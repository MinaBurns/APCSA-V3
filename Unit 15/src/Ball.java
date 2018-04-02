//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;
	public int width;
	public int height;
	public int xPos;
	public int yPos;
	
	private Color color;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int xPos, int yPos)
	{
		setxPos(xPos);
		setyPos(yPos);
		width = 1;
		height = 1;
		color = Color.black;
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int xPos, int yPos, int width, int height)
	{
		setxPos(xPos);
		setyPos(yPos);
		setWidth(width);
		setHeight(height);
		color = Color.black;
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int xPos, int yPos, int width, int height, Color c)
	{
		setxPos(xPos);
		setyPos(yPos);
		setWidth(width);
		setHeight(height);
		setColor(c);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int xPos, int yPos, int width, int height, Color c, int xSpeed, int ySpeed)
	{
		setxPos(xPos);
		setyPos(yPos);
		setWidth(width);
		setHeight(height);
		setColor(c);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}
	public void setxPos(int x)
	{
		xPos = x;
	}
	
	public void setyPos(int y)
	{
		yPos = y;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public void setXSpeed(int x)
	{
		xSpeed = x;
	}
	
	public void setYSpeed(int y)
	{
		ySpeed = y;
	}
	   
	public void setColor(Color c)
	{
		color = c;
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
  
  public int getXSpeed()
  {
	  return xSpeed;
  }
  
  public int getYSpeed()
  {
	  return ySpeed;
  }
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   draw(window, Color.white);

      setX(getX()+xSpeed);
      setY(getY() + ySpeed);
      draw(window);
		//setY

		//draw the ball at its new location
   }
   
	public boolean equals(Ball obj)
	{
		Ball other = (Ball)obj;
		if(xPos==other.getX() && getY()==other.getY() && getWidth() == other.getWidth() && getHeight() == other.getHeight() && getColor() == other.getColor() && getXSpeed() ==other.getXSpeed() && getYSpeed() == other.getYSpeed())
		{
			return true;
		}

		return false;
	}   
	
	public String toString()
	{
		String output = "";
		output = output + "x and y position;" + getX() + ", " + getY() + "\n";
		output = output+ "width: " + getWidth() + "\n";
		output = output + "height:" + getHeight() + "\n";
		output = output + "color: " + getColor() + "\n";
		output = output + "X Speed: " + getXSpeed() + "\n";
		output = output + "Y Speed: " + getYSpeed() + "\n\n";
		
		return output;
	}
	
}