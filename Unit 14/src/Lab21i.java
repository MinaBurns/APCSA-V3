//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File ("C:\\Users\\burnsc6389\\Desktop\\APCSA-V3\\Unit14_2016\\Unit14_2016\\Unit14-Assignments"));
		int length = file.nextInt();
		String s = file.nextLine();
		Maze test = new Maze(length, s);
	}
}