import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 	System.out.println("Mina Burns, Period 1, 3/23/2018, 09");
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if(selectedCards.size()==2)
		{
			return(containsPairSum15(selectedCards));
		}
		if(selectedCards.size()==1)
		{
			return(containsK(selectedCards));
		}
		return false;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		if(containsPairSum15(cardIndexes())||containsK(cardIndexes()))
			return true;
		else
			return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum15(List<Integer> selectedCards) {
		//int ptvalue = 0;
		//if(selectedCards.size()>=3)
		//{
			//return false;
		//}
		for (int i = 0; i<selectedCards.size()-1; i++)
		{
			for (int j = 0; j<selectedCards.size(); j++)
			{
				if(cardAt(selectedCards.get(i)).pointValue() +cardAt(selectedCards.get(j)).pointValue()==15)
				{
					return true;
				}
			}
			
		}
		return false;
		/**
		for(int i = 0; i< selectedCards.size(); i++)
		{
			for (int j = 0; j<POINT_VALUES.length; j++)
			{
				if (selectedCards.get(i) == POINT_VALUES[j])
				{
					ptvalue = POINT_VALUES[j];
				}
			}
			for(int k = 0; k<selectedCards.size(); k++)
			{
				for(int l =0; l<POINT_VALUES.length; l++)
				{
					if(selectedCards.get(i)==POINT_VALUES[l])
					{
						if(ptvalue+POINT_VALUES[l]==11)
						{
							return true;
						}
					}
				}
			}
			**/
		}
		
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsK(List<Integer> selectedCards) {
		//boolean isJack = false;
		//boolean isQueen = false;
		boolean isKing = false;
		//if(selectedCards.size()>1)
		//{
			//return false;
		//}
		
		if((cardAt(selectedCards.get(0))).rank()==RANKS[12])
		{
			isKing = true;
		}
		
		
		/**
		for (int i = 0; i<selectedCards.size(); i++)
		{
			//if(cardAt(selectedCards.get(i)).rank()=="jack")
			//{
				//isJack = true;
			//}
			//if(cardAt(selectedCards.get(i)).rank()== RANKS[11])
			//{
				//isQueen = true;
			//}
			if(cardAt(selectedCards.get(i)).rank()== "king")
			{
				isKing = true;
			}
		}
		**/
		if(isKing==true)
		{
			return true;
		}
		return false;
		
		
	}

}
