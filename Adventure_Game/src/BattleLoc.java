
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	
	public BattleLoc(Player player, String name,Obstacle obstacle, String award ) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}
	public boolean getLocation() {
		int  obsCount = obstacle.count();
		System.out.println("You are in " + this.getName());
		System.out.println("Attention! This place has " + obsCount +" "+obstacle.getName()+".");
		System.out.print("<F>ight or <R>un");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("F")) {
			if (combat(obsCount)) {
				System.out.println("You defeated the enemies in " + this.getName());
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println("You won  "+this.award);
					player.getInv().setFood(true);
				}else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println("You won  "+this.award);
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println("You won  "+this.award);
					player.getInv().setFirewood(true);
				}
				return true;
			} 
			if (player.getHealthy() <= 0) {
				System.out.println("You  died");
				return false;
			}
			return true;
		}
		
		return true;
		
	}
	
	public boolean combat(int obsCount){
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStatus();
			enemyStatus();
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.println("<H>it or <R>un");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You hit");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth() > 0) {
						System.out.println("");
						System.out.println("Enemy hit you");
						player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getAvoid()));
						afterHit();
					}				
				}
				else {
					return false;
				}
			}
			if (obstacle.getHealth() < player.getHealthy()) {
				System.out.println("You defeated the enemy");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Updated Money: " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			}
			else {
				return false;
			}
			System.out.println("---------------------------------------");
		}
		
		
		
		return true;
	}
	private void enemyStatus() {
		System.out.println(obstacle.getName() + " Status\n---------------------");
		System.out.println("Health: " + obstacle.getHealth());
		System.out.println("Damage: " + obstacle.getDamage());
		System.out.println("Award: " + obstacle.getAward());
		
	}
	private void playerStatus() {
		System.out.println("Player Status\n--------------------- ");
		System.out.println("Health: " + player.getHealthy());
		System.out.println("Damage: " + player.getTotalDamage());
		System.out.println("Money: " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Weapon: "+ player.getInv().getwName());
		}
		if (player.getInv().getAvoid() > 0) {
			System.out.println("Avoid: "+ player.getInv().getaName());
		}
		System.out.println("");
	}
	public void afterHit() {
		System.out.println("Player Health: " + player.getHealthy());
		System.out.println(obstacle.getName() + " has " + obstacle.getHealth());
		System.out.println();
	}

}
