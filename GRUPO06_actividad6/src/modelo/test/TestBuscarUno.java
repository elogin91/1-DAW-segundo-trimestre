package modelo.test;

import modelo.dao.Instituto;

public class TestBuscarUno {

	public static void main(String[] args) {
		
		//Probando creación de Instituto
		Instituto instituto = new Instituto();
		
		//Probando Buscar Persona
		System.out.println("La persona que ha buscado por Nif es: ");
		
		System.out.println(instituto.buscarPersona("111111111A"));
		
		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");

	}

}
