//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = new char[0][0];
	}

   public FancyWord(String s)
	{
	   int end = s.length();
	   mat = new char[end][end];
	   for(char[] row: mat)
	   {
		   Arrays.fill(row, ' ');
	   }
	   for(int i = 0; i<s.length(); i++)
	   {
		   int bottomrow = s.length()-1-i;
		   mat[0][i]= s.charAt(i);
		   mat[bottomrow][i]= s.charAt(i);
		   mat[i][i] = s.charAt(i);
		   mat[s.length()-1][i]= s.charAt(i);
	   }
	   
	}

	public String toString()
	{
		String output="";
		for(int i = 0; i<mat.length; i++)
		{
			for(int a = 0; a<mat[i].length; a++)
			{
				output = output+mat[i][a];
			}
			output = output +"\n";
		}
		return output+"\n\n";
	}
}