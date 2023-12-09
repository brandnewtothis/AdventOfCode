import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

/**
*/



public class Driver{
	
	
	public static final String[] RANK = 
		{"2","3", "4", "5", "6", "7", "8", "9", "T", "J","Q","K","A"};
	    //2   3    4    5    6    7    8    9   10   11  12  13  14
	
	public static Hashtable<String,Integer> cardTable;
	
    public static void main(String[] args) throws Exception {
    	Parser parse = new Parser(args);
    	ArrayList<String> input = parse.getInput();
    	
    	cardTable = new Hashtable<String,Integer>();
    	for(int i = 0;i<RANK.length;i++) {
    		cardTable.put(RANK[i],2+i);
    	}
    	
    	part1(input);
    	
    	
    }
    
    public static void part1(ArrayList<String> input) {
    	
    	TreeSet<Hand> hands = new TreeSet<Hand>(new Comparator<Hand>() {
            @Override
            public int compare(Hand h1, Hand h2) {
                return h1.getPower().compareTo(h2.getPower());
            }
        });
    	
    	//get all hands and power levels
    	for(int i = 0;i<input.size();i++) {
    		
  	    	String line = input.get(i);
    		String[] lineArray = line.split(" ");
    			
    		int bid = Integer.parseInt(lineArray[1].replaceAll(" ",""));
         	Hand hand = new Hand(bid);
    		
    		for(int j = 0;j<lineArray[0].length();j++) {
    			String currentCard = "" + lineArray[0].charAt(j);
    			Card current = new Card(cardTable.get(currentCard),1);
    			hand.addCard(current);
    		}
    		
    		hand.updatePower();
    		hands.add(hand);
   
    	}
    	
    	
    	System.out.println(hands);
    	
    	int sum = 0;
    	int rank = 1;
    	
    	for(Hand hand: hands) {
    	   	sum += hand.getBid() * rank;
    	   	rank++;
    	}
    	
    	System.out.println("Winnings: " + sum);
    	
    	
    }
    
	
    
}