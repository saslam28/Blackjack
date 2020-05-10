import java.util.Scanner;


public class GameRunner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		//initialise player objects
		
		
		Player me = new Player("Suleman");
		Player dealer = new Player("Dealer");
		
		// Dealt two cards to dealer and me
		
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		
		System.out.println("cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		// flags for when me and dealer are finished hitting
		
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while (!meDone || !dealerDone) {
			
			if (!meDone) {
				
				System.out.print("Hit or Stay? (Enter H or S):  ");
				ans = sc.next();
				System.out.println();
				
				//If player hits
				
				if (ans.compareToIgnoreCase("H") == 0) {
					
					// add next card in deck and store whether player is busted
					
					meDone = !me.addCard(theDeck.dealNextCard());
					me.printHand(true);
					
					} else {
						meDone = true;
						
					}
				 
				
			}
			
			// dealer's turn
			
			if (!dealerDone) {
				if (dealer.getHandSum() < 17) {
					System.out.println(" The dealer hit\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					dealer.printHand(false);
				
				} else {
					System.out.println("The dealer stays\n");
					dealerDone = true;
					
				}
			}
			System.out.println();
		}
		
		
		// close scanner
		sc.close();
		
		// print final hands
		me.printHand(true);;
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if (mySum >dealerSum && mySum <=21 || dealerSum > 21) {
			System.out.println("You Win!!!");
			
			
		} else {
			System.out.println("Dealer Wins!!!");
		}
		
		

	}

}
