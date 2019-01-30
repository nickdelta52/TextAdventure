/* Nick Basti
 * Period 1
 * 6/1/17
 * APCS Final Project
 * 
 * NOTE: I bit off way more than I can chew for the amount of time we had to work on this project, but I did this because I wanted
 * 		 to make a GOOD game not just something to hand in. So as of right now there is not much content to play through and minimal
 * 		 story. Also there are not a ton of features. But as of right now I have a robust and easily expandable system, with easy 
 * 		 content creation with JSON and plenty of room for many more features. I think for this game to be fully up to my standards
 * 		 of what I want it to be it will take another few months. I do plan on continuing this project to bring it to a finished state
 * 		 down the line.
 * 
 * 		 P.S. I am using Google's GSON plugin to parse the JSON file to give credit where credit is due. To view the JSON files i
 * 		 would download a JSON editor from the Eclipse Marketplace.
 * 
 */
public class game {

	private static player player = new player("tempName");
	private static map map = new map();
	private static parser parse = new parser(player, map);
	private static boolean running = false;
	
	// Main game loop
	public static void main(String[] args) {
		boolean charCreated = false;
		
		map.load();
		start();
		while (running) {
			if (!charCreated) {
				System.out.println("Please enter name:");
				player.setName(parse.charCreateParse());
				System.out.println("Type help for a list of commands.");
				charCreated = true;
			}
			parse.parse();
			
		}
	}
	
	// Runs at the start of the game
	public static void start() {
		System.out.println("Hello and welcome to The Cinder Lands! \nType start to begin.");
		boolean finish = false;
		while(!finish) {
			if (parse.startParse() == true) {
				finish = true;
			}
		}
		running = true;
		player.setCoord(new coordinates(0, 0, 0));
		player.addItem(map.getItems().get(0));
	}
	
}
