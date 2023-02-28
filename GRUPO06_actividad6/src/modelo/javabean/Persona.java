package modelo.javabean;

import java.util.Objects;

//La clase Persona será abstracta.
public abstract class Persona {

	//Propiedades privadas de la clase Persona.
	private String nif;
	private String nombre;
	private String direccion;
	private String telefono;

	//Getters & Setters de las propiedades de la clase Persona.
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	//Constructor.
	public Persona() {
		super();
	}
	
	//Constructor con parámetros.
	public Persona(String nif, String nombre, String direccion, String telefono) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	//Sobrescritura del método toString.
	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	//Sobrescritura del método hashCode.
	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	//Sobrescritura del método equals, dos Personas son iguales si tienen el mismo NIF.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nif, other.nif);
	}
	
	//El método llamar() devolverá una cadena similar a esta: “Alicia Torres llamando 
	//a Carlos Robles”. Como parte de la cadena se utilizará la propiedad nombre del 
	//objeto al que se aplica y del objeto pasado como argumento.
	public String llamar(Persona p) {
		return this.nombre + " llamando a " + p.nombre;
	}

	//El método trabajar()será abstracto, se especializará en cada subclase para devolver una cadena 
	//que indique el tipo de tarea que realizará.
	public abstract String trabajar();
}