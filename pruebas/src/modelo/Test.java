package modelo;

public class Test {
	
	public static void main(String[] args) {
		Animal animal, gato, gato2;
	
		animal= new Animal ();
		gato = new Gato();
		gato2 = new Animal();
		
		System.out.println(animal.saludar());
		System.out.println(gato.saludar());
		System.out.println(gato2.saludar());
		//System.out.println(((Gato)gato).vida()); hay que castearlo para que vea los métodos de la clase gato
	}

}
