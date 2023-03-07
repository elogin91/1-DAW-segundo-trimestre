package javabeans;

import java.sql.Date;
import java.time.temporal.ChronoUnit;

public class Proyecto {

	// Atributos de la clase proyecto.
	private String idProyecto, descripcion, estado;
	private Date fechaInicio, fechaFinPrevisto, fechaFinReal;
	private Double ventaPrevista, costePrevisto, costeReal;
	private Empleado jefeProyecto;
	private Cliente cliente;

	// Constructor con parametros.
	public Proyecto(String idProyecto, String descripcion, String estado, Date fechaInicio, Date fechaFinPrevisto,
			Date fechaFinReal, Double ventaPrevista, Double costePrevisto, Double costeReal, Empleado jefeProyecto,
			Cliente cliente) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevista = ventaPrevista;
		this.costePrevisto = costePrevisto;
		this.costeReal = costeReal;
		this.jefeProyecto = jefeProyecto;
		this.cliente = cliente;
	}

	// Método propio margén previsto.
	public double margenPrevisto() {

		return ventaPrevista - costePrevisto;
	}

	// Método propio margén real.
	public double margenReal() {

		return ventaPrevista - costeReal;
	}

	// Método propio diferencia de gastos real y previsto.
	public double diferenciaGastos() {

		return costeReal - costePrevisto;
	}

	// Método propio diferencia de días previstos y reales.
	public int diferenciaFinPrevistoReal() {
		long dias = ChronoUnit.DAYS.between(fechaFinPrevisto.toInstant(), fechaFinReal.toInstant());
		return (int) dias;
	}

	// Constructor por defecto.
	public Proyecto() {
		super();
	}

	// Getters & Setters.
	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Double getVentaPrevista() {
		return ventaPrevista;
	}

	public void setVentaPrevista(Double ventaPrevista) {
		this.ventaPrevista = ventaPrevista;
	}

	public Double getCostePrevisto() {
		return costePrevisto;
	}

	public void setCostePrevisto(Double costePrevisto) {
		this.costePrevisto = costePrevisto;
	}

	public Double getCosteReal() {
		return costeReal;
	}

	public void setCosteReal(Double costeReal) {
		this.costeReal = costeReal;
	}

	public Empleado getJefeProyecto() {
		return jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Sobreescritura del método toString.
	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", fechaInicio=" + fechaInicio + ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal="
				+ fechaFinReal + ", ventaPrevista=" + ventaPrevista + ", costePrevisto=" + costePrevisto
				+ ", costeReal=" + costeReal + ", jefeProyecto=" + jefeProyecto + ", cliente=" + cliente + "]";
	}

}
