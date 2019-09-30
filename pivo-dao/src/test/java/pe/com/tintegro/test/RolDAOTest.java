package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.RolDAO;
import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dominio.Rol;
import pe.com.tintegro.dto.request.ActualizarRolRequest;
import pe.com.tintegro.dto.request.AsignarPaginaRolRequest;
import pe.com.tintegro.dto.request.ListaRolPorInstanciaRequest;
import pe.com.tintegro.dto.request.ListaRolSinInstanciaRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.request.RolRequest;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaRolPorInstanciaResponse;
import pe.com.tintegro.dto.response.ListaRolSinInstanciaResponse;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.dto.response.RolResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class RolDAOTest
{
	@Autowired
	RolDAO rolDAO;

	// @Test
	public void testListarRolesPorTipo()
	{
		ListarRolPorTipoRolRequest request = new ListarRolPorTipoRolRequest();
		request.setIdTipoRol(1);
		try
		{
			ListarRolPorTipoRolResponse response = new ListarRolPorTipoRolResponse();
			List<Rol> roles = new ArrayList<Rol>();

			response = rolDAO.listarRolPorTipo(request);
			roles = response.getListaRoles();
			for (int i = 0; i < roles.size(); i++)
			{
				System.out.println(roles.get(i).getIdRol() + " " + roles.get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//@Test
	public void testListaRolPorPagina()
	{
		ListaRolPorInstanciaRequest request = new ListaRolPorInstanciaRequest();
		request.setCodUsuario("cli");
		request.setIdInstanciaDeco(54);
		ListaRolPorInstanciaResponse response = new ListaRolPorInstanciaResponse();
		try
		{
			response = rolDAO.listarRolPorPagina(request);
         response.setEstado(1);
         response.setMensaje("Ok");
			for (int i = 0; i < response.getRoles().size(); i++)
			{
				System.out.println(response.getRoles().get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

	}
	
	

	
	@Test
	@Ignore
	public void testPaginas(){
		ListaPaginasRequest request=new ListaPaginasRequest();
		request.setCodUsuario("cli");
		request.setIdRol(2);
		
		ListaPaginasResponse response=new ListaPaginasResponse();
		
		try
		{
			response=rolDAO.listaPaginasPorRol(request);
			for (int i = 0; i < response.getPaginas().size(); i++)

			{
				Pagina p=new Pagina();
				p=response.getPaginas().get(i);
				System.out.println(p.getIdPagina()+"---"+p.getNoPagina());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

      }
   
   //@Test
	public void testCrearRolServices(){
	   RolRequest request=new RolRequest();
	   	
	   	request.setNoRol("Rol Auxiliar");
		request.setNoDescri("Nuevo rol de prueba no se asusten.");
		request.setIlActivo(true);
		request.setIdTipoRol(2);
		request.setIdInstancia(53);	
		
	   	try
			{
	   		RolResponse response = new RolResponse();	   	     
	   	   
	   	    response = rolDAO.crearRol(request);	   	   
					System.out.println(response.getIdRol()+" "+response.getNoMensaje());		
			}
		catch (Exception e)
		{
				System.out.println(e.getMessage());
		}	   
}
	
	//@Test
	public void testAsignarPaginaPorRol(){
	   AsignarPaginaRolRequest request=new AsignarPaginaRolRequest();
	   	
	   	request.setIdRol(1);
		request.setIdPagina(1);
		
		
	   	try
			{
	   		RolResponse response = new RolResponse();	   	     
	   	   
	   	    response = rolDAO.AsignarPaginaPorRol(request);
					System.out.println(response.getIdRol()+" "+response.getNoMensaje());		
			}
		catch (Exception e)
		{
				System.out.println(e.getMessage());
		}	   
	}
	
	//@Test
	public void testActualizarRolServices(){
	   ActualizarRolRequest request=new ActualizarRolRequest();
	   
	    request.setIdRol(16);
	   	request.setNoRol("Rol Auxiliar");
		request.setNoDescri("Actualiza II");
		request.setIlActivo(true);
		request.setIdTipoRol(2);
		request.setIdInstancia(53);	
		
	   	try
			{
	   		RolResponse response = new RolResponse();	   	     
	   	   
	   	    response = rolDAO.actualizarRol(request);	   	   
					System.out.println(response.getIdRol()+" "+response.getNoMensaje());		
			}
		catch (Exception e)
		{
				System.out.println(e.getMessage());
		}	   
	}
	
	//@Test
	public void testEliminarPaginaPorRol(){
	   AsignarPaginaRolRequest request=new AsignarPaginaRolRequest();
	   	
	   	request.setIdRol(16);				
		
	   	try
			{
	   		RolResponse response = new RolResponse();	   	     
	   	   
	   	    response = rolDAO.eliminarPaginaPorRol(request);
					System.out.println(response.getIdRol()+" "+response.getNoMensaje());		
			}
		catch (Exception e)
		{
				System.out.println(e.getMessage());
		}	   

	}

	
	
	@Test
	@Ignore
	public void testListaRolSinPagina()
	{
		ListaRolSinInstanciaRequest request = new ListaRolSinInstanciaRequest();
		request.setCodUsuario("cli");
		
		ListaRolSinInstanciaResponse response = new ListaRolSinInstanciaResponse();
		try
		{
			response = rolDAO.listaRolSinInstancia(request);
         
			for (int i = 0; i < response.getRoles().size(); i++)
			{
				System.out.println(response.getRoles().get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	@Test
	public void testEliminarRol()
	{
		Integer idInstancia = 53;
		Integer idRol = 50;
		
		try 
		{
			List<Confirmacion> confirmacionList = rolDAO.eliminarRol(idInstancia, idRol);
			System.out.println( "Resultado de la eliminación: " );
			confirmacionList.forEach( confirmacion -> { 
				System.out.println( String.format( "%s %s", confirmacion.getID(), confirmacion.getMensaje() ) ); 
			} );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
