package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.PaginaDAO;
import pe.com.tintegro.dominio.Rol;
import pe.com.tintegro.dto.request.ActualizarRolRequest;
import pe.com.tintegro.dto.request.AsignarPaginaRolRequest;
import pe.com.tintegro.dto.request.EliminaRolRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.request.RolRequest;
import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.request.ListaRolPorInstanciaRequest;
import pe.com.tintegro.dto.request.ListaRolSinInstanciaRequest;
import pe.com.tintegro.dto.response.EliminaRolResponse;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaRolPorInstanciaResponse;
import pe.com.tintegro.dto.response.ListaRolSinInstanciaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.dto.response.RolResponse;
import pe.com.tintegro.services.RolServices;
import pe.com.tintegro.services.util.PaginaUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class RolServicesTest
{
	@Autowired
	RolServices rolServices;

	@Resource(name = "paginaDAO")
	PaginaDAO paginaDAO;

	//@Test
	public void testRolServices(){
		ListarRolPorTipoRolRequest request=new ListarRolPorTipoRolRequest();
		request.setIdTipoRol(1);
		List<Rol> listas = new ArrayList<Rol>();
		try
		{
			ListarRolPorTipoRolResponse response = new ListarRolPorTipoRolResponse();
			response = rolServices.listarRolesServices(request);
			listas = response.getListaRoles();
			for (int i = 0; i < listas.size(); i++)
			{
				System.out.println(listas.get(i).getIdRol() + " " + listas.get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// @Test
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

			response = rolServices.crearRol("usuAdminis", "sdasdadsadasdasdas", request);
			System.out.println(response.getIdRol() + " " + response.getNoMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testAsignarPaginaPorRol()
	{
		AsignarPaginaRolRequest request = new AsignarPaginaRolRequest();

		List<AsignarPaginaRolRequest> lista = new ArrayList<AsignarPaginaRolRequest>();

		request.setIdRol(1);
		request.setIdPagina(1);

		lista.add(request);

		request = new AsignarPaginaRolRequest();
		request.setIdRol(1);
		request.setIdPagina(2);

		lista.add(request);

		try
		{
			RolResponse response = new RolResponse();
			AsignarPaginaRolRequest requestfn;
			for (int i = 0; i <= lista.size(); i++)
			{
				requestfn = new AsignarPaginaRolRequest();
				requestfn.setIdRol(lista.get(i).getIdRol());
				requestfn.setIdPagina(lista.get(i).getIdPagina());
				response = rolServices.asignarPaginaPorRol("usuAdminis", "masmamsm", requestfn);
				System.out.println(response.getIdRol() + " " + response.getNoMensaje());
			}

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testAsignarPaginaPorRolTotal()
	{

		RolRequest request = new RolRequest();
		request.setNoRol("Rol Auxiliar II");
		request.setNoDescri("Nuevo rol de prueba no se asusten.");
		request.setIlActivo(true);
		request.setIdTipoRol(2);
		request.setIdInstancia(53);

		AsignarPaginaRolRequest requestAsg = new AsignarPaginaRolRequest();

		List<AsignarPaginaRolRequest> lista = new ArrayList<AsignarPaginaRolRequest>();

		requestAsg.setIdRol(1);
		requestAsg.setIdPagina(1);

		lista.add(requestAsg);

		requestAsg = new AsignarPaginaRolRequest();
		requestAsg.setIdRol(1);
		requestAsg.setIdPagina(2);

		lista.add(requestAsg);

		request.setListPaginaRol(lista);

		try
		{
			RolResponse response = new RolResponse();
			response = rolServices.asignarPaginaPorRolTotal("usuAdminis", "msmsm", request);
			System.out.println(response.getIdRol() + " " + response.getNoMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testActualizarRolServices()
	{
		ActualizarRolRequest request = new ActualizarRolRequest();
		request.setIdRol(16);
		request.setNoRol("Rol Auxiliar");
		request.setNoDescri("Nuevo rol de prueba no se asusten.");
		request.setIlActivo(true);
		request.setIdTipoRol(1);
		request.setIdInstancia(53);

		try
		{
			RolResponse response = new RolResponse();

			response = rolServices.actualizarRol("usuAdminis", "sdasdadsadasdasdas", request);
			System.out.println(response.getIdRol() + " " + response.getNoMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	//@Test
	public void testActualizarRolTotal(){
		
		ActualizarRolRequest request=new ActualizarRolRequest();
		request.setIdRol(16);
		request.setNoRol("Rol Auxiliar TRES");
		request.setNoDescri("Actualizado mas...");
		request.setIlActivo(true);
		request.setIdTipoRol(2);
		request.setIdInstancia(53);

		AsignarPaginaRolRequest requestAsg = new AsignarPaginaRolRequest();

		List<AsignarPaginaRolRequest> lista = new ArrayList<AsignarPaginaRolRequest>();

		requestAsg.setIdRol(16);
		requestAsg.setIdPagina(1);

		lista.add(requestAsg);

		requestAsg = new AsignarPaginaRolRequest();
		requestAsg.setIdRol(16);
		requestAsg.setIdPagina(2);
		lista.add(requestAsg);

		// requestAsg = new AsignarPaginaRolRequest();
		// requestAsg.setIdRol(16);
		// requestAsg.setIdPagina(3);
		// lista.add(requestAsg);

		request.setListPaginaRol(lista);

		try
		{
			RolResponse response = new RolResponse();
			response = rolServices.actualizarRolTotal("usuAdminis", "msmsm", request);
			System.out.println(response.getIdRol() + " " + response.getNoMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

//	@Test
	public void testListaRolPorPagina()
	{
		ListaRolPorInstanciaRequest request = new ListaRolPorInstanciaRequest();
		ListaRolPorInstanciaResponse response = new ListaRolPorInstanciaResponse();
		request.setCodUsuario("cli");
		request.setIdInstancia("qgm3WrDneOQ=");
		try
		{
			response = rolServices.listarRolPorPaginaServices(request);

			for (int i = 0; i < response.getRoles().size(); i++)
			{
				System.out.println(response.getRoles().get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	// @Test
	public void testListarPaginaPorIdRol()
	{
		ListaPaginasRequest request = new ListaPaginasRequest();
		request.setCodUsuario("cli");
		request.setIdRol(2);

		ListarPaginaRequest request2 = new ListarPaginaRequest();

		ListaPaginasResponse response = new ListaPaginasResponse();
		ListarPaginaResponse response2 = new ListarPaginaResponse();

		List<Pagina> pags1 = new ArrayList<Pagina>();
		List<Pagina> pags2 = new ArrayList<Pagina>();

		List<Pagina> result = new ArrayList<Pagina>();

		try
		{
			response = rolServices.listaPaginasPorRolServices(request);
			response2 = paginaDAO.listarPagina(request2);

			pags1 = response.getPaginas();
			pags2 = response2.getListaPagina();

			result = PaginaUtil.interseccion(pags1, pags2);
			
			for (int i = 0; i < result.size(); i++)
			{
				Pagina p = new Pagina();
				p = result.get(i);
				System.out.println(p.getIdPagina() + "---" + p.getNoPagina() +"---"+p.isSeleccionado());
			}

			//
			// System.out.println(response.getEstado()+"\n"+response.getMensaje()+"\n");
			// for (int i = 0; i < response.getPaginas().size(); i++)
			// {
			// Pagina p=new Pagina();
			// p=response.getPaginas().get(i);
			// System.out.println(p.getIdPagina()+"---"+p.getNoPagina());
			// }
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	
	
	//@Test
	public void testListaRolSinPagina()
	{
		ListaRolSinInstanciaRequest request = new ListaRolSinInstanciaRequest();
		ListaRolSinInstanciaResponse response = new ListaRolSinInstanciaResponse();
		request.setCodUsuario("cli");
		//request.setIdInstancia("qq4zMLPZv40=");
		try
		{
			response = rolServices.listarRolSinInstanciaServices(request);

			for (int i = 0; i < response.getRoles().size(); i++)
			{
				System.out.println(response.getRoles().get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testEliminarRolServices()
	{
		String idInstancia = "qgm3WrDneOQ=";
		Integer idRol = 50;
		
		EliminaRolRequest request = new EliminaRolRequest();
		request.setIdRol( idRol );
		
		EliminaRolResponse response = new EliminaRolResponse();
		
		try 
		{
			response = rolServices.eliminarRol(idInstancia, request);
			List<Confirmacion> confirmacionList = response.getConfirmacionList();
			
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
