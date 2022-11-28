
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "SafeHouse");
	}
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("You are in Safe House.");
		System.out.println("Your health is full again.");
		return true;
		
	}

}
