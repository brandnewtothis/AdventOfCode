import java.util.ArrayList;

/**
--- Day 1: Trebuchet?! ---

Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.

You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").

As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.

The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.
*/


public class Driver{
	
	//don't need zero
	public static final String[] DIGITS = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
    public static void main(String[] args) throws Exception {
    	Parser parse = new Parser(args);
    	
    	ArrayList<String> input = parse.getInput();
    	
//    	part1(input);
    	part2(input);
    	
    }
    
    public static void part2(ArrayList<String> input) {
    	int total = 0;
    	for(int i = 0;i < input.size();i++) {
    		String line = input.get(i);
    		
//    System.out.println(line);		
    
   		    boolean isFirst = true;
   		    
   		    char first = ' ';
   		    char last = ' ';
    		
    		for(int j = 0; j < line.length();j++) {
    		   if(Character.isDigit(line.charAt(j)) && isFirst){
    		      isFirst = false;
    		      first = line.charAt(j);
    		      last = line.charAt(j);
    		   } else if(Character.isDigit(line.charAt(j))) {
    			  last = line.charAt(j);
    		   }
    		   int word = checkWord(line,j);     		  
    		   
    		   if(word > 0 && isFirst) {
    			  isFirst = false;
    		      first = (char)(word+'0');
    		      last = (char)(word+'0');
    		   } else if(word > 0){
    			  last = (char)(word+'0');
    		   }
    		}
    		String digit = "" + first + last;
//    		total = Integer.valueOf(digit);
//    		System.out.println("Word " + i + ": " + total);
    		total += Integer.valueOf(digit);
    	}
    	
    	System.out.println("Total including number words is " + total);
    }
    
    public static int checkWord(String line, int index) {
    
    	//Null check
    	if(index+2 >= line.length()) {
    		return 0;
    	}
    	
    	//o one 
    	if(line.charAt(index) == 'o') {
    		if(isMatch(line,index,1)){
    			return 1;
    		}
    	}
    	//t two, three 
    	if(line.charAt(index) == 't') {
    		if(isMatch(line,index,2)) {
    			return 2;
    		}
    		
    		//null check
    		if(index+4 >= line.length()) {
    			return 0;
    		}
    		
    		if(isMatch(line,index,3)) {
    			return 3;
    		}
    		
    	}
    	//f four, five
    	if(line.charAt(index) == 'f') {
    		//null check
    		if(index+3 >= line.length()) {
    			return 0;
    		}
    		
    		if(isMatch(line,index,4)) {
    			return 4;
    		}
    		
    		if(isMatch(line,index,5)) {
    			return 5;
    		}
    	}
    	
    	//s six, seven
    	if(line.charAt(index) == 's') {
    		if(isMatch(line,index,6)) {
    			return 6;
    		}
    		
    		//Null check
    		if(index+4 >= line.length()) {
    			return 0;
    		}
    		
    		if(isMatch(line,index,7)) {
    			return 7;
    		}
    		
    	}
    	
   	
    	//e eight
    	if(line.charAt(index) == 'e') {
    		if(index+4 >= line.length()) {
    	      return 0;
    	    }
 
    		if(isMatch(line,index,8)) {
    			return 8;
    		}
    	}
   	
    	//n nine
    	if(line.charAt(index) == 'n') {
    		if(index+3 >= line.length()) {
    		   return 0;
    	    }
 
    		if(isMatch(line,index,9)) {
    			return 9;
    		}
    	}
    	
    	return 0;
    }
    
    //assumes out of bounds already checked
    public static boolean isMatch(String line, int index, int digit) {
    	for(int i = 0;i<DIGITS[digit].length();i++) {
    	   if(DIGITS[digit].charAt(i)!=line.charAt(index+i)) {
    		   return false;
    	   }
    	}
    	return true;
    }
    
    public static void part1(ArrayList<String> input) {
    	int total = 0;
    	for(int i = 0;i < input.size();i++) {
    		String line = input.get(i);
   		    boolean isFirst = true;
   		    
   		    char first = ' ';
   		    char last = ' ';
    		
    		for(int j = 0; j < line.length();j++) {
    		   if(Character.isDigit(line.charAt(j)) && isFirst){
    		      isFirst = false;
    		      first = line.charAt(j);
    		      last = line.charAt(j);
    		   } else if(Character.isDigit(line.charAt(j))) {
    			   last = line.charAt(j);
    		   }
    		}
    		String digit = "" + first + last;
    		total += Integer.valueOf(digit);
    	}
    	
    	System.out.println("Total is " + total);
    }
    
}