
public class Grid {

	protected GameObject[][] grid;
	
	public Grid() {
		this.grid = new GameObject[10][10];
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				this.grid[i][j] = new Blank(i,j);
			}
		}
	}
	
	
	private void printGridLine(int line) {// Do not touch this
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
	
	private void printSymbols(int x,int y,int row) {
		String field = " ";
		for (int i = x - 1; i < y; i++) {
			field += "  " + this.grid[row - 1][i].getSymbol() +" ";
		}
		System.out.println(field);
	}
	
	public void printGrid() {
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

	public boolean setGameObject (GameObject gameObject){
		if(gameObject instanceof Ships){
			if(!isValid((Ships) gameObject)) {
				return false;
			}
			if(((Ships) gameObject).getOrientation()){
				for (int i = 0; i < ((Ships) gameObject).getLength(); i++) {
					this.grid[((Ships) gameObject).getShip()[0].getCoord()[0]][((Ships) gameObject).getShip()[i].getCoord()[1]] = ((Ships) gameObject).getShip()[i];
					//Get the coordinate from the ShipSection from the ShipSection Array from the object
				}
			} else {
				for (int i = 0; i < ((Ships) gameObject).getLength(); i++) {
					this.grid[((Ships) gameObject).getShip()[i].getCoord()[0]][((Ships) gameObject).getShip()[0].getCoord()[1]] = ((Ships) gameObject).getShip()[i];
					//Get the coordinate from the ShipSection from the ShipSection Array from the object
				}
			}
			
		} else {
			this.grid[gameObject.getCoord()[0]][gameObject.getCoord()[1]] = gameObject;
		}
		
		return true;
	}

	
	public int getGameObject (GameObject gameObject){
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
	
	public boolean isValid(Ships ship) {
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
	
}
