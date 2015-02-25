
public class Ships extends GameObject{
	
	private boolean orientation;
	private	int 	length;
	private char[] ship;

	private char symbol2,
				symbol3;
	
	public Ships(String coord,boolean orientation,int length){
		super(coord);
		this.orientation = orientation;
		this.length = length;
		this.setSymbol(this.orientation);
		this.ship = new char[this.length];
		this.ship[0] = symbol;
		for (int i = 0; i < this.length - 2; i++) {
			this.ship[i + 1] = symbol2;
		}
		this.ship[this.length - 1] = symbol3;
	}

	public boolean getOrientation() {
		return orientation;
	}

	public int getLength() {
		return length;
	}
	
	public char[] getSymbol() {
		return this.ship;
	}
	
	public void setSymbol(boolean orientation) {
		if (orientation) {
			this.symbol = '<';
			this.symbol2 = '=';
			this.symbol3 = '>';
		} else { // Check for Unicode values
			this.symbol = '<';
			this.symbol2 = '=';
			this.symbol3 = '>';
		}
	}



}
