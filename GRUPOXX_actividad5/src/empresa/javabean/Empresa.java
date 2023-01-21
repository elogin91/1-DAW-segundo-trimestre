package empresa.javabean;

import java.util.ArrayList;

import empleado.javabean.Departamento;
import empleado.javabean.Empleado;
import empleado.javabean.Localidad;
import empleado.javabean.Trabajo;

public class Empresa implements IntGestionEmpresa {
	private String nombre;
	private ArrayList<Empleado> plantilla;

	// Getter an setter SOLO de nombre.
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Un constructor con un parámetro tipo String con nombreEmpresa, hacer new
	// ArrayList.
	public Empresa(String nombreEmpresa) {
		super();
		this.nombre = nombreEmpresa;
		this.plantilla = new ArrayList();

	}

	// Damos de alta a un empleado en la empresa
	public boolean alta(Empleado empleado) {
		return plantilla.add(empleado);
	}

	// Eliminamos de la empresa a un empleado
	public boolean eliminarUno(Empleado empleado) {
		return plantilla.remove(empleado);
	}

	// Modificamos un empleado
	public boolean modificarUno(Empleado empleado) {
		if (plantilla.indexOf(empleado) != -1) {
			plantilla.set(plantilla.indexOf(empleado), empleado);
			return true;
		} else {
			return false;
		}
	}

	// Buscamos todos los empleados en plantilla con el mismo genero
	public ArrayList<Empleado> buscarPorSexo(char sexo) {
		ArrayList<Empleado> empleadosPorGenero = new ArrayList();
		for (int i = 0; i <= (plantilla.size() - 1); i++) {
			if (Character.toLowerCase(plantilla.get(i).getGenero()) == Character.toLowerCase(sexo)) {
				empleadosPorGenero.add(plantilla.get(i));
			}
		}
		return empleadosPorGenero;
	}

	// Buscamos un empleado por IdEmpleado
	public Empleado buscarUno(int idEmpleado) {

		for (int i = 0; i < (plantilla.size()); i++) {
			if (plantilla.get(i).getIdEmpleado() == idEmpleado) {
				return plantilla.get(i);
			}
		}
		return null;
	}

	// Todos los valores de la lista
	public ArrayList<Empleado> buscarTodos() {
		return plantilla;
	}

	@Override
	public Double masaSalarial() {
		Double masaSalarial = 0.00;
		for (int i = 0; i <= (plantilla.size() - 1); i++) {
			masaSalarial = masaSalarial + plantilla.get(i).salarioBruto();
		}

		return masaSalarial;
	}

	@Override
	public ArrayList<Empleado> buscarPorDepartamento(int idDepar) {
		ArrayList<Empleado> empleadosPorDepartamento = new ArrayList();
		for (int i = 0; i <= (plantilla.size() - 1); i++) {
			if (plantilla.get(i).getDepartamento().getIdDepar() == (idDepar)) {
				empleadosPorDepartamento.add(plantilla.get(i));
			}
		}
		return empleadosPorDepartamento;
	}

	@Override
	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo) {
		ArrayList<Empleado> empleadosPorTrabajo = new ArrayList();
		for (int i = 0; i <= (plantilla.size() - 1); i++) {
			if (plantilla.get(i).getTrabajo().getIdTrabajo().equals(idTrabajo)) {
				empleadosPorTrabajo.add(plantilla.get(i));
			}
		}
		return empleadosPorTrabajo;
	}

	@Override
	public ArrayList<Empleado> buscarPorPais(String pais) {
		ArrayList<Empleado> empleadosPorPais = new ArrayList();
		for (int i = 0; i <= (plantilla.size() - 1); i++) {
			if (plantilla.get(i).getDepartamento().getLocalidad().getPais().equals(pais)) {
				empleadosPorPais.add(plantilla.get(i));
			}
		}
		return empleadosPorPais;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", plantilla=" + plantilla + "]";
	}

}
