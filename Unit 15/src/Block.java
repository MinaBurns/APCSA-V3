//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 150;
		width = 100;
		height = 100;
		color = Color.black;

	}

	//add other Block constructors - x , y , width, height, color
	
	public Block (int width, int height)
	{
		xPos = 100;
		yPos = 150;
		setWidth(width);
		setHeight(height);
		color = Color.black;
	}
	
	public Block (int x, int y, int width, int height, Color c)
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(c);
	}
	
	
	public Block (int x, int y, int width, int height)
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		color = Color.blue;
	}
	
   //add the other set methods
   
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
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

   public void setColor(Color col)
   {
	   color = col;

   }
   
   public void setPos(int x, int y)
   {
	   xPos = x;
	   yPos = y;
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

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Block obj)
	{
		if(xPos==obj.getX() && getY()==obj.getY() && getWidth() == obj.getWidth() && getHeight() == obj.getHeight() && getColor() == obj.getColor())
		{
			return true;
		}

		return false;
	}   

	public String toString()
	{
		String output = "";
		output = output + "x and y position;" + getX() + ", " + getY() + "\n" + "width: " + getWidth() + "\n" + "height:" + getHeight() + "\n" + "color: " + getColor() + "\n\n";
		
		return output;
	}

   //add a toString() method  - x , y , width, height, color
}