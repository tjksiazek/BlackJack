

//Tucker Ksiazek
//Grayson Brenna


import java.util.ArrayList;
import java.util.Random;


//Creates and shuffles a deck of 52 playing cards.
 


public class Deck {
	
	
		private ArrayList<Card> deck;  //represents a deck of cards
//from card class

Deck()
{
    deck = new ArrayList<Card>();
    for(int i=0; i<4; i++)
    {
        for(int j=1; j<=13; j++)
        {
            deck.add(new Card(i,j));
        }
    }
}

 
 

public void shuffle()   // shuffling the deck in pairs 
{
    Random random = new Random();
    Card temp;
    for(int i=0; i<200; i++)  //loops through 200 pairs of cards for randomizing
    {
        int index1 = random.nextInt(deck.size()-1);
        int index2 = random.nextInt(deck.size()-1);
        temp = deck.get(index2);
        
        deck.set(index2, deck.get(index1));
        deck.set(index1, temp);
    }
}

 

public Card drawCard()   //draws card from deck
{
    return deck.remove(0);  //removes it from the available cards 
}	
}