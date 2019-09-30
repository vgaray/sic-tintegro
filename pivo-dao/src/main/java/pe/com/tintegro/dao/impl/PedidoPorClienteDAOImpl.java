package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.PedidoPorClienteDAO;
import pe.com.tintegro.dominio.DetallePedido;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.PedidoPorCliente;
import pe.com.tintegro.dominio.Usuario;
import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListaPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListaPedidoPorClienteResponse;
import pe.com.tintegro.mapper.PedidoPorClienteMapper;
import pe.com.tintegro.mapper.PedidosMapper;

@Repository("pedidoPorClienteDAO")
public class PedidoPorClienteDAOImpl extends DAOTintegroImpl implements PedidoPorClienteDAO {

	@SuppressWarnings("unused")
	private List<Usuario> userInsert;

	@Override
	public ListaPedidoPorClienteResponse listaPedidoxCliente(ListaPedidoPorClienteRequest obj) throws Exception {
		List<PedidoPorCliente> result = new ArrayList<PedidoPorCliente>();
		ListaPedidoPorClienteResponse response = new ListaPedidoPorClienteResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.PedidosMapper.class);
		result = (List<PedidoPorCliente>) mapper.listPedidoxClientess(obj.getIdTipdoc(), 
																	  obj.getIdCliente(), 
																	  obj.getIdPedido(), 
																	  obj.getIdEstadoPedido());
		response.setPedidoxClienteList(result);
		return response;
	}

	@Override
	public InsertarPedidoPorClienteResponse insertaPedidoPorCliente(InsertarPedidoPorClienteRequest request) throws Exception {
		InsertarPedidoPorClienteResponse response = new InsertarPedidoPorClienteResponse();
		PedidoPorClienteMapper mapper = this.sqlSessionSic.getMapper(pe.com.tintegro.mapper.PedidoPorClienteMapper.class);
		List<PedidoPorCliente> pedidosCliente = new ArrayList<PedidoPorCliente>();
		pedidosCliente = (List<PedidoPorCliente>) mapper.pedidosPorcliente(request.getCliente().getNoRazonSocial(), 
																		   request.getCliente().getNuDocIde(), 
																		   request.getCliente().getDirecc(), 
																		   request.getCliente().getTelef(), 
																		   request.getCliente().getCorreoEle(), 
																		   request.getCliente().getPersonRef(), 
																		   request.getCliente().isEstado(), 
																		   request.getCliente().getIdTipoDoc(), 
																		   request.getPedido().getIdEstadPedido());
		List<Integer> detallePedidos = new ArrayList<Integer>();
		int cantidad = 0;
		List<DetallePedido> dePedidos = request.getPedido().getDestallesList();
		List<Usuario> usuarioList = new ArrayList<Usuario>();

		for (int i = 0; i < dePedidos.size(); i++) {
			InstanciaServerAsterisk instancia = new InstanciaServerAsterisk();
			instancia = dePedidos.get(i).getInstancia();
			detallePedidos = (List<Integer>) mapper.insertarInstanciaPorDetallePedido(dePedidos.get(i).getNoDetaPedido(), 
																					  dePedidos.get(i).getIdTipoPedido(),
																					  pedidosCliente.get(0).getIdPedido(), 
																					  dePedidos.get(i).getIdTipoDetalle(), 
																					  dePedidos.get(i).getIdPlan(), 
																					  pedidosCliente.get(0).getIdCliente(),
																					  instancia.getIpAsterisk(), 
																					  instancia.getNomMascaraRedLan(), 
																					  instancia.getNomMascaraOpenVpn(), 
																					  instancia.getIlEstado(), 
																					  instancia.getIlLibre(), 
																					  instancia.getIpAsteriskBash(), 
																					  instancia.getPuerto_ssh_asterisk(), 
																					  instancia.getPuertoOpenVPN(), 
																					  instancia.getPamConfInicial(),
																					  instancia.getSimPais(), 
																					  instancia.getSimProvincia(), 
																					  instancia.getFullProvincia(), 
																					  instancia.getNoOrgani(), 
																					  instancia.getEmail(), 
																					  instancia.getIdModelo(), 
																					  instancia.getIdMarca(), 
																					  instancia.getNoModelo(), 
																					  instancia.getNoMarca(), 
																					  instancia.getInicial(), 
																					  instancia.getIdEstadoInstancia());
			cantidad += detallePedidos.size();
			usuarioList = instancia.getUsuarioList();
			userInsert = new ArrayList<Usuario>();
			for (int j = 0; j < usuarioList.size(); j++) {
				userInsert = (List<Usuario>) mapper.asignarInstanciaUsuario(detallePedidos.get(0), 
																			usuarioList.get(j).getNoLogin(), 
																			usuarioList.get(j).getNoPasswo(), 
																			usuarioList.get(j).getNoNombre(), 
																			usuarioList.get(j).getNoApellido(), 
																			usuarioList.get(j).getEmail(), 
																			usuarioList.get(j).getNoProfe());
			}
		}
		response.setCantidadPedidos(cantidad);
		response.setPedidos(pedidosCliente);
		return response;
	}

	//
	// @Override
	// public ListaPedidoPorClienteResponse listaPedidoxCliente(String ip,
	// ListaPedidoPorClienteRequest request) throws Exception
	// {
	//
	// PostgreSQL db =new PostgreSQL();
	// db.conectar(ip);
	//
	// ListaPedidoPorClienteResponse response= new
	// ListaPedidoPorClienteResponse();
	//
	// try{ //Nombre del Stored Procedure
	// String storedProcedureName = "sistema.fn_pedido_cliente";
	//
	// //Lista de parametros
	// Object[][] params = {{request.getIdTipdoc(),Integer.class},
	// {request.getIdCliente(),Integer.class},
	// {request.getIdPedido(),Integer.class},
	// {request.getIdEstadoPedido(),Integer.class}
	// };
	//
	// //Map que relaciona nombre de columna retornada con atributo a la que
	// corresponde
	// Map<String, String> mapColumnToAttributte = new HashMap<String,
	// String>();
	// mapColumnToAttributte.put( "id_tipdoc","idTipdoc" );
	// mapColumnToAttributte.put( "no_razonsocial","noRazonSocial" );
	// mapColumnToAttributte.put( "fe_pedido","fePedido" );
	//
	// mapColumnToAttributte.put( "id_cliente", "idCliente" );
	//
	// mapColumnToAttributte.put( "id_pedido","idPedido" );
	// mapColumnToAttributte.put( "id_estadopedido", "idEstadoPedido" );
	// mapColumnToAttributte.put( "no_estadopedido", "noEstadoPedido" );
	//
	// Response<PedidoPorCliente> responseT = BaseDao.baseData(
	// storedProcedureName,params, db.con, PedidoPorCliente.class,
	// mapColumnToAttributte );
	//
	// if( responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK )
	// {
	// throw responseT.getException();
	// }
	// else{
	// response.setMensaje("OK");
	//
	// response.setPedidoxClienteList((ArrayList<PedidoPorCliente>)responseT.getData());
	// //responseT.getData());
	//
	// }
	//
	// response.setEstado(responseT.getCodigo());
	//
	// }
	//
	// finally{
	// try{
	//
	// db.cerrar();
	// }
	// catch(Exception e)
	// {}
	// }
	// return response;
	// }

}