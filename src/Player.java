/**
 * An implementation of a blackjack player
 * @author suleman.aslam
 *
 */
public class Player {
	
	private String name;
	
	//the cards in the player's current hand
	
	private Card[] hand = new Card[10];
	
	// The number of cards in the player's current hand
	
	private int numCards;

	// constructor is used for the name of the player
	
	public Player(String aName) {
		
		this.name = aName;
		
		// set a player's hand to empty
		
		this.emptyHand();
	}
	public void emptyHand() {
		
		for (int c = 0; c < 10; c++) {
			
			this.hand[c] = null;
		}
		this.numCards = 0;
	}

   // Add a card to the player's hand
	// The return value is a boolean describing whether the sum of the new hand is below or equal to 21
	
	
	public boolean addCard(Card aCard) {
		
		if (this.numCards ==10) {
			System.err.printf("%s's hand already has 10", this.name );
			System.exit(1);
			
		}
		// Add new card in next slot and increment number of cards
		
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
		
	}
	
	// a method used to get the Sum of cards in player's hand
	public int getHandSum() {
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		for (int c = 0; c < this.numCards; c++) {
			
			cardNum = this.hand[c].getNumber();
			
			if (cardNum == 1) {
				// Ace
			
					
			numAces++;
			handSum += 11;
			
		} else if (cardNum > 10) {
			
			handSum += 10;
		}
		else { 
			handSum += cardNum;
		}
		}
		
		while (handSum > 21 && numAces > 0) {
			handSum -=10;
			numAces--;
		}
			
			return handSum;
			
		
		
		
			
		
	}
	
	public void printHand( boolean showFirstCard) {
		
		System.out.printf("%s's cards:\n", this,name);
		for (int c =0; c < this.numCards; c++) {
			
			if (c==0 && !showFirstCard) {
				System.out.println("[hidden]");
				
			}else {
				System.out.printf("%s\n", this.hand[c].toString());
				
			}
			
		}
	}
}
