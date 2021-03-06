//� A+ Computer Science  -  www.apluscompsci.com
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
			for(int j = 0; j<vowels.length(); j++)
			{
				if (vowels.charAt(j)==word.charAt(i))
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
	
	


	public int compareTo (Word rhs)
	{
		if(this.numVowels()!=rhs.numVowels())
		{
			if(numVowels()>rhs.numVowels())
			{
				return 1;
			}
			else if (numVowels()<rhs.numVowels())
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
				if((int)word.charAt(0)>(int)rhs.toString().charAt(0))
				{
					return 1;
				}
				else if ((int)word.charAt(0)==(int)rhs.toString().charAt(0))
				{
					if((int)word.charAt(1)>(int)rhs.toString().charAt(0))
					{
						return 1;
					}
					if((int)word.charAt(1) == (int)rhs.toString().charAt(1))
					{
						return 0;
					}
					else
					{
						return -1;
					}
					
				}
				else
				{
					return -1;
				}
			}
		}
		return 0;
		
	}
	
	
	/**
	public int compareTo(Word rhs)
	{
		if(word.length()!=rhs.toString().length())
		{
			if(word.length()>rhs.toString().length()){
				return 1;
			}
			return -1;
		}
		else if (word.length() == rhs.toString().length()){
			if(word.charAt(0) > rhs.toString().charAt(0))
			{
				return 1;
			}
			else if (word.charAt(0) == rhs.toString().charAt(0))
			{
				if (word.charAt(1) > rhs.toString().charAt(1))
				{
					return 1;
				}
				if (word.charAt(1) == rhs.toString().charAt(1))
				{
					return 0;
				}
				else
				{
					return -1;
				}
			}
			return -1;
		}
		return 0;
	}
	**/

	public String toString()
	{
		return word;
	}
}