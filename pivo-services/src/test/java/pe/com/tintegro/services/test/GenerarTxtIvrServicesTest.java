package pe.com.tintegro.services.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.GenerarTxtIvrDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dto.request.GenerarTxtIvrReques;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.GenerarTxtIvrResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;
import pe.com.tintegro.services.GenerarTxtIvrServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.IvrOpcionServices;
import pe.com.tintegro.services.util.ServicesProperties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GenerarTxtIvrServicesTest
{
	@Autowired
	GenerarTxtIvrServices generarTxtIvrServices;

	@Autowired
	private GenerarTxtIvrDAO generarTxtIvrDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	private IvrOpcionServices ivrOptionServices;

	@Autowired
	private ServicesProperties servicesProperties;

	private static final String COD_USUARIO_TEST = "cli";
	private static final String ID_INSTANCIA_TEST = "L3hv4Sm0Vro=";

//	@Test
	public void generarhorarioTxt()
	{
		try
		{
			String resultHorario = "";

			InstanciaServerAsterisk vm = instanciaServices.buscarInstancia( COD_USUARIO_TEST, ID_INSTANCIA_TEST );

			GenerarTxtIvrResponse listHorario = generarTxtIvrDAO.listarGenerarTxtIvr( vm.getIpAsterisk(), new GenerarTxtIvrReques() );

			resultHorario = generarTxtIvrServices.generarHorarioIVR( COD_USUARIO_TEST, listHorario.getListGenerarTxtIvr() );

			System.out.println( resultHorario );
		}
		catch ( Exception ex )
		{
			System.out.println( "error" + ex.getMessage() );
		}
	}

	// @Test
	public void generarSeccionIVRTest()
	{
		try
		{
			ListarIvrOpcionResponse lsIvrOptionsResponse = ivrOptionServices.listarIvrResponse( COD_USUARIO_TEST, ID_INSTANCIA_TEST, new ListarIvrOpcionRequest() );

			String sectionIVROptions = generarTxtIvrServices.generarSeccionIVR( COD_USUARIO_TEST, lsIvrOptionsResponse.getListaIvrOpcion() );
			System.out.println( sectionIVROptions );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void generarArchivoIVRTest()
	{
		String ivrFileString;

		try
		{
			ivrFileString = generarTxtIvrServices.generarArchivoIVREnServidorAsterisk( COD_USUARIO_TEST, ID_INSTANCIA_TEST );
			System.out.println( ivrFileString );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
