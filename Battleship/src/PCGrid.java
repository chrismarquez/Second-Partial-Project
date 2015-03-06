import java.util.Random;

import javax.swing.JOptionPane;

public class PCGrid extends Grid{

	
	public PCGrid() {
		super();
	}
	
	public void setShipsInPcGrid(){//PC situa sus 4 barcos
		JOptionPane.showMessageDialog(null, "Tu enemigo está ordenando sus barcos.");
		boolean flag = false;
		for (int i=0; i<4; i++){
			do {
				//Genera la coordenada
				
				Random randomInt = new Random();
				int row = (randomInt.nextInt(10-(5-i)));
				int column = (randomInt.nextInt(10-(5-i)));
				System.out.println("Row: "+row+", Column: "+column);
				
				//Recibe y valida orientación
				Random randomBoolean = new Random();
				boolean orientation = (randomBoolean.nextBoolean());
				System.out.println("Orientation: "+orientation);
				
				//Crea el barco #i con los inputs recibidos
				Ships ship = new Ships(row, column, orientation, 5-i);
				flag = this.setGameObject(ship);
					
				//Muestra el mapa para ver que barcos haz puesto
				System.out.println("PC Board");
				this.printGrid();
			} while(!flag);
		}
	}
	
	public void attackUser(Grid grid){//PC ataca al User
		JOptionPane.showMessageDialog(null, "Es el turno del enemigo! Estás listo?");
		
		//Genera la coordenada
		Random randomInt = new Random();
		int row = (randomInt.nextInt(10));
		int column = (randomInt.nextInt(10));
		
		JOptionPane.showMessageDialog(null, "El enemigo ha disparado en "+this.coordTranslator(row, column)+"!");
				
		if (this.attackShip(row, column, grid)){
			JOptionPane.showMessageDialog(null, "Chale! Te han dañado!");
		} else{
			JOptionPane.showMessageDialog(null, "Uff, estuvo cerca");
		}
		System.out.println("User Board");
		grid.printGrid(); 
	}
	
	public String coordTranslator(int row, int column){//Transcribe las coordenadas de la PC
		String rowStr = "";
		String columnStr = Integer.toString(column) ;
		
		switch(row){
			case 0:
				rowStr= "A";
				break;
			case 1:
				rowStr= "B";
				break;
			case 2:
				rowStr= "C";
				break;
			case 3:
				rowStr= "D";
				break;
			case 4:
				rowStr= "E";
				break;
			case 5:
				rowStr= "F";
				break;
			case 6:
				rowStr= "G";
				break;
			case 7:
				rowStr= "H";
				break;
			case 8:
				rowStr= "I";
				break;
			case 9:
				rowStr= "J";
				break;
		}
		
		return rowStr+columnStr;
	}
	
}



