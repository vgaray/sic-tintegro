package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.ClienteDAO;
import pe.com.tintegro.dominio.Cliente;
import pe.com.tintegro.dto.request.ClienteActualizarRequest;
import pe.com.tintegro.dto.request.ClienteEliminarRequest;
import pe.com.tintegro.dto.request.InsertarClienteRequest;
import pe.com.tintegro.dto.request.ListaClienteAutoCompletarRequest;
import pe.com.tintegro.dto.response.ListaClienteAutoCompletarResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ClienteDAOTest {

	@Autowired
	ClienteDAO clienteDao;

	//@Test
	public void testClienteListar() throws Exception
	{
		
		clienteDao.listarCliente();
	}
	
	//@Test
	public void testClienteInsertar() throws Exception
	{
		InsertarClienteRequest obj=new InsertarClienteRequest();
		obj.setNoRazonSocial("saooo");
		obj.setRuc("lol");
		obj.setDirecc("cxrucdsdcdscdscd");
		obj.setTelef("98979");
		obj.setCorreoEle("correito");
		obj.setPersonRef("personal");
		clienteDao.insertarCliente(obj);
	}
	
	//@Test
	public void testListarClienteAutocompletar(){
		ListaClienteAutoCompletarRequest request=new ListaClienteAutoCompletarRequest(); 
		request.setNoRazon("misael sac");
		try
		{
			List<Cliente> listas=new ArrayList<Cliente>();
			ListaClienteAutoCompletarResponse response=new ListaClienteAutoCompletarResponse();	
		   response=clienteDao.listarClienteAutoCompletar(request);
		   
		   listas=response.getListaCliente();
		   
		   for (int i = 0; i < listas.size(); i++)
			{
				System.out.println(listas.get(i).getNoRazonSocial()+" "+ listas.get(i).getRuc());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//@Test
	//public void testEliminadoCliente() throws Exception
	//{
		//clienteDao.insertarCliente();
		
		//Cliente obj=new Cliente();
		//obj.setIdCliente(10);
		//ClienteMapper.eliminadoCliente(obj);
	//}
	
	@Test
	public void testEliminarCliente() throws Exception
		{
		ClienteEliminarRequest obj=new ClienteEliminarRequest();
		obj.setIdCliente(85);
		clienteDao.eliminarCliente(obj);
		}
	
	//@Test
	public void testActualizarCliente() throws Exception
	{
		//clienteDao.insertarCliente();
		ClienteActualizarRequest obj=new ClienteActualizarRequest();
		obj.setIdCliente(40);
		obj.setNoRazonSocial("NOmbereRazon1234");
		obj.setRuc("cxruc");
		obj.setDirecc("cxrucdsdcdscdscd");
		obj.setTelef("98979");
		obj.setCorreoEle("correito");
		obj.setPersonRef("personal");
		
		clienteDao.actualizarCliente(obj);
	}
}
