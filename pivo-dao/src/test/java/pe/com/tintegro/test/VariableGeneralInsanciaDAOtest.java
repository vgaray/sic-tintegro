package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.VariableGeneralInstanciaDAO;
import pe.com.tintegro.dominio.VariableGeneralInstancia;
import pe.com.tintegro.dto.request.ListarVariableGeneralInstanciaRequest;
import pe.com.tintegro.dto.response.ListarVariableGeneralInstanciaResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class VariableGeneralInsanciaDAOtest {
	@Autowired
	VariableGeneralInstanciaDAO listarvariables;
	@Test
	public void testListaVariable() {
		try {
			ListarVariableGeneralInstanciaRequest request = new ListarVariableGeneralInstanciaRequest();
			request.setpIdGrupoVariable(2);
			ListarVariableGeneralInstanciaResponse response = listarvariables
					.listarVariables("192.168.3.202", request);
			System.out.println("Tamaño de lista"
					+ response.getLsVariableGeneral().size());
			for (VariableGeneralInstancia general : response
					.getLsVariableGeneral()) {
				System.out.println(general.getNoVariablesGenerales());
			}
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}
}
