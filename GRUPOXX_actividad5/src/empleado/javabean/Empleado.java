package empleado.javabean;

import java.util.Objects;

public class Empleado {
	private int idEmpleado;
	private String nombre, apellidos, email;
	private Double salario, comision;
	private char genero;
	private Trabajo trabajo;
	private Departamento departamento;

	// Constructor por defecto
	public Empleado() {
	}

	// Constructor con parametros
	public Empleado(int idEmpleado, String nombre, String apellidos, String email, Double salario, Double comision,
			char genero, Trabajo trabajo, Departamento departamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.salario = salario;
		this.comision = comision;
		this.genero = genero;
		this.trabajo = trabajo;
		this.departamento = departamento;
	}

	// Getters & Setters
	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	//Devuelve la suma del salario y la comision (complemento se ha refactorizado a comisión)
	public double salarioBruto() {
		return comision + salario;
	}
	
	//Devuelve salario mensual
	public double salarioMensual(int meses) {
		return salarioBruto() / meses;
	}
	
	//Devuelve el literal del Sexo(variable sexo refactorizada a género)
	public String literalSexo() {
		if (genero == 'h' || genero == 'H') {
			return "Hombre";
		} else if (genero == 'm' || genero == 'M') {
			return "Mujer";
		} else {
			return "Caracter no válido.";
		}

	}
	
	//Devuelve un String con la primera letra del nombre + primer apellido, en minúsculas
	public String obtenerEmail() {

		String primerApellido[] = apellidos.split(" ");
		char primeraLetraNombre = nombre.charAt(0);

		return (primeraLetraNombre + primerApellido[0]).toLowerCase();

	}

	//Devuelve la concatenación del nombre + “ “ + apellidos
	public String nombreCompleto() {
		return nombre + " " + apellidos;

	}

	//Redefinir toString en cada clase
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", salario=" + salario + ", comision=" + comision + ", genero=" + genero + ", trabajo="
				+ trabajo + ", departamento=" + departamento + "]";
	}
	
	//Redefinir equals y hashcode: Dos empleados son iguales si su idEmpleado es el mismo.
	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return idEmpleado == other.idEmpleado;
	}
}