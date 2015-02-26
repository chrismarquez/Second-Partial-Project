
public class Ships extends GameObject{
	
	private boolean orientation;
	private	int 	length;
	private ShipSection[] ship;

	public Ships(String coord,boolean orientation,int length){
		super(coord);
		this.orientation = orientation;
		this.length = length;
		this.ship[0] = new ShipSection("",1,this.orientation);
		for (int i = 0; i < this.length - 2; i++) {
			this.ship[i + 1] = new ShipSection("",i + 2,this.orientation);
		}
		this.ship[this.length - 1] = new ShipSection("",this.length,this.orientation);

	}

	public boolean getOrientation() {
		return orientation;
	}

	public int getLength() {
		return length;
	}
	


	public ShipSection[] getShip() {
		return this.ship;
	}
	

}
