
public class Ships extends GameObject{
	
	private boolean orientation;
	private	int 	length;
	private ShipSection[] ship;

	public Ships(int row, int column, boolean orientation,int length){
		super(row,column);
		this.orientation = orientation;
		this.length = length;
		setSectionCoords(this.orientation);

	}
	
	private void setSectionCoords(boolean orientation) {
		if(orientation) {
			this.ship[0] = new ShipSection(this.coord[0],this.coord[1],1,this.orientation);
			for (int i = 0; i < this.length - 2; i++) {
				this.ship[i + 1] = new ShipSection(this.coord[0],this.coord[1] + i,i + 2,this.orientation);
			}
			this.ship[this.length - 1] = new ShipSection(coord[0],coord[1] + this.length,this.length,this.orientation);
		} else {
			this.ship[0] = new ShipSection(this.coord[0],this.coord[1],1,this.orientation);
			for (int i = 0; i < this.length - 2; i++) {
				this.ship[i + 1] = new ShipSection(this.coord[0] + i,this.coord[1],i + 2,this.orientation);
			}
			this.ship[this.length - 1] = new ShipSection(coord[0] + this.length,coord[1] + this.length,this.length,this.orientation);
		}
	}

	public boolean getOrientation() {
		return this.orientation;
	}

	public int getLength() {
		return this.length;
	}
	


	public ShipSection[] getShip() {
		return this.ship;
	}
	

}
