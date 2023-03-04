package javabeans;

public class Perfil {
	private int idPerfil;
	private String nombre;
	private double precioHora;

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

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + ", precio_hora=" + precioHora +"]";
	}

	public Perfil(int idPerfil, String nombre, double precioHora) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.precioHora = precioHora;
	}

	public Perfil() {
		super();
	}

}
