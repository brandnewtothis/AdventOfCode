import java.util.Objects;


public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void left() {
		this.x--;
	}
	
	public void right() {
		this.x++;
	}
	
	public void up() {
		this.y++;
	}
	
	public void down() {
		this.y--;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		else if(o == null || this.getClass() != o.getClass())
			return false;
		
		Coordinates coordinate = (Coordinates)o;
		return x == coordinate.x && y == coordinate.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	
}
