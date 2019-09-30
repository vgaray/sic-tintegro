package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.GrupoDirectorio;
import pe.com.tintegro.dto.request.ListarGrupoDirectRequest;
import pe.com.tintegro.dto.response.ListarGrupoDirectResponse;
import pe.com.tintegro.services.GrupoDirectorioServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GrupoDirectorioServicesTest
{
	@Autowired
	protected GrupoDirectorioServices grupoDirectorioServices;
	
	
	@Test
	public void TestListarAgentexCola()
	{
		try
		{
			ListarGrupoDirectRequest request=new ListarGrupoDirectRequest();
			ListarGrupoDirectResponse response= grupoDirectorioServices.listarGrupoDirectorio("cli", "jPfFl7Jg2rg=",request);
			for (GrupoDirectorio directorio : response.getListado()) {
				System.out.println("Directorio: "+ directorio.getNoNombre());
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
