package modules;

public class Logger {
    private static int tabCount = 0;
    private static boolean printEnabled = false;

    public static void LogFunctionCall(String msg) {
        tabCount++;
        for (int n = 0; n < tabCount; n++) {
            System.out.print("\t|");
        }
        System.out.println(msg);
    }

    public static void LogFunctionReturn(String msg){
        for (int n = 0; n < tabCount; n++) {
            System.out.print("\t|");
        }
        System.out.println(msg);
        tabCount--;
    }

    public static void EnablePrint() {
        printEnabled = true;
    }

    public static void DisablePrint() {
        printEnabled = false;
    }
}
