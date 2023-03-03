package javabeans;

public class Cliente {

	private String cif, nombre, apellidos, domicilio;
	private Double facturacionAnual;
	private int numeroEmpleado;

	public Cliente() {
		super();
	}

	public Cliente(String cif, String nombre, String apellidos, String domicilio, Double facturacionAnual,
			int numeroEmpleado) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Double getFacturacionAnual() {
		return facturacionAnual;
	}

	public void setFacturacionAnual(Double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
				+ ", facturacionAnual=" + facturacionAnual + ", numeroEmpleado=" + numeroEmpleado + "]";
	}


}
