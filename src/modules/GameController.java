package modules;

import java.util.ArrayList;

public class GameController
{
    Map map;
    private ArrayList<Player> players = new ArrayList<Player>();
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

    public void setMap(Map m)
    {
        Logger.LogFunctionCall(this.toString() + " setMap was called with param: " + m.toString());
        map = m;
        Logger.LogFunctionReturn("return");
    }

    public void addPlayer(Player newPlayer)
    {
        Logger.LogFunctionCall(this.toString() + " addPlayer was called with param: " + newPlayer.toString());
        players.add(newPlayer);
        Logger.LogFunctionReturn("return");
    }

    private void startGame()
    {
        Logger.LogFunctionCall(this.toString() + " startGame was called");
        turn();
        Logger.LogFunctionReturn("return");
    }

    public void turn()
    {
        Logger.LogFunctionCall(this.toString() + " turn was called");
        boolean b = true;
        for (Player p : players){
            if (p.getEnergy() != 0){
                b = false;
            }
        }
        if (!b) {
            Logger.LogFunctionReturn("return");
            return;
        }

        map.generateStorm();
        Logger.LogFunctionReturn("return");
    }

    public void win()
    {
        Logger.LogFunctionCall(this.toString() + " win was called");
        Logger.LogFunctionReturn("return");
    }

    public void lose()
    {
        Logger.LogFunctionCall(this.toString() + " lose was called");
        Logger.LogFunctionReturn("return");
    }

    public void checkWinningConditions()
    {
        Logger.LogFunctionCall(this.toString() + " checkWinningConditions was called");
        Logger.LogFunctionReturn("return");
    }
}
