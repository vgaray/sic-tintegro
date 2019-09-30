package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;
import pe.com.tintegro.services.ModeloTelefonoGeneralServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ModeloTelefonoGeneralServicesTest
{
	@Autowired
	ModeloTelefonoGeneralServices modeloTelefonoGeneralServices;
	@Test
	public void testModeloTelefonoList()
	{
		try
		{
			ListaModeloTelefonoPorMarcaRequest request= new ListaModeloTelefonoPorMarcaRequest();
			request.setMarcaId(1);
			ListaModeloTelefonoPorMarcaResponse response = modeloTelefonoGeneralServices.listaModeloTelefonoPorMarca("cli", request);			System.out.println(response.getModeloTelefonoList().size());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
