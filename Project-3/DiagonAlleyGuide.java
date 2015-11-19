import java.util.Hashtable;
import java.util.Scanner;

public class DiagonAlleyGuide {
	
	public static double balance = 0;
	
	public static Hashtable<String, Boolean> inventory = new Hashtable<String, Boolean>();
	
	public static void setInventory(){
		inventory.put("Broom", false);
		inventory.put("School robes", false);
		inventory.put("Wand", false);
		inventory.put("The Standard Book of Spells", false);
		inventory.put("A History of Magic", false);
		inventory.put("Magical Drafts and Potions", false);
		inventory.put("Cauldron", false);
	}
	
	public static int exchangeGalleons(double USD){
		double doubleGalleon = USD / 49.3;
		int galleon = (int) doubleGalleon;
		return galleon;
	}
	
	public static int exchangeSickles(double USD){
		double doubleSickle = USD / 2.9;
		int sickle = (int) doubleSickle;
		return sickle;
	}
	
	public static int exchangeKnuts(double USD){
		double doubleKnut = USD * 10;
		int knut = (int) doubleKnut;
		return knut;
	}
	
	
	public static boolean enoughMoney(int galleon, int sickle, int knut, int cost){
		int wallet = 493 * galleon + 29 * sickle + knut;
		if(wallet < cost){
			return false;
		}
		else {
			return true;
		}
	}
	public static int[] walletToCoins(double wallet){
		int galleon = (int) wallet / 493;
		int temp = (int) wallet % 493;
		int sickle = temp / 29;
		int knut = temp % 29;
		
		int[] array = new int[3];
		array[0] = galleon;
		array[1] = sickle;
		array[2] = knut;
		
		return array;
	}
	public static void balance(int galleon, int sickle, int knut){
		System.out.println("You have " + galleon + " Galleons, " + sickle + " Sickles, and " + knut + " Knuts");
	}
	public static void MainMenu(Scanner input) {
		while(true){
			//prints Main menu
			System.out.println("Main Menu:");
			System.out.println("1. Gringotts Bank");
			System.out.println("2. List of Supplies");
			System.out.println("3. Shoppes");
			System.out.println("4. Leave");
			System.out.println();
			
			//Gets input
			System.out.print("Selection: ");
			int choice = input.nextInt();
			System.out.println();
			
			if ((choice >= 1) && (choice <= 4)){
				switch(choice) {
				case 1: GringottsMenu(input);
						break;
				case 2: System.out.println();
						getInventory(inventory);
						getNeeded(inventory);
						break;
				case 3: ShoppesMenu(input);
						break;
				
				case 4: 
						int count = 0;
						for (String key : inventory.keySet()) {							
							if (inventory.get(key) == false) {
								count++;
							}
						}
						if (count == inventory.size()){
							System.out.println("You have no supplies!");
							System.out.println();
							break;
						}
						else if((count > 0) && (count < inventory.size())){
							System.out.println("Your are missing some items!");
							getNeeded(inventory);
							break;
						}
						else if(count == 0){
							System.out.println("Have a nice day!!");
							System.exit(0);
						}
						System.out.println();
				}
			}
			else{
				System.out.println("Invalid entry!");
			}
		}
	}
	
	public static void GringottsMenu(Scanner input){
		while(true) {
		System.out.println("Gringotts Bank");
		System.out.println("1. Exchange Money");
		System.out.println("2. Check Balance");
		System.out.println("3. Exit");
		System.out.println();
		
		System.out.print("Selection: ");
		
		int choice = input.nextInt();
		
		System.out.println();
		
			if((choice >= 1) && (choice <= 3)){
				switch(choice) {
					case 1: System.out.println("How much would you like to exchange?");
							System.out.print("USD: ");
							double amount = input.nextDouble();
							if ((int) amount < 0){
								System.out.println("Transaction Failed!");
								System.out.println("Input cannot be negative!");
							}
							else {
								balance += exchangeKnuts(amount); 
								System.out.println();
								//System.out.println(balance);
								System.out.println("Transaction Complete!");
							}
							
							break;
					case 2: int[] coins = walletToCoins(balance);
							balance(coins[0],coins[1],coins[2]);
							break;
				}
				if (choice == 3 ) {
					break;
				}
			}
			else{
				System.out.println("Invalid entry!");
			}
			System.out.println();
		}
	}
	
	public static void ShoppesMenu(Scanner input){
		while (true){
			System.out.println("Shoppes");
			System.out.println("1. Broomstix");
			System.out.println("2. Second-Hand Robes");
			System.out.println("3. Olivanders");
			System.out.println("4. Flourish and Blotts");
			System.out.println("5. Potage's Cauldron Shop");
			System.out.println("6. Exit");
			System.out.println();
			System.out.print("Selection: ");
			int choice = input.nextInt();
			System.out.println();
			
			if ((choice >= 1)&&(choice <= 6)){
				switch(choice){
					case 1: while (true){
								System.out.println("Broomstix");
								System.out.println("1. Buy Broom for 1 Galleon");
								System.out.println("2. Exit");
								System.out.println();
								System.out.print("Selection: ");
								int choiceBroom = input.nextInt();
								System.out.println();
								if(choiceBroom == 1){
									if(!inventory.get("Broom")){
										purchaseItem("Broom",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");
									}
								}
								else if (choiceBroom == 2){
									break;
								}
								else{
									System.out.println("Invalid entry!");
								}
								System.out.println();
							}
							break;
					case 2: while (true){
								System.out.println("Second-Hand Robes");
								System.out.println("1. Buy School robes for 12 Sickles");
								System.out.println("2. Exit");
								System.out.println();
								System.out.print("Selection: ");
								int choiceBroom = input.nextInt();
								System.out.println();
								if(choiceBroom == 1){
									if(!inventory.get("School robes")){
										purchaseItem("School robes",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");
									}
								}
								else if (choiceBroom == 2){
									break;
								}
								else{
									System.out.println("Invalid entry!");
								}
								System.out.println();
							}
							break;
					case 3: while (true){
								System.out.println("Olivanders");
								System.out.println("1. Buy Wand for 7 Sickles");
								System.out.println("2. Exit");
								System.out.println();
								System.out.print("Selection: ");
								int choiceBroom = input.nextInt();
								System.out.println();
								if(choiceBroom == 1){
									if(!inventory.get("Wand")){
										purchaseItem("Wand",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");
									}
								}
								else if (choiceBroom == 2){
									break;
								}
								else{
									System.out.println("Invalid entry!");
								}
								System.out.println();
							}
							break;
					case 4: while (true){
								System.out.println("Flourish and Blotts");
								System.out.println("1. Buy The Standard Book of Spells for 5 Sickles");
								System.out.println("2. Buy A History of Magic for 3 Sickles and 12 Knuts");
								System.out.println("3. Buy Magical Drafts and Potions for 27 Knuts");
								System.out.println("4. Exit");
								System.out.println();
								System.out.print("Selection: ");
								int choiceBroom = input.nextInt();
								System.out.println();
								if(choiceBroom == 1){
									if(!inventory.get("The Standard Book of Spells")){
										purchaseItem("The Standard Book of Spells",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");

									}
								}
								else if(choiceBroom == 2){
									if(!inventory.get("A History of Magic")){
										purchaseItem("A History of Magic",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");
								
									}
								}
								else if(choiceBroom == 3){
									if(!inventory.get("Magical Drafts and Potions")){
										purchaseItem("Magical Drafts and Potions",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");
								
									}
								}
								else if (choiceBroom == 4){
									break;
								}
								else{
									System.out.println("Invalid entry!");
								}
								System.out.println();
							}
							break;
					case 5: while (true){
								System.out.println("Potage's Cauldron Shop");
								System.out.println("1. Buy Cauldron for 10 Sickles");
								System.out.println("2. Exit");
								System.out.println();
								System.out.print("Selection: ");
								int choiceBroom = input.nextInt();
								System.out.println();
								if(choiceBroom == 1){
									if(!inventory.get("Cauldron")){
										purchaseItem("Cauldron",inventory,itemValues());
									}
									else{
										System.out.println("Transaction failed!");
										System.out.println("You already have this!");
							
									}
								}
								else if (choiceBroom == 2){
									break;
								}
								else{
									System.out.println("Invalid entry!");
								}
								System.out.println();
							}
							break;
				}
				if (choice == 6 ) {
					break;
				}
			}
		}
	} 
	public static Hashtable<String, Integer> itemValues() {
		//Creates Hashtable
		Hashtable<String, Integer> inventory = new Hashtable<String, Integer>();
		
		inventory.put("Broom", 493);
		inventory.put("School robes", 348);
		inventory.put("Wand", 203);
		inventory.put("The Standard Book of Spells", 145);
		inventory.put("A History of Magic", 99);
		inventory.put("Magical Drafts and Potions", 27);
		inventory.put("Cauldron", 290);
		
		return inventory;
	}
	
	public static void getNeeded(Hashtable<String,Boolean> inventory){
		System.out.println("Need: ");
		System.out.println();
		if (!inventory.get("Broom")){
			System.out.println("Broom");
		}
		if (!inventory.get("School robes")){
			System.out.println("School robes");
		}
		
		if (!inventory.get("Wand")){
			System.out.println("Wand");
		}
		
		if (!inventory.get("The Standard Book of Spells")){
			System.out.println("The Standard Book of Spells");
		}
		
		if (!inventory.get("A History of Magic")){
			System.out.println("A History of Magic");
		}
		
		if (!inventory.get("Magical Drafts and Potions")){
			System.out.println("Magical Drafts and Potions");
		}
		
		if (!inventory.get("Cauldron")){
			System.out.println("Cauldron");
		}
		
		System.out.println();
	}
	//gets items in inventory
	public static void getInventory(Hashtable<String,Boolean> inventory){
		System.out.println("Inventory: ");
		System.out.println();
		if (inventory.get("Broom")){
			System.out.println("Broom");
		}
		if (inventory.get("School robes")){
			System.out.println("School robes");
		}
		
		if (inventory.get("Wand")){
			System.out.println("Wand");
		}
		
		if (inventory.get("The Standard Book of Spells")){
			System.out.println("The Standard Book of Spells");
		}
		
		if (inventory.get("A History of Magic")){
			System.out.println("A History of Magic");
		}
		
		if (inventory.get("Magical Drafts and Potions")){
			System.out.println("Magical Drafts and Potions");
		}
		
		if (inventory.get("Cauldron")){
			System.out.println("Cauldron");
		}
		
		System.out.println();
	}
	
	//purchases item
	public static void purchaseItem(String key, Hashtable<String,Boolean> inventory, Hashtable<String,Integer> price){
		int[] coins = walletToCoins(balance);
		if(!enoughMoney(coins[0],coins[1],coins[2],price.get(key))) {
			System.out.println("Transaction failed!");
			System.out.println("You do not have enough money!");
		}
		else {
			balance -= price.get(key);
			//System.out.println(balance);
			inventory.put(key, true);
			System.out.println("Transaction successful!");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Diagon Alley!");
		System.out.println();
		setInventory();
		MainMenu(input);
	}

}
