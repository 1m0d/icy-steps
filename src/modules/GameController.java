package modules;

public class GameController
{
    Map map;
    private Player[] players;
    public Player getPlayer(int Id){
        for (Player player : players)
            if (player.getId() == Id)
                return player;
        return null;
    }

    public GameController()
    {

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

    private void turn()
    {
        System.out.println( this.toString() + " turn was called");
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
