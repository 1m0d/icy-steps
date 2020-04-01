package main;

import modules.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        String[] TestCaseStrings = {"Player steps onto regular tile","Player steps onto hole tile",
                "Player uses Eskimo ability","Player uses Scientist ability",
                "Player passes", "Player picks up item",
                "Player clears snow ", "Player uses diving suit",
                "Player uses food", "Player uses winning item",
                "Player uses rope", "Player uses shovel",
                "Game Controller generates storm"};

        GameController gc = new GameController();
        Map m = new Map(gc);
        RegularTile rt1 = new RegularTile(m, 0);
        RegularTile rt2 = new RegularTile(m, 1);
        HoleTile ht = new HoleTile(m, 2);
        Eskimo e = new Eskimo(0, rt1);
        Scientist s = new Scientist(1, ht);
        m.addTile(0, rt1);
        m.addTile(1, rt2);
        gc.addPlayer(e);
        gc.setMap(m);


        for (int i = 0; i < TestCaseStrings.length; i++)
        {
            System.out.println(i + ":\t" + TestCaseStrings[i]);
        }
        System.out.println("Choose a testcase!");
        Scanner in = new Scanner(System.in);

        int input;

        Logger.EnablePrint();

        while (true) {
            input = in.nextInt();
            System.out.println("Integer read: " + input);
            switch(input)
            {
                case 0:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.step(rt2);
                    break;
                }
                case 1:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.step(ht);
                    break;
                }
                case 2:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.useAbility(rt1);
                    break;
                }
                case 3:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    s.useAbility(rt1);
                    break;
                }
                case 4:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.pass();
                    break;
                }
                case 5:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.pickUpItem();
                    break;
                }
                case 6:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.clearSnow();
                    break;
                }
                case 7:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    DivingSuit d = new DivingSuit();
                    rt1.setItem(d);
                    e.pickUpItem();
                    e.useItem(d);
                    break;
                }
                case 8:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Food f = new Food();
                    rt1.setItem(f);
                    e.pickUpItem();
                    e.useItem(f);
                    break;
                }
                case 9:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    WinningItem w = new WinningItem();
                    rt1.setItem(w);
                    e.pickUpItem();
                    e.useItem(w);

                    break;
                }
                case 10:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Rope r = new Rope();
                    rt1.setItem(r);
                    e.pickUpItem();
                    e.useItem(r);
                    break;
                }
                case 11:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    Shovel sh = new Shovel();
                    rt1.setItem(sh);
                    e.pickUpItem();
                    e.useItem(sh);
                    break;
                }
                case 12:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    e.step(rt1);
                    e.setEnergy(0);
                    e.pass();
                    e.setEnergy(4);
                    break;
                }

            }

        }
    }
}