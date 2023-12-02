public class Map {
	
	private Coordinates currentLocation;
	
    public Map(int startingX, int startingY) {	
    	this.currentLocation = new Coordinates(startingX,startingY);
    
    }
    
    public Coordinates getCurrentLocation() {
    	return currentLocation;
    }
    
    public String toString() {
    	return currentLocation.getX() + "," + currentLocation.getY();
    }

}
