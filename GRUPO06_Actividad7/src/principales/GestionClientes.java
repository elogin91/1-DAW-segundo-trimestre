package principales;

import java.util.Scanner;

public class GestionClientes {
	private int opcion = 0;
	Scanner leer = new Scanner(System.in);
	

	public static void main(String[] args) {

		/*
		 * Hacer una clase con main estático GestionClientes con un menú con las
		 * siguientes opciones:
		 * 
		 * Alta del Cliente Buscar un Cliente Mostrar Todos. Eliminar un cliente Salir
		 */
		GestionClientes gestionandoCliente = new GestionClientes();
		while (gestionandoCliente.opcion != 5) {
			gestionandoCliente.pintaMenu();
			gestionandoCliente.leerOpcion();
			gestionandoCliente.seleccionaOpcion();
		}
	}
	
	private void seleccionaOpcion() {
		if (opcion==1) {
			
		}
		else if (opcion==2) {
			
		}
		else if (opcion==3) {
			
		}
		else if (opcion==4) {
			
		}
		else if (opcion==5) {
			
		}
		else {
			System.out.println("Opción elegida no correcta. Por favor pulse un número correcto.");
		}
		
	}
	
	private int leerOpcion() {
		return Integer.parseInt(leer.nextLine());
		
	}
	
	private void pintaMenu() {
		System.out.println("Iniciando Gestión de Clientes, por favor elija una opción marcando el número:");
		System.out.println("1. Alta de Cliente.");
		System.out.println("2. Buscar un Cliente.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Eliminar un cliente.");
		System.out.println("5. Salir.");
	}
	

}
