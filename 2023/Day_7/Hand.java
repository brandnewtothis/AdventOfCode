import java.util.ArrayList;
import java.util.Hashtable;

public class Hand {
	
	public static final String[] RANK = 
		{"2","3", "4", "5", "6", "7", "8", "9", "T", "J","Q","K","A"};
	
	private Hashtable<Integer,String> cardTable;
	
	private ArrayList<Card> cards;
	String handName;
	int highestRank;
	int power;
	int bid;
	
	public Hand(int bid) {
		this.cards = new ArrayList<Card>();
		this.handName = "";
		this.highestRank = 0;
		this.power = 0;
		this.bid = bid;
		
		cardTable = new Hashtable<Integer,String>();
    	for(int i = 0;i<RANK.length;i++) {
    		cardTable.put(2+i,RANK[i]);
    	}
	}
	
	public void addCard(Card card) {
		handName += cardTable.get(card.getRank());
		
		if(cards.contains(card)) {
		    int key = cards.indexOf(card);	
			Card updateCard = cards.remove(key);
			updateCard.addCard();
			cards.add(updateCard);
		} else {
  		   cards.add(card);
  		   if(card.getRank() > highestRank) {
  			   highestRank = card.getRank();
  		   }
		}
	}
	
	/*
	 * Every hand is exactly one type. From strongest to weakest, they are:

    Five of a kind, where all five cards have the same label: AAAAA
    Four of a kind, where four cards have the same label and one card has a different label: AA8AA
    Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
    Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
    Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
    One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
    High card, where all cards' labels are distinct: 23456

	 */
	
	/*
	 * Five of  a kind == 1 Card  (5 Same)
	 * Four of  a kind == 2 Cards (4 Same 1 Different) 
	 * Full     House  == 2 Cards (3 Same 2 Same)
	 * Three of a kind == 3 Cards (3 Same 2 Different)
	 * Two       Pair  == 3 Cards (2 Same 2 Same 1 Different)
	 * One       Pair  == 4 Cards (2 Same 3 Different)
	 * High       Card == 5 Cards (5 Different)
	 */
	public void updatePower() {
		if(cards.size() == 5) {
			power = 10*highestRank;
		} else if(cards.size() == 4) {
			power = 20*highestRank;
		} else if(isTwoPair() == true) {
			power = 30*highestRank;
		} else if(isThreeOfAKind()== true) {
			power = 40*highestRank;
		} else if(isFullHouse() == true) {
			power = 50*highestRank;
		} else if(isFourOfAKind() == true) {
			power = 60*highestRank;
		} else if(cards.size() == 1) {
			power = 1000*highestRank;
		}
		System.out.println();
	}
	
	private boolean isFourOfAKind() {
		return !isFullHouse() && cards.size() == 2;
	}
	
	private boolean isFullHouse() {
		if(cards.size() != 2) {
			return false;
		}
		
		int rank = 0;
		
		//pass two checks to be full house 
		int checks = 0;
		
		for(int i = 0;i<cards.size();i++) {
//			Full     House  == 2 Cards (3 Same 2 Same)
			Card card = cards.get(i);
			if(card.getAmount() == 3) {
				rank = card.getRank();
				checks++;
			}
			
			if(card.getAmount() == 2) {
				checks++;
			}
			
			//four of a kind update highest rank and return false
			if(card.getAmount() == 4) {
				highestRank = card.getRank();
				return false;
			}
			
		}
		
		if(checks == 2) {
			highestRank = rank;
		}
		
		return checks == 2 ? true : false;
		
	}
	
	private boolean isThreeOfAKind() {
		return !isTwoPair() && cards.size() == 3;
	}
	
	//Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
	private boolean isTwoPair() {
		
		int pairs = 0;
		
		if(cards.size() != 3) {
			return false;
		}
		
		int rank = 0;
		
		for(int i = 0;i<cards.size();i++) {
		   //2 pair
		   if(cards.get(i).getAmount() == 2) {
			   if(cards.get(i).getRank() > rank) {
				   rank = cards.get(i).getRank();
			   }
			   pairs++;
		   }
		   
		   //Three of a kind or full house, update highest rank and return false
		   if(cards.get(i).getAmount() == 3) {
		      highestRank = cards.get(i).getRank();
		      return false;
		   }
		   
		}
		
		
		if(pairs == 2) {
			highestRank = rank;
		}
		
		return pairs == 2 ? true : false;
	}
	
	public int getHighestCardValue() {
		return highestRank;
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public Integer getPower() {
		return power;
	}
	
	public int getBid() {
		return bid;
	}
	
	
	@Override
	public String toString() {
		return handName + " Power " + power;
	}
	
}

