import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	public void login() {
		System.out.println("Welcome to adventure game..!");
		System.out.println("Please enter your name before the game starts");
		//String playerName = scan.nextLine();
		player = new Player("a");
		player.selectCha();
		start();
	}
	public void start() {
		while (true) {
			System.out.println();
			System.out.println("==================================================");
			System.out.println();
			System.out.println("Pick a place you want to go");
			System.out.println("1. Safe House\t --> Place that you are safe, no enemy!");
			System.out.println("2. Cave\t\t --> Attention! You may see zombie here. ");
			System.out.println("3. Forrest\t --> Attention! You may see vampire here.");
			System.out.println("4. River\t --> Attention! You may see bear here.");
			System.out.println("5. Store\t --> Place that you can buy weapon or armor");
			System.out.print("Place that you want to go: ");
			int selLoc = scan.nextInt();
			while (selLoc<1 || selLoc>5) {
				System.out.print("Please pick a valid Location!");
				selLoc = scan.nextInt();
			}

			switch(selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);	
			}
			
			if (location.getClass().getName().equals(("SafeHouse"))) {
				if (player.getInv().isWater()&&player.getInv().isFood() && player.getInv().isFirewood()) {
					System.out.println("Congratulations! You won the game");
					break;
				}
			}
			
			if (!location.getLocation()) {
				System.out.println("Oyun bitti!");
				break;
			}
		}

	}
}
