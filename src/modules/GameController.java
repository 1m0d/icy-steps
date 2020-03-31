package modules;

import java.util.ArrayList;

public class GameController
{
    Map map;
    private ArrayList<Player> players = new ArrayList<Player>();
    public Player getPlayer(int Id){
        for (Player player : players)
            if (player.getId() == Id)
                return player;
        return null;
    }

    public GameController()
    {

    }

    public void setMap(Map m)
    {
        map = m;
    }

    public void addPlayer(Player newPlayer)
    {
        System.out.println( this.toString() + " addPlayer was called with param: " + newPlayer);
    }

    private void startGame()
    {
        System.out.println( this.toString() + " startGame was called");
        turn();
    }

    public void turn()
    {
        return;/*
        System.out.println( this.toString() + " turn was called");
        boolean b = true;
        for (Player p : players){

            System.out.println(p.getEnergy());
            if (p.getEnergy() != 0){
                b = false;
                System.out.println("most");
            }
        }
        if (!b) return;

        map.generateStorm();*/
    }

    public void win()
    {
        System.out.println( this.toString() + " win was called");
    }

    public void lose()
    {
        System.out.println( this.toString() + " lose was called");
    }

    public void checkWinningConditions()
    {
        System.out.println( this.toString() + " checkWinningConditions was called");
    }
}
