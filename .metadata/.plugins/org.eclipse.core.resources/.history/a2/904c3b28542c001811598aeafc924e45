//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\burnsc6389\\Documents\\GitHub\\APCSA-V3\\Unit12-2016(1)\\Unit12-2016\\Unit12-Assignments\\lab18d.dat"));

		int size = file.nextInt();
		file.nextLine();
		Word[] wordList = new Word[size];
		for(int i = 0; i<size; i++)
		{
			wordList[i] = new Word(file.nextLine());
		}
		for(int i = 0; i<size; i++)
		{
			for (int j = 0; j< size-1; j++)
			{
				if (wordList[j].compareTo(wordList[j+1])==1)
				{
					Word one = wordList[j+1];
					wordList[j+1] = wordList[j];
					wordList[j] = one;
				}
			}
		}
		
		for(int i = 0; i<size; i++)
		{
			System.out.println(wordList[i].toString());
		}











	}
}