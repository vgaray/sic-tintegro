package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.IaxTrunk;
import pe.com.tintegro.dto.request.ActualizaIaxTrunkRequest;
import pe.com.tintegro.dto.request.EliminaIaxTrunkRequest;
import pe.com.tintegro.dto.request.InsertaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListaIaxTrunkRequest;
import pe.com.tintegro.dto.response.ActualizaIaxTrunkResponse;
import pe.com.tintegro.dto.response.EliminaIaxTrunkResponse;
import pe.com.tintegro.dto.response.InsertaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListaIaxTrunkResponse;
import pe.com.tintegro.services.IaxTrunkServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class IaxTrunkServicesTest
{
	@Autowired
	IaxTrunkServices iaxTrunkServices;

	// @Test
	public void insertaIaxTrunk()
	{
		try
		{
			InsertaIaxTrunkRequest request = new InsertaIaxTrunkRequest();
			request.setNomIaxTrunk("nombre ser");
			request.setTipoCentral("Entrante");
			request.setCentralInterna(0);
			request.setIdCentralExterna(2);
			request.setPuertoIax("1000");
			request.setLlamadasConcurrentes(1);
			request.setPrefLlamadaSalientes("064");
			request.setNumEmpresa("056");
			request.setAnexoInterno(1);
			request.setFijoLocal(1);
			request.setFijoNacional(1);
			request.setFijoInternacional(1);
			request.setCelularNacional(1);
			request.setCelularInternacional(1);
			request.setCelularRpm(1);

			InsertaIaxTrunkResponse response = iaxTrunkServices.insertaIaxTrunk("", "192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getResultado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public void actualizaIaxTrunk()
	{
		try
		{
			ActualizaIaxTrunkRequest request = new ActualizaIaxTrunkRequest();
			request.setIdIaxTrunk(1);
			request.setNomIaxTrunk("reds");
			request.setTipoCentral("Entrante");
			request.setCentralInterna(0);
			request.setIdCentralExterna(2);
			request.setPuertoIax("1000");
			request.setLlamadasConcurrentes(1);
			request.setPrefLlamadaSalientes("064");
			request.setNumEmpresa("056");
			request.setAnexoInterno(1);
			request.setFijoLocal(1);
			request.setFijoNacional(1);
			request.setFijoInternacional(1);
			request.setCelularNacional(1);
			request.setCelularInternacional(1);
			request.setCelularRpm(1);

			ActualizaIaxTrunkResponse response = iaxTrunkServices.actualizaIaxTrunk("", "192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getResultado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public void eliminaIaxTrunk()
	{
		try
		{
			EliminaIaxTrunkRequest request = new EliminaIaxTrunkRequest();
			request.setIdIaxTrunk(1);

			EliminaIaxTrunkResponse response = iaxTrunkServices.eliminaIaxTrunk("", "192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getResultado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void listaIaxTrunk()
	{
		try
		{
			ListaIaxTrunkRequest request = new ListaIaxTrunkRequest();
			request.setIdIaxTrunk(21);

			ListaIaxTrunkResponse response = iaxTrunkServices.listaIaxTrunk("cli", "jPfFl7Jg2rg", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
			for (IaxTrunk iaxTrunk : response.getListaIaxTrunk())
			{
				System.out.println(iaxTrunk.getTipoCentral()+" "+iaxTrunk.getCentralInterna() +" "+ iaxTrunk.getCentralInternaEncript() );
			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
