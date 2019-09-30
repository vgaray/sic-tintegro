package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.MascotaDAO;
import pe.com.tintegro.dominio.ClienteN;
import pe.com.tintegro.dominio.Mascota;
import pe.com.tintegro.dto.request.EliminarMascotaRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarMascotaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MascotaDAOTest {

	@Autowired
	MascotaDAO mascotaDao;

	 @Test
	public void listarTest() {
		ListarMascotaResponse response = new ListarMascotaResponse();
		ListarMascotaRequest request = new ListarMascotaRequest();

		request.setpIdMascota(null);
		request.setpCodUsuario(null);
		request.setpTiFun(null);
		request.setpTiFun(0);

		try {
			response = mascotaDao.listarMascota(request);
			for (Mascota per : response.getLsMascota()) {
				System.out.println("*****************************************");
				System.out.println("id mascota:" + per.getIdMascota());
				System.out.println("nombre:" + per.getNoNombre());
				System.out.println("especie:" + per.getNoEspecie());
				System.out.println("raza:" + per.getNoRaza());
				System.out.println("color:" + per.getNoColor());
				System.out.println("senias particulares:" + per.getNoSeniasParticulares());
				System.out.println("sexo:" + per.getNoSexo());
				System.out.println("edad:" + per.getNuEdad());
				System.out.println("chip:" + per.getNuChip());
				System.out.println("fenacimiento:" + per.getFeNacimiento());
				System.out.println("dueño:" + per.getNoDuenio());
				System.out.println("registro:" + per.getFeRegistro());
				System.out.println("id_especie:" + per.getIdEspecie());
				System.out.println("id_raza:" + per.getIdRaza());
				System.out.println("*****************************************");

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getCause());
		}
	}

	//@Test
	public void RegistrarTest() throws Exception {
		CRUDResponse response = new CRUDResponse();
		RegistrarMascotaRequest request = new RegistrarMascotaRequest();
		Mascota maobj = new Mascota();
		maobj.setNoNombre("faffy");
		maobj.setNoColor("marron");
		maobj.setNoSeniasParticulares("ninguna");
		maobj.setNoSexo("macho");
		maobj.setCodUsuario("usuAdminis");
		request.setMascota(maobj);
		response = mascotaDao.registrarMascota(request);
		System.out.println("IMPRIMIENDO"+response.getEstado());
		System.out.println("IMPRIMIENDO"+response.getMensaje());
	}
	//@Test
	public void EliminarTest() throws Exception {
		CRUDResponse response = new CRUDResponse();
		EliminarMascotaRequest request = new EliminarMascotaRequest();

		request.setpIdMascota(1);
		response = mascotaDao.eliminarMascota(request);
		System.out.println("IMPRIMIENDO"+response.getEstado());
		System.out.println("IMPRIMIENDO"+response.getMensaje());
	}
}
