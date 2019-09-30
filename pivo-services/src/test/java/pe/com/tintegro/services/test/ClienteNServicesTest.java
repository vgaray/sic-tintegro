package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.ClienteN;
import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;
import pe.com.tintegro.services.ClienteNServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ClienteNServicesTest {
	@Autowired
	 ClienteNServices clienteNServices;
	@Test
	public void testClienteList()
	{int contador=1;
	ListarClienteNRequest request = new ListarClienteNRequest();
		try
		{
			ListarClienteNResponse response= clienteNServices.listarClienteN(request);
			for (ClienteN general : response.getLsClientesN()) {
				System.out.println("fila:" + contador);
				System.out.println(general.getIdCliente());
				System.out.println(general.getNoRazonSocial());
				System.out.println(general.getRuc());
				System.out.println(general.getDirecc());
				System.out.println(general.getTelef());
				System.out.println(general.getCorreoEle());
				System.out.println(general.getPersonRef());
				System.out.println(general.getIdTipdoc());
				System.out.println(general.isEstado());
				System.out.println(general.getNuDocumentoPref());
				System.out.println(general.getIdTipdocPref());
				System.out.println(general.getNuCelularPref());
				System.out.println(general.getNuFijoPref());
				contador++;
				System.out
						.println("*****************************************************");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	 //@Test
		public void testClienteNInsertar() throws Exception {
			RegistrarClienteNRequest obj = new RegistrarClienteNRequest();
			ClienteN cliobj = new ClienteN();
			cliobj.setNoRazonSocial("correo.com");
			cliobj.setNuDocIde("123");
			cliobj.setDirecc("123");
			cliobj.setTelef("123");
			cliobj.setCorreoEle("123");
			cliobj.setPersonRef("123");
			cliobj.setEstado(true);
			cliobj.setIdTipdoc(1);
			cliobj.setNuDocumentoPref("123");
			cliobj.setIdTipdocPref(2);
			cliobj.setNuCelularPref("123");
			cliobj.setNuFijoPref("123");
			obj.setClienteN(cliobj);
			RegistrarClienteNResponse response = new RegistrarClienteNResponse();

			response = clienteNServices.registrarClienteN(obj);

			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}

		//@Test
		public void testClienteNEliminar() throws Exception {
			EliminarClienteNRequest obj = new EliminarClienteNRequest();
			obj.setpIdCliente(88);
			EliminarClienteNResponse response = new EliminarClienteNResponse();

			response = clienteNServices.eliminarClienteN(obj);

			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}

		//@Test
		public void testClienteNActualizar() throws Exception {
			ActualizarClienteNRequest obj = new ActualizarClienteNRequest();
			ClienteN cliobj = new ClienteN();
			cliobj.setIdCliente(88);
			cliobj.setNoRazonSocial("actualizado");
			cliobj.setNuDocIde("actualizadoN");
			cliobj.setDirecc("actualizado");
			cliobj.setTelef("actualizado");
			cliobj.setCorreoEle("actualizado");
			cliobj.setPersonRef("actualizado");
			cliobj.setEstado(true);
			cliobj.setIdTipdoc(1);
			cliobj.setNuDocumentoPref("actualizado");
			cliobj.setIdTipdocPref(2);
			cliobj.setNuCelularPref("actualizado");
			cliobj.setNuFijoPref("actualizado");
			obj.setClienteN(cliobj);
			ActualizarClienteNResponse response = new ActualizarClienteNResponse();

			response = clienteNServices.actualizarClienteN(obj);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());

		}
}
