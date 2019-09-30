package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dominio.VariableGeneralInstancia;
import pe.com.tintegro.dto.request.ListarVariableGeneralInstanciaRequest;
import pe.com.tintegro.dto.response.ListarVariableGeneralInstanciaResponse;
import pe.com.tintegro.services.VariableGeneralInstanciaService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class VariableGeneralInstanciaServiceTest {
	@Autowired
	VariableGeneralInstanciaService variableServices;
	@Test
	public void testListaVariable() {
		{
				ListarVariableGeneralInstanciaRequest request = new ListarVariableGeneralInstanciaRequest();

				request.setpIdGrupoVariable(1);

				ListarVariableGeneralInstanciaResponse response;
				try {
					response = variableServices.listarVariables("cli", "jPfFl7Jg2rg=", request);
					System.out.println("Tamaño de lista:"
							+ response.getLsVariableGeneral().size());
					for (VariableGeneralInstancia general : response
							.getLsVariableGeneral()) {
						System.out.println(general.getNoVariablesGenerales());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
