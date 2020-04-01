package main;

import modules.*;
import java.util.Scanner;


public class Main {

    static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {

        String[] TestCaseStrings = {"Player steps onto regular tile","Player steps onto hole tile",
                "Player uses Eskimo ability","Player uses Scientist ability",
                "Player passes", "Player picks up item",
                "Player clears snow ", "Player uses diving suit",
                "Player uses food", "Player uses winning item",
                "Player uses rope", "Player uses shovel",
                "Game Controller generates storm"};


        for (int i = 0; i < TestCaseStrings.length; i++)
        {
            System.out.println(i + ":\t" + TestCaseStrings[i]);
        }
        System.out.println("Choose a testcase!");
        Scanner in = new Scanner(System.in);        //user input

        int input = -1;

        Logger.EnablePrint();

        while (true) {
            try {
                String str = in.next();
                if (tryParseInt(str)) {
                    input = Integer.parseInt(str);
                }
                else {
                    input = -1;
                }
            } catch (Exception ex){
                input = -1;
            }
            System.out.println("Integer read: " + input);

            Logger.DisablePrint();
            GameController gc = new GameController();   //adding a gamecontroller
            Map m = new Map(gc);                        //initializing map
            RegularTile rt1 = new RegularTile(m, 0);    //tiles for testing
            RegularTile rt2 = new RegularTile(m, 1);
            HoleTile ht = new HoleTile(m, 2);
            Eskimo e = new Eskimo(0, rt1);              //new eskimo player
            Scientist s = new Scientist(1, ht);         //new scientist player
            m.addTile(0, rt1);                          //putting the tiles to the map
            m.addTile(1, rt2);
            m.addTile(2, ht);
            gc.addPlayer(e);                            //adding eskimo to gamecontroller
            gc.addPlayer(s);                            //adding scientist to gamecontroller
            gc.setMap(m);                               //setting up the map
            Logger.EnablePrint();

            switch(input)
            {
                case 0:     //player steps onto regular tile
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Logger.DisablePrint();
                    e.step(rt1);
                    Logger.EnablePrint();
                    e.step(rt2);
                    break;
                }
                case 1:     //player steps onto hole tile
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Logger.DisablePrint();
                    e.step(rt1);
                    Logger.EnablePrint();
                    e.step(ht);
                    break;
                }
                case 2:     //player uses eskimo ability
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.useAbility(rt1);                              //he useAbility method is called on an eskimo player
                    break;
                }
                case 3:     //player uses scientist ability
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    s.useAbility(rt1);                              //the useAbility method is called on a scientist player
                    break;
                }
                case 4:     //player passes
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.pass();                                  //player passes
                    break;
                }
                case 5:     //player picks up item
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.pickUpItem();                             // e player picks up the item 
                    break;
                }
                case 6:     //player clears snow
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.clearSnow();                              //player uses the clearsnow method
                    break;
                }
                case 7:     //player uses diving suit
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    DivingSuit d = new DivingSuit();            //adding a diving suit
                    rt1.setItem(d);                             //putting it into the tile
                    e.pickUpItem();                             //player picks it up
                    e.useItem(d);                               //player uses the diving suit
                    break;
                }
                case 8:     //player uses food
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Food f = new Food();                        //adding a food item
                    rt1.setItem(f);                             //putting it into the tile
                    e.pickUpItem();                             //player picks it up
                    e.useItem(f);                               //player uses the food
                    break;
                }
                case 9:     //player uses winning item
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    WinningItem w = new WinningItem();          //adding a winning item
                    rt1.setItem(w);                             //putting it into the tile
                    e.pickUpItem();                             //player picks it up
                    e.useItem(w);                               //player uses the item

                    break;
                }
                case 10:        //player uses rope
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Rope r = new Rope();            //adding a rope item 
                    rt1.setItem(r);                 //putting it to the tile
                    e.pickUpItem();                 //player picks up the rope
                    e.useItem(r);                   //player uses the rope
                    break;
                }
                case 11:        //player uses shovel
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Shovel sh = new Shovel();       //adding a shovel item
                    rt1.setItem(sh);                //putting it to the tile
                    e.pickUpItem();                 //player picks up the shovel
                    e.useItem(sh);                  //player uses the shovel
                    break;  
                }   
                case 12:        //game controller generates storm
                {       
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Logger.DisablePrint();
                    e.step(rt2);
                    gc.turn();      //new turn of the game
                    e.pass();       //players passes
                    s.pass();       //after every player plays its turn generatestorm is called in gamecontroller
                    break;
                }
                default:{       //if wrong input is given
                    System.out.println("Wrong input!");
                    break;
                }

            }

        }
    }
}