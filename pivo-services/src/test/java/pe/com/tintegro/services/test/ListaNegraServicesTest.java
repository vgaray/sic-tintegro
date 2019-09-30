package pe.com.tintegro.services.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.ListaNegra;
import pe.com.tintegro.dto.request.BuscarListaNegraRequest;
import pe.com.tintegro.dto.request.EliminarListaNegraRequest;
import pe.com.tintegro.dto.request.ActualizarListaNegraRequest;
import pe.com.tintegro.dto.request.InsertarListaNegraRequest;
import pe.com.tintegro.dto.request.ListarListaNegraRequest;
import pe.com.tintegro.dto.response.BuscarListaNegraResponse;
import pe.com.tintegro.dto.response.EliminarListaNegraResponse;
import pe.com.tintegro.dto.response.ActualizarListaNegraResponse;
import pe.com.tintegro.dto.response.InsertarListaNegraResponse;
import pe.com.tintegro.dto.response.ListarListaNegraResponse;
import pe.com.tintegro.services.ListaNegraServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ListaNegraServicesTest {
	@Autowired
	ListaNegraServices listaNegraServices;

	// @Test
	public void testInsertarListaNegra() {
		InsertarListaNegraRequest request = new InsertarListaNegraRequest();
		request.setNuTelefo("892938989899912343231");
		request.setNoDescri("Cliente tapa yakuza Numero mafioso");
		request.setIlActivo(true);
		request.setCoTipllam(1);

		try {
			InsertarListaNegraResponse response = new InsertarListaNegraResponse();
			response = listaNegraServices.insertarListaServices("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getEstado() + "   " + response.getMensaje());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// @Test
	public void testActualizarListaNegra() {
		ActualizarListaNegraRequest request = new ActualizarListaNegraRequest();
		request.setNuTelefo("945333234");
		request.setNoDescri("Cliente tapa yakuza Numero2 mafioso");
		request.setIlActivo(false);
		request.setCoTipllam(2);

		try {
			ActualizarListaNegraResponse response = new ActualizarListaNegraResponse();
			response = listaNegraServices.actualizarListaServices("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getEstado() + "   " + response.getMensaje());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testEliminarListaNegra() {
		EliminarListaNegraRequest request = new EliminarListaNegraRequest();
		request.setNuTelefo("954065482");

		try {
			EliminarListaNegraResponse response = new EliminarListaNegraResponse();
			response = listaNegraServices.eliminarListaNegraServices("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getEstado() + "   " + response.getMensaje());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// @Test
	public void testListarListaNegra() {

		ListarListaNegraRequest request = new ListarListaNegraRequest();
		request.setNuTelefo("987077482");
		try {
			ListarListaNegraResponse response = new ListarListaNegraResponse();
			response = listaNegraServices.listarListaNegraServices("cli", "jPfFl7Jg2rg=", request);

			System.out.println(response.getEstado() + " " + response.getMensaje());
			List<ListaNegra> listas = response.getListasNegras();

			for (int i = 0; i < listas.size(); i++) {
				System.out.println(listas.get(i).getNuTelefo() + "   " + listas.get(i).getNoDescri() + "   " + listas.get(i).getCoTipllam());

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testBuscarListaNegra() {
		BuscarListaNegraRequest request = new BuscarListaNegraRequest();
		request.setNuTelefo(null);
		request.setIlActivo(true);
		request.setCoTipllam(null);
		try {
			BuscarListaNegraResponse response = new BuscarListaNegraResponse();
			response = listaNegraServices.buscarListaNegraServices("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getEstado() + " " + response.getMensaje());
			List<ListaNegra> listas = response.getLsListaNegra();

			for (int i = 0; i < listas.size(); i++) {
				System.out.println(listas.get(i).getNuTelefo() + "   " + listas.get(i).getNoDescri() + "   " + listas.get(i).getCoTipllam());

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
