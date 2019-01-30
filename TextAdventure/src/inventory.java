import java.util.ArrayList;

public class inventory {
	
	private ArrayList<item> items;
	private int maxWeight;
	private int weight;
	
	// Constructor
	// takes ArrayList<item>, int
	public inventory(ArrayList<item> items, int maxWeight) {
		this.items = items;
		this.maxWeight = maxWeight;
		this.weight = 0;
		for (item i: items) {
			weight += i.getWeight();
		}
	}
	
	// Constructor
	// takes ArrayList<item>
	public inventory(ArrayList<item> items) {
		this.items = items;
		this.maxWeight = 100;
		this.weight = 0;
	}
	
	// Constructor
	// takes int
	public inventory(int maxWeight) {
		this.items = new ArrayList<item>();
		this.maxWeight = maxWeight;
		this.weight = 0;
	}
	
	// Constructor
	public inventory() {
		this.items = new ArrayList<item>();
		this.maxWeight = 100;
		this.weight = 0;
	}
	
	// Gets inventory max weight
	public int getMaxWeight() {
		return maxWeight;
	}
	
	// Gets inventory current weight
	public int getWeight() {
		return weight;
	}
	
	// Adds item to inventory
	// takes item
	// returns boolean
	public boolean addItem(item i) {
		if (i.getWeight() + weight < maxWeight) {
			items.add(i);
			return true;
		}
		return false;
	}
	
	// Removes item from inventory
	// takes item
	// returns boolean
	public boolean removeItem(item i) {
		items.remove(i);
		return true;
	}
	
	// Checks if inventory contains item
	// takes item
	// returns boolean
	public boolean contains(item i) {
		for (item j: items) {
			if (i.equals(j)) {
				return true;
			}
		}
		return false;
	}
	
	// Puts major information into compact string
	// returns String
	public String toString() {
		String rtrn = "";
		for (item i: items) {
			rtrn += "[" + i.getName() + "]";
		}
		return rtrn;
	}
	
	// Puts major information into user friendly string
	// returns String
	public String toString2() {
		String rtrn = "";
		for (item i: items) {
			rtrn += i.getName() + "\n";
		}
		return rtrn;
	}
	
}
