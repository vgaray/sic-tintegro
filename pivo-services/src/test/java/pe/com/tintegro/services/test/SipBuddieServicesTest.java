package pe.com.tintegro.services.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.ConfigAnnexRequest;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.ConfigAnnexResponse;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" } )
public class SipBuddieServicesTest
{
	@Autowired
	SipBuddieServices	sipBuddieServices;

	@Ignore
	@Test
	public void testSipBuddieInserta()
	{
		try
		{
			InsertaSipBuddieRequest request = new InsertaSipBuddieRequest();

			request.setNomUsuario("5334");
			request.setClaveUsuario("233");
			request.setCallerId("233");
			/*
			 * request.setBuzonBox("233");
			 * request.setCorreoBox("ejemplo@correo.com"); request.setMarcaId(5);
			 * request.setModeloId(4); request.setMac("test");
			 * request.setIpDominio("127.0.0.1");
			 * request.setRuta("c:/ruta/congig");
			 */

			InsertaSipBuddieResponse response = sipBuddieServices.insertarSipBuddie("codusuariox", "1", request);

			System.out.println(response.getInsertado());

		}
		catch ( Exception e )
		{
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testSipBuddieEdita()
	{
		try
		{
			EditaSipBuddieRequest request = new EditaSipBuddieRequest();

			request.setNomUsuario("5334");
			request.setClaveUsuario("233");
			request.setCallerId("233");
			request.setBuzonBox("233");
			request.setCorreoBox("editar@testito.com");
			request.setMac("testito");
			request.setIpDominio("127.0.0.1");
			request.setRuta("c:/ruta/congig");

			EditaSipBuddieResponse response = sipBuddieServices.editarSipBuddie("codusuariox", "1", request, false);

			System.out.println(response.getEditado());

		}
		catch ( Exception e )
		{
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testSipBuddieElimina()
	{
		try
		{
			EliminaSipBuddieRequest request = new EliminaSipBuddieRequest();

			request.setNomUsuario("5334");

			EliminaSipBuddieResponse response = sipBuddieServices.eliminaSipBuddie("codusuariox", "1", request);

			System.out.println(response.getEliminado());

		}
		catch ( Exception e )
		{
			System.out.println(e.getMessage());
		}
	}
	
	//@Test
	public void getCredentials()
	{
		try
		{
			ConfigAnnexRequest request = new ConfigAnnexRequest();
			request.setNomUsuario( "1060" );
			request.setNomMarca( "NO-APROV" );
			
			ConfigAnnexResponse response = sipBuddieServices.getCredentials( "cli", "jPfFl7Jg2rg=", request );
			System.out.println( "Nombre archivo: " + response.getNameFile() );
			System.out.println( "File base64: " + response.getFileProvisioningBase64() );
			System.out.println( "URL: " + response.getLinkProvisioning() );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testEncriptar()
	{
		try
		{
			System.out.println( EncriptaUtils.encriptar("redhat"));
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}	
}
