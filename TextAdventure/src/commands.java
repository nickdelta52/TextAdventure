
public class commands {

	private player p;
	private map m;
	private String cmd;
	
	// Constructor
	// takes player, map
	public commands(player p, map m) {
		this.p = p;
		this.m = m;
	}
	
	// Moves player in map
	// takes String
	// returns String
	public String move(String d) {
		switch (d) {
		case "n":
			if (p.moveN(p, m)) {
				cmd = "You traveled north.";
				break;
			}
			cmd = "You can't go this way.";	
			break;
		case "s": 
			if (p.moveS(p, m)) {
				cmd = "You traveled south.";
				break;
			}
			cmd = "You can't go this way.";	
			break;
		case "e": 
			if (p.moveE(p, m)) {
				cmd = "You traveled east.";
				break;
			}
			cmd = "You can't go this way.";	
			break;
		case "w": 
			if (p.moveW(p, m)) {
				cmd = "You traveled west.";
				break;
			}
			cmd = "You can't go this way.";	
			break;
		case "u": 
			if (p.moveU(p, m)) {
				cmd = "You traveled up.";
				break;
			}
			cmd = "You can't go this way.";	
			break;
		case "d": 
			if (p.moveD(p, m)) {
				cmd = "You traveled down.";
				break;
			}
			cmd = "You can't go this way.";	
			break;
		default : 
			cmd = "You can't go this way.";
		}
		return cmd;
	}
	
	// Lets player looks at description of area
	// return String
	public String look() {
		if (p.getArea(m) != null) {
			return p.getArea(m).getDescription();
		}
		return "can't get description.";
	}
	
	// Lets player look at description of item
	// takes String
	// returns String
	public String lookAt(String item) {
		if (m.isItem(item)) {
			if (p.getInventory().contains(m.toItem(item))) {
				return m.toItem(item).getDescription();
			} else {
				return "You do not have that item.";
			}
		} else {
			return "That is not a valid item.";
		}
		
	}
	
	// Lets player take an item from an area and put it in their inventory
	// takes String
	// returns String
	public String take(String item) {
		item tempItem = m.toItem(item);
		if (m.isItem(item)) {
			if (p.getArea(m) != null && p.getArea(m).getInventory().contains(tempItem) == true) {
				if (p.getInventory().contains(m.toItem("nothing"))) {
					p.getInventory().removeItem(m.toItem("nothing"));
				}
				p.addItem(tempItem);
				p.getArea(m).getInventory().removeItem(tempItem);
				return tempItem.getName() + " was added to your inventory.";
			} else {
				return "That item is not in your area.";
			}
		} else {
			return "That is not a valid item.";
		}
		
	}
	
	// Lets player drop item from their inventory
	// takes String
	// returns String
	public String drop(String item) {
		item tempItem = m.toItem(item);
		if (m.isItem(item)) {
			if (p.getInventory().contains(tempItem)) {
				p.getArea(m).getInventory().addItem(tempItem);
				p.getInventory().removeItem(tempItem);
				return "You dropped the " + tempItem.getName() + " on the ground.";
			} else {
				return "This item is not in your inventory.";
			}
		}
		return "That is not a valid item.";
	}
	
	// Lets player look a contents of inventory
	// returns String
	public String inventory() {
		return p.getInventory().toString2();
	}
	
	// Lets player see items in area
	// returns String
	public String itemList() {
		return p.getArea(m).getInventory().toString2();
	}
	
	// Lets player check their coordinates
	// returns String
	public String coord() {
		return p.getCoord().toString();
	}
	
	// Lets player see all commands
	// returns String
	public String help() {
		return "Type \"look\" to see what your area looks like.\n"
				+ "Type \"look at\" followed by an item in your inventory to get a description of that item.\n"
				+ "Type \"item list\" to see all the items in the area.\n"
				+ "Type \"inventory\" to see items in your inv.\n"
				+ "Type \"go\" followed by \"north, south, east, west, up, or down\" to move in that direction.\n"
				+ "Type \"coord\" to find your coordinate location.\n"
				+ "Type \"take\" followed by the name of any item in the area that you want to pick up.\n";
	}
	
}
