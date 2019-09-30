package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.PedidoPorClienteDAO;
import pe.com.tintegro.dominio.PedidoPorCliente;
import pe.com.tintegro.dto.request.ListaPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.ListaPedidoPorClienteResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PedidoxClienteDAOTest
{
	@Autowired
	PedidoPorClienteDAO pedidoxClienteDAO;

	@Test
	public void testPedidoxCliente() throws Exception
	{
		ListaPedidoPorClienteRequest obj = new ListaPedidoPorClienteRequest();
		obj.setIdTipdoc(1);
		obj.setIdCliente(3);
		obj.setIdPedido(2);
		obj.setIdEstadoPedido(1);
		
		List<PedidoPorCliente> pedidos = new ArrayList<PedidoPorCliente>();
		ListaPedidoPorClienteResponse response = pedidoxClienteDAO.listaPedidoxCliente(obj);
		pedidos = response.getPedidoxClienteList();
//		for (int i = 0; i < pedidos.size(); ++)
//		{
			System.out.println(pedidos.size());
//		}
	
	}

	// //@Test
	// public void pedidoXClienteTest() {
	// try {
	//
	// ListaPedidoPorClienteRequest request = new ListaPedidoPorClienteRequest();
	// request.setIdTipdoc(1);
	// request.setIdCliente(3);
	// request.setIdPedido(1);
	// request.setIdEstadoPedido(1);
	//
	// ListaPedidoPorClienteResponse response =
	// pedidoxClienteDAO.listaPedidoxCliente("192.168.3.202", request);
	// for (PedidoPorCliente pedido : response.getPedidoxClienteList())
	// {
	// System.out.println("" + pedido.getIdCliente());
	// }
	// } catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }

}
