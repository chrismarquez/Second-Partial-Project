
public class Grid {

	private GameObject[][] grid; // Hosts all game objects on the grid
	public Ships[] aliveShips; // Hosts all alive ships on the grid
	
	public Grid() { //Constructs a new grid and fills it with Blank game objects.
		this.grid = new GameObject[10][10];
		this.aliveShips = new Ships[5];
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				this.grid[i][j] = new Blank(i,j);
			}
		}
	}
	
	
	private void printGridLine(int line) {// Do not touch this. //Prints an empty grid to the screen.
		String textLine = " ";
		switch(line) {
			case 1:				
				textLine += "╔ ";
				for(int i = 0; i < 9; i++) {
					textLine += "  ╦ ";
				}
				textLine += "  ╗";
				System.out.println(textLine);
				break;
			case 2:
				textLine += "║ ";
				for(int i = 0; i < 9; i++) {
					textLine += "  ╬ ";
				}
				textLine += "  ║";
				System.out.println(textLine);
				break;
			case 3:
				textLine += "╚ ";
				for(int i = 0; i < 9; i++) {
					textLine += "  ╩ ";
				}
				textLine += "  ╝";
				System.out.println(textLine);
		}
	}
	
	private void printSymbols(int x,int y,int row) { //Pulls data from the grid array and prints it to the screen
		String field = " ";
		for (int i = x - 1; i < y; i++) {
			field += "  " + this.grid[row - 1][i].getSymbol() +" ";
		}
		System.out.println(field);
	}
	
	public void printGrid() { //Prints a grid
		printGridLine(1);
		printSymbols(1,10,1);
		for (int i = 2; i < 10; i++) {
			printGridLine(2);
			printSymbols(1,10,i);
		}
		printGridLine(2);
		printSymbols(1,10,10);
		printGridLine(3);
	}

	public boolean setGameObject (GameObject gameObject){ //Sets a GameObject in the grid.
		if(gameObject instanceof Ships){
			if(!isValid((Ships) gameObject)) {
				return false;
			}
			if(((Ships) gameObject).getOrientation()){
				for (int i = 0; i < ((Ships) gameObject).getLength(); i++) {
					this.grid[((Ships) gameObject).getShip()[0].getCoord()[0]]/*   */[((Ships) gameObject).getShip()[i].getCoord()[1]] = ((Ships) gameObject).getShip()[i];
					// Get the coordinate from the ShipSection from the ShipSection Array from the object
				}
			} else {
				for (int i = 0; i < ((Ships) gameObject).getLength(); i++) {
					this.grid[((Ships) gameObject).getShip()[i].getCoord()[0]]/*   */[((Ships) gameObject).getShip()[0].getCoord()[1]] = ((Ships) gameObject).getShip()[i];
					// Get the coordinate from the ShipSection from the ShipSection Array from the object
				}
			}
			
			return this.addShip(((Ships) gameObject));
			
		} else {
			this.grid[gameObject.getCoord()[0]][gameObject.getCoord()[1]] = gameObject;
			return true;
		}
	}
	
	public int getGameObject (GameObject gameObject){ //Returns a number representing the type of the GameObject.
		int typeObject =0;
		if (gameObject instanceof ShipSection){
			typeObject= 1;
		}
		else if (gameObject instanceof Shots || gameObject instanceof Explosion){
			typeObject= 2;
		}
		else if (gameObject instanceof Blank){
			typeObject= 3;
		}
		return typeObject;
	}
	
	public boolean isValid(Ships ship) {  // Validates the position of the ship on the grid.
		boolean orientation = ship.getOrientation();
		if(orientation) {
			if(ship.getLength() + ship.getCoord()[1] <= 10) {
					return true;
				}
		} else {
			if(ship.getLength() + ship.getCoord()[0] <= 10) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addShip(Ships ship) { // Add the ship to the array in order to keep track of ships on the grid.
		for (int i = 0; i < this.aliveShips.length; i++) {
			if (this.aliveShips[i] == null) {
				this.aliveShips[i] = ship;
				return true;
			}
		}
		return false;
	}
	
	public boolean attackShip(int row, int column, Grid grid){//Ataca al barco enemigo
		boolean attempt = true;
		
		if(grid.getGameObject(grid.getGrid()[row][column]) == 1){
			attempt = true;
			grid.setGameObject(new Explosion(row, column));
		}
		else if(grid.getGameObject(grid.getGrid()[row][column]) ==  2){
			attempt = false;
		}
		else{
			attempt = false;
			grid.setGameObject(new Shots(row, column));
		}
		
		return attempt;
	}
	
	public GameObject[][] getGrid(){//Obtiene el valor de los atributos deseados
		
		return this.grid;
	}

}




