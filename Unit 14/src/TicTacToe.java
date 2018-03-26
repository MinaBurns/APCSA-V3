//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[0][0];
	}

	public TicTacToe(String game)
	{
		for(int i = 0; i<game.length(); i++)
		{
			mat[i/3][i%3] = game.charAt(i);
		}
	}

	public String getWinner()
	{
		for(int i = 0; i<3; i++)
		{
			if (mat[i][0] ==mat[i][1]&&mat[i][1]==mat[i][2])
			{
				return mat[i][0] + "wins horizontally!";
			}
			if (mat[0][i] ==mat[1][i]&&mat[1][i]==mat[2][i])
			{
				return mat[0][i] + "wins vertically!";
			}
		}
		if(mat[1][1]==mat[2][2]&& mat[2][2]==mat[3][3])
		{
			return mat[1][1] + "wins diagonally!";
		}
		if(mat[1][3]==mat[2][2]&& mat[2][2]==mat[3][1])
		{
			return mat[1][3] + "wins diagonally!";
		}
		return "cats game- no winner";
	}

	public String toString()
	{
		String output="";
		for(int r =0; r<mat.length; r++)
		{
			for(int c = 0; c<mat[r].length; c++)
			{
				output = output + mat[r][c];
			}
			output = output + "\n";
		}

		return output+ getWinner();
	}
}