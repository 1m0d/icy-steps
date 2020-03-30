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

        Map m = new Map();
        RegularTile rt1 = new RegularTile(m, 0);
        RegularTile rt2 = new RegularTile(m, 1);
        HoleTile ht = new HoleTile(m, 2);
        Eskimo e = new Eskimo(0, rt1);
        Scientist s = new Scientist(1, ht);

        DivingSuit ds = new DivingSuit();
        Food f = new Food();
        WinningItem wi = new WinningItem();
        Rope r = new Rope();
        Shovel sh = new Shovel();

        for (int i = 0; i < TestCaseStrings.length; i++)
        {
            System.out.println(i + ":\t" + TestCaseStrings[i]);
        }
        System.out.println("Choose a testcase!");
        Scanner in = new Scanner(System.in);

        int input;
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
                    //e.useItem();
                    break;
                }
                case 8:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                   // e.useItem();
                    break;
                }
                case 9:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    //e.useItem();
                    break;
                }
                case 10:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    //e.useItem();
                    break;
                }
                case 11:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                    //e.useItem();
                    break;
                }
                case 12:
                {
                    System.out.println(input + "\t" + TestCaseStrings[input]);
                   //e.useItem();
                    break;
                }

            }

        }
    }
}