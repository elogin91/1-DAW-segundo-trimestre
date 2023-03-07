package javabeans;

public class Perfil {

	// Atributos de la clase Perfil.
	private int idPerfil;
	private String nombre;
	private double precioHora;

	// Getters & Setters.
	public double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Sobreescritura del método toString.
	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + ", precio_hora=" + precioHora + "]";
	}

	// Constructor con parametros.
	public Perfil(int idPerfil, String nombre, double precioHora) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.precioHora = precioHora;
	}

	// Constructor por defecto.
	public Perfil() {
		super();
	}

}
