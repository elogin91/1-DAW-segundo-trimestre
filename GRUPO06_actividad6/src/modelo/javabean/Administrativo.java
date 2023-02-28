package modelo.javabean;

//La clase Administrativo heredará de la clase Persona.
public class Administrativo extends Persona{

	//Propiedad  privada de la clase Administrativo.
	private String tareas;
	
	//Get & Set.
	public String getTareas() {
		return tareas;
	}

	public void setTareas(String tareas) {
		this.tareas = tareas;
	}

	//Constructor.
	public Administrativo() {
		super();
	}
	
	//Constructor de la case Administrativo, con parametros de sus propieades propias y heredadas.
	public Administrativo(String nif, String nombre, String direccion, String telefono, String tareas) {
		super(nif, nombre, direccion, telefono);
		this.tareas = tareas;
	}
	
	//Sobrescritura del método toString.
	@Override
	public String toString() {
		return  super.toString() + " Tareas: " + tareas ;
	}

	//Método propio de la clase Administrativo, que devuelve una cadena que utiliza la propiedad nombre.
	public String gestionarMatricula() {
		return "El administrativo " + this.getNombre() + " va a gestionar una matrícula.";
	}

	//Sobrescritura  y especialización del método abstracto trabajar heredado de Persona.
	@Override
	public String trabajar() {
		
		return "El administrativo" + this.getNombre() + " va a realizar estas tareas: " + this.getTareas() + ".";
	}
	
}
