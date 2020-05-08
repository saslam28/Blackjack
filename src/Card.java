/**
 * An implementation of a card type
 * @author suleman.aslam
 *
 */
public class Card {

	private Suit mySuit;
	private int myNumber;
	
	
	public Card(Suit aSuit, int aNumber) {
		
		this.mySuit = aSuit;
	    this.myNumber = aNumber;
	    
	    
	}
	
	public int getNumber() {
		return myNumber;
	}
	 public String toString() {
		 
		 String numStr;
		 
		 switch(this.myNumber) {
		 
		 case 2:
			 numStr = "Two";
			 break;
			 
		 case 3:
			 numStr ="Three";
			 break;
			 
		 case 4:
			 numStr = "Four";
			 break;
			 
		 case 5:
			 numStr = "Five";
			 break;
			 
		 case 6:
			 numStr = "Six";
			 break;
			 
		 case 7:
			 numStr = "Seven";
			 break;
			 
		 case 8:
			 numStr = "Seven";
			 break;
			 
		 case 9:
			 numStr = "Eight";
			 break;
			 
		 case 10:
			 numStr = "Ten";
			 break;
			 
		 case 11:
			 numStr = "Jack";
			 break;
			 
		 case 12:
			 numStr = "Queen";
			 break;
			 
		 case 13:
			 numStr = "King";
			 break;
			 
		 case 14:
			 numStr = "Ace";
			 break;
			 
			 
		 
		 }
	 }	
	 
}
