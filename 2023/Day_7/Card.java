import java.util.Objects;


public class Card {
	
	private int rank;
	private int amount;

	public Card(int rank, int amount) {
		this.rank = rank;
		this.amount = amount;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void addCard() {
		amount++;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		else if(o == null || this.getClass() != o.getClass())
			return false;
		
		Card card = (Card)o;
		return rank == card.rank;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rank);
	}
	
}

