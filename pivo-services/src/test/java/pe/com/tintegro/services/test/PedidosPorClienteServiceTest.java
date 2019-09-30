/**
 * 
 */
package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Pedido;
import pe.com.tintegro.dominio.Plan;
import pe.com.tintegro.dominio.TipoDetallePedido;
import pe.com.tintegro.dominio.TipoPedido;
import pe.com.tintegro.dto.request.EliminarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListarPlanRequest;
import pe.com.tintegro.dto.request.ListarTipoDetallePedidoRequest;
import pe.com.tintegro.dto.request.ListarTipoPedidoRequest;
import pe.com.tintegro.dto.response.EliminarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListarPlanResponse;
import pe.com.tintegro.dto.response.ListarTipoDetallePedidoResponse;
import pe.com.tintegro.dto.response.ListarTipoPedidoResponse;
import pe.com.tintegro.services.PedidosPorClienteService;

/**
 * @author FReyes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PedidosPorClienteServiceTest {
	@Autowired
	private PedidosPorClienteService pedidosPorClienteService;
	//@Test
	public void listarPedidosPorClienteTest()
	{
		ListarPedidoPorClienteRequest request = new ListarPedidoPorClienteRequest();
		request.setIdCliente(64);
		try{
		ListarPedidoPorClienteResponse response = pedidosPorClienteService.listarPedidoPorCliente(request);
		for(Pedido general : response.getPedidoPorClienteList()){
			System.out.println("************");
			System.out.println(general.getCoPedido());		
		    System.out.println(general.getTiPedido());	
		    System.out.println(general.getPlan());
		    System.out.println(general.getDePedido());
		    System.out.println(general.getFePedido());
		    System.out.println(general.getEstadoPedido());
			System.out.println("************");
		}
		//System.out.println(response.getPedidoPorClienteList());
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
	}
	
	//@Test
	public void InsertarPedidosPorClienteTest () throws Exception
	{
		try	
		{
		InsertarPedidoPorClienteRequest request = new InsertarPedidoPorClienteRequest();
		request.setIdCliente(71);
		request.setCoPedido("TTTTTTTTT");
		request.setIdTipoPedido(2);
		request.setIdPlan(2);
		request.setDePedido("Pedido PEDIDO");
		request.setIdTipoDetalle(1);	
		InsertarPedidoPorClienteResponse response = new InsertarPedidoPorClienteResponse();
		response = pedidosPorClienteService.insertarPedidoPorCliente(request);
		}
		catch (Exception e){
			e.getStackTrace();	
		}
	}
	
	//@Test
	public void EliminarPedidosPorClienteTest() throws Exception
	{
		try
		{
			EliminarPedidoPorClienteRequest request = new EliminarPedidoPorClienteRequest();
			request.setIdPedido(111);
			EliminarPedidoPorClienteResponse response = new EliminarPedidoPorClienteResponse();
			response = pedidosPorClienteService.eliminarPedidoPorCliente(request);
			
			System.out.println(response.getEstado());
		    System.out.println(response.getMensaje());
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	//@Test
		public void ListarTipoPedido() throws Exception{
			ListarTipoPedidoRequest request = new ListarTipoPedidoRequest();
			try{
				ListarTipoPedidoResponse response = pedidosPorClienteService.listarTipoPedido(request);
				for(TipoPedido general : response.getListTipoPedido()) {
					System.out.println(general.getId() +"  "+general.getNoDescripcion());
					
				}			
			}
			catch(Exception e)
			{
				System.out.println("" + e.getMessage());
				e.printStackTrace();
			}
		}

		//@Test
		public void ListarTipoDetallePedido() throws Exception{
			ListarTipoDetallePedidoRequest request = new ListarTipoDetallePedidoRequest();
			try{
				ListarTipoDetallePedidoResponse response = pedidosPorClienteService.listarTipoDetallePedido(request);
				for(TipoDetallePedido general : response.getListTipoDetallePedido()) {
					System.out.println(general.getId() +"  "+general.getNoDescripcion());
					
				}			
			}
			catch(Exception e)
			{
				System.out.println("" + e.getMessage());
				e.printStackTrace();
			}
		}
		
		@Test
		public void ListarPlan() throws Exception{
			ListarPlanRequest request = new ListarPlanRequest();
			try{
				ListarPlanResponse response = pedidosPorClienteService.listarPlan(request);
				for(Plan general : response.getListPlan()) {
					System.out.println(general.getId() +"  "+general.getNoDescripcion());
					
				}			
			}
			catch(Exception e)
			{
				System.out.println("" + e.getMessage());
				e.printStackTrace();
			}
		}
}
