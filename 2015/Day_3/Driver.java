

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
--- Day 3: Perfectly Spherical Houses in a Vacuum ---

Santa is delivering presents to an infinite two-dimensional grid of houses.

He begins by delivering a present to the house at his starting location, and then an elf 
at the North Pole calls him via radio and tells him where to move next. 
Moves are always exactly one house to the north (^), south (v), east (>), or west (<). 
After each move, he delivers another present to the house at his new location.

However, the elf back at the north pole has had a little too much eggnog, 
and so his directions are a little off, and Santa ends up visiting some houses more than once. 
How many houses receive at least one present?

For example:

    > delivers presents to 2 houses: one at the starting location, and one to the east.
    ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
    ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
*/


public class Driver{
    public static String filename;
    
    public static String commands;
    
    public static void main(String[] args) throws Exception {
    	System.out.println("Hello World");
        parseArgs(args);
        
        Map Santa = new Map(0,0);
        Map RoboSanta = new Map(0,0);
   	    
        HashMap<Coordinates,Integer> visited = new HashMap<Coordinates,Integer>();
    	
        visited.put(Santa.getCurrentLocation(),2);
        
        for(int i = 0; i < commands.length();i++) {
        	
        	if(i%2 == 0) {
        	  switch(commands.charAt(i)){
        		case '<': Santa.getCurrentLocation().left();
        		          break;
        		case '>': Santa.getCurrentLocation().right();
        				  break;
        		case 'v': Santa.getCurrentLocation().down();
        				  break;
        		case '^': Santa.getCurrentLocation().up();
        				  break;
        	   }
       		   checks(Santa,visited);
        	} else {
        	  switch(commands.charAt(i)){
        		case '<': RoboSanta.getCurrentLocation().left();
        		          break;
        		case '>': RoboSanta.getCurrentLocation().right();
        				  break;
        		case 'v': RoboSanta.getCurrentLocation().down();
        				  break;
        		case '^': RoboSanta.getCurrentLocation().up();
        				  break;
        	   }
       		   checks(RoboSanta,visited);
        	}
     		
     		
        }
        
        System.out.println("Santa finished at " + Santa.getCurrentLocation().getX() + ","
        + Santa.getCurrentLocation().getY());
        
        //extra one for starting house
        System.out.println("Both visited " + (visited.size()+1) + " houses!");
        
        
    }
    
    public static void checks(Map Santa, HashMap<Coordinates,Integer> visited) {
    	 Coordinates check = new Coordinates(Santa.getCurrentLocation().getX(),Santa.getCurrentLocation().getY());
         
    	 if(visited.containsKey(check)){
    		 visited.put(check,visited.get(check)+1);
    	 } else {
             visited.put(check,1);
    	 }

    }

    private static void usage() {
        System.err.println("usage: java Driver input.txt");
        System.exit(1);
    }

    public static void parseArgs(String[] args) {
        if (args.length == 0) {
            usage();
        }
        Scanner sc;
		try {
			sc = new Scanner(new File(args[0]));
			 // the input should only be one line of commands 
            commands = sc.nextLine();
            sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}