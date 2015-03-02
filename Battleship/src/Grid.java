
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
	
}
