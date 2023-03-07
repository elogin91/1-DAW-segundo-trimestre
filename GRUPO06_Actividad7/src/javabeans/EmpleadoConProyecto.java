package javabeans;

import java.sql.Date;

public class EmpleadoConProyecto {
	
	//Atributos de la clase EmpleadoConProyecto
	private int numeroOrden, horasAsignadas;
	private Proyecto proyecto;
	private Empleado empleado;
	private Date fechaIncorporacion;
	
	//Método propio que calcula Horas * precio/hora
	public double costeHorasAsignadas() {
		return horasAsignadas * empleado.getPerfil().getPrecioHora();
	}

	//Constructor con parametros.
	public EmpleadoConProyecto(int numeroOrden, int horasAsignadas, Proyecto proyecto,
			Empleado empleado, Date fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.horasAsignadas = horasAsignadas;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.fechaIncorporacion = fechaIncorporacion;
	}

	//Constructor por defecto.
	public EmpleadoConProyecto() {
		super();
	}

	//Sobreescritura del método toString.
	@Override
	public String toString() {
		return "ProyectoConEmpleado [numeroOrden=" + numeroOrden +  ", horasAsignadas="
				+ horasAsignadas + ", proyecto=" + proyecto + ", empleado=" + empleado + ", fechaIncorporacion="
				+ fechaIncorporacion + "]";
	}

	//Getters & Setters.
	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	
	
}
