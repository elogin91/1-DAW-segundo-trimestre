package javabeans;

import java.sql.Date;

public class Empleado {
	private int idEmpleado;
	Perfil perfil;
	Departamento departamento;
	private String nombre, apellidos, email, password;
	private Double salario;
	private Date fechaIngreso, fechaNacimiento;
	private char genero;

	// Devuelve la suma del salario y la comision (complemento se ha refactorizado a
	// comisión).
	public double salarioBruto() {
		return salario;
	}

	// Devuelve salario mensual.
	public double salarioMensual(int meses) {
		return salarioBruto() / meses;
	}

	// Devuelve el literal del Sexo(variable sexo refactorizada a género).
	public String literalSexo() {
		if (genero == 'h' || genero == 'H') {
			return "Hombre";
		} else if (genero == 'm' || genero == 'M') {
			return "Mujer";
		} else {
			return "Caracter no válido.";
		}

	}

	// Devuelve un String con la primera letra del nombre + primer apellido, en
	// minúsculas.
	public String obtenerEmail() {

		String primerApellido[] = apellidos.split(" ");
		char primeraLetraNombre = nombre.charAt(0);

		return (primeraLetraNombre + primerApellido[0]).toLowerCase();

	}

	// Devuelve la concatenación del nombre + “ “ + apellidos.
	public String nombreCompleto() {
		return nombre + " " + apellidos;

	}

	public Empleado(int idEmpleado, Perfil perfil, Departamento departamento, String nombre, String apellidos,
			String email, String password, Double salario, Date fechaIngreso, Date fechaNacimiento, char genero) {
		super();
		this.idEmpleado = idEmpleado;
		this.perfil = perfil;
		this.departamento = departamento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	public Empleado() {
		super();
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", perfil=" + perfil + ", departamento=" + departamento
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", password=" + password
				+ ", salario=" + salario + ", fechaIngreso=" + fechaIngreso + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + "]";
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

}
