import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**

*/


public class Driver{
	
    public static void main(String[] args) throws Exception {
    	Parser parse = new Parser(args);
    	ArrayList<String> input = parse.getInput();
    	part1(input);
    }
    
    public static boolean isNumeric(String str){
    	
    	try {
    		int integer = Integer.parseInt(str);
    	} catch(NumberFormatException nfe) {
    		return false;
    	}
    	
    	return true;
    	
    	
    }
    
    public static void part1(ArrayList<String> input) {
    	ArrayList<Integer> times = new ArrayList<Integer>();
    	ArrayList<Integer> distances = new ArrayList<Integer>();
    	
    	String getTimes = input.get(0);
		String[] timesArray = getTimes.split(" ");
		
		String getDistances = input.get(1);
		String[] distancesArray = getDistances.split(" ");
		
		for(int i = 0;i<timesArray.length;i++) {
			if(isNumeric(timesArray[i])) {
				times.add(Integer.parseInt(timesArray[i]));
			}
		}
		
		for(int i = 0;i<distancesArray.length;i++) {
			if(isNumeric(distancesArray[i])) {
				distances.add(Integer.parseInt(distancesArray[i]));
			}
		}
		
		int marginOfError = 0;
//			for(int i = 0;i<1;i++) {
	
		for(int i = 0;i<times.size();i++) {
		    int ways = 0;
			int timePassed = 0;
			int holdTime = 0;
			int recordTime = times.get(i);
			
			for(int j = 0;j<recordTime;j++) {
				int distanceTraveled = 0;
				
				//Can we beat record if let go at this time?
				int timePassedCopy = timePassed;
				while(true) {
					//failed to break record
					if(timePassedCopy > recordTime || holdTime == 0) {
						System.out.println("Cannot win with hold time of " + holdTime);
						break;
					}
					
					
					if(distanceTraveled > distances.get(i) && timePassedCopy<= recordTime) {
						System.out.println("Hold Time:  "
								+ holdTime + " New Record: " + distanceTraveled
								+ " Time Left: " + (recordTime - timePassedCopy));
//								+ " Seconds left to beat " + (recordTime-holdTime));
						
						ways++;
						break;
					}
					timePassedCopy++;
					distanceTraveled = distanceTraveled + holdTime;
				
				}
				holdTime++;
				timePassed++;
			}
			System.out.println("Ways " + ways);
			
			marginOfError = i == 0 ? 
							ways : marginOfError * ways;
			
		}
		
		System.out.println("Margin of Error " + marginOfError);
		
    	
    }
    
    
}