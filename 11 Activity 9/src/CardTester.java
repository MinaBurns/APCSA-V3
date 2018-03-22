/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card test = new Card("King", "Hearts", 3);
		System.out.println(test.toString());
		Card test2 = new Card("9", "Diamonds", 9);
		System.out.println(test2.toString());
		Card test3 = new Card("2", "Clubs", 2);
		System.out.println(test3.toString());
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
	}
}
