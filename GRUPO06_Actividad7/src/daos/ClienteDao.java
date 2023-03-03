package daos;

import java.util.List;

import javabeans.Cliente;

public interface ClienteDao {

	int altaCliente(Cliente cliente);
	int eliminarCliente(String cif);
	Cliente buscarUno(String cif);
	List <Cliente> buscarTodo();

}
