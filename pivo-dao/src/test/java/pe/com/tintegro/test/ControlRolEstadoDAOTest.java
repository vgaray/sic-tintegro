package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.ControlRolEstadoDAO;
import pe.com.tintegro.dto.request.ListaControlRolEstadoRequest;
import pe.com.tintegro.dto.response.ListaControlRolEstadoResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ControlRolEstadoDAOTest
{
	@Autowired
	ControlRolEstadoDAO controlRolEstadoDAO;
	
	@Test
	public void testListarControlRolEstado() throws Exception{
		ListaControlRolEstadoRequest obj= new ListaControlRolEstadoRequest();
		obj.setNoLogin("cli");
		obj.setTiElemto(1);
		obj.setIdEstadoelemento(4);
		ListaControlRolEstadoResponse response = controlRolEstadoDAO.listaControlRolEstadoDAO(obj);
		System.out.println(response.getValidarControlResult().get(0));
	}
}
