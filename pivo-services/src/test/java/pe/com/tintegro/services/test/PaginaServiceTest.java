package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dominio.Rol;
import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.services.PaginaService;
import pe.com.tintegro.services.util.PaginaUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PaginaServiceTest {
	@Autowired
	PaginaService paginaServices;
	
	//@Test
	public void testListarPaginaServices(){
		ListarPaginaRequest request = new ListarPaginaRequest();
		request.setCodUsuario("cli");
		request.setIdRol(2);
		List<Pagina> listas=new ArrayList<Pagina>();
		List<Pagina> listas1=new ArrayList<Pagina>();
		try
		{
			ListarPaginaResponse response=new ListarPaginaResponse();
			response = paginaServices.listarPaginaServices(request);
			listas1=response.getListaPagina();
			
			//PaginaUtil  PaginaUtil = new PaginaUtil();
			
			//listas1 = PaginaUtil.procesarData(listas);
			System.out.println("---------------------------------------------------------");
			for (int i = 0; i < listas1.size(); i++)
			{
				System.out.println(listas1.get(i).getIdPagina()+" "+listas1.get(i).getNoPagina()+"  "+listas1.get(i).isSeleccionado());
				for(int k= 0; k<listas1.get(i).getListHijos().size(); k++){
					System.out.println(listas1.get(i).getListHijos().get(k).getIdPagina()+" "+listas1.get(i).getListHijos().get(k).getNoPagina()+" "+listas1.get(i).getListHijos().get(k).getIdPadre()+"  "+listas1.get(i).getListHijos().get(k).isSeleccionado());
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//@Test
	public void testListarPaginaServicesGP(){
		ListarPaginaRequest request = new ListarPaginaRequest();
		request.setCodUsuario("cli");
		request.setIdRol(2);
		
		List<Pagina> listas1=new ArrayList<Pagina>();
		try
		{
			ListarPaginaResponse response=new ListarPaginaResponse();
			response = paginaServices.listarPaginaServicesGP(request);
			listas1=response.getListaPagina();
			
			for (int i = 0; i < listas1.size(); i++)
			{
				System.out.println(listas1.get(i).getIdPadre()+"  "+listas1.get(i).getIdPagina()+"  "+listas1.get(i).getNoPagina()+"  "+listas1.get(i).isSeleccionado());
			}
			
			//PaginaUtil  PaginaUtil = new PaginaUtil();
			
			//listas1 = PaginaUtil.procesarData(listas);
			System.out.println("---------------------------------------------------------");
			for (int i = 0; i < listas1.size(); i++)
			{
				System.out.println(listas1.get(i).getIdPagina()+" "+listas1.get(i).getNoPagina()+"  "+listas1.get(i).isSeleccionado());
				for(int k= 0; k<listas1.get(i).getListHijos().size(); k++){
					System.out.println(listas1.get(i).getListHijos().get(k).getIdPagina()+" "+listas1.get(i).getListHijos().get(k).getNoPagina()+" "+listas1.get(i).getListHijos().get(k).getIdPadre()+"  "+listas1.get(i).getListHijos().get(k).isSeleccionado());
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testListarUrlServices(){
		ListaUrlPaginaRequest request = new ListaUrlPaginaRequest();
		request.setpNoComponente("principal.musicOnHold");
		try {
			List<Pagina> paginas = new ArrayList<Pagina>();
			ListaUrlPaginaResponse response = new ListaUrlPaginaResponse();
			response = paginaServices.listaUrlPaginaResponse(request);
			paginas = response.getLsPaginaUrl();
			for(int i = 0; i< paginas.size(); i++){
				System.out.println(paginas.get(i).getNoComponente() + " " + paginas.get(i).getNoUrl() + " ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
