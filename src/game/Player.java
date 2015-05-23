package game;

import java.util.ArrayList;

public class Player
{
    private int playerID;
    private String piece;
    private int location;
    private int money;
    private ArrayList<Property> properties;
    private int[] diceLast = new int[2];
    
    public Player(int id, String piece)
    {
        this.playerID = id;
        this.piece = piece;
        this.location = 0;
        this.money = 0;
        this.diceLast[0] = 0;
        this.diceLast[1] = 0;
    }
}