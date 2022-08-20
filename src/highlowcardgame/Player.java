package highlowcardgame;

/**
 * @author Jacob Kotowski
 */

import java.util.Random;

public abstract class Player 
{
    Random rdn = new Random();
    private String name;
    
    public Player(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public abstract void Play(GroupOfCards deck);
}