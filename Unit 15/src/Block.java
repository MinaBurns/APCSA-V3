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
		xPos = 0;
		yPos = 0;
		width = 0;
		height = 0;
		color = Color.white;

	}

	//add other Block constructors - x , y , width, height, color
	public Block (int x, int y, int width, int height, Color c)
	{
		setXPos(x);
		setYPos(y);
		setWidth(width);
		setHeight(height);
		setColor(c);
	}
	
	
   //add the other set methods
   
	public void setXPos(int x)
	{
		xPos = x;
	}
	
	public void setYPos(int y)
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
		
		return output;
	}

   //add a toString() method  - x , y , width, height, color
}