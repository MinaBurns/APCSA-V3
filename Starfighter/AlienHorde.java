//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>(size);
		int x = 50;
		int y = 100;
		int speed = 2;
		for (int i = 0; i<size; i++)
		{
			aliens.add(new Alien(x,y,2));
			x+=65;
			if(x>=670)
			{
				x=80;
				speed = -speed;
				y+=80;
			}
		}
		
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for( int i = 0; i<aliens.size(); i++)
		{
			aliens.get(i).draw(window);
		}
	}

	public void moveEmAll()
	{
		
		for(Alien al : aliens)
		{
			al.move("DOWN");
		}
		/*
		for( int i = 0; i<aliens.size(); i++)
		{
			//if(aliens.get(i).getX()>=750-aliens.get(i).getWidth())
			//{
				//aliens.get(i).move("LEFT");
			//}
			aliens.get(i).move("RIGHT");	
		}
		*/
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(int j = 0; j<aliens.size(); j++)
		{
			for(int i = 0; i<shots.size(); i++)
			{
				if(shots.get(i).getX() >= aliens.get(j).getX() && shots.get(i).getX() <=aliens.get(j).getX() + 45 && shots.get(i).getY() <=aliens.get(j).getY() +70)
				{
					aliens.remove(j);
					shots.remove(i);
					if(shots.size()==0)
					{
						break;
					}
				}
			}
		}
	}
	
	public boolean Win()
	{
		if(aliens.size()==0)
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return "";
	}
}
