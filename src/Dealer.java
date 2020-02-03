
//Tucker Ksiazek
//Grayson Brenna


import java.util.ArrayList;
import java.util.Arrays;


//Creates a dealer basically the computer the player goes against
 
public class Dealer {
	
ArrayList<Card> hand;  //dealers cards

		private int handtotal=0;  //total of dealers hand

		private Card[] aHand;  //converts dealers hand to arrary

		private int Aces;  // counts the dealers aces

		
Dealer(Deck deck)
{
	
	// array of the first hand  and drawn cards
    hand = new ArrayList<>();
    aHand = new Card[]{};
    int AceCounter=0;
    for(int i=0; i<2; i++)
    {
        hand.add(deck.drawCard());
    }
    
    
    aHand = hand.toArray(aHand);
    for(int i=0; i<aHand.length; i++)
    {
    	
    	// calculating total and counting aces
        handtotal += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handtotal>21)
        {
            handtotal-=10;
            AceCounter--;
        }
    }
}

  


public void showFirstCard()   //tells you the dealers first card that would be face up on table
{
    Card[] firstCard = new Card[]{};
    firstCard = hand.toArray(firstCard);
    System.out.println("["+firstCard[0]+"]");
}

 

public void Hit(Deck deck)      // hits dealer, calculates his value after it taking account of potential ace
{
    hand.add(deck.drawCard());
    aHand = hand.toArray(aHand);
    handtotal = 0;
    for(int i=0; i<aHand.length; i++)
    {
    	
        handtotal += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        	
        {
            Aces++;
            
        }
        while(Aces>0 && handtotal>21)
        	
        	
        {
            handtotal-=10;
            Aces--;
        }
    }
}



 
public boolean wantsToHit()
{
    if(handtotal<17)  // uses blackjack rule to hit dealer or not
    {
        return true;
    }
    return false;
}



 
public boolean hasBlackJack()     //checks for dealer blackjack
{
    if(hand.size()==2 && handtotal==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}


 
public void showHand()  // shows what cards dealer has
{
    System.out.println(hand);
}



public int getHandTotal()   // dealers hand total
{
    return handtotal;
}


 
public boolean busted(int handtotal)   // checks for a t or f bust of dealer
{
    if(handtotal>21)
    {
        System.out.println("The dealer busted!");
        return true;
    }
    return false;
}



 
public int takeTurn(Deck deck)   // dealers turn is simulated
								// tells his card hand value
				
{
    while(wantsToHit())
    {
        System.out.println("The dealer hits");
        Hit(deck);
        if(busted(handtotal))
        {
            break;
        }
    }
    if(handtotal<=21)
    {
        System.out.print("The dealer stands.");
    }
    return handtotal;
}
}