package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.ListaNegraDAO;
import pe.com.tintegro.dominio.ListaNegra;
import pe.com.tintegro.dto.request.BuscarListaNegraRequest;
import pe.com.tintegro.dto.request.CambiaEstadoListaNegraRequest;
import pe.com.tintegro.dto.request.EliminarListaNegraRequest;
import pe.com.tintegro.dto.request.ActualizarListaNegraRequest;
import pe.com.tintegro.dto.request.InsertarListaNegraRequest;
import pe.com.tintegro.dto.request.ListarListaNegraRequest;
import pe.com.tintegro.dto.response.BuscarListaNegraResponse;
import pe.com.tintegro.dto.response.CambiaEstadoListaNegraResponse;
import pe.com.tintegro.dto.response.EliminarListaNegraResponse;
import pe.com.tintegro.dto.response.ActualizarListaNegraResponse;
import pe.com.tintegro.dto.response.InsertarListaNegraResponse;
import pe.com.tintegro.dto.response.ListarListaNegraResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ListaNegraDAOTest
{
	@Autowired
	ListaNegraDAO listaNegraDAO;

	// @Test
	public void testInsertarListaNegra()
	{
		InsertarListaNegraRequest request = new InsertarListaNegraRequest();
		request.setNuTelefo("987077482");
		request.setNoDescri("Cliente desea bloquear Numero");
		request.setIlActivo(true);
		request.setCoTipllamSig("Todas");

		try
		{
			InsertarListaNegraResponse response = new InsertarListaNegraResponse();

			response = listaNegraDAO.insertarLista("192.168.3.202", request);
			System.out.println(response.getEstado() + " " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testActualizarListaNegra()
	{
		ActualizarListaNegraRequest request = new ActualizarListaNegraRequest();
		request.setNuTelefo("987077482");
		request.setNoDescri("Cliente tapa Numero");
		request.setIlActivo(true);
		request.setCoTipllamSig("Entrantes");

		try
		{
			ActualizarListaNegraResponse response = new ActualizarListaNegraResponse();
			response = listaNegraDAO.actualizarLista("192.168.3.202", request);

			System.out.println(response.getEstado() + "  " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	// @Test
	public void testEliminarListaNegra()
	{

		EliminarListaNegraRequest request = new EliminarListaNegraRequest();
		request.setNuTelefo("91782e9314");

		try
		{

			EliminarListaNegraResponse response = new EliminarListaNegraResponse();
			response = listaNegraDAO.eliminarListaNegra("192.168.3.202", request);

			System.out.println(response.getEstado() + "  " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testListarListaNegra()
	{
		ListarListaNegraRequest request = new ListarListaNegraRequest();
		request.setNuTelefo("987077482");

		try
		{
			ListarListaNegraResponse response = new ListarListaNegraResponse();
			response = listaNegraDAO.listarListaNegra("192.168.3.202", request);
			List<ListaNegra> listas = new ArrayList<ListaNegra>();
			listas = response.getListasNegras();
			for (int i = 0; i < listas.size(); i++)
			{
				System.out.println(listas.get(i).getNuTelefo() + "   " + listas.get(i).getNoDescri() + "   " + listas.get(i).getCoTipllam());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

//	@Test
	public void testCambiaEstadoListaNegra()
	{
		CambiaEstadoListaNegraRequest request = new CambiaEstadoListaNegraRequest();
		request.setNuTelefo("99286694");
		request.setIlActivo(true);

		try
		{
			CambiaEstadoListaNegraResponse response = new CambiaEstadoListaNegraResponse();
			response = listaNegraDAO.cambiaEstadoListaNegra("192.168.3.202", request);
			System.out.println(response.getMensaje());
			System.out.println(response.getResultado());

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBuscarListaNegra () {
		BuscarListaNegraRequest request = new BuscarListaNegraRequest();
		request.setNuTelefo(null);//"992866923"
		request.setIlActivo(null);
		request.setCoTipllam("Todas");
		try {
			BuscarListaNegraResponse response = new BuscarListaNegraResponse ();
			response = listaNegraDAO.buscarListaNegra("192.168.3.202", request);
			List<ListaNegra> listas = new ArrayList<ListaNegra>();
			listas = response.getLsListaNegra();
			for (int i = 0; i < listas.size(); i++)
			{
				System.out.println(listas.get(i).getNuTelefo() + "   " + listas.get(i).getNoDescri() + "   " + listas.get(i).getCoTipllam());
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
