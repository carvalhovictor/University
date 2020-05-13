
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victorcarvalho
 */
public class ConnectPlayer extends Player implements Serializable {
    
    private int score;
    private int numberGames;
    
    /**
            The constructor creates a default Connect 4 Player object.
    */    
    public ConnectPlayer()
    {
        numberGames = 0;
        score = 0;
    }
    /**
            The constructor creates a Player object with the specified name and score.
            @param n represents the name of the Player.
            @param s represents the score of the Player.
    */    
    public ConnectPlayer(String n, int s)
    {
        super(n);
        score = s;
    }
    /**
            Method to retrieve the score of the player.
            @return a String representing the name of the Player.
    */
    public int getScore()
    { // return the score
            return score;
    }

    /**
            Method to set the Players score.
            @param s represents the name of the Player.
    */
    public void setScore(int s)
    { // set the Players score
            score = s;
    }
    
    /**
            Method to retrieve the number of games played.
            @return a String representing the name of the Player.
    */
    public int getNumberOfGames()
    { // return the number of games
            return numberGames;
    }

    /**
            Method to set the number of games played.
            @param n represents the number of games played.
    */
    public void setNumberGames(int n)
    { // set the number of games played
            numberGames = n;
    }
    
}
