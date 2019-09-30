package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.GrupoDirectorioDAO;
import pe.com.tintegro.dominio.GrupoDirectorio;
import pe.com.tintegro.dto.request.ListarGrupoDirectRequest;
import pe.com.tintegro.dto.response.ListarGrupoDirectResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GrupoDirectorioDAOTest
{
	@Autowired
	GrupoDirectorioDAO grupoDirectorioDAO;	

	@Test
	public void TestListarGrupoDirectorio()
	{
		try {
			ListarGrupoDirectRequest request=new ListarGrupoDirectRequest();
			request.setIdGrupo(null);
			ListarGrupoDirectResponse response=grupoDirectorioDAO.listarGrupoDirectorio("192.168.3.202",request);
			System.out.println(response.getListado().size());
			for (GrupoDirectorio grupo : response.getListado()) {
				System.out.println("Grupo Nombre: "+ grupo.getNoNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
