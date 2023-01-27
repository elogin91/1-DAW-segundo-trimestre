package modelo.javabean;

import java.util.Objects;

public class Trabajo {
	private String idTrabajo, descripcion;
	private Double minSalario, maxSalario;

	// Constructor por defecto.
	public Trabajo() {
	}

	// Constructor con parámetros.
	public Trabajo(String idTrabajo, String descripcion, Double minSalario, Double maxSalario) {
		super();
		this.idTrabajo = idTrabajo;
		this.descripcion = descripcion;
		this.minSalario = minSalario;
		this.maxSalario = maxSalario;
	}

	// Getters & Setters.
	public String getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(String idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMinSalario() {
		return minSalario;
	}

	public void setMinSalario(Double minSalario) {
		this.minSalario = minSalario;
	}

	public Double getMaxSalario() {
		return maxSalario;
	}

	public void setMaxSalario(Double maxSalario) {
		this.maxSalario = maxSalario;
	}

	// Redefinir toString en cada clase.
	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", descripcion=" + descripcion + ", minSalario=" + minSalario
				+ ", maxSalario=" + maxSalario + "]";
	}

	// Redefinir equals y hashcode: Dos trabajos son iguales si su idTrabajo es la
	// misma.
	@Override
	public int hashCode() {
		return Objects.hash(idTrabajo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajo other = (Trabajo) obj;
		return Objects.equals(idTrabajo, other.idTrabajo);
	}
}
