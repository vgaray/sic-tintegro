package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.PlanSalienteDAO;
import pe.com.tintegro.dominio.PlanSaliente;
import pe.com.tintegro.dto.request.ActualizarPlanSalienteRequest;
import pe.com.tintegro.dto.request.InsertarPlanSalienteRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ActualizarPlanSalienteResponse;
import pe.com.tintegro.dto.response.InsertarPlanSalienteResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PlanSalienteDAOTest
{

	@Autowired
	PlanSalienteDAO planSalienteDAO;	

  @Test
	public void TestListarPlanSaliente()
	{
		try {
			ListarPlanSalienteRequest request=new ListarPlanSalienteRequest();
			request.setIdPlanSaliente(null);
			ListarPlanSalienteResponse response=planSalienteDAO.listarPlanSaliente("192.168.3.202",request);
			System.out.println(response.getListado().size());
			for (PlanSaliente plan : response.getListado()) {
				System.out.println("Fecha Inicio"+ plan.getIlClaveUsuario());
				System.out.println("Fecha Inicio"+ plan.getIlHorarioLlamada());
				System.out.println("Fecha Inicio"+ plan.getIlListaNegra());
				System.out.println("Fecha Inicio"+ plan.getIltemporizado());
				System.out.println("idTroncal "+plan.getIdTroncal());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//@Test
	public void TestInsertarPlanSaliente()
	{
		try {
			InsertarPlanSalienteRequest request=new InsertarPlanSalienteRequest();
			request.setNoNombre("PLAN11");
			request.setIlListaNegra(1);
			request.setIlHorarioLlamada(0);
			request.setIlHorarioLlamada(0);
			request.setIltemporizado(1);
			request.setNoDescripcion("DS");
			InsertarPlanSalienteResponse response=planSalienteDAO.insertarPlanSaliente("192.168.3.202",request);
			System.out.println(response.getInsertado());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	//@Test
	public void TestActualizarPlanSaliente()
	{
		try {
			ActualizarPlanSalienteRequest request=new ActualizarPlanSalienteRequest();
			request.setIdPlanSaliente(1);;
			request.setNoNombre("PLAN11");
			request.setIlListaNegra(1);
			request.setIlHorarioLlamada(0);
			request.setIlHorarioLlamada(0);
			request.setIltemporizado(1);
			request.setNoDescripcion("DS");
			ActualizarPlanSalienteResponse response=planSalienteDAO.actualizarPlanSaliente("192.168.3.202",request);
			System.out.println(response.getActualizado());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}
