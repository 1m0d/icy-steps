package modules;

import java.util.ArrayList;

public class GameController     //gamecontroller class
{
    Map map;        //contains the map
    private ArrayList<Player> players = new ArrayList<Player>();        //array of players
    public Player getPlayer(int Id){        
        Logger.LogFunctionCall(this.toString() + " clearSnow was called");
        for (Player player : players){
            if (player.getId() == Id) {
                Logger.LogFunctionReturn("return with " + player.toString());
                return player;
            }
        }
        Logger.LogFunctionReturn("return with NULL");
        return null;
    }

    public GameController()
    {

    }

    public void setMap(Map m)       //sets up the man
    {
        Logger.LogFunctionCall(this.toString() + " setMap was called with param: " + m.toString());
        map = m;
        Logger.LogFunctionReturn("return");
    }

    public void addPlayer(Player newPlayer)     //adding player
    {
        Logger.LogFunctionCall(this.toString() + " addPlayer was called with param: " + newPlayer.toString());
        players.add(newPlayer);
        Logger.LogFunctionReturn("return");
    }

    private void startGame()        //starting the game
    {
        Logger.LogFunctionCall(this.toString() + " startGame was called");
        while(true)     //doing turns until gameover
        {
                turn();
		}

        Logger.LogFunctionReturn("return");
    }

    public void turn()      //turn in the game
    {
        Logger.LogFunctionCall(this.toString() + " turn was called");
        boolean b = true;
        for (Player p : players){
            if (p.getEnergy() != 0){
                b = false;
            }
            p.setEnergy(4);     //every players energy is resetted
        }
        if (!b) {
            Logger.LogFunctionReturn("return");
            return;
        }

        map.generateStorm();        //the map generates storm on random tiles
        Logger.LogFunctionReturn("return");
    }

    public void win()           //it is called if winning conditions are met
    {
        Logger.LogFunctionCall(this.toString() + " win was called");
        Logger.LogFunctionReturn("return");
    }

    public void lose()      //it is called if losing conditions are met
    {
        Logger.LogFunctionCall(this.toString() + " lose was called");
        Logger.LogFunctionReturn("return");
    }

    public void checkWinningConditions()        //checks if players can win
    {
        Logger.LogFunctionCall(this.toString() + " checkWinningConditions was called");
        Logger.LogFunctionReturn("return");
    }
}
