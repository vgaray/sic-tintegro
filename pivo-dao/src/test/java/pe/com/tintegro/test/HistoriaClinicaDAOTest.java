package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.ConstanteFisiologicaDAO;
import pe.com.tintegro.dao.HistoriaClinicaDAO;
import pe.com.tintegro.dao.HistoriaClinicaServiceDAO;
import pe.com.tintegro.dao.ListadoProblemaDAO;
import pe.com.tintegro.dao.VacunaDAO;
import pe.com.tintegro.dominio.Vacuna;
import pe.com.tintegro.dominio.ConstanteFisiologica;
import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dominio.ListadoProblema;
import pe.com.tintegro.dto.request.ActualizarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.EliminarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.ListarListadoProblemaResponse;
import pe.com.tintegro.dto.response.ListarVacunaResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class HistoriaClinicaDAOTest {
	@Autowired
	HistoriaClinicaServiceDAO historiaClinicaDao;
	@Autowired
	ConstanteFisiologicaDAO constanteDao;
	@Autowired
	ListadoProblemaDAO problemaDao;
	@Autowired
	VacunaDAO vacunaDao;

	@Test
	public void listarServiceHistoriaTest() {
		ListarVacunaResponse response = new ListarVacunaResponse();
		ListarHistoriaClinicaServiceRequest request = new ListarHistoriaClinicaServiceRequest();

		request.setpNuChip("77777777777");
		request.setpNoPass("123");
		request.setpIdInstancia(2); // 0: listar todo , 1: listar con contraseña

		try {
			response = vacunaDao.listaVacuna(request);
			if (response.getLsVacuna().get(0) == null) {
				System.out.println("contrasena incorrecta");
			} else {
				for (Vacuna hist : response.getLsVacuna()) {
					System.out.println("Listado:" + hist.toString());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("causa" + e.getCause());
		}
	}
}
