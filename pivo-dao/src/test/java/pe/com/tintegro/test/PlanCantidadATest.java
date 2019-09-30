package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.PlanCantidadADAO;
import pe.com.tintegro.dominio.Plan;
import pe.com.tintegro.dto.request.ListarPlanCantidadARequest;
import pe.com.tintegro.dto.response.ListarPlanCantidadAResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class PlanCantidadATest {
	@Autowired
	PlanCantidadADAO plancatidadADAO;
	@Test
	public void testTerritorioListar() throws Exception {
		int contador = 1;
		ListarPlanCantidadARequest request=new ListarPlanCantidadARequest();
		request.setpIdPlan(3);
		ListarPlanCantidadAResponse response = plancatidadADAO.listarplancantidadanexos(request);
			System.out.println("Tamaño de lista"
					+ response.getLsplanAnexos().size());
			for (Plan general : response.getLsplanAnexos()) {
				System.out.println("fila:" + contador);
				System.out.println(general.getNoDescripcion());
				System.out.println(general.getCaAnexos());
				contador++;
				System.out.println("*****************************************************");
		}
	}
}
