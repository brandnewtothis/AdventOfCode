import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class  Driver{
    public static String filename;
    
    public static void main(String[] args) throws Exception {
    	System.out.println("Hello World");
        parseArgs(args);
    }

    private static void usage() {
        System.err.println("usage: java Driver input.txt");
        System.exit(1);
    }

    public static void parseArgs(String[] args) {
        if (args.length == 0) {
            usage();
        }
    }

}