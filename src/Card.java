
//Tucker Ksiazek
//Grayson Brenna


public class Card {

	
	

	//making the cards
	
	
		private int suit;   //suits of cards
	 	
		private int rank;  //ranks of cards 

	 	private int value;   //values of the cards

	 	private static String[] ranks = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};

	 	private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

   
	 	// two string of ranks and suits of the single cards
	 	// each card is an integer in the string
	 	
	 	

Card(int suit, int values)
{
    this.rank=values;
    this.suit=suit;
}




public String toString()      // gives the string of a card
{
    return ranks[rank]+" of "+suits[suit];
}


 

public int getRank()
{
    return rank;    // card rank 
}


 

public int getSuit()
{
    return suit;  //gives you card suit
}


 

public int getValue()    // finding the value of card

						// face cards are 10 and ace defaults to 11
{
    if(rank>10)
    {
        value=10;
    }
    else if(rank==1)
    {
        value=11;
    }
    else
    {
        value=rank;
    }
    return value;
}

 
 

public void setValue(int set)   //sets the value for the card
{
    value = set;
}
}
