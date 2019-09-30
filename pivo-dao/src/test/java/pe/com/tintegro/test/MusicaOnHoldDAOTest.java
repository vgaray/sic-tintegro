package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.MusicaOnHoldDAO;
import pe.com.tintegro.dominio.MusicaOnHold;
import pe.com.tintegro.dto.request.ActualizarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.EliminarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.InsertarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.ListarMusicaOnHoldRequest;
import pe.com.tintegro.dto.response.ActualizarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.EliminarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.InsertarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.ListarMusicaOnHoldResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MusicaOnHoldDAOTest
{
	@Autowired
	MusicaOnHoldDAO musicaOnHoldDAO;
	@Test
	public void listarMusicaOnHoldTest(){
		try
		{
			ListarMusicaOnHoldRequest request = new ListarMusicaOnHoldRequest();
			ListarMusicaOnHoldResponse response = musicaOnHoldDAO.listarMusicaOnHold("192.168.3.202", request);
			System.out.println(response.getLsMusicaOnHold().size());
			for (MusicaOnHold musica : response.getLsMusicaOnHold())
			{
				System.out.println(" id clase:  " + musica.getIdClase() + "      nombre clase: " + musica.getNoClase());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//@Test
	public void insertarMusicaOnHoldTest()
	{
		InsertarMusicaOnHoldRequest request = new InsertarMusicaOnHoldRequest();
		request.setpNoClase("PruebaDAOIn");
		try
		{
			 InsertarMusicaOnHoldResponse response = musicaOnHoldDAO.insertarMusicaOnHold("192.168.3.202", request);
					System.out.println(" resultado:  " + response.getIdRasult() + " mensaje: " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void actualizarMusicaOnHoldTest()
	{
		ActualizarMusicaOnHoldRequest request = new ActualizarMusicaOnHoldRequest();
		request.setpIdClase(19);
		request.setpNoClase("ppppp");
		try
		{
			 ActualizarMusicaOnHoldResponse response = musicaOnHoldDAO.actualizarMusicaOnHold("192.168.3.202", request);
					System.out.println(" resultado:  " + response.getIdRasult() + " mensaje: " + response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void eliminarMusicaOnHoldTest()
		{
			EliminarMusicaOnHoldRequest request = new EliminarMusicaOnHoldRequest();
			request.setpIdClase(19);
			try
			{
				EliminarMusicaOnHoldResponse response = musicaOnHoldDAO.eliminarMusicaOnHold("192.168.3.202", request);
				 System.out.println(" resultado:  " + response.getIdRasult() + " mensaje: " + response.getMensaje());
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
}
