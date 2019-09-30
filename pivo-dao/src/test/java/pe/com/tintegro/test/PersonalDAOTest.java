package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.PersonalDAO;
import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class PersonalDAOTest {
	@Autowired
	PersonalDAO personalDao;
	
	@Test
	public void listarTest() {
		ListarPersonalResponse response = new ListarPersonalResponse();
		ListarPersonalRequest request=new ListarPersonalRequest();
		
		request.setpNuDocumento(null);
		request.setpNoNombreApellido(null);
		request.setpIdTipoDocumento(null);
		request.setpIlActivo(null);
		request.setpTiFun(1);
		
		try {
			response=personalDao.listarPersonal("localhost",request);
			for(Personal per: response.getLsPersonal())
			{
				System.out.println("nombre:"+per.getNoPersonal());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getCause());
		}
	}
	//@Test
	public void RegistrarTest() {
		CRUDResponse response = new CRUDResponse();
		RegistrarPersonalRequest request=new RegistrarPersonalRequest();
		Personal obj=new Personal();
		obj.setIdPersonal("10000000007");
		obj.setNoPersonal("");
		obj.setNoApePat("");
		obj.setNoApeMat("");
		obj.setNuDocumento("77518135");
		obj.setNoDireccion("");
		obj.setNuTelefono("");
		obj.setNuCelular("");
		obj.setNoCorreo("");
		obj.setNuCmvp("");
		obj.setIdTipoDocumento(1);
		obj.setIdGrupoOcupacional(1);
		request.setPersonal(obj);
		try {
			response=personalDao.registrarPersonal("localhost",request);
			System.out.println("estado:"+response.getEstado());
			System.out.println("mensaje:"+response.getMensaje());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getCause());
		}
	}
	//@Test
	public void ActualizarTest() {
		CRUDResponse response = new CRUDResponse();
		ActualizarPersonalRequest request=new ActualizarPersonalRequest();
		
		Personal obj=new Personal();
		obj.setIdPersonal("10000000003");
		obj.setNoPersonal("");
		obj.setNoApePat("");
		obj.setNoApeMat("");
		obj.setNuDocumento("");
		obj.setNoDireccion("");
		obj.setNuTelefono("");
		obj.setNuCelular("");
		obj.setNoCorreo("");
		obj.setNuCmvp("");
		obj.setIdTipoDocumento(1);
		obj.setIdGrupoOcupacional(1);
		request.setPersonal(obj);
		try {
			response=personalDao.actualizarPersonal("localhost",request);
			System.out.println("estado:"+response.getEstado());
			System.out.println("mensaje:"+response.getMensaje());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getCause());
		}
	}
}
