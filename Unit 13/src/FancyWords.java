//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void setWords(String sentence)
	{
		
		
	}

	public String toString()
	{
		String output = "";
		int max = Integer.MIN_VALUE;
		for (int i = 0; i<wordRay.length; i++)
		{
			if(wordRay[i].length()>max)
			{
				max = wordRay[i].length();
			}
			wordRay[i] = new StringBuffer(wordRay[i]).reverse().toString(); //creates a string buffer so can reverse the chars, then converts back to a string by calling toString
		}
		System.out.println("wordRay after reversing characters: " + Arrays.toString(wordRay));
		Collections.reverse(Arrays.asList(wordRay)); //converts wordRay into List in order to flip from row to column
		for(int r = 0; r<max; r++)
		{
			for(int c = 0; c<wordRay.length; c++)
			{
				
				if(r<wordRay[c].length())
				{
					output = output + wordRay[c].charAt(r);
				}
			}
		}


		return output+"\n\n";
	}
}