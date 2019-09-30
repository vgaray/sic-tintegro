package pe.com.tintegro.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.PedidoPorClienteDAO;
import pe.com.tintegro.dominio.Cliente;
import pe.com.tintegro.dominio.Pedido;
import pe.com.tintegro.dominio.PedidoPorCliente;
import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PedidoPorClienteDAOTest
{
   @Autowired
   PedidoPorClienteDAO pedidoPorClienteDao;
   
   @Test
   public void testInsertar()  throws Exception{
   	InsertarPedidoPorClienteRequest request=new InsertarPedidoPorClienteRequest();
   	Cliente clienteRequest=new Cliente();
   	clienteRequest.setNoRazonSocial("PruebaTest");
   	clienteRequest.setCorreoEle("");
   	clienteRequest.setCorreoEle("");
   	clienteRequest.setCorreoEle("");
   	clienteRequest.setCorreoEle("");
   	clienteRequest.setCorreoEle("");
   	
   	
   	
//   	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   	Pedido pedidoRequest=new Pedido();
//   	Date fePedido = format.parse("2017-03-01");
   //	pedidoRequest.setFePedido();
   	
   	request.setCliente(clienteRequest);
   	request.setPedido(pedidoRequest);
   	
   	InsertarPedidoPorClienteResponse reponse=pedidoPorClienteDao.insertaPedidoPorCliente(request);
   	
   	List<PedidoPorCliente> pedidos=reponse.getPedidos();
   	
   	for (int i = 0; i < pedidos.size(); i++)
		{
			System.out.println(pedidos.get(i).getIdCliente()+"--"+pedidos.get(i).getIdPedido());
		}
   	
   }
   
   
  
}
