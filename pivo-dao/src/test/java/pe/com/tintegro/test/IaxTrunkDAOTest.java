package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.IaxTrunkDAO;
import pe.com.tintegro.dominio.IaxTrunk;
import pe.com.tintegro.dto.request.ActualizaIaxTrunkRequest;
import pe.com.tintegro.dto.request.EliminaIaxTrunkRequest;
import pe.com.tintegro.dto.request.InsertaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListarCentralesNoDisponiblesRequest;
import pe.com.tintegro.dto.response.ActualizaIaxTrunkResponse;
import pe.com.tintegro.dto.response.EliminaIaxTrunkResponse;
import pe.com.tintegro.dto.response.InsertaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListarCentralesNoDisponiblesResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class IaxTrunkDAOTest
{
	@Autowired
	IaxTrunkDAO iaxTrunkDAO;

	//@Test
	public void insertaIaxTrunk()
	{
		try
		{
			InsertaIaxTrunkRequest request = new InsertaIaxTrunkRequest();
			request.setNomIaxTrunk("trunk");
			request.setTipoCentral("Entrante");
			request.setCentralInterna(0);
			request.setIdCentralExterna(null);
			request.setPuertoIax("1000");
			request.setLlamadasConcurrentes(1);
			request.setPrefLlamadaSalientes("064");
			request.setNumEmpresa("064,065");
			request.setAnexoInterno(1);
			request.setFijoLocal(1);
			request.setFijoNacional(1);
			request.setFijoInternacional(1);
			request.setCelularNacional(1);
			request.setCelularInternacional(1);
			request.setCelularRpm(1);
			request.setNomContext("from-trunk");

			InsertaIaxTrunkResponse response = iaxTrunkDAO.insertaIaxTrunk("192.168.3.202", request);
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

	// @Test
	public void actualizaIaxTrunk()
	{
		try
		{
			ActualizaIaxTrunkRequest request = new ActualizaIaxTrunkRequest();
			request.setIdIaxTrunk(2);
			request.setNomIaxTrunk("iax editado");
			request.setTipoCentral("Entrante editado");
			request.setCentralInterna(0);
			request.setIdCentralExterna(18);
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

			ActualizaIaxTrunkResponse response = iaxTrunkDAO.actualizaIaxTrunk("192.168.3.202", request);
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

	// @Test
	public void eliminaIaxTrunk()
	{
		try
		{
			EliminaIaxTrunkRequest request = new EliminaIaxTrunkRequest();
			request.setIdIaxTrunk(3);

			EliminaIaxTrunkResponse response = iaxTrunkDAO.eliminaIaxTrunk("192.168.3.202", request);
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

	// @Test
	public void listaIaxTrunk()
	{
		try
		{
			ListaIaxTrunkRequest request = new ListaIaxTrunkRequest();
			request.setIdIaxTrunk(1);

			ListaIaxTrunkResponse response = iaxTrunkDAO.listaIaxTrunk("192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
			for (IaxTrunk iaxTrunk : response.getListaIaxTrunk())
			{
				System.out.println(iaxTrunk.getNomIaxTrunk() + " " + iaxTrunk.getTipoCentral());
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void listarCentrales()
	{
		try
		{
			ListarCentralesNoDisponiblesRequest request = new ListarCentralesNoDisponiblesRequest();
			request.setTipoCentral("Externa");

			ListarCentralesNoDisponiblesResponse response = iaxTrunkDAO.listaCentralesNoDisponibles("192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
			for (int i = 0; i < response.getListado().size(); i++)
			{
				System.out.println(response.getListado().get(i)+"");
			}			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}	
}
