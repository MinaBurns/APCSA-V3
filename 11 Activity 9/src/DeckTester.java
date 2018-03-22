/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		//Deck(String[] ranks, String[] suits, int[] values)
		String[] ranks1 = {"A", "2", "3"};
		String[] suits1 = {"Diamonds", "Clubs", "Spades"}; 
		int[] values1 = {1, 2, 3};
		Deck test1 = new Deck (ranks1, suits1, values1);
		System.out.println(test1.isEmpty());
		
		String[] ranks2 = {"K", "Q", "J"};
		String[] suits2 = {"Hearts", "Spades", "Clubs"}; 
		int[] values2 = {13, 12, 11};
		Deck test2 = new Deck (ranks2, suits2, values2);
		System.out.println(test2.deal());
		
		String[] ranks3 = {"5", "6", "7"};
		String[] suits3 = {"Hearts", "Spades", "Clubs"}; 
		int[] values3 = {5, 6, 7};
		Deck test3 = new Deck (ranks3, suits3, values3);
		System.out.println(test3.size());
		
		String[] ranks4 = {"5", "6", "A"};
		String[] suits4 = {"Diamonds", "Spades", "Clubs"}; 
		int[] values4 = {5, 6, 1};
		Deck test4 = new Deck (ranks4, suits4, values4);
		System.out.println(test4.toString());
	
		String[] ranks5 = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits5 = {"Diamonds", "Spades", "Clubs", "Hearts"}; 
		int[] values5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		Deck test5 = new Deck (ranks5, suits5, values5);
		test5.shuffle();
		System.out.println(test5.toString());
	}
	
}
