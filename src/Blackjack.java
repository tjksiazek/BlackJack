
//Tucker Ksiazek
//Grayson Brenna
//Final Project
//Blackjack game


import java.util.*;
public class Blackjack {
	
	
		private static int cash;   //players starting money

		private static int bet;   //players bet amount

		private static int handtotal;  //players hand total
		
		private static int Aces;  //number of aces in hand


public static void main(String[] args){
    
    System.out.println("Yo pals,lets play some BlackJack aka 21!");
    
    System.out.println("How much cash do you want to start the game with?");
    
    Scanner money = new Scanner(System.in);  //scans for how much money the player wants to have
    
    cash = money.nextInt();
    
    System.out.println("You will start with cash: "+cash);
   
    while(cash>0){     // cash set to zero
        Deck deck = new Deck();   //takes deck of cards in 
        deck.shuffle();   //uses shuffle on deck
        Aces=0;
        Dealer dealer = new Dealer(deck);    //sets the dealer hand
        List<Card> hand = new ArrayList<>();
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
       
        System.out.println("How much would you like to gamble?");
        bet=Bet(cash);     // gets the bet amount
        
        System.out.println("Cash:"+(cash-bet));
       
        System.out.println("Money on the table:"+bet);
       
        System.out.println("Here is your hand: ");
       
        System.out.println(hand);
       
        int handtotal = calcHandTotal(hand);  //finds total of the hand
        
        System.out.println("The dealers face up card is: ");
        dealer.showFirstCard();
        if(hasBlackJack(handtotal) && dealer.hasBlackJack())  // looks if both got blackjack
        {
            Push();
        }
        else if(hasBlackJack(handtotal))   // player blackjack?
        {
            System.out.println("You got 21! BLACKJACK!!");
           
        }
        else if(dealer.hasBlackJack())    //dealer blackjack?
        {
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            Lose();
        }
        else
        {
           
               
            System.out.println("Would you like to hit or stay?");  //ask if the player wants to hit or stay
            
            Scanner hitorstay = new Scanner(System.in);
            String hitter = hitorstay.nextLine();
            while(!isHitorStay(hitter))
            {
               
            	System.out.println("Please enter 'hit' or 'stay'.");
                
            			hitter = hitorstay.nextLine();
           
            }
            while(hitter.equals("hit"))     //gives the player as many cards as they hit for.
            {
                Hit(deck, hand);
                
                System.out.println("Your hand is now:");
                System.out.println(hand);
                
                
                handtotal = calcHandTotal(hand);
                if(checkBust(handtotal))     //checks for a bust in players hand
                
                {
                    Lose();
                    break;
                }
                
                
                System.out.println("Would you like to hit or stay?");
                hitter = hitorstay.nextLine();
          
            }
            
            if(hitter.equals("stay"))   //looking if player stands
            
            {
               
            	int dealerhand = dealer.takeTurn(deck);  //takes the turn for the dealer
                
                
                System.out.println("");
               
                
                System.out.println("Here is the dealer's hand:");
                
                
                dealer.showHand();
                if(dealerhand>21)   //if the dealer busted, player wins.
                {
                    Win();
                }
                else
                {
                    int you = 21-handtotal;   //check who is closer to 21 and determine winner
                    int deal = 21-dealerhand;
                    if(you==deal)
                    {
                        Push();    //if scores are same
                    }
                    if(you<deal)   //if you win
                    {
                        Win();
                    }
                    if(deal<you)     //if you lose
                    {
                        Lose();
                    }
                }
            }
        }
    System.out.println("Would you like to play again?");  //ask if the player wants to play again
    Scanner yesorno = new Scanner(System.in);
    String answer = yesorno.nextLine();
   
    while(!isyesorno(answer))
            {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();   //input for new game or not
            }
    if(answer.equals("no"))
    {
        break;
    }
}
    System.out.println("Your cash is: "+cash);   //if player doesn't want to play or runs out of cash, either tell them good job
    //or let them know they are broke
    if(cash==0)
    {
        System.out.println("You ran out of bread bro!");
    }
    else
    {
        System.out.println("Enjoy your money!");
    }
    }


public static int Bet(int cash)   //betting code
{
    Scanner sc=new Scanner(System.in);
    int bet=sc.nextInt();
    while(bet>cash)    // checks to make sure they have enough cash
    	
    {
        System.out.println("You cannot bet more cash than you have, duh!");
        System.out.println("How much would you like to bet for real?");
        bet=sc.nextInt();
        
    }
    return bet;
}



public static void Hit(Deck deck, List<Card> hand)    //deck array of cards drawn
{
    hand.add(deck.drawCard());   //keeps adding cards when they hit 
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    handtotal = 0;
    for(int i=0; i<aHand.length; i++)
    	
    {
        handtotal += aHand[i].getValue();  //adds up the value of cards 
        if(aHand[i].getValue()==11)  
        {
            Aces++;
        }
        while(Aces>0 && handtotal>21)   //pays attention to the aces 
        {
            handtotal-=10;
            Aces--;
        }
    }
}


public static boolean hasBlackJack(int handValue)  //code to check blackjacks
{
    if(handtotal==21)
    {
        return true;
    }
    return false;
}

 

public static int calcHandTotal(List<Card> hand)   // calculates the total of players cards
{
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    int handtotal=0;
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
    return handtotal;
}


public static void Push()    // called on if its a tie
{
    System.out.println("It's a tie boy!");
    System.out.println("You get your money back.");
    System.out.println("Cash: "+cash);
}



public static void Win()      //If player wins then it will print this
{
    System.out.println("Congratulations, you win!");
    cash=cash+bet;     // showing how much cash they now have 
    System.out.println("Cash: "+cash);
}



public static void Lose()    //called on for a loss
{
    System.out.println("Sorry, you lose hahahahahah!");
    cash=cash-bet;           //subtracts the players bet from cash amount
    System.out.println("Cash: "+cash);
}


 
public static boolean isHitorStay(String hitter)  //checks for a hit or stay
{
    if(hitter.equals("hit") || hitter.equals("stay"))
    {
        return true;
    }
    return false;
}

 

public static boolean checkBust(int handtotal) // checks to see for a bust
{
    if(handtotal>21)
    {
        System.out.println("You have busted!");
        return true;
    }
    return false;
}


 
public static boolean isyesorno(String answer)  //checks for new game or not
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}

}
