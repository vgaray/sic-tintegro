package pe.com.tintegro.services.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.ListaNegra;
import pe.com.tintegro.dominio.TbUsuario;
import pe.com.tintegro.dto.request.ActualizarUsuarioRequest;
import pe.com.tintegro.dto.request.BuscarTbUsuarioRequest;
import pe.com.tintegro.dto.request.EliminarTbPinRequest;
import pe.com.tintegro.dto.request.EliminarUsuarioRequest;
import pe.com.tintegro.dto.request.FlagTbUsuarioRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioxNombreRequest;
import pe.com.tintegro.dto.request.ListarUsuarioxIdRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioResponse;
import pe.com.tintegro.dto.response.BuscarTbUsuarioResponse;
import pe.com.tintegro.dto.response.EliminarTbPinResponse;
import pe.com.tintegro.dto.response.EliminarUsuarioResponse;
import pe.com.tintegro.dto.response.FlagUsuarioResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.dto.response.ListaLlamadaUsuarioResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.dto.response.ListarTbUsuarioxNombreResponse;
import pe.com.tintegro.dto.response.ListarUsuarioxIdResponse;
import pe.com.tintegro.services.TbUsuarioServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class TbUsuarioServicesTest {

	@Autowired
	TbUsuarioServices tbUsuarioServices;

	// @Test
	public void testTbUsuario() {
		try {
			ListaTbUsuarioResponse response = tbUsuarioServices.ListarTbUsuario("codusuariox", "1");
			System.out.println(response.getTbUsuarioList().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * @Test public void testListaTbUsuarioxNombre() { try {
	 * ListaTbUsuarioxNombreRequest request = new
	 * ListaTbUsuarioxNombreRequest("Arévalo"); ListarTbUsuarioxNombreResponse
	 * response=tbUsuarioServices.ListarTbUsuarioxNombre("", request);
	 * System.out.println(response.getTbUsuarioListxNombre().size()); for
	 * (TbUsuario usuario : response.getTbUsuarioListxNombre()) {
	 * 
	 * System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
	 * 
	 * }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * @Test public void testListaTbUsuarioxID() { try { ListarUsuarioxIdRequest
	 * request = new ListarUsuarioxIdRequest(); request.setIdUsuario(884);
	 * ListarUsuarioxIdResponse response=tbUsuarioServices.ListarUsuarioxId("",
	 * request); System.out.println(response.getTbUsuarioListaxId().size()); for
	 * (TbUsuario usuario : response.getTbUsuarioListaxId()) {
	 * 
	 * System.out.println("Nombre del Usuario prueba x id: " +
	 * usuario.getNoNombre());
	 * 
	 * }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * @Test public void testModificarFlagUsuario() { try { FlagTbUsuarioRequest
	 * request = new FlagTbUsuarioRequest(); request.setEstado( 1 );
	 * request.setIdUsupin(820);
	 * 
	 * FlagUsuarioResponse
	 * response=tbUsuarioServices.modificarFlagTbUsuario("192.168.3.206",
	 * request); System.out.println(response.getActivado()); } catch (Exception
	 * exception) { // TODO Auto-generated catch block System.out.println(
	 * exception.getMessage() ); } }
	 * 
	 * @Test public void testInsertarUsuario() { try { InsertarUsuarioRequest
	 * request = new InsertarUsuarioRequest(); request.setNoApepat("josue5");
	 * request.setNoApemat("josue34"); request.setNoNombre("josue5");
	 * request.setNoPuesto("josue"); request.setNuPin("1223");
	 * request.setTiLlamad(110); request.setIdEmpare(19); request.setIdSip(659);
	 * 
	 * request.setIlfijloca(1); request.setIlfijnaci(1);
	 * request.setIlfijinte(0);
	 * 
	 * request.setIlcelNac(0); request.setIlcelInt(0); request.setIlcelRpm(0);
	 * InsertarUsuarioResponse
	 * response=tbUsuarioServices.insertarUsuario("192.168.3.206", request);
	 * System.out.println(response.getInsertado()); } catch (Exception
	 * exception) { // TODO Auto-generated catch block System.out.println(
	 * exception.getMessage() ); } }
	 * 
	 * @Test public void testActualizarUsuario() { try {
	 * ActualizarUsuarioRequest request = new ActualizarUsuarioRequest();
	 * request.setIdUsuario(884); request.setNoApepat("josue1");
	 * request.setNoApemat("josue1"); request.setNoNombre("josue1");
	 * request.setNoPuesto("josue1"); request.setNuPin("1223");
	 * request.setTiLlamad(110); request.setIdEmpare(19); request.setIdSip(659);
	 * 
	 * request.setIlfijloca(1); request.setIlfijnaci(1);
	 * request.setIlfijinte(0);
	 * 
	 * request.setIlcelNac(0); request.setIlcelInt(0); request.setIlcelRpm(0);
	 * ActualizarUsuarioResponse
	 * response=tbUsuarioServices.ActualizarUsuario("192.168.3.206", request);
	 * System.out.println(response.getActualizado()); } catch (Exception
	 * exception) { // TODO Auto-generated catch block System.out.println(
	 * exception.getMessage() ); } }
	 * 
	 * @Test public void testUsuarioEliminar() { try { EliminarUsuarioRequest
	 * request = new EliminarUsuarioRequest(); request.setIdUsuari(884);
	 * 
	 * EliminarUsuarioResponse
	 * response=tbUsuarioServices.EliminarUsuario("192.168.3.206", request);
	 * System.out.println(response.getEliminado()); } catch (Exception
	 * exception) { // TODO Auto-generated catch block System.out.println(
	 * exception.getMessage() ); } }
	 */

	//@Test
	public void testBuscarTbUsuario (){
		try {
			BuscarTbUsuarioRequest request = new BuscarTbUsuarioRequest();
			request.setNoNombre("Alva");
			
			BuscarTbUsuarioResponse response = tbUsuarioServices.buscarTbUsuario("cli",  "jPfFl7Jg2rg=", request);
			System.out.println(response.getLsUsuario().size());
			for (TbUsuario usuario : response.getLsUsuario()) {
				System.out.println("Nombre del Usuario: " + usuario.getNoNombre());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSelectUsuario (){
		try {
//			System.out.println(EncriptaUtils.desencriptar("hNiSx3gtpNs="));
			ListarUsuarioxIdRequest request = new ListarUsuarioxIdRequest();
			request.setIdUsuario(123);
			
			ListarUsuarioxIdResponse response = tbUsuarioServices.ListarUsuarioxId("cli",  "jPfFl7Jg2rg=", request);

			for (TbUsuario usuario : response.getTbUsuarioListaxId()) {
				System.out.println("pin: " + usuario.getNuPin());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}	
}
