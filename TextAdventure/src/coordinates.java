
public class coordinates {

	private int x;
	private int y;
	private int z;
	
	// Constructor
	public coordinates() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	// Constructor
	// takes int, int, int
	public coordinates(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// Constructor
	// takes String
	// returns coordinates
	public coordinates(String coord) {
		String[] splitCoord = coord.split(",");
		this.x = Integer.parseInt(splitCoord[0]);
		this.y = Integer.parseInt(splitCoord[1]);
		this.z = Integer.parseInt(splitCoord[2]);
	}
	
	// Gets direction of coordinates
	// takes direction
	// returns coordinates
	public coordinates getCoordDirection(direction d) {
		return new coordinates(x + d.getdX(), y + d.getdY(), z + d.getdZ());
	}
	
	// Gets x coordinate
	// returns int
	public int getX() {
		return x;
	}
	
	// Sets x coordinate
	// takes int
	public void setX(int x) {
		this.x = x;
	}
	
	// Gets y coordinate
	// returns int
	public int getY() {
		return y;
	}
	
	// Sets y coordinate
	// takes int
	public void setY(int y) {
		this.y = y;
	}

	// Gets z coordinate
	// returns int
	public int getZ() {
		return z;
	}
	
	// Sets z coordinate
	// takes int
	public void setZ(int z) {
		this.z = z;
	}
	
	// Checks if two coordinates are equal
	// takes coordinates
	// returns boolean
	public boolean equals(coordinates c) {
		return (x == c.getX() && y == c.getY() && z == c.getZ());
	}
	
	// Puts x, y, z values into string
	// returns String
	public String toString() {
		return "" + x + ", " + y + ", " + z;
	}
	
}
