import java.util.*;

public class area {
	
	private String title;
	private coordinates coord;
	private String description;
	private inventory inv;
	
	// Constructor
	// takes String, coordinates, String, inventory
	public area(String title, coordinates coord, String description, inventory inv) {
		this.title = title;
		this.coord = coord;
		this.description = description;
		this.inv = inv;
	}
	
	// Constructor
	// takes String, coordinates, String, ArrayList<item>
	public area(String title, coordinates coord, String description, ArrayList<item> items) {
		this.title = title;
		this.coord = coord;
		this.description = description;
		
		for(item i: items) {
			inv.addItem(i);
		}
	}
	
	// Constructor
	// takes String, int, int, int, String, String, ArrayList<item>
	public area(String title, int x, int y, int z, String description, ArrayList<item> items) {
		this.title = title;
		this.coord = new coordinates(x, y, z);
		this.description = description;
		
		for(item i: items) {
			inv.addItem(i);
		}
	}
	
	// Constructor
	// takes String, int, int, int, String
	public area(String title, int x, int y, int z, String description) {
		this.title = title;
		this.coord = new coordinates(x, y, z);
		this.description = description;
	}
	
	// Gets area coordinates
	// returns coordinates
	public coordinates getCoord() {
		return coord;
	}
	
	// Sets area coordinates
	// takes coordinates
	public void setCoord(coordinates coord) {
		this.coord = coord;
	}
	
	// Gets area title
	// returns String
	public String getTitle() {
		return title;
	}
	
	// Sets area title
	// takes String
	public void setTitle(String title) {
		this.title = title;
	}
	
	// Gets area description
	// returns String
	public String getDescription() {
		return description;
	}
	
	// Sets area description
	// takes String
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Gets area inventory
	// returns inventory
	public inventory getInventory() {
		return inv;
	}
	
	// Adds item to area inventory
	// takes item
	// returns boolean
	public boolean addToInventory(item i) {
		return inv.addItem(i);
	}
	
	// Gets coordinate to the north of the area
	// returns coordinates
	public coordinates getN() {
		return new coordinates(coord.getX(), coord.getY() + 1, coord.getZ());
	}
	
	// Gets coordinate to the south of the area
	// returns coordinates
	public coordinates getS() {
		return new coordinates(coord.getX(), coord.getY() - 1, coord.getZ());
	}
	
	// Gets coordinate to the east of the area
	// returns coordinates
	public coordinates getE() {
		return new coordinates(coord.getX() + 1, coord.getY(), coord.getZ());
	}
	
	// Gets coordinate to the west of the area
	// returns coordinates
	public coordinates getW() {
		return new coordinates(coord.getX() - 1, coord.getY(), coord.getZ());
	}
	
	// Gets coordinate above the area
	// returns coordinates
	public coordinates getU() {
		return new coordinates(coord.getX(), coord.getY(), coord.getZ() + 1);
	}
	
	
	// Gets coordinate below the area
	// returns coordinates
	public coordinates getD() {
		return new coordinates(coord.getX(), coord.getY(), coord.getZ() - 1);
	}
	
	// Puts major area information into a string
	// returns String
	public String toString() {
		return title + ", " + coord.toString() + ", " + description + ", " + inv.toString();
	}
	
}
