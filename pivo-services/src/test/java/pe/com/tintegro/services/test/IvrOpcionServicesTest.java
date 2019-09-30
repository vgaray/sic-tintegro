package pe.com.tintegro.services.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.IvrOpcion;
import pe.com.tintegro.dto.request.BuscarIVRPorNombreRequest;
import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;
import pe.com.tintegro.services.IvrOpcionServices;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" } )
public class IvrOpcionServicesTest
{
	@Autowired
	IvrOpcionServices	ivrOpcionServices;

	// @Test
	public void insertarIvrTest()
	{
		try
		{
			InsertarIvrOpcionRequest obj = new InsertarIvrOpcionRequest();
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
			InsertarIvrOpcionResponse response = ivrOpcionServices.insertarIvrResponse("192.168.3.202", "L3hv4Sm0Vro=", obj);
			System.out.println(response.getIdResult() + " " + response.getMensaje());
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	// @Test
	public void eliminarIvrOpcionTest()
	{
		try
		{
			EliminarIvrOpcionRequest obj = new EliminarIvrOpcionRequest();
			obj.setpIdIvrCop(2);
			CRUDResponse response = ivrOpcionServices.eliminarIvrResponse("192.168.3.202", "L3hv4Sm0Vro=", obj);
			System.out.println(response.getIdResult() + " " + response.getMensaje());
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	// @Test
	public void editarIvrOpcionTest()
	{
		try
		{
			EditarIvrOpcionRequest obj = new EditarIvrOpcionRequest();
			obj.setpIdIvrCop(4);
			obj.setpIdPadre(0);
			obj.setpNoDescripcion("prueba services");
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
			CRUDResponse response = ivrOpcionServices.editarIvrResponse("192.168.3.202", "L3hv4Sm0Vro=", obj);
			System.out.println(response.getIdResult() + " " + response.getMensaje());
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void listarIvrOpcionTest()
	{
		try
		{
			ListarIvrOpcionRequest obj = new ListarIvrOpcionRequest();
			ListarIvrOpcionResponse response = ivrOpcionServices.listarIvrResponse("192.168.3.202", "63/MrYlPZHs=", obj);
			for (IvrOpcion ivr : response.getListaIvrOpcion())
			{
				System.out.println(ivr.getpNoNombre() + " " + ivr.getpIdPadre() + " " + ivr.getIdIvrCop());
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void buscarIVRPorNombreTest()
	{
		CRUDResponse response = new CRUDResponse();
		try
		{
			BuscarIVRPorNombreRequest request = new BuscarIVRPorNombreRequest();
			request.setNoIVR( "ivr-oficina" );
			
			response = ivrOpcionServices.buscarIVRPorNombre( "cli", "63/MrYlPZHs=", request );
			
			Assert.assertNotNull( response );
			System.out.println( response.getMensajeValidacion() );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
