//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   int row;
   int col;

	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
	}

	public int countAts(int r, int c)
	{
		row = r;
		col = c;
		if(r>=0 && c>=0 && r<atMat.length && c < atMat.length && atMat[r][c] == '@')
		{
			atCount++;
			//char save = atMat[r][c];
			atMat[r][c]='0';
			countAts(r,c-1);
			countAts(r,c+1);
			countAts(r-1,c);
			countAts(r+1,c);
			//atMat[r][c]= save;
		}
		return 0;
		
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+= row + ", " + col+ " has " + getAtCount()+" @s connected.";
		return output;
	}
}