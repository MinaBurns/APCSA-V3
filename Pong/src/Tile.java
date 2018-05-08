import java.awt.Color;
import java.awt.Graphics;

public class Tile extends Block
{
	public Tile(int x, int y, int h, int w)
	{
		super(x, y, h, w);
	}
	
	public Tile(int x, int y, int h, int w, Color col)
	{
		super(x, y, h, w, col);
	}
}
