package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Cliente;
import pe.com.tintegro.dto.request.ClienteActualizarRequest;
import pe.com.tintegro.dto.request.ClienteEliminarRequest;
import pe.com.tintegro.dto.request.InsertarClienteRequest;
import pe.com.tintegro.dto.request.ListaClienteAutoCompletarRequest;
import pe.com.tintegro.dto.response.ListaClienteAutoCompletarResponse;
import pe.com.tintegro.services.ClienteServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ClienteServicesTest
{

	@Autowired
	ClienteServices clienteServices;

	//@Test
	public void testClienteList()
	{
		try
		{
			clienteServices.listarcliente("");

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testClientActualizar()
	{
		try
		{

			ClienteActualizarRequest obj = new ClienteActualizarRequest();
			obj.setIdCliente(26);
			obj.setNoRazonSocial("LUISito");
			obj.setRuc("el");
			obj.setDirecc("chama");
			obj.setPersonRef("co");
			obj.setCorreoEle("LUIS");
			obj.setTelef("LUIS");
			clienteServices.actualizarCliente("", obj);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testClientEliminar()
	{
		try
		{

			ClienteEliminarRequest obj = new ClienteEliminarRequest();
			obj.setIdCliente(12);

			clienteServices.eliminarCliente("", obj);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testClienteInsert2()
	{
		try
		{

			InsertarClienteRequest obj = new InsertarClienteRequest();

			obj.setNoRazonSocial("nandito");
			obj.setRuc("nandito");
			obj.setDirecc("nandito");
			obj.setPersonRef("nandito");
			obj.setCorreoEle("nandito");
			obj.setTelef("nandito");
			clienteServices.insertarCliente("", obj);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListaClienteAutocompletarServices()
	{
		ListaClienteAutoCompletarRequest request = new ListaClienteAutoCompletarRequest();
		request.setNoRazon("misael sac");
		try
		{

			List<Cliente> listas = new ArrayList<Cliente>();
			ListaClienteAutoCompletarResponse response = new ListaClienteAutoCompletarResponse();
			response = clienteServices.listaClienteAutoCompletar("asd", request);
			listas = response.getListaCliente();

			for (int i = 0; i < listas.size(); i++)
			{
				System.out.println(listas.get(i).getNoRazonSocial() + " " + listas.get(i).getRuc());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
