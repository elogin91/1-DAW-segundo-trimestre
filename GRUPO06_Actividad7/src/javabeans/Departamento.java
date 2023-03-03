package javabeans;

public class Departamento {
	private int idDepartamento;
	private String nombre, direccion;

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
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

	public Departamento() {
		super();
	}

	public Departamento(int idDepartamento, String nombre, String direccion) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", direccion=" + direccion
				+ "]";
	}

}
