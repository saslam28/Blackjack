import java.util.Random;

import java.util.Random;

/**
 * An implementation of a deck of cards
 * 
 * @author suleman.aslam
 *
 */
public class Deck {
	
	/**
	 * The array of cards in the deck where the top card is the first index
	 */
	private Card[] myCards;
	
	/**
	 * Number of cards currently in the deck
	 */
	private int numCards;
	
	// overloading 
	// call the other constructor, defining one deck without shuffling
	public Deck() {
	
		this(1, false);
	}
	
	/**
	 * Constructor that defines how many deck of 52 cards and the boolean is implemented in case 
	 the deck needs to be shuffled
	 * @param numDeck
	 * @param shuffle
	 */
	
	public Deck(int numDecks, boolean shuffle) {

		this .numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		// card index
		
		int c =0;
		
		// for each deck
		for (int d = 0; d < numDecks; d ++) {
			
			// for each suit
			
			for (int s = 0; s < 4; s++) { 
				
				// for each number
				
				for (int n = 1; n <= 13; n++) {
					
					// add a new card to the deck
					
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
					
				}
			}
		}
		if (shuffle) {
			
		this.shuffle();
	}
	

}

	// shuffle car by randomly swapping cards from deck
	//random number generator
    public void shuffle() {
	
	Random rng = new Random();
	
	Card temp;
	
	int j;
	for ( int i = 0; i < this.numCards; i++ ) {
		
		// get a random card j to swap i's value with
		
		j = rng.nextInt(this.numCards);
		
		// do the swap
		
		temp = this.myCards[i];
		this.myCards[i] = this.myCards[j];
		this.myCards[j] = temp;
		
		
	}
}

    public Card dealNextCard() {
    	
    	// get the top card
    	
    	Card top = this.myCards[0];
    	
    	// shift all the subsequent cards in the deck to the left by one index
    	
    	for (int c = 1; c < this.numCards; c++) {
    		this.myCards[c-1] = this.myCards[c];
    		
    		this.myCards[this.numCards-1] = null;
    		 // decrement the number of cards in our deck
    		
    		this.numCards--;
    	}
    	
    	 return top;
    	
    }
    // print the top cards in the deck
    
    public void printDeck(int numToPrint) {
    	
    	for (int c = 0; c < numToPrint; c++) {
    		System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
    	}
    	System.out.printf("\t\t[%d other\n", this.numCards-numToPrint);
    }
}
	