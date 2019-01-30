import java.util.Scanner;

public class parser {

	private commands c = null;
	private player p = null;
	private map m = null;
	
	Scanner scan = new Scanner(System.in);
	String input = null;
	String[] splitInput = null;
	String arg1 = "";
	String arg2 = "";
	String arg3 = "";
	String output = null;

	// Constructor
	// takes player, map
	public parser(player p, map m) {
		this.p = p;
		this.m = m;
		c = new commands(p, m);
	}
	
	// Used to parse user input
	// returns String
	public String parse() {
		String cmd = null;
		output = null;
		input = scan.nextLine().toLowerCase();
		splitInput = input.split(" ");
		if (splitInput.length >= 1) {
			arg1 = splitInput[0];
		}
		if (splitInput.length >= 2) {
			arg2 = splitInput[1];
		}
		if (splitInput.length >= 3) {
			arg3 = splitInput[2];
		} 
		
		switch(arg1) {
		case "help" :
			output = c.help();
			break;
		case "look" :
			if (arg2.equals("at")) {
				output = c.lookAt(arg3);
				break;
			}
			output = c.look();
			break;
		case "walk":
		case "run":
		case "move":
		case "go":
			switch(arg2) {
			case "n":
			case "north": 
				output = c.move("n");
				break;
			case "s":
			case "south":
				output = c.move("s");
				break;
			case "e":
			case "east":
				output = c.move("e");
				break;
			case "w":
			case "west":
				output = c.move("w");
				break;
			case "u":
			case "up": 
				output = c.move("u");
				break;
			case "d":
			case "down": 
				output = c.move("d");
				break;
			default :
				output = "That is not a valid direction.";
				break;
			}
			break;		
		case "take":
			if (m.isItem(arg2)) {
				output = c.take(arg2);
			} else {
				output = "That is not valid item.";
			}
			break;
		case "drop":
			if (m.isItem(arg2)) {
				output = c.drop(arg2);
			} else {
				output = "That is not a valid item.";
			}
			break;
		case "inv":
		case "inventory":
			output = c.inventory();
			break;
		case "item":
			if (arg2.equals("list")) {
				output = c.itemList();
				break;
			}
			output = "That is not a valid command.";
			break;
		case "coord":
			output = c.coord();
			break;
		default:
			output = "That is not a valid command.";
			break;
		}
		
		System.out.println(output);
		return cmd;	
	}
	
	// Used to parse start
	public boolean startParse() {
		boolean rtrn = false;
		input = scan.nextLine().toLowerCase();
		splitInput = input.split(" ");
		
		if (splitInput.length == 1) {
			arg1 = splitInput[0];
		} else {
			output = "That is not a valid command.";
		}
		
		if (arg1.equals("start") || arg1.equals("s")) {
			output = "The game has started!";
			rtrn = true;
		} else {
			output = "That is not a valid command.";
		}
		
		System.out.println(output);
		return rtrn;
	}
	
	// Used to parse character creation	
	public String charCreateParse() {
		String rtrn = "tempName";
		input = scan.nextLine().toLowerCase();

		rtrn = input;
		
		System.out.println("Good luck " + rtrn + " you will need it!");
		return rtrn;
	}

}
