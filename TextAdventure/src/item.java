
public class item {
	
	private String name;
	private int id;
	private String type;
	private String description;
	private int weight;
	
	// Constructor
	// takes String, int, String, String, int
	public item(String name, int id, String type, String description, int weight) {
		this.name = name;
		this.id = id;
		this.type = type;
		this.description = description;
		this.weight = weight;
	}
	
	// Gets item name
	// returns String
	public String getName() {
		return name;
	}
	
	// Sets item name
	// takes String
	public void setName(String name) {
		this.name = name;
	}
	
	// Gets item id
	// returns int
	public int getId() {
		return id;
	}
	
	// Sets item id
	// takes int
	public void setId(int id) {
		this.id = id;
	}
	
	// Gets item type
	// returns String
	public String getType() {
		return type;
	}
	
	// Sets item type
	// takes String
	public void setType(String type) {
		this.type = type;
	}
	
	// Gets item description
	// returns String
	public String getDescription() {
		return description;
	}
	
	// Sets item description
	// takes String
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Gets item weight
	// returns int
	public int getWeight() {
		return weight;
	}
	
	// Sets item weight
	// takes int
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	// Checks if two items are equal
	// takes item
	// returns boolean
	public boolean equals(item i) {
		if (getId() == i.getId()) {
			return true;
		} else {
			return false;
		}
	}
	
	// Puts items major information into string
	// returns String
	public String toString() {
		return name + ", " + Integer.toString(id) + ", " + type + ", " + description + ", " + Integer.toString(weight);
	}
	
}
