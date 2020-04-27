package modules;

import java.io.File;

public class Interpreter {

    public  boolean setCurrentDirectory(String directory_name) {
        boolean result = false;  // Boolean indicating whether directory was set
        File directory;       // Desired current working directory
        directory = new File(directory_name).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs())
        {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }
        return result;
    }

    public void check(String absolutePath) {

    }

    public void execute(String absolutePath) {

    }
}
