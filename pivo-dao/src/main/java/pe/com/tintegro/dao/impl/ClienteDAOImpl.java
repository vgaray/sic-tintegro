package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.ClienteDAO;
import pe.com.tintegro.dominio.Cliente;
import pe.com.tintegro.dto.request.ClienteActualizarRequest;
import pe.com.tintegro.dto.request.ClienteEliminarRequest;
import pe.com.tintegro.dto.request.InsertarClienteRequest;
import pe.com.tintegro.dto.request.ListaClienteAutoCompletarRequest;
import pe.com.tintegro.dto.response.ClienteActualizarReponse;
import pe.com.tintegro.dto.response.ClienteEliminarResponse;
import pe.com.tintegro.dto.response.InsertarClienteResponse;
import pe.com.tintegro.dto.response.ListaClienteAutoCompletarResponse;
import pe.com.tintegro.dto.response.ListaClienteResponse;
import pe.com.tintegro.mapper.ClienteMapper;

@Repository("clienteDAO")
public class ClienteDAOImpl extends DAOTintegroImpl implements ClienteDAO {

	@Override
	public ListaClienteResponse listarCliente() throws Exception {
		ListaClienteResponse response = new ListaClienteResponse();
		List<Cliente> result = new ArrayList<Cliente>();
		ClienteMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.ClienteMapper.class);
		result = (List<Cliente>) mapper.listaCliente();
		response.setListarClientes(result);
		return response;
	}

	/*
	 * @Override public List<Cliente> insertarCliente() throws Exception { //
	 * TODO Auto-generated method stub
	 * 
	 * 
	 * 
	 * Cliente obj=new Cliente(); String razon=obj.getNoRazonSocial(); String
	 * direcc=obj.getDirecc(); String ruc=obj.getRuc(); String
	 * persona=obj.getPersonRef(); String telef=obj.getTelef(); String
	 * correo=obj.getCorreoEle();
	 * 
	 * ClienteMapper mapper =
	 * this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper
	 * .ClienteMapper.class);
	 * 
	 * //set //List<InstanciaServerAsterisk> resultado =
	 * (List<InstanciaServerAsterisk>)mapper.insertarInstancia(2);
	 * 
	 * 
	 * List<Cliente> resultado =
	 * (List<Cliente>)mapper.InsertaCliente(razon,ruc,direcc
	 * ,telef,correo,persona);
	 * 
	 * System.out.println(resultado.get(0).getConfirmacion());
	 * 
	 * return null; }
	 * 
	 * 
	 * 
	 * 
	 * @Override public int eliminandoCliente(Cliente obj) throws Exception { //
	 * TODO Auto-generated method stub
	 * 
	 * //obj.getIdCliente();
	 * 
	 * ClienteMapper mapper =
	 * this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper
	 * .ClienteMapper.class);
	 * 
	 * int resultado = mapper.eliminadoCliente(obj);
	 * 
	 * 
	 * System.out.println(resultado);
	 * 
	 * 
	 * return resultado; }*
	 */

	@Override
	public ClienteActualizarReponse actualizarCliente(ClienteActualizarRequest cliente) throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		ClienteActualizarReponse response = new ClienteActualizarReponse();
		ClienteMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.ClienteMapper.class);
		result = (List<Integer>) mapper.actualizaCliente(cliente.getIdCliente(), cliente.getNoRazonSocial(), cliente.getRuc(), cliente.getDirecc(), cliente.getTelef(), cliente.getCorreoEle(), cliente.getPersonRef());
		response.setActualizo(result);
		return response;
	}

	@Override
	public InsertarClienteResponse insertarCliente(InsertarClienteRequest cliente) throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		InsertarClienteResponse response = new InsertarClienteResponse();
		ClienteMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.ClienteMapper.class);
		result = (List<Integer>) mapper.InsertaCliente(cliente.getNoRazonSocial(), cliente.getRuc(), cliente.getDirecc(), cliente.getTelef(), cliente.getCorreoEle(), cliente.getPersonRef());
		response.setInserto(result);
		return response;
	}

	@Override
	public ClienteEliminarResponse eliminarCliente(ClienteEliminarRequest cliente) throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		ClienteEliminarResponse response = new ClienteEliminarResponse();
		ClienteMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.ClienteMapper.class);
		result = (List<Integer>) mapper.eliminaCliente(cliente.getIdCliente());
		response.setElimino(result);
		return response;
	}

	@Override
	public ListaClienteAutoCompletarResponse listarClienteAutoCompletar(ListaClienteAutoCompletarRequest request) throws Exception {
		ListaClienteAutoCompletarResponse response = new ListaClienteAutoCompletarResponse();
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMapper mapper = this.getSqlSessionSic().getMapper(ClienteMapper.class);
		clientes = (List<Cliente>) mapper.listarClienteAutoCompletar(request.getNoRazon());
		response.setListaCliente(clientes);
		return response;
	}

}
