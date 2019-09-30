package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.ClienteNDAO;
import pe.com.tintegro.dominio.ClienteN;
import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ClienteNDAOTest {
	@Autowired
	ClienteNDAO clienteNDao;

	// @Test
	public void testClienteListar() throws Exception {
		int contador = 1;
		ListarClienteNRequest request = new ListarClienteNRequest();
		request.setpIdCliente(null);
		request.setpNoRazon(null);
		request.setpNudocide(null);
		request.setpEstado(true);
		request.setpNuPagina(1);
		request.setpNuRegMostras(10);
		try {
			ListarClienteNResponse response = clienteNDao.listarClienteN(request);
			System.out.println("Tamaño de lista" + response.getLsClientesN().size());
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
				System.out.println(general.getNoTipo());
				System.out.println(general.getNoTipoRef());
				System.out.println(general.getNuCentrales());
				contador++;
				System.out.println("*****************************************************");
			}
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}

	//@Test
	public void testClienteNInsertar() throws Exception {
		RegistrarClienteNRequest obj = new RegistrarClienteNRequest();
		ClienteN cliobj = new ClienteN();
		cliobj.setNoRazonSocial("correo.cssom");
		cliobj.setNuDocIde("1ss1");
		cliobj.setDirecc("11");
		cliobj.setTelef("11");
		cliobj.setCorreoEle("11");
		cliobj.setPersonRef("11");
		cliobj.setEstado(true);
		cliobj.setIdTipdoc(1);
		cliobj.setNuDocumentoPref("11");
		cliobj.setIdTipdocPref(2);
		cliobj.setNuCelularPref("11");
		cliobj.setNuFijoPref("11");
		obj.setClienteN(cliobj);
		RegistrarClienteNResponse response = new RegistrarClienteNResponse();

		response = clienteNDao.registrarClienteN(obj);
		System.out.println(response.getEstado());
		System.out.println(response.getMensaje());
	}

	// @Test
	public void testClienteNEliminar() throws Exception {
		EliminarClienteNRequest obj = new EliminarClienteNRequest();
		obj.setpIdCliente(85);
		EliminarClienteNResponse response = new EliminarClienteNResponse();
		response = clienteNDao.eliminarClienteN(obj);
		System.out.println(response.getEstado());
		System.out.println(response.getMensaje());
	}

	@Test
	public void testClienteNActualizar() throws Exception {
		ActualizarClienteNRequest obj = new ActualizarClienteNRequest();
		ClienteN cliobj = new ClienteN();
		cliobj.setIdCliente(156);
		cliobj.setNoRazonSocial("actualizado");
		cliobj.setNuDocIde("11111111111");
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

		response = clienteNDao.actualizarClienteN(obj);
		System.out.println(response.getEstado());
		System.out.println(response.getMensaje());
	}
}
