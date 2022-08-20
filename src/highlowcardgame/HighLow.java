package highlowcardgame;

/**
 * @author Jacob Kotowski
 */

import java.util.Scanner;
import java.util.Random;

public class HighLow extends Game 
{
    GamePlayer player;
    Dealer dealer;
    GroupOfCards deck = new GroupOfCards(52);
    Scanner sc = new Scanner(System.in);
    Random rnd = new Random();
    
    public HighLow()
    {
        super("HighLow");
    }
    
    public void startGame()
    {
        System.out.println("Please enter your name:");
        player = new GamePlayer(sc.nextLine());
        dealer = new Dealer();
        
        boolean isValid = false;
        while(!isValid)
        {
            System.out.println("Please enter the amount of chips you would like to start with.(1 chip is equal to 1 dollar): ");
            String input = sc.next();
            
            if(input.matches("[0-9]+"))
            {
                isValid = true;
                int chips = Integer.parseInt(input);
                player.setChips(chips);
                
                if(chips < 1)
                {
                    System.out.println("Please enter a positive amount of chips.");
                }
                else
                {
                    isValid = true;
                    player.setChips(chips);
                }
            }
            else
            {
                System.out.println("Please enter an integer or whole number.");
            }
        }
    }
    
    public void makeDeck()
    {
        deck.getCards().clear();
        {
            for(Suit suit : Suit.values())
            {
                for(Value value : Value.values())
                {
                    deck.getCards().add(new GameCard(suit, value));
                }
            }
        }
        deck.shuffle();
    }
    
    public void decisionBet()
    {
        boolean isValid = false;
        while(!isValid)
        {
            System.out.println("Place your bet for this decision:");
            String input = sc.next();
            
            if(input.matches("[0-9]+"))
            {
                int bet = Integer.parseInt(input);
                
                if(bet < 1)
                {
                    System.out.println("Please enter a positive amount of chips.");
                }
                else if(bet > player.getChips())
                {
                    System.out.println("You do not have enough chips to bet this amount.");
                }
                else
                {
                    isValid = true;
                    player.getHand().setBet(bet);
                }
            }
            
            else
            {
                System.out.println("Please enter an integer or whole number.");
            }
        }
        System.out.println("--------------------");
    }
    
    public void draw()
    {
        
    }
    
    public boolean again()
    {
        boolean tryAgain = true;
        
        if(player.getChips() > 0)
        {
            char again;
            
            do
            {
                System.out.println("Would you like to try again?(Y/N):");
                again = sc.next().toUpperCase().charAt(0);
                
                if(again == 'Y')
                {
                    tryAgain = true;
                }
                else
                {
                    tryAgain = false;
                    System.out.println("You have finshed the game with " + player.getChips() + " chip(s)");
                }
            }
            while(again != 'Y' && again != 'N');
        }
        else
        {
            System.out.println("You ran out of chips, better luck next time.");
            tryAgain = false;
        }
        return tryAgain;
    }
    
    @Override
    public void Play()
    {
        boolean tryAgain = true;
        boolean playerStandBy;
        
        startGame();
        
        while(tryAgain)
        {
            playerStandBy = false;
            makeDeck();
            decisionBet();
            
            draw();
            
            while(!playerStandBy)
            {
                dealer.revealNextCard();
                
                player.play(deck);
                
                System.out.println("--------------------");
                
                dealer.play(deck);
                
                playerStandBy = player.StandBy();
            }
            System.out.println("Used cards:");
            player.displayUsedCards();
            
            tryAgain = again();
        }
        System.out.println("Thanks for playing.");
    }
    
    public static void main(String[] args)
    {
        HighLow game = new HighLow();
        game.play();
    }
}