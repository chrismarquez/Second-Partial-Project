
public class Ships extends GameObject{
	
	private boolean orientation;

	public Ships(int row, int column, boolean orientation,int length){
		super(row,column);
		this.orientation = orientation;
		this.length = length;
		this.ship = new ShipSection[this.length];
		setSectionCoords(this.orientation);

	}
	
	private void setSectionCoords(boolean orientation) {
		if(orientation) {
			this.ship[0] = new ShipSection(this.coord[0] , this.coord[1],1);
			for (int i = 0; i < this.length - 2; i++) {
				this.ship[i + 1] = new ShipSection(this.coord[0],this.coord[1] + i + 1,i + 2);
			}
			this.ship[this.length - 1] = new ShipSection(coord[0],coord[1] + this.length - 1,this.length);
		} else {
			this.ship[0] = new ShipSection(this.coord[0],this.coord[1],1);
			for (int i = 0; i < this.length - 2; i++) {
				this.ship[i + 1] = new ShipSection(this.coord[0] + i + 1,this.coord[1],i + 2);
			}
			this.ship[this.length - 1] = new ShipSection(coord[0] + this.length - 1,coord[1] + this.length,this.length);
		}
		
	}

	public boolean getOrientation() {
		return this.orientation;
	}

	

}
