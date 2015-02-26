
public class ShipSection extends GameObject{

	private int location;
	private int shipLength;
	
	public ShipSection(String coords, int location, boolean orientation) {
		super(coords);
		this.location = location;
		setSymbol(this.location, orientation);		
	}
	
	public int getLocation() {
		return this.location;
	}
	
	private void setSymbol(int location, boolean orientation) {
		if(this.location == 1) {
			if (orientation) {
				this.symbol = '<';
			}
		} else if (this.location == this.shipLength) {				
			if (orientation) {
				this.symbol = '=';
				}
		} else {
			if (orientation) {
				this.symbol = '>';
				}
		}
	}
}
