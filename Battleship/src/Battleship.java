import javax.swing.JOptionPane;


public class Battleship {
	
	public static int eventHandler(Grid user, Grid PC) {
		int result;
		int PCShips = 0;
		int userShips = 0;
		for (int i = 0; i < user.getAliveShips().length; i++) {
			if(user.getAliveShips()[i] instanceof Ships) {
				if (user.getAliveShips()[i].getHP() == 0) {
					user.getAliveShips()[i] = null;
					JOptionPane.showMessageDialog(null, "Que mal! Tu barco se ha hundido. Vamos!");
				}
			}
		}
		for (int i = 0; i < PC.getAliveShips().length; i++) {
			if(PC.getAliveShips()[i] instanceof Ships) {
				if (PC.getAliveShips()[i].getHP() == 0) {
					PC.getAliveShips()[i] = null;
					JOptionPane.showMessageDialog(null, "Eso, has hundido el barco");
				}
			}
		}
		
		for (int i = 0; i < user.getAliveShips().length; i++) {
			if (user.getAliveShips()[i] != null) {
				userShips++;
			}
		}
		
		for (int i = 0; i < PC.getAliveShips().length; i++) {
			if (PC.getAliveShips()[i] != null) {
				PCShips++;
			}
		}
		
		if(userShips == 0) {
			result = 2;
		} else if (PCShips == 0) {
			result = 1;
		} else {
			result = 3;
		}
		
		return result;
	}

	public static void main(String[] args) {
		UserGrid user = new UserGrid();
		PCGrid PC = new PCGrid();
		System.out.println("Your Board");
		user.printGrid();
		user.setShipsInUserGrid();
		PC.setShipsInPcGrid();
		
		do {  //Game Loop
	
			//Inicializa el juego, obteniendo los barcos del usuario
			
			
			//Empieza la batalla!
			user.attackPC(PC);
			PC.attackUser(user);
			
			
			
		} while (eventHandler(user, PC) == 3);
		
		System.out.println("Resultado final...");
		System.out.println("Your Board");
		user.printGrid();
		System.out.println("PC Board");
		PC.printGrid();

	}

}