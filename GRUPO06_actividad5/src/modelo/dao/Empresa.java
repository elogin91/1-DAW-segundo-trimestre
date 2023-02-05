package modelo.dao;

import java.util.ArrayList;
import java.util.Objects;

import modelo.javabean.Departamento;
import modelo.javabean.Empleado;
import modelo.javabean.Localidad;
import modelo.javabean.Trabajo;

public class Empresa implements IntGestionEmpresa {
	private String nombre;
	private ArrayList<Empleado> plantilla;

	// Constructor con un parámetro String nombreEmpresa, hacer new ArrayList.
	public Empresa(String nombreEmpresa) {
		super();
		this.nombre = nombreEmpresa;
		this.plantilla = new ArrayList<>();
		cargarDatos();
	}

	// Getter & setter.
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Implementamos los métodos de IntGestionEmpresa.

	// Damos de alta a un empleado en la empresa.
	@Override
	public boolean alta(Empleado empleado) {
		if (plantilla.contains(empleado)) {
			return false;
		} else {
			return plantilla.add(empleado);
		}
	}

	// Eliminamos de la empresa a un empleado.
	@Override
	public boolean eliminarUno(Empleado empleado) {
		return plantilla.remove(empleado);
	}

	// Modificamos un empleado de la empresa.
	@Override
	public boolean modificarUno(Empleado empleado) {
		if (plantilla.indexOf(empleado) != -1) {
			plantilla.set(plantilla.indexOf(empleado), empleado);
			return true;
		} else {
			return false;
		}
	}

	// Buscamos todos los empleados en plantilla con el mismo genero.
	@Override
	public ArrayList<Empleado> buscarPorSexo(char sexo) {
		ArrayList<Empleado> empleadosPorGenero = new ArrayList<>();
		for (Empleado empleado : plantilla) {
			if (Character.toLowerCase(empleado.getGenero()) == Character.toLowerCase(sexo)) {
				empleadosPorGenero.add(empleado);
			}
		}
		return empleadosPorGenero;
	}

	// Buscamos un empleado por IdEmpleado.
	@Override
	public Empleado buscarUno(int idEmpleado) {
		for (Empleado empleado : plantilla) {
			if (empleado.getIdEmpleado() == idEmpleado) {
				return empleado;
			}
		}
		return null;
	}

	// Buscamos todos los empleados de la empresa.
	@Override
	public ArrayList<Empleado> buscarTodos() {
		return plantilla;
	}

	// Calculamos la masa salarial de todos los empleados en plantilla.
	@Override
	public Double masaSalarial() {
		Double masaSalarial = 0.00;
		for (Empleado empleado : plantilla) {
			masaSalarial = masaSalarial + empleado.salarioBruto();
		}
		return masaSalarial;
	}

	// Buscamos a los empleados de la empresa por departamento.
	@Override
	public ArrayList<Empleado> buscarPorDepartamento(int idDepar) {
		ArrayList<Empleado> empleadosPorDepartamento = new ArrayList<>();
		for (Empleado empleado : plantilla) {
			if (empleado.getDepartamento().getIdDepar() == (idDepar)) {
				empleadosPorDepartamento.add(empleado);
			}
		}
		return empleadosPorDepartamento;
	}

	// Buscamos a los empleados de la empresa por el trabajo que realizan.
	@Override
	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo) {
		ArrayList<Empleado> empleadosPorTrabajo = new ArrayList<>();
		for (Empleado empleado : plantilla) {
			if (empleado.getTrabajo().getIdTrabajo().equalsIgnoreCase(idTrabajo)) {
				empleadosPorTrabajo.add(empleado);
			}
		}
		return empleadosPorTrabajo;
	}

	// Buscamos a los empleados de la empresa por país.
	@Override
	public ArrayList<Empleado> buscarPorPais(String pais) {
		ArrayList<Empleado> empleadosPorPais = new ArrayList<>();
		for (Empleado empleado : plantilla) {
			if (empleado.getDepartamento().getLocalidad().getPais().equalsIgnoreCase(pais)) {
				empleadosPorPais.add(empleado);
			}
		}
		return empleadosPorPais;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", plantilla=" + plantilla + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(nombre, other.nombre);
	}

	// Crea empleados en la empresa.
	private void cargarDatos() {
		Localidad localizacionMalaga = new Localidad(1, "Calle Feria", "Malaga", "España");
		Departamento departamentoInforMalaga = new Departamento(1, "Informático", localizacionMalaga);
		Trabajo trabajoTecnico = new Trabajo("1", "Técnico", 2000.99, 4999.99);

		plantilla.add(new Empleado(1, "Loli", "Lopez Lopez", "loli.lplp@gmail.com", 3000.99, 500.99, 'm',
				trabajoTecnico, departamentoInforMalaga));
		plantilla.add(new Empleado(2, "Luisita", "Lopez Lopez", "luisita.lplp@gmail.com", 2000.99, 300.99, 'M',
				trabajoTecnico, departamentoInforMalaga));
		plantilla.add(new Empleado(3, "Pepe", "Ruiz Hernandez", "pepe_ruiz@gmail.com", 3042.99, 442.99, 'H',
				trabajoTecnico, departamentoInforMalaga));
		plantilla.add(new Empleado(4, "Manuel", "Alvarez Almeida", "manolin@hotmail.es", 2800.99, 288.99, 'h',
				trabajoTecnico, departamentoInforMalaga));

	}

}
