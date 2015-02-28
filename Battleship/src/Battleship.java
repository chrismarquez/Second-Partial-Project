
public class Battleship {

	public static void main(String[] args) {
		UserGrid user = new UserGrid();
		PCGrid PC = new PCGrid();
		
		do {  //Game Loop
			System.out.println("Your Board");
			user.printGrid();
			System.out.println("PC Board");
			PC.printGrid();
		} while (false);

	}

}
