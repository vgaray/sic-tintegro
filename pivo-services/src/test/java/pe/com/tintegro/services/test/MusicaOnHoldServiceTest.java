package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.MusicaOnHold;
import pe.com.tintegro.dto.request.ActualizarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.EliminarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.InsertarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.ListarMusicaOnHoldRequest;
import pe.com.tintegro.dto.response.ActualizarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.EliminarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.InsertarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.ListarMusicaOnHoldResponse;
import pe.com.tintegro.services.MusicaOnHoldServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MusicaOnHoldServiceTest
{
	@Autowired
	MusicaOnHoldServices musicaOnHoldServices;
	//@Test
	public void listarMusicaOnHoldTest()
	{
		try
		{
			ListarMusicaOnHoldRequest request = new ListarMusicaOnHoldRequest();
			ListarMusicaOnHoldResponse response = musicaOnHoldServices.listarMusicaOnHold("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getLsMusicaOnHold().size());
			for (MusicaOnHold musica : response.getLsMusicaOnHold())
			{
				System.out.println(" id clase:  " + musica.getIdClase() + "°°  nombre Clase: " + musica.getNoClase());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//@Test
	public void insertarMusicaOnHoldTest(){
		InsertarMusicaOnHoldRequest request = new InsertarMusicaOnHoldRequest();
		request.setpNoClase("CarpetaB");
		try
		{
			 InsertarMusicaOnHoldResponse response;
			 response = musicaOnHoldServices.insertarMusicaOnHold("cli", "jPfFl7Jg2rg=", request);
					System.out.println(" resultado:  " + response.getIdRasult() + " mensaje: " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void actualizacionMusicaOnHoldTest(){
		ActualizarMusicaOnHoldRequest request = new ActualizarMusicaOnHoldRequest();
		MusicaOnHold musica = new MusicaOnHold();
		request.setpIdClase(32);
		request.setpNoClase("CarpetaCambio");
		musica.setIdClase(32);
		musica.setNoClase("CarpetaB");
		request.setMusica(musica);
		try
		{
			 ActualizarMusicaOnHoldResponse response = musicaOnHoldServices.actualizarMusicaOnHold("cli", "jPfFl7Jg2rg=", request);
					System.out.println(" resultado:  " + response.getIdRasult() + " mensaje: " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void EliminarMusicaOnHoldTest(){
		EliminarMusicaOnHoldRequest request = new EliminarMusicaOnHoldRequest();
		MusicaOnHold musica = new MusicaOnHold();
		request.setpIdClase(32);
		musica.setIdClase(32);
		musica.setNoClase("CarpetaCambio");
		request.setMusica(musica);
		
		try
		{
			EliminarMusicaOnHoldResponse response = musicaOnHoldServices.eliminarMusicaOnHold("cli", "jPfFl7Jg2rg=", request);
			 System.out.println(" resultado:  " + response.getIdRasult() + " mensaje: " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
