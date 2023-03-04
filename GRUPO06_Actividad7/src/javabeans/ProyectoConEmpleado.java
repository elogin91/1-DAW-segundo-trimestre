package javabeans;

import java.util.Date;

public class ProyectoConEmpleado {
	private int numeroOrden, idEmpleado, horasAsignadas;
	private Proyecto proyecto;
	private Empleado empleado;
	private Date fechaIncorporacion;
	
	public ProyectoConEmpleado(int numeroOrden, int idEmpleado, int horasAsignadas, Proyecto proyecto,
			Empleado empleado, Date fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.idEmpleado = idEmpleado;
		this.horasAsignadas = horasAsignadas;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public ProyectoConEmpleado() {
		super();
	}

	@Override
	public String toString() {
		return "ProyectoConEmpleado [numeroOrden=" + numeroOrden + ", idEmpleado=" + idEmpleado + ", horasAsignadas="
				+ horasAsignadas + ", proyecto=" + proyecto + ", empleado=" + empleado + ", fechaIncorporacion="
				+ fechaIncorporacion + "]";
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
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
