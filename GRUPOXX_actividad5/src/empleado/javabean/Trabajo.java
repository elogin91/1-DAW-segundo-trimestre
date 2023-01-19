package empleado.javabean;

import java.util.Objects;

public class Trabajo {
	private String idTrabajo, descripcion;
	private Double minSalario, maxSalario;

	public Trabajo() {
	}
	
	public Trabajo(String idTrabajo, String descripcion, Double minSalario, Double maxSalario) {
		super();
		this.idTrabajo = idTrabajo;
		this.descripcion = descripcion;
		this.minSalario = minSalario;
		this.maxSalario = maxSalario;
	}

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

	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", descripcion=" + descripcion + ", minSalario=" + minSalario
				+ ", maxSalario=" + maxSalario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idTrabajo, maxSalario, minSalario);
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
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idTrabajo, other.idTrabajo)
				&& Objects.equals(maxSalario, other.maxSalario) && Objects.equals(minSalario, other.minSalario);
	}

}
