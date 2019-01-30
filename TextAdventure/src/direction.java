import java.util.ArrayList;

public class direction {
	
	public ArrayList<direction> compass = new ArrayList<direction>() {{
		add(new direction("North", 0, 1, 0));
		add(new direction("South", 0, -1, 0));
		add(new direction("East", 1, 0, 0));
		add(new direction("West", -1, 0, 0));
		add(new direction("Up", 0, 0, 1));
		add(new direction("Down", 0, 1, -1));
	}};

	private String text;
	private int dX;
	private int dY;
	private int dZ;
	
	public direction(String text, int dX, int dY, int dZ) {
		this.text = text;
		this.dX = dX;
		this.dY = dY;
		this.dZ = dZ;
	}
	
	public String getText() {
		return text;
	}
	
	public int getdX() {
		return dX;
	}
	
	public int getdY() {
		return dY;
	}
	
	public int getdZ() {
		return dZ;
	}
	
}
