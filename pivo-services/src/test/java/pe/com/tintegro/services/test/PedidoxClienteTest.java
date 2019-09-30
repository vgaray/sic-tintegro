package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.PedidoPorCliente;
import pe.com.tintegro.dto.request.ListaPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.ListaPedidoPorClienteResponse;
import pe.com.tintegro.services.PedidoPorClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PedidoxClienteTest
{
 @Autowired
 PedidoPorClienteService pedidoxClienteService;
 
 @Test
 public void testPedidoXcliente(){
	 try{
		 ListaPedidoPorClienteRequest obj = new ListaPedidoPorClienteRequest();
			obj.setIdTipdoc(1);
			obj.setIdCliente(3);
			obj.setIdPedido(1);
			obj.setIdEstadoPedido(1);
			
			List<PedidoPorCliente> pedidos = new ArrayList<PedidoPorCliente>();
			ListaPedidoPorClienteResponse response = pedidoxClienteService.listaPedidoxCliente("", obj);
			pedidos = response.getPedidoxClienteList();
//			for (int i = 0; i < pedidos.size(); i++)
//			{
				System.out.println(pedidos.size());
//			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
 }
 
	// @Test
	 public void testListPedidos()
		{
			try
			{
				ListaPedidoPorClienteRequest obj = new ListaPedidoPorClienteRequest();
				
				obj.setIdTipdoc(1);
				obj.setIdCliente(3);
				obj.setIdPedido(1);
				obj.setIdEstadoPedido(1);
				
				ListaPedidoPorClienteResponse response = pedidoxClienteService.listaPedidoxCliente("", obj);
				System.out.println(response.getPedidoxClienteList().size());
				for (PedidoPorCliente pedidos : response.getPedidoxClienteList()) {
				System.out.println(" "+ pedidos.getNoRazonSocial()+pedidos.getIdCliente());
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
 }

