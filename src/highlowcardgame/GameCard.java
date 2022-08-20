package highlowcardgame;

/**
 * @author Jacob Kotowski
 */

public class GameCard extends Card
{
    private Value value;
    private Suit suit;
    
    public GameCard(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }
    
    public Value getValue()
    {
        return value;
    }
    
    public void setValue(Value value)
    {
        this.value = value;
    }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }
    
    @Override
    public String toString()
    {
        return "[" + value + " of " + suit + "[";
    }
}