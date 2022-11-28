import java.util.Scanner;

public class Player {
	private int damage,healthy,money,rHealthy,avoid;
	public int getAvoid() {
		return avoid;
	}

	public void setAvoid(int avoid) {
		this.avoid = avoid;
	}

	private String name,cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectCha() {
		switch (chaMenu()) {
		case 1:
			initPlayer("Samuray",5,21,15);
			break;
		case 2:
			initPlayer("Archer",7,18,20);
			break;
		case 3:
			initPlayer("Knight",8,24,5);
			break;
		default:
			initPlayer("Samuray",5,21,15);
			break;
		}
		System.out.println("Character is: " + getcName()+ "\tDamage:" + getDamage()+ "\tHealth:"+ getHealthy()+"\tMoney:"+getMoney() );
	}
	
	public int chaMenu() {
		System.out.println("Please pick a character :");
		System.out.println("Type_1: Samuray\t Damage: 5\t Health: 21\t Money: 15 ");
		System.out.println("Type_2: Archer\t Damage: 7\t Health: 18\t Money: 20 ");
		System.out.println("Type_3: Knight\t Damage: 8\t Health: 24\t Money: 5 ");
		System.out.print("Your character choice is: ");
		int chaID = scan.nextInt();
		while (chaID<1 || chaID>3) {
			System.out.println("Please pick a valid type of character!");
			chaID = scan.nextInt();
		}
		
		return chaID;
	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
	}
	public int getTotalAvoid() {
		return this.getAvoid() + this.getInv().getAvoid();
	}
	
	public void initPlayer(String cName, int damage,int health, int money) {
		setcName(cName);
		setDamage(damage);
		setHealthy(health);
		setMoney(money);
		setrHealthy(health);
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealthy() {
		return healthy;
	}
	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
}
