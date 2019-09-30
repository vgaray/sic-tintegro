package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;

import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;
import pe.com.tintegro.services.ModeloTelefonoServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ModeloTelefonoServicesTest
{
	@Autowired
	ModeloTelefonoServices modeloTelefonoServices;

	@Test
	public void testModeloTelefonoList()
	{
		try
		{
			ListaModeloTelefonoPorMarcaRequest request= new ListaModeloTelefonoPorMarcaRequest();
			request.setMarcaId(5);
			ListaModeloTelefonoPorMarcaResponse response = modeloTelefonoServices
					.listaModeloTelefonoPorMarca("codusuariox","1", request);
			System.out.println(response.getModeloTelefonoList().size());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
