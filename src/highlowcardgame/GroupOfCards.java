package highlowcardgame;

/**
 * @author Jacob Kotowski
 */

import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards 
{
    private ArrayList<GameCard> cards = new ArrayList<>();
    private int size;
    
    public GroupOfCards(int size)
    {
        this.size = size;
    }
    
    public ArrayList<GameCard> getCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void setSize(int size)
    {
        this.size = size;
    }
}