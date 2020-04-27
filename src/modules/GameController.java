package modules;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    private Map map;
    private ArrayList<Player> players;
    private static GameController gameController;
    public static GameController getInstance() {
        if (gameController == null)
            gameController = new GameController();
        return gameController;
    }

    public void loadMap(String path) {
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while(myReader.hasNextLine())
            {
                String line = myReader.nextLine();
                if (line == "Tiles:\n") {
                    while (line != "Players:\n") {
                        parseTile(myReader.nextLine());
                    }
                }
                else if (line == "Players:\n") {
                    while (line != "Players:\n") {
                        parsePlayer(myReader.nextLine());
                    }
                }
                else if (line == "Items:\n") {
                    while (myReader.hasNextLine()) {
                        parseItem(myReader.nextLine());
                    }
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void parsePlayer(String s) {
        String delims = "[,]";
        String[] tokens = s.split(delims);
        if(Integer.parseInt(tokens[0]) == 0)
        {
            addPlayer(new Eskimo(map.getTile(Integer.parseInt(tokens[0])), tokens[2], tokens[3], tokens[4], tokens[5]));
        }
        else if (Integer.parseInt(tokens[0]) == 1)
        {
            addPlayer(new Scientist(map.getTile(Integer.parseInt(tokens[0])), tokens[2], tokens[3], tokens[4], tokens[5]));
        }
    }

    private void parseItem(String s) {
        String delims = "[,]";
        String[] tokens = s.split(delims);
        if (tokens[1] == "camp") {
            map.addItem(new Camp(), Integer.parseInt(tokens[0]));
        }
        else if (tokens[1] == "divingsuit") {
            map.addItem(new DivingSuit(), Integer.parseInt(tokens[0]));
        }
        else if(tokens[1]  == "food") {
            map.addItem(new Food(), Integer.parseInt(tokens[0]));
        }
        else if (tokens[1] == "rope") {
            map.addItem(new Rope(), Integer.parseInt(tokens[0]));
        }
        else if (tokens[1] == "shovel") {
            map.addItem(new Shovel(), Integer.parseInt(tokens[0]));
        }
        else if (tokens[1] == "winningitem") {
            map.addItem(new WinningItem(), Integer.parseInt(tokens[0]));
        }
        else {
            System.out.println(tokens[1] + "type could not been found");
        }

    }

    private void parseTile(String s) {
        String delims = "[,]";
        String[] tokens = s.split(delims);
        if (Integer.parseInt(tokens[0]) == 0)
        {
            map.addTile(new HoleTile(tokens[0],tokens[1],tokens[2],tokens[3], tokens[4]));
        }
        else
        {
            map.addTile(new RegularTile(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]));
        }
    }

    public void addPlayer(Player newPlayer)
    {
        players.add(newPlayer);
    }

    private void startGame() {
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

    public void checkWinningConditions() {
        System.out.println( this.toString() + " checkWinningConditions was called");
    }

    public Player getPlayer(int Id) {
        for (Player player : players)
            if (player.getUniqueID() == Id)
                return player;
        return null;
    }

    public Map getMap() {
        return map;
    }

}