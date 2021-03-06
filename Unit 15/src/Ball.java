//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collide
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

   public Ball(int x, int y)
   {
		super(x,y);
		xSpeed = 3;
		ySpeed= 1;
   }

   public Ball(int x, int y, int wid, int ht)
   {
		super(x,y,wid, ht);
		xSpeed = 3;
		ySpeed= 1;
   }

   public Ball(int x, int y, int wid, int ht, Color col)
   {
		super(x,y,wid,ht,col);
		xSpeed = 3;
		ySpeed= 1;
   }

   public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
		super(x,y,wid,ht);
		xSpeed = xSpd;
		ySpeed= ySpd;
   }

   public Ball(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		super(x,y,wid,ht,col);
		xSpeed = xSpd;
		ySpeed= ySpd;
   }

   public void setXSpeed( int xSpd )
   {
   	xSpeed = xSpd;
   }

   public void setYSpeed( int ySpd )
   {
   	ySpeed = ySpd;
   }

   public void moveAndDraw(Graphics window)
   {
   	//draws over the old ball with a white ball
   	draw(window,Color.white);

   	//draw(window,Color.red); //draws over the old ball with whichever color you want
   									//in case you want to have a trail

      setX(getX()+xSpeed);
      setY(getY()+ySpeed);

      draw(window);   //draws the Ball
   }

	public boolean equals(Object obj)
	{
		Ball other = (Ball)obj;
		if(super.equals(other)&&getXSpeed()==other.getXSpeed()&&getYSpeed()==other.getYSpeed())
		   return true;
		return false;
	}

   public int getXSpeed(  )
   {
		return xSpeed;
   }

   public int getYSpeed(  )
   {
   	return ySpeed;
   }

   public String toString()
   {
   	return super.toString()+" "+xSpeed+" "+ySpeed;
   }

 @Override
public boolean didCollideLeft(Object obj) {
	// TODO Auto-generated method stub
	Paddle paddle = (Paddle)obj;
	if (getX()<=paddle.getX()+paddle.getWidth()&&getX()>paddle.getX()&&(getY()>=paddle.getY() && getY()<=paddle.getY()+paddle.getHeight())){
		return true;
	}
	return false;
}

@Override
public boolean didCollideRight(Object obj) {
	Paddle paddle = (Paddle)obj;
	if (getX()+getWidth()>=paddle.getX()&&getX()<paddle.getX()&&(getY()>=paddle.getY() && getY()<=paddle.getY()+paddle.getHeight())){
		return true;
	}
	return false;
}

@Override
public boolean didCollideTop(Object obj) {
	Paddle paddle = (Paddle)obj;
	if (getY()+getHeight()>=paddle.getY() && getY() < paddle.getY()+paddle.getHeight() && (getX()>=paddle.getX() && getX()+getWidth()<=paddle.getX()+paddle.getWidth())){
		//if ((getY()>=paddle.getY() && getY()<=paddle.getY()+paddle.getHeight())
			//	||getY()>=paddle.getY() && getY()<paddle.getY()+paddle.getHeight()){
			return true;
		}
		return false;
}

@Override
public boolean didCollideBottom(Object obj) {
	// TODO Auto-generated method stub
	Paddle paddle = (Paddle) obj;
	if (getY()+getHeight()>paddle.getY() && getY() <= paddle.getY()+paddle.getHeight() && (getX()>=paddle.getX() && getX()+getWidth()<=paddle.getX()+paddle.getWidth())){
	//if ((getY()>=paddle.getY() && getY()<=paddle.getY()+paddle.getHeight())
			//||getY()+getHeight()>=paddle.getY()&&getY()+getHeight()<paddle.getY()+paddle.getHeight()){
				return true;
						
			}
	return false;
}


}