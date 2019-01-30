
public class player {

	private String name;
	private inventory inv;
	private coordinates coord;
	
	// Constructor
	// take String, inventory, coordnates
	public player(String name, inventory inv, coordinates coord) {
		this.name = name;
		this.inv = inv;
		this.coord = coord;
	}
	
	// Constructor
	// takes name
	public player(String name) {
		this.name = name;
		inv = new inventory();
		coord = new coordinates(0, 0, 0);
	}
	
	// Gets player name
	// returns String
	public String getName() {
		return name;
	}
	
	// Sets player name
	// takes String
	public void setName(String name) {
		this.name = name;
	}	
	
	// Gets player inventory
	// returns inventory
	public inventory getInventory() {
		return inv;
	}
	
	// Sets player inventory
	// takes inventory
	public void setInventory(inventory inv) {
		this.inv = inv;
	}
	
	// Gets player coordinates
	// returns coordinates
	public coordinates getCoord() {
		return coord;
	}
	
	
	// Sets player coordinates
	// takes coordinates
	public void setCoord(coordinates coord) {
		this.coord = coord;
	}
	
	// Adds item to player inventory
	// takes item
	public void addItem(item i) {
		inv.addItem(i);
	}
	
	public area getArea(map m) {
		for(area a: m.getMap()) {
			if(getCoord().equals(a.getCoord())) {
				return a;
			}
		}
		return null;
	}
	
	// Moves player north
	// takes player, map
	// returns boolean
	public boolean moveN(player p, map m) {
		if (m.areaExists(new coordinates(p.getCoord().getX(), p.getCoord().getY() + 1, p.getCoord().getZ()))) {
			p.setCoord(new coordinates(p.getCoord().getX(), p.getCoord().getY() + 1, p.getCoord().getZ()));
			return true;
		}
		return false;
	}
	
	// Moves player south
	// takes player, map
	// returns boolean
	public boolean moveS(player p, map m) {
		if (m.areaExists(new coordinates(p.getCoord().getX(), p.getCoord().getY() - 1, p.getCoord().getZ()))) {
			p.setCoord(new coordinates(p.getCoord().getX(), p.getCoord().getY() - 1, p.getCoord().getZ()));
			return true;
		}
		return false;
	}
	
	// Moves player east
	// takes player, map
	// returns boolean
	public boolean moveE(player p, map m) {
		if (m.areaExists(new coordinates(p.getCoord().getX() + 1, p.getCoord().getY(), p.getCoord().getZ()))) {
			p.setCoord(new coordinates(p.getCoord().getX() + 1, p.getCoord().getY(), p.getCoord().getZ()));
			return true;
		}
		return false;
	}
	
	// Moves player west
	// takes player, map
	// returns boolean
	public boolean moveW(player p, map m) {
		if (m.areaExists(new coordinates(p.getCoord().getX() - 1, p.getCoord().getY(), p.getCoord().getZ()))) {
			p.setCoord(new coordinates(p.getCoord().getX() - 1, p.getCoord().getY(), p.getCoord().getZ()));
			return true;
		}
		return false;
	}
	
	// Moves player up
	// takes player, map
	// returns boolean
	public boolean moveU(player p, map m) {
		if (m.areaExists(new coordinates(p.getCoord().getX(), p.getCoord().getY(), p.getCoord().getZ() + 1))) {
			p.setCoord(new coordinates(p.getCoord().getX(), p.getCoord().getY(), p.getCoord().getZ() + 1));
			return true;
		}
		return false;
	}
	
	// Moves player down
	// takes player, map
	// returns boolean
	public boolean moveD(player p, map m) {
		if (m.areaExists(new coordinates(p.getCoord().getX(), p.getCoord().getY(), p.getCoord().getZ() - 1))) {
			p.setCoord(new coordinates(p.getCoord().getX(), p.getCoord().getY(), p.getCoord().getZ() - 1));
			return true;
		}
		return false;
	}
	
}
