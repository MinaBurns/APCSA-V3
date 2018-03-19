//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;

	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (int i = 0; i<word.length(); i++)
		{
			for(int j =0; j<word.length(); j++)
			{
				if (word.charAt(i) == vowels.charAt(j))
				{
					vowelCount++;
				}
				else
				{
					vowelCount = vowelCount;
				}
			}
		}
		return vowelCount;
	}

	public int compareTo(Word rhs)
	{
		if(this.numVowels()!=rhs.numVowels())
		{
			if(this.numVowels()>rhs.numVowels())
			{
				return 1;
			}
			else if (this.numVowels()<rhs.numVowels())
			{
			return -1;
			}
		}
		else if(this.numVowels()==rhs.numVowels())
		{
			if((int)word.charAt(0) > (int)rhs.toString().charAt(0))
			{
				return 1;
			}
			else if ((int)word.charAt(0) == (int)rhs.toString().charAt(0))
			{
				
			}
		}
		
	}

	public String toString()
	{
		return word;
	}
}