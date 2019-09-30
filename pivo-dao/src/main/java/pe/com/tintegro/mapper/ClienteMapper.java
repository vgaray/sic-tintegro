package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;



import pe.com.tintegro.dominio.Cliente;

public interface ClienteMapper {

	
	public List<Cliente> listaCliente();
	
	public List<Cliente> listarClienteAutoCompletar(@Param("pNoRazonSocial") String pNoRazonSocial);
	
	public List<Integer> InsertaCliente(@Param("noRazonSocial") String noRazonSocial,@Param("ruc") String ruc, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("correo") String correo, @Param("personareferencia") String personareferencia);
	//public List<Cliente> InsertaCliente(Cliente obj);
	
	public List<Integer> eliminaCliente (@Param("idCliente") int idCliente);
	
	
	public List<Integer> actualizaCliente (@Param("idCliente") int idCliente,@Param("noRazonSocial") String noRazonSocial,@Param("ruc") String ruc, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("correo") String correo, @Param("personareferencia") String personareferencia);
}
