package javabeans;

public class Factura {

	// Atributos de la clase Factura.
	private String idFactura, descripcion;
	private Proyecto proyecto;

	// Constructor con parametros.
	public Factura(String idFactura, String descripcion, Proyecto proyecto) {
		super();
		this.idFactura = idFactura;
		this.descripcion = descripcion;
		this.proyecto = proyecto;
	}

	// Constructor por defecto.
	public Factura() {
		super();
	}

	// Setters & Getters.
	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	// Sobreescritura del método toString.
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", descripcion=" + descripcion + ", proyecto=" + proyecto + "]";
	}

}
