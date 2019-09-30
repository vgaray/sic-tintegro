package pe.com.tintegro.services.test;

import java.util.regex.Pattern;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dto.request.CheckTokenRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAInstanciaRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAServicioRequest;
import pe.com.tintegro.dto.response.ValidaAccesoAInstanciaResponse;
import pe.com.tintegro.dto.response.ValidaAccesoAServicioResponse;
import pe.com.tintegro.dto.response.ValidaAccessTokenResponse;
import pe.com.tintegro.services.SeguridadServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SeguridadServicesTest
{
	@Autowired
	private SeguridadServices seguridadServices;

	//@Test
	public void validarAccesoAServicioTest()
	{
		ValidaAccesoAServicioRequest request = new ValidaAccesoAServicioRequest();
		request.setNoLogin("cli");
		request.setNoUrl("/sic-ws/pagina/listarPaginasGPedido");
		request.setIlIstancia(true);

		try
		{
			ValidaAccesoAServicioResponse response = seguridadServices.validarAccesoAServicio(request);
			Confirmacion confirmacion = response.getConfirmacion();
			System.out.println(String.format("%s %s", confirmacion.getID(), confirmacion.getMensaje()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void validarAccesoAInstanciaTest()
	{
		ValidaAccesoAInstanciaRequest request = new ValidaAccesoAInstanciaRequest();
		request.setNoLogin("cli");
		request.setIdInstancia("jPfFl7Jg2rg=");

		try
		{
			ValidaAccesoAInstanciaResponse response = seguridadServices.validarAccesoAInstancia(request);
			Confirmacion confirmacion = response.getConfirmacion();
			System.out.println(String.format("%s %s", confirmacion.getID(), confirmacion.getMensaje()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void validarAccessTokenTest()
	{
		CheckTokenRequest request = new CheckTokenRequest();
		ValidaAccessTokenResponse response = new ValidaAccessTokenResponse();
		
		try
		{
			request.setClientId( "sic-frontend" );
			request.setToken( "sdfaf" );
			
			response = seguridadServices.validarAccessToken(request);
			Confirmacion confirmacion = response.getConfirmacion();
			
			System.out.println( confirmacion.getMensaje() );
			System.out.println( "Fin" );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
    public Pattern[] patterns = new Pattern[]{
        // Script fragments
        Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
        // src='...'
        Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // lonely script tags
        Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
        Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // eval(...)
        Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // expression(...)
        Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // javascript:...
        Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
        // vbscript:...
        Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
        // onload(...)=...
        Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };


}
