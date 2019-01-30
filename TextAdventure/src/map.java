import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class map {

	private String mapFileName = "src/layout.json";
	private File mapFile = new File(mapFileName);
	private String itemFileName = "src/items.json";
	private File itemFile = new File(itemFileName);
	
	private List<area> map = new ArrayList<area>(); // Entire world map
	
	private List<item> items = new ArrayList<item>(); // List of all possible items
	
	// Constructor
	public map() {
		map = new ArrayList<area>();
	}
	
	// Constructor
	// takes array list of area
	public map(List<area> map) {
		this.map = map;
	}
	
	// Loads map and items from JSON file
	public void load() {	
		if(itemFile != null) {
			try {
				Gson gson = new Gson();
				BufferedReader reader = new BufferedReader(new FileReader(itemFile));
				Type type = new TypeToken<ArrayList<item>>(){}.getType();
				items = gson.fromJson(reader, type);
			} catch (FileNotFoundException ex){
				System.out.println(ex);
			}
		}
		
		if(mapFile != null) {
			try {
				Gson gson = new Gson();
				BufferedReader reader = new BufferedReader(new FileReader(mapFile));
				Type type = new TypeToken<ArrayList<tempArea>>(){}.getType();
				map = parseArea(gson.fromJson(reader, type));
			} catch (FileNotFoundException ex){
				System.out.println(ex);
			}
		}
		
	}
	
	// Parses JSON object into area object
	// Takes array list of tempArea
	// returns array list of area
	public ArrayList<area> parseArea(ArrayList<tempArea> tempMap) {
		ArrayList<area> rtrn = new ArrayList<area>();	
		coordinates coord = null;
		inventory inv = null;
		for (tempArea t : tempMap) {
			coord = new coordinates();
			inv = new inventory();
			for (String i : t.getItems()) {
				if (toItem(i) != null) {
					inv.addItem(toItem(i));
				}
			}
			coord.setX(t.getCoord()[0]);
			coord.setY(t.getCoord()[1]);
			coord.setZ(t.getCoord()[2]);
			rtrn.add(new area(t.getTitle(), coord, t.getDesc(), inv));
		}
		return rtrn;
	}
	
	// returns map
	public List<area> getMap() {
		return map;
	}
	
	// returns all items
	public List<item> getItems() {
		return items;
	}
	
	// Tests is String is a possible item
	// Takes String 
	// returns boolean
	public boolean isItem(String item) {
		for (item i: items) {
			if (i.getName().equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	// Converts string into item
	// Takes String
	// returns item
	public item toItem(String item) {
		for (item i: items) {
			if (i.getName().equals(item)) {
				return i;
			}
		}
		return null;
	}
	
	// Checks if area exists in map
	// Takes coordinate
	// returns boolean
	public boolean areaExists(coordinates coord) {
		for (area a: map) {
			if (a.getCoord().equals(coord)) {
				return true;
			}
		}
		return false;
	}
	
}
