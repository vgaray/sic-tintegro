package pe.com.tintegro.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.SeguridadDAO;
import pe.com.tintegro.dominio.Confirmacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SeguridadDAOTest
{
	@Autowired
	private SeguridadDAO seguridadDAO;

	@Test
	public void testListarServicioxUsuario() throws Exception
	{
		String noLogin = "jzelada";
		String webServiceURL = "/sic-ws/usuario/listaUsuarioEstandar";
		boolean flEnviaInstancia = true;
		
		List<Confirmacion> confirmacionList = seguridadDAO.validarAccesoAServicio( noLogin, webServiceURL, flEnviaInstancia );
		confirmacionList.forEach( confirmacion -> {
			System.out.println( confirmacion.getMensaje() );
		});
	}

	@Test
	public void testListarInstanciaxUsuario() throws Exception
	{
		String noLogin = "cli";
		Integer idInstancia = 83;
		
		List<Confirmacion> confirmacionList = seguridadDAO.validarAccesoAInstancia(noLogin, idInstancia);
		confirmacionList.forEach( confirmacion -> {
			System.out.println( confirmacion.getMensaje() );
		});
	}
}
