package modules;

public class Logger {
    /**
     * Behúzás mértéke.
     */
    private static int tabCount = 0;
    /**
     * Logger állapota. True esetben logol, false esetben nem.
     */
    private static boolean printEnabled = false;

    /**
     * Itt logolhatóak a függvényhívások tetszőleges szöveggel. Növeli a soreleji behúzást.
     * @param msg Tetszőlegesen megadható szöveg.
     */
    public static void LogFunctionCall(String msg) {
        if (!printEnabled) return;
        tabCount++;
        for (int n = 0; n < tabCount; n++) {
            System.out.print("\t|");
        }
        System.out.println(msg);
    }

    /**
     * Itt logolhatóak a függvények visszatérései tetszőleges szöveggel. csökkenti a soreleji behúzást.
     * @param msg Tetszőlegesen megadható szöveg.
     */
    public static void LogFunctionReturn(String msg){
        if (!printEnabled) return;
        for (int n = 0; n < tabCount; n++) {
            System.out.print("\t|");
        }
        System.out.println(msg);
        tabCount--;
    }

    /**
     * Kikapcsolja a logolást
     */
    public static void EnablePrint() {
        printEnabled = true;
    }

    /**
     * Bekapcsolja a logolást
     */
    public static void DisablePrint() {
        printEnabled = false;
    }
}
