package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dominio.DetallePedidoN;
import pe.com.tintegro.dto.request.ListarDetallePedidoNRequest;
import pe.com.tintegro.dto.response.ListarDetallePedidoNResponse;
import pe.com.tintegro.services.DetallePedidoNServices;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class DetallePedidoNServicesTest {
	@Autowired
	DetallePedidoNServices detallepedidoservices;
	@Test
	public void testDetallePedidoListar() throws Exception {
		int contador = 1;
		ListarDetallePedidoNRequest request=new ListarDetallePedidoNRequest();
		request.setIdCliente(65);
			ListarDetallePedidoNResponse response = detallepedidoservices.listardetallepedido(request);
			System.out.println("Tamaño de lista"
					+ response.getLsdetaped().size());
			for (DetallePedidoN general : response.getLsdetaped()) {
				System.out.println("fila:" + contador);
				System.out.println(general.getNoDetallePedido());
				System.out.println(general.getIdPlan());
				contador++;
				System.out.println("------------------------------------");
		}
	}
}
