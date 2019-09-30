package pe.com.tintegro.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.IvrOpcionDAO;
import pe.com.tintegro.dominio.IvrOpcion;
import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" } )
public class IvrOpcionDAOTest
{
	@Autowired
	IvrOpcionDAO	ivrOpcionDAO;

	// @Test
	public void testInsertarIvrOpcionTest() throws Exception
	{
		InsertarIvrOpcionRequest obj = new InsertarIvrOpcionRequest();
		obj.setpIdPadre(0);
		obj.setpNoDescripcion("prueba registro borrar luego");
		obj.setpNoAudio("audio.mp3");
		obj.setpNuAnexo("100");
		obj.setpIdtipo(1);
		obj.setpNoValor("asd");
		obj.setpNoNombre("ivr prueba");
		obj.setpIdGrupo(null);
		obj.setpNoAnexoTiempo("asd");
		obj.setpVuelveInicioTiempo(1);
		obj.setpVuelveInicioIncorrecto(1);
		obj.setpNoAnexoIncorrecto("asdasd");
		obj.setpMarcaAnexo(1);
		obj.setpOperadora(1);
		obj.setpTiempoEspera(1);
		obj.setIlDisponible(true);

		InsertarIvrOpcionResponse response = ivrOpcionDAO.insertarIvrResponse("192.168.3.202", obj);
		System.out.println(response.getIdResult() + " " + response.getMensaje() + " " + response.getId());
	}

	// @Test
	public void eliminarIvrOpcionTest() throws Exception
	{
		EliminarIvrOpcionRequest obj = new EliminarIvrOpcionRequest();
		obj.setpIdIvrCop(1);
		CRUDResponse response = ivrOpcionDAO.eliminarIvrResponse("192.168.3.202", obj);
		System.out.println(response.getIdResult() + " " + response.getMensaje());
	}

	// @Test
	public void editarIvrOpcionTest() throws Exception
	{
		EditarIvrOpcionRequest obj = new EditarIvrOpcionRequest();
		obj.setpIdIvrCop(59);
		obj.setpIdPadre(0);
		obj.setpNoDescripcion("prueba registro borrar luego");
		obj.setpNoAudio("audio.mp3");
		obj.setpNuAnexo("100");
		obj.setpIdtipo(1);
		obj.setpNoValor("asd");
		obj.setpNoNombre("asd");
		obj.setpIdGrupo(null);
		obj.setpNoAnexoTiempo("asd");
		obj.setpVuelveInicioTiempo(1);
		obj.setpVuelveInicioIncorrecto(1);
		obj.setpNoAnexoIncorrecto("asdasd");
		obj.setpMarcaAnexo(1);
		obj.setpOperadora(1);
		obj.setpTiempoEspera(1);
		obj.setIlDisponible(false);

		CRUDResponse response = ivrOpcionDAO.editarIvrResponse("192.168.3.202", obj);

		System.out.println(response.getIdResult() + " " + response.getMensaje());
	}

//	@Test
	public void listarIvrOpcionTest() throws Exception
	{
		try
		{
			ListarIvrOpcionRequest obj = new ListarIvrOpcionRequest();
			ListarIvrOpcionResponse response = ivrOpcionDAO.listarIvrResponse("192.168.3.254", obj);
			for (IvrOpcion ivr : response.getListaIvrOpcion())
			{
				System.out.println(ivr.getpNoNombre() + " " + ivr.getParent() + " " + ivr.getIdIvrCop() + " " + ivr.isDisponible());
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void buscarOpcionIVRTest()
	{
		String ip = "192.168.3.254";
		String indicioDeNombreIVR = "ivr-oficina";
		
		try
		{
			CRUDResponse response = ivrOpcionDAO.buscarIVRPorNombre( ip, indicioDeNombreIVR );
			Assert.assertNotNull( response );
			System.out.println( response.getMensajeValidacion() );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
