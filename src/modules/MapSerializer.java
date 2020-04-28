package modules;

import java.util.ArrayList;

public class MapSerializer {
    private GameController gameController = GameController.getInstance();
    private Map map;

    public void printMap(){
        map = gameController.getMap();
        printTiles();
        printPlayers();
        printItems();
        printBear();
        System.out.println();
    }

    private void printTiles(){
        ArrayList<Tile> tiles = map.getAllTiles();
        if(tiles.isEmpty())
            return;

        int rowCount = 0;

        System.out.println("Tiles:");
        for (Tile tile : tiles ) {
            if(rowCount != tile.getPositionY()) {
                System.out.println();
                rowCount++;
            }

            System.out.print(tile.getPlayerCapacity() + ",");
            System.out.print(tile.getSnowLayerCount() + ",");
            if(tile instanceof RegularTile){
                String iglooBuilt = Boolean.toString(((RegularTile) tile).isIglooBuilt());
                String campBuilt = Boolean.toString(((RegularTile) tile).isCampBuilt());
                System.out.print(iglooBuilt + ",");
                System.out.print(campBuilt + ",");
            } else
                System.out.print("false,false,");

            System.out.printf("%d;",tile.getUniqueID());
        }
    }

    private void printPlayers(){
       ArrayList<Player> players = gameController.getAllPlayers();
       if(players.isEmpty())
           return;

       System.out.print("\nPlayers:\n");
       for(Player player : players){
           if(player instanceof Eskimo)
               System.out.print("0,");
           else
               System.out.print("1,");

           int position = player.getPosition().getUniqueID();
           int energy = player.getEnergy();
           int lives = player.getLives();
           boolean drowning = player.isDrowning();
           int UID = player.getUniqueID();
           System.out.printf("%d,%d,%d,%s,%d;", position, energy, lives, drowning, UID);
       }
    }

    private void printItems(){
        ArrayList<Item> items = map.getItems();
        if(items.isEmpty())
            return;

        System.out.print("\nItems:\n");
        for (Item item : items ) {
            int position;
            if(item.getPlayer() != null){
                position = item.getPlayer().getUniqueID();
            }else{
                position = item.getTile().getUniqueID();
            }
            System.out.printf("%d,%s;", position, item.getClass().getSimpleName());
        }
    }

    private void printBear(){
        Bear bear = gameController.getBear();
        if(bear == null)
            return;

        System.out.printf("\nBear:\n%d;", bear.getPosition().getUniqueID());
    }
}
