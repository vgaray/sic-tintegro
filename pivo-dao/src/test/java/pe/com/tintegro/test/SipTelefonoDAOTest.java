package pe.com.tintegro.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.SipTelefonoDAO;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.AutoCompletarSipTelefonoRequest;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.request.ValidaMailBoxRequest;
import pe.com.tintegro.dto.response.AutoCompletarSipTelefonoResponse;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaMailBoxResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SipTelefonoDAOTest
{
	@Autowired
	SipTelefonoDAO sipTelefonoDAO;

	@Test
	public void testSipTelefonoList()
	{
		try
		{
			ListaSipTelefonoResponse response = sipTelefonoDAO.listaSipTelefono("192.168.3.202");
			List<SipTelefono> sipTelefonoList = response.getSipTelefonoList();
			sipTelefonoList.forEach( ( sipTelefono ) -> {
				System.out.println( String.format( "Anexo: %s", sipTelefono.getCallerId() ) );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// @Test
	public void testBuscaSipTelefonoList()
	{
		try
		{
			BuscaSipBuddieIdRequest request = new BuscaSipBuddieIdRequest();
			request.setNomUsuario("3843");

			BuscaSipBuddieIdResponse response = sipTelefonoDAO.BuscaSipBuddie("192.168.3.202", request);
			System.out.println(response.getSipTelefonoList().size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// @Test
	public void obtenerSipTelelefonoPorNumeroAnexoTest()
	{
		String nuAnexo = "9002";
		try
		{
			SipTelefono sipTelefono = sipTelefonoDAO.obtenerSipTelelefonoPorNumeroAnexo("rpareja", "192.168.3.245", nuAnexo);
			System.out.println("Anexo obtenido con éxito: " + sipTelefono.getNomUsuario() + " " + sipTelefono.getNomMac());
		}
		catch (Exception e)
		{
			System.err.println("Ocurrió un error al obtener el anexo con número: " + nuAnexo);
		}
	}

	// @Test
	public void obtenerMarcaPorNumeroDeAnexoTest()
	{
		String nuAnexo = "9002";

		try
		{
			MarcaTelefono marca = sipTelefonoDAO.obtenerMarcaPorNumeroDeAnexo("rpareja", "192.168.3.245", nuAnexo);
			System.out.println("Marca obtenida con éxito: " + marca.getNomMarca() + " " + marca.getNoExtensionForProvisioning());
		}
		catch (Exception e)
		{
			System.err.println("Ocurrió un error al obtener la marca del teléfono " + nuAnexo);
		}
	}

	// @Test
	public void testAutoCompletarSipTelefono()
	{
		try
		{
			AutoCompletarSipTelefonoRequest request = new AutoCompletarSipTelefonoRequest();
			request.setpNuAnexo("1");
			AutoCompletarSipTelefonoResponse response = sipTelefonoDAO.AutoCompletarSipTelefono("192.168.3.202", request);

			System.out.println(response.getListaAnexos().get(1));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

//	@Test
	public void testValidaMailBox()
	{
		try
		{
			ValidaMailBoxRequest request = new ValidaMailBoxRequest();
			request.setMailBox("3843");

			ValidaMailBoxResponse response = sipTelefonoDAO.validarMailBox("cli", "192.168.3.202", request);
			System.out.println(response.getExiste());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
