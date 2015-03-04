import javax.swing.*;

public class UserGrid extends Grid{

	public UserGrid() {
		super();
	}
	
	
	private int rowReader(String coord){ //Interpreta los valores de row (A,B... J)
		int rowCoord = 0;
		if (coord.charAt(0) == 'a' || coord.charAt(0) =='A'){
			rowCoord= 0;
		}
		else if (coord.charAt(0) == 'b' || coord.charAt(0) =='B'){
			rowCoord=  1;
		}
		else if (coord.charAt(0) == 'c' || coord.charAt(0) =='C'){
			rowCoord=  2;
		}
		else if (coord.charAt(0) == 'd' || coord.charAt(0) =='D'){
			rowCoord=  3;
		}
		else if (coord.charAt(0) == 'e' || coord.charAt(0) =='E'){
			rowCoord=  4;
		}
		else if (coord.charAt(0) == 'f' || coord.charAt(0) =='F'){
			rowCoord=  5;
		}
		else if (coord.charAt(0) == 'g' || coord.charAt(0) =='G'){
			rowCoord=  6;
		}
		else if (coord.charAt(0) == 'h' || coord.charAt(0) =='H'){
			rowCoord=  7;
		}
		else if (coord.charAt(0) == 'i' || coord.charAt(0) =='I'){
			rowCoord=  8;
		}
		else if (coord.charAt(0) == 'j' || coord.charAt(0) =='J'){
			rowCoord=  9;
		}
		else{
			rowCoord= -1;
		}
		return rowCoord;
	}
	
	
	public int columnReader(String coord){//Interpreta los valores de column (1,2... 10)
		int column = (Character.getNumericValue(coord.charAt(1)));
		if(column != 1){
			return column;
		}
		
		else{
			if(coord.length() == 2){
				return column;
			}else if (Character.getNumericValue(coord.charAt(2)) == 0){
				return 10;
			}else{
				return -1;
			}
		}
	}

	
	public void setShipsInUserGrid(){//Instancia los 5 barcos del usuario
		JOptionPane.showMessageDialog(null, "Es momento de ordenar tus barcos");
		for (int i=0; i<2; i++){
			//Obtiene la coordenada del barco
			String coord = JOptionPane.showInputDialog("Inserta la coordenada del barco "+(i+1));
			int row =0;
			int column=0;
			//Valida la coordenada
			if (coord.length() == 2 || coord.length() == 3){
				row = this.rowReader(coord);
				column = (this.columnReader(coord)-1);
			}else{
				JOptionPane.showMessageDialog(null, "Coordenada inválida. Intenta de nuevo.");
				this.setShipsInUserGrid();
			}
			
			if(!this.isValidCoord(row, column, this)){
				JOptionPane.showMessageDialog(null, "Coordenada inválida. Intenta de nuevo.");
				this.setShipsInUserGrid();
			}else{
				//Obtiene su orientación
				boolean orientation =false;
				String orientationStr =  JOptionPane.showInputDialog("Inserta su orientación");
				if(orientationStr.equals("horizontal")){
					orientation = true;
				}
				else if (orientationStr.equals("vertical")){
					orientation = false;
				}
				else{
					JOptionPane.showMessageDialog(null, "Orientación inválida. Intenta de nuevo.");
					this.setShipsInUserGrid();
				}
				
				//Crea el barco #i con los inputs recibidos
				Ships ship = new Ships(row, column, orientation, 5-i);
				this.setGameObject(ship);
				this.addShip(ship);
				
				//Muestra tu mapa para ver que barcos haz puesto
				System.out.println("Your Board");
				this.printGrid();
			}
			
		}
	}

	
	public void attackPC(Grid grid){//Realizas un ataque al enemigo
		JOptionPane.showMessageDialog(null, "Es hora de atacar!");
		
		//Recibe la coordenada
		String coord = JOptionPane.showInputDialog("Inserta la coordenada del ataque");
		int row =0;
		int column=0;
		//Valida la coordenada
		if (coord.length() == 2 || coord.length() == 3){
			row = this.rowReader(coord);
			column = (this.columnReader(coord)-1);
		}else{
			JOptionPane.showMessageDialog(null, "Coordenada inválida. Intenta de nuevo.");
			this.attackPC(grid);
		}
		if(this.isValidCoord(row, column, grid)){			
			//Realiza el ataque
			if (this.attackShip(row, column, grid)){
				JOptionPane.showMessageDialog(null, "Nice shot! Le haz dado a uno de sus barcos");
			} else{
				JOptionPane.showMessageDialog(null, "Uyyy! Haz fallado! Suerte a la próxima");
			}
			System.out.println("PC Board");
			grid.printGrid();
		} 
		
		else{
			JOptionPane.showMessageDialog(null, "Coordenada inválida. Intenta de nuevo.");
			this.attackPC(grid);
			
		}
	}

}



