package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Grabacion;
import pe.com.tintegro.dto.request.GrabacionRequest;
import pe.com.tintegro.dto.response.GrabacionResponse;
import pe.com.tintegro.services.GrabacionServices;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;
import pe.com.tintegro.services.util.Util;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class GrabacionAgenteServicesTest {
	@Autowired
	GrabacionServices	grabacionAgenteServices;
	 @Test
	public void listarArchivosDeCarpetaTest()
	{
		 GrabacionRequest request=new GrabacionRequest();
			request.setAgente(2);
			request.setOrigen("Igual Origen");
			request.setDestino("IgualDestino");
			request.setTipo("Igual IN");
			request.setFeInicon("2017-08-07");
			request.setFeFincon("2017-09-10");
			request.setpHorai("00:00:00");
			request.setpHoraf("00:00:00");
			//////////////////////////////////////////////////////////
			CredencialesEquipo machine = new CredencialesEquipo();
			machine.setHost( "192.168.3.206" );
			machine.setUser( "root" );
			machine.setPassword( "redhat" );
			machine.setPort( 22 );
		try
		{
				
			GrabacionResponse listaArchivos = grabacionAgenteServices.listarDesdeCarpeta("cli", "jPfFl7Jg2rg=", request, machine, "/var/spool/asterisk/monitor/2017/08/07", Util.FILES_AND_DIRECTORIES, new String[]{ ".docx", ".mp3",".wav" } );
				System.out.println("************************************************************");
			for ( Grabacion nombreArchivo : listaArchivos.getLsAudioA() )
			{
				System.out.println("Archivo Encontrado");
				System.out.println( nombreArchivo.getNombreAudio());//ruta del archivo
				System.out.println( nombreArchivo.getDuracion());
				System.out.println( nombreArchivo.getOrigen());
				System.out.println( nombreArchivo.getDestino());
				System.out.println( nombreArchivo.getFecha());
				System.out.println( nombreArchivo.getHora());
				System.out.println( nombreArchivo.getTipo());
				System.out.println("************************************************************");
			}

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	//@Test
	public void listarGrabacionesTest()
		{
		try
		{	GrabacionRequest request = new GrabacionRequest();
		
				request.setAgente(null);
				request.setTipo("AGENT_OUT");
				request.setOrigen(null);
				request.setDestino(null);
				request.setFeInicon("2017-01-10");
				request.setFeFincon("2018-10-10");
				request.setpHorai("00:00:00");
				request.setpHoraf("12:00:00");
				request.setTipoFun(1);
			
			GrabacionResponse response = grabacionAgenteServices.listarGrabaciones("cli", "jPfFl7Jg2rg=", request);
			System.out.println("Tamaño de lista:"+response.getLsAudioA().size());
			for (Grabacion general : response.getLsAudioA())
			{
				System.out.println(general.getNombreAudio());
				System.out.println(general.getUniqueId());
				System.out.println(general.getNuAnexo());
				
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e.getMessage());
		}
		}
}
