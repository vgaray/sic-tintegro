package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.TbUsuarioDAO;
import pe.com.tintegro.dominio.LlamadaUsuario;
import pe.com.tintegro.dominio.TbUsuario;
import pe.com.tintegro.dto.request.ActualizarUsuarioRequest;
import pe.com.tintegro.dto.request.BuscarTbUsuarioRequest;
import pe.com.tintegro.dto.request.EliminarUsuarioRequest;
import pe.com.tintegro.dto.request.FlagTbUsuarioRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioPaginadoRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioxNombreRequest;
import pe.com.tintegro.dto.request.ListarUsuarioxIdRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioResponse;
import pe.com.tintegro.dto.response.BuscarTbUsuarioResponse;
import pe.com.tintegro.dto.response.EliminarUsuarioResponse;
import pe.com.tintegro.dto.response.FlagUsuarioResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.dto.response.ListaLlamadaUsuarioResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioPaginadoResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.dto.response.ListarTbUsuarioxNombreResponse;
import pe.com.tintegro.dto.response.ListarUsuarioxIdResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class TbUsuarioDAOTest {

	@Autowired
	TbUsuarioDAO tbUsuarioDao;

	// @Test
	public void testUsuarioList() {
		try {
			ListaTbUsuarioResponse response = tbUsuarioDao.listarTbUsuario("192.168.3.202");
			System.out.println(response.getTbUsuarioList().size());
			for (TbUsuario usuario : response.getTbUsuarioList()) {
				System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void testListaLlamadaUsuario() {
		try {
			// SimpleDateFormat dateFormatter = new
			// SimpleDateFormat("yyyy-MM-dd");
			// java.util.Date feIni = dateFormatter.parse( "2017-05-18" );
			// java.util.Date feFin = dateFormatter.parse( "2017-05-19" );

			ListaLlamadaUsuarioRequest request = new ListaLlamadaUsuarioRequest();
			request.setIdUsuario(0);
			request.setIdExtension(0);
			request.setFeIni("2017-05-18");
			request.setFeFin("2017-05-19");
			request.setpHorai("00:00:00");
			request.setpHoraf("21:59:59");
			request.setNumPagina(2);
			request.setCantidadxPag(75);
			ListaLlamadaUsuarioResponse response = tbUsuarioDao.ListaLlamadaUsuario("192.168.3.202", request);
			System.out.println(response.getListaLlamadaUsuario().size());
			for (LlamadaUsuario listaLlamada : response.getListaLlamadaUsuario()) {
				System.out.println("Nombre del Usuario: " + listaLlamada.getNoUsuario());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testListaReporteLlamadaUsuario() {
		try {
			ListaLlamadaUsuarioRequest request = new ListaLlamadaUsuarioRequest();
			request.setIdUsuario(0);
			request.setIdExtension(0);
			request.setFeIni("2017-01-01");
			request.setFeFin("2017-07-01");
			request.setpHorai("0:00");
			request.setpHoraf("23:45");

			ListaLlamadaUsuarioResponse response = tbUsuarioDao.ListaReporteLlamadaUsuario("192.168.3.254", request);
			System.out.println(response.getListaLlamadaUsuario().size());
			for (LlamadaUsuario listaLlamada : response.getListaLlamadaUsuario()) {
				System.out.println("Nombre del Usuario: " + listaLlamada.getNoUsuario());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void testUsuarioListxNombre() {
		try {
			ListaTbUsuarioxNombreRequest request = new ListaTbUsuarioxNombreRequest("Ricardo");
			ListarTbUsuarioxNombreResponse response = tbUsuarioDao.listarTbUsuarioxNombre("192.168.3.206", request);
			System.out.println(response.getTbUsuarioListxNombre().size());

			for (TbUsuario usuario : response.getTbUsuarioListxNombre()) {

				System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testModificarFlagUsuario() {
		try {
			FlagTbUsuarioRequest request = new FlagTbUsuarioRequest();
			request.setIdUsupin(817);
			request.setEstado(0);

			FlagUsuarioResponse response = tbUsuarioDao.modificarFlagTbUsuario("192.168.3.206", request);
			System.out.println(response.getActivado());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	// @Test
	public void testInsertarUsuario() {
		try {
			InsertarUsuarioRequest request = new InsertarUsuarioRequest();
			request.setNoApepat("armando");
			request.setNoApemat("armando");
			request.setNoNombre("armando");
			request.setNoPuesto("armando");
			request.setNuPin("176");
			request.setTiLlamad(null);
			request.setIdEmpare(null);
			request.setIdSip(null);

			request.setIlfijloca(0);
			request.setIlfijnaci(1);
			request.setIlfijinte(1);

			request.setIlcelNac(2);
			request.setIlcelInt(0);
			request.setIlcelRpm(1);
			InsertarUsuarioResponse response = tbUsuarioDao.insertarUsuario("192.168.3.206", request);
			System.out.println(response.getInsertado());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	// @Test
	public void testActualizarUsuario() {
		try {
			ActualizarUsuarioRequest request = new ActualizarUsuarioRequest();

			request.setIdUsuario(884);
			request.setNoApepat("see");
			request.setNoApemat("saulito33");
			request.setNoNombre("saulito33");
			request.setNoPuesto("saulito33");
			request.setNuPin("1223");
			// request.setTiLlamad(110);
			// request.setIdEmpare(19);
			request.setIdSip(659);

			// request.setIlfijloca(0);
			// request.setIlfijnaci(0);
			// request.setIlfijinte(0);
			//
			// request.setIlcelNac(0);
			// request.setIlcelInt(0);
			// request.setIlcelRpm(0);
			ActualizarUsuarioResponse response = tbUsuarioDao.ActualizarUsuario("192.168.3.206", request);
			System.out.println(response.getActualizado());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	// @Test
	public void UsuarioEliminar() {
		try {
			EliminarUsuarioRequest request = new EliminarUsuarioRequest();
			request.setIdUsuari(891);

			EliminarUsuarioResponse response = tbUsuarioDao.EliminarUsuario("192.168.3.206", request);
			System.out.println(response.getEliminado());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	// @Test
	public void testUsuarioListxID() {
		try {
			ListarUsuarioxIdRequest request = new ListarUsuarioxIdRequest();
			request.setIdUsuario(884);
			ListarUsuarioxIdResponse response = tbUsuarioDao.ListarUsuarioxId("192.168.3.206", request);
			System.out.println(response.getTbUsuarioListaxId().size());

			for (TbUsuario usuario : response.getTbUsuarioListaxId()) {
				System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testListaUsuarioPaginacion() {
		try {
			ListaTbUsuarioPaginadoRequest request = new ListaTbUsuarioPaginadoRequest();
			request.setNumpagina(2);
			request.setNumRegisMostrar(10);
			ListaTbUsuarioPaginadoResponse response = tbUsuarioDao.listaTbUsuarioPaginado("192.168.3.202", request);
			System.out.println(response.getTbUsuarioList().size());

			for (TbUsuario usuario : response.getTbUsuarioList()) {

				System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBuscarUsuario () {
		try {
			BuscarTbUsuarioRequest request = new BuscarTbUsuarioRequest();
			request.setNoNombre("Alva");
			
			BuscarTbUsuarioResponse response = tbUsuarioDao.buscarTbUsuario("192.168.3.202", request);
			System.out.println(response.getLsUsuario().size());
			for (TbUsuario usuario : response.getLsUsuario()) {
				System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
