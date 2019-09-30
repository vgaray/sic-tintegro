package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.PlanPrincipalDAO;
import pe.com.tintegro.dominio.PlanPrincipal;
import pe.com.tintegro.dto.request.InsertarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.ListarContextoPorPlanRequest;
import pe.com.tintegro.dto.request.ListarPlanPrincipalRequest;
import pe.com.tintegro.dto.response.InsertarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.ListarContextoPorPlanResponse;
import pe.com.tintegro.dto.response.ListarPlanPrincipalResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PlanPrincipalDAOTest
{
	@Autowired
	PlanPrincipalDAO planPrincipalDAO;	
	
	@Test
	public void TestListarPlanPrincipal()
	{
		try {
			ListarPlanPrincipalRequest request=new ListarPlanPrincipalRequest();
			request.setIdPlanPrincipal(null);
			ListarPlanPrincipalResponse response=planPrincipalDAO.listarPlanPrincipal("192.168.3.202",request);
			System.out.println(response.getListado().size());
			for (PlanPrincipal plan : response.getListado()) {
				System.out.println("Nombre Plan: "+ plan.getIdPlanPrincipal());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	//@Test
	public void TestListarContextoPorPlan()
	{
		try {
			ListarContextoPorPlanRequest request=new ListarContextoPorPlanRequest();
			request.setIdPlanPrincipal(null);
			ListarContextoPorPlanResponse response=planPrincipalDAO.listarContextoPorPlan("192.168.3.202",request);
			System.out.println(response.getListado().size());
			for (String plan : response.getListado()) {
				System.out.println("Contexto: "+ plan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	//@Test
	public void TestInsertarPlanPrincipal()
	{
		try {
			InsertarPlanPrincipalRequest request=new InsertarPlanPrincipalRequest();
			request.setNoNombre("Plan Principal 2");
			request.setNoDescripcion("Descripcion 2");
			request.setContexto("2_7,2_5,2_1");
			InsertarPlanPrincipalResponse response=planPrincipalDAO.insertarPlanPrincipal("192.168.3.202",request);
			System.out.println(response.getInsertado());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}
