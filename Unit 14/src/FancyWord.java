//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

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
	   for(int i = 0; i<s.length(); i++)
	   {
		   mat[0][i]= s.charAt(i);
	   }
	   
	   
	}

	public String toString()
	{
		String output="";
		//if(mat.length%2==0)
		//{
			//for (int i = 0; i<mat.length; i++)
			//{
				//output = output+mat
			//}
		//}




		return output+"\n\n";
	}
}