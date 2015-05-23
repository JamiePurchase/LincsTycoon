package game;

public class Game
{
    private Player[] players;
    private int stockpile;
    private int turns;
    
    public Game(int[] players)
    {
        // NOTE: player objects should be created in the lobby, when pieces are chosen?
        this.players = new Player[players.length];
    }
}