
public class ToolStore extends NormalLoc {
	
	public ToolStore(Player player) {
		super(player ,"ToolStore");
	}

	public boolean getLocation() {
		System.out.println("Money: " + player.getMoney());
		System.out.println("1. Weapons");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.print("Your choice is: ");
		int selTool = scan.nextInt();
		int selItemID;
		
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
		
		return true;
		
	}

	private void buyWeapon(int itemID) {
		int damage = 0,price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Gun";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Exiting..");
			break;

		default:
			System.out.println("Unvalid process..!");
			break;
		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println("You bought a " +wName +". Previous damage is: " + player.getDamage()+ "\tNew damage is: " + player.getTotalDamage());
				System.out.println("Available balance: "+ player.getMoney());
				
			} else {
				System.out.println("Insufficient balance");
			}
		}
		
	}
	
	private void buyArmor(int itemID) {
		int avoid = 0,price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Light";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Middle";
			price = 25;
			break;
		case 3:
			avoid = 5;
			aName = "Heavy";
			price = 40;
			break;
		case 4:
			System.out.println("Exiting..");
			break;

		default:
			System.out.println("Unvalid process..!");
			break;
		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setAvoid(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println("You bought a " +aName +". Previous armor is: " + player.getAvoid()+ "\tNew armor is: " + player.getTotalAvoid());
				System.out.println("Available balance: "+ player.getMoney());
				
			} else {
				System.out.println("Insufficient balance");
			}
		}
		
	}
	private int armorMenu() {
		System.out.println("1. Light\t <Money : 15 - Avoid : 1>");
		System.out.println("2. Middle\t <Money : 25 - Avoid : 3>");
		System.out.println("3. Heavy\t <Money : 40 - Avoid : 5>");
		System.out.println("4. Exit");
		System.out.println("Your Armor choice: ");
		int selArmorID = scan.nextInt();
		return selArmorID;
		
	}
	
	
	

	private int weaponMenu() {
		System.out.println("1. Gun\t\t <Money : 25 - Damage : 2>");
		System.out.println("2. Sword\t <Money : 35 - Damage : 3>");
		System.out.println("3. Rifle\t <Money : 45 - Damage : 7>");
		System.out.println("4. Exit");
		System.out.println("Your Weapon choice: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
		
	}

}
