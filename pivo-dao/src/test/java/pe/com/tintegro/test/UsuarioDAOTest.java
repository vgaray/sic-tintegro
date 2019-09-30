package pe.com.tintegro.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.UsuarioDAO;
import pe.com.tintegro.dominio.Usuario;
import pe.com.tintegro.dto.request.ActualizarPasswordRequest;
import pe.com.tintegro.dto.request.ActualizarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.EliminaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioPorCodigoRequest;
import pe.com.tintegro.dto.request.ValidarLoginUsuarioRequest;
import pe.com.tintegro.dto.response.ActualizarPasswordResponse;
import pe.com.tintegro.dto.response.ActualizarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.EliminaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioPorCodigoResponse;
import pe.com.tintegro.dto.response.ValidarLoginUsuarioResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class UsuarioDAOTest
{
	@Autowired
	UsuarioDAO usuarioDAO;

	//@Test
	public void testValidaUsuarioLogin()
	{

		ValidarLoginUsuarioRequest request = new ValidarLoginUsuarioRequest();
		request.setNologin("cli");
		try
		{

			ValidarLoginUsuarioResponse response = new ValidarLoginUsuarioResponse();

			response = usuarioDAO.validarUsuario(request);

			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//@Test
	public void testListarUsuarioEstandar()
	{
		ListaUsuarioEstandarRequest request = new ListaUsuarioEstandarRequest();
		request.setNologin("usuAdminis");
		request.setIdInstancia(null);
		request.setIdUsuario(null);
		request.setTiOpera(0);
      

		try
		{
			ListaUsuarioEstandarResponse response = new ListaUsuarioEstandarResponse();
			response = usuarioDAO.listaUsuarioEstandar(request);
			List<Usuario> users = response.getUsuarioList();

			for (int i = 0; i < users.size(); i++)
			{
				System.out.println(users.get(i).getNoLogin() + " " + users.get(i).getNoNombre() + " " + users.get(i).getNoApellido()+"  "+users.get(i).getNoRol());
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	//@Test
	public void testInsertarUsuarioEstandar(){
		InsertarUsuarioEstandarRequest request =new InsertarUsuarioEstandarRequest();
		request.setNoLogin("PruebaT1");
		request.setNoPasswo("123465");
		request.setNoNombre("PercyT1");
		request.setNoApelli("GómezT1");
		request.setEmail("pgomez@redmi.com");
		request.setNoProfe("Programador");
		request.setIdRol(6);
		request.setNoLoginCreador("usuAdminis");
		request.setIdInstanciadesc(null);

		
		try
		{
			InsertarUsuarioEstandarResponse response=new InsertarUsuarioEstandarResponse();
			response=usuarioDAO.insertarUsuarioEstandar(request);
			
			System.out.println();
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

	// @Test
	public void testEliminarUsuarioEstandar()
	{
		EliminaUsuarioEstandarRequest request = new EliminaUsuarioEstandarRequest();
		request.setIdUsuario(70);
		request.setNoLoginCreador("usuario76");
		request.setIdInstanciadesc(53);
		try
		{

			EliminaUsuarioEstandarResponse response = new EliminaUsuarioEstandarResponse();
			response = usuarioDAO.eliminarUsuarioEstandar(request);
			System.out.println();
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	//@Test

	public void testActualizarUsuarioEstadar()
	{
		ActualizarUsuarioEstandarRequest request = new ActualizarUsuarioEstandarRequest();

		request.setIdUsuario(246);
		request.setNoPasswo("123678");
		request.setNoNombre("MM");
		request.setNoApellido("MAss");
		request.setEmail("mm@hotmail.com");
		request.setNoProfe("");
		request.setIdRol(2);
		request.setNoLoginCreador("usuAdminis");
		request.setIdInstanciadesenc(73);
//select * from oauth.fn_actualizar_usuario_standar(70, 'Maraujo', '123', 'Martin', 'Araujo', 'maraujo@hotmail.com', 'Programador',2, 'cli', 53)
		try
		{
			ActualizarUsuarioEstandarResponse response = new ActualizarUsuarioEstandarResponse();
			response = usuarioDAO.actualizarUsuarioEstandar(request);
			System.out.println();
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void testListarUsuarioCodigo()
	{
		ListaUsuarioPorCodigoRequest request = new ListaUsuarioPorCodigoRequest();
		request.setpCodUsuario("usuAdminis");
		try
		{
			ListaUsuarioPorCodigoResponse response = new ListaUsuarioPorCodigoResponse();
			response = usuarioDAO.listarUsuarioPorCodigo(request);
			List<Usuario> users = response.getUsuarioList();
			for (int i = 0; i < users.size(); i++)
			{
				System.out.println(users.get(i).getNoLogin() + " " + users.get(i).getNoNombre() + " " + users.get(i).getNoApellido()+"  "+users.get(i).getEmail());
			}
		}
		catch (Exception e)
		{
		}
	}
	@Test
	public void testCambiarPassword()
	{
		ActualizarPasswordRequest request = new ActualizarPasswordRequest();
		request.setpNewPassword("99999");
		request.setpCodUsuario("usuAdminis");
		request.setpConfirmacion(false);
		request.setpToken("RRRRR");
		try
		{
			ActualizarPasswordResponse response = new ActualizarPasswordResponse();
			response = usuarioDAO.actualizarPassword(request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
