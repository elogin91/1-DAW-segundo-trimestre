package modelo.javabean;

//La clase Alumno hereda de la clase Persona.
public class Alumno extends Persona{
	
	//Propiedad privada de la clase Curso.
	private String curso;

	//Get & Set.
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	//Constructor.
	public Alumno() {
		super();
	}
	
	//Constructor con parametros,  para las propiedades propias y heredadas.
	public Alumno(String nif, String nombre, String direccion, String telefono, String curso) {
		super(nif, nombre, direccion, telefono);
		this.curso = curso;
	}

	//Sobrescritura del método toString.
	@Override
	public String toString() {
		return  super.toString() + " Curso: " + curso ;
	}
	
	//Método propio de la clase Alumno, que devuelve una cadena que utiliza la propiedad nombre.
	public String hacerExamen() {
		return "El alumno " + this.getNombre() + " va a hacer su examen.";
	}
	
	//Sobrescritura  y especialización del método abstracto trabajar heredado de Persona.
	@Override
	public String trabajar() {
		
		return "El alumno " + this.getNombre()+ " va a estudiar para el curso " + this.getCurso() + ".";
	}

}