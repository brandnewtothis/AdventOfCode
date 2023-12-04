import java.util.ArrayList;
import java.util.Scanner;

/**
--- Day 2: Cube Conundrum ---

You're launched high into the atmosphere! The apex of your trajectory just barely reaches the surface of a large island floating in the sky. You gently land in a fluffy pile of leaves. It's quite cold, but you don't see much snow. An Elf runs over to greet you.

The Elf explains that you've arrived at Snow Island and apologizes for the lack of snow. He'll be happy to explain the situation, but it's a bit of a walk, so you have some time. They don't get many visitors up here; would you like to play a game in the meantime?

As you walk, the Elf shows you a small bag and some cubes which are either red, green, or blue. Each time you play this game, he will hide a secret number of cubes of each color in the bag, and your goal is to figure out information about the number of cubes.

To get information, once a bag has been loaded with cubes, the Elf will reach into the bag, grab a handful of random cubes, show them to you, and then put them back in the bag. He'll do this a few times per game.

You play several games and record the information from each game (your puzzle input). Each game is listed with its ID number (like the 11 in Game 11: ...) followed by a semicolon-separated list of subsets of cubes that were revealed from the bag (like 3 red, 5 green, 4 blue).

For example, the record of a few games might look like this:

Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green

In game 1, three sets of cubes are revealed from the bag (and then put back again). The first set is 3 blue cubes and 4 red cubes; the second set is 1 red cube, 2 green cubes, and 6 blue cubes; the third set is only 2 green cubes.

The Elf would first like to know which games would have been possible if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?

In the example above, games 1, 2, and 5 would have been possible if the bag had been loaded with that configuration. However, game 3 would have been impossible because at one point the Elf showed you 20 red cubes at once; similarly, game 4 would also have been impossible because the Elf showed you 15 blue cubes at once. If you add up the IDs of the games that would have been possible, you get 8.

Determine which games would have been possible if the bag had been loaded with only 12 red cubes, 13 green cubes, and 14 blue cubes. What is the sum of the IDs of those games?
*/


public class Driver{
	
 	//12 red cubes, 13 green cubes, and 14 blue cubes	
	public static final int RED = 12;
	public static final int GREEN = 13;
	public static final int BLUE = 14;
	
    public static void main(String[] args) throws Exception {
    	Parser parse = new Parser(args);
    	ArrayList<String> input = parse.getInput();
    	part1(input);
    	part2(input);
    }
    
    public static void part2(ArrayList<String> input) {
    	
    	int cubeSum = 0;
    	
    	for(int j = 0;j<input.size();j++) {
    		String str = input.get(j);
    		String[] strArray = str.split(" ");
    		
    		int min_red = -1;
    		int min_blue = -1;
    		int min_green = -1;
    		
    		for(int i = 2; i < strArray.length;i+=2) {
    			int red = min_red;
    			int green = min_green;
    			int blue = min_blue;
    		
    			if(strArray[i+1].charAt(0) == 'r') {
    				red = Integer.parseInt(strArray[i]);
    			} else if(strArray[i+1].charAt(0) == 'g') {
    				green = Integer.parseInt(strArray[i]);
    			} else if(strArray[i+1].charAt(0) == 'b') {
    				blue = Integer.parseInt(strArray[i]);
    			}
    			
    			if(red > min_red) {
    			   min_red = red;	
    			}
    			
    			if(green > min_green) {
    				min_green = green;
    			}
    			
    			if(blue > min_blue) {
    				min_blue = blue;
    			}
    				
    		}
    		
/*    		System.out.println("R:"+min_red +
    				" B:"+min_blue+
    				" G:"+min_red);
    		
    		System.out.println(min_red*min_blue*min_green);
  */  		
    		cubeSum += min_red * min_blue * min_green;
    	}
    	
    	System.out.println("Cube Sum: " + cubeSum);	
    	
    }
    
    public static void part1(ArrayList<String> input) {
    	int total = 0;
    	
    	for(int j = 0;j<input.size();j++) {
    		boolean possible = false;
    		String str = input.get(j);
    		String[] strArray = str.split(" ");
    		
    		for(int i = 2; i < strArray.length;i+=2) {
    			int red = 0;
    			int green = 0;
    			int blue = 0;
    		
    			if(strArray[i+1].charAt(0) == 'r') {
    				red = Integer.parseInt(strArray[i]);
    			} else if(strArray[i+1].charAt(0) == 'g') {
    				green = Integer.parseInt(strArray[i]);
    			} else if(strArray[i+1].charAt(0) == 'b') {
    				blue = Integer.parseInt(strArray[i]);
    			}
    		
    			possible = part1_check(red,green,blue);
    			if(possible == false) {
    				break;
    			}
    		}
    		int id = j + 1;
    		if(possible == true) {
    		   System.out.print(id + ": " + total + "+" + id + "=");
    		   total = total + id;	
   		       System.out.println(total);
    		}
    	}
    	
    	System.out.println("Possible ID Sum: " + total);
    }
    
    public static boolean part1_check(int red, int green, int blue) {
        boolean possible = true;
    	
    	if(RED - red < 0) {
//    		System.out.println(RED + "-" + red + "=" + (RED - red));
    		possible = false;
    	}
    	
    	if(GREEN - green < 0) {
//   		System.out.println(GREEN + "-" + green + "=" + (GREEN - green));
    		possible = false;
    	}
    	
    	if(BLUE - blue < 0) {
//    		System.out.println(BLUE + "-" + blue + "=" + (BLUE - blue));
    		possible = false;
    	}
    	
    	return possible;
    }
    
}