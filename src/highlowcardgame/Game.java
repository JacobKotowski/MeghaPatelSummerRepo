package highlowcardgame;

/**
 * @author Jacob Kotowski
 */

import java.util.ArrayList;

public abstract class Game 
{
    private final String name;
    private ArrayList<Player> players;
    
    public Game(String name)
    {
        this.name = name;
        players = new ArrayList<>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public ArrayList<Player> getPlayer()
    {
        return players;
    }
    
    public void setPlayers(ArrayList<Player> players)
    {
        this.players = players;
    }
    
    public abstract void Play();
}