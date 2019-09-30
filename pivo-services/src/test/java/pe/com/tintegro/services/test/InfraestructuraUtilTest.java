package pe.com.tintegro.services.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class InfraestructuraUtilTest
{
	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Autowired
	private ServicesProperties servicesProperties;

	 @Test
	public void listarArchivosDeCarpetaTest()
	{
		CredencialesEquipo machine = new CredencialesEquipo();
		machine.setHost( "192.168.3.202" );
		machine.setUser( "root" );
		machine.setPassword( "redhat" );
		machine.setPort( 22 );

		try
		{

			List< String > listaArchivos = infraestructuraUtil.listarDesdeCarpeta( machine, "/var/lib/asterisk/sounds/ivr", Util.FILES_AND_DIRECTORIES, new String[]{ ".docx", ".mp3" } );

			System.out.println( "=========== TEST LISTAR ARCHIVOS DE UNA CARPETA DEL SERVIDOR ===========" );

			for ( String nombreArchivo : listaArchivos )
			{
				System.out.println( nombreArchivo );
			}

			System.out.println( "=========== FIN TEST LISTAR ARCHIVOS DE UNA CARPETA DEL SERVIDOR ===========" );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

//	@Test
	public void copyFileLocalToRemoteTest()
	{
		CredencialesEquipo machine = new CredencialesEquipo();
		machine.setHost( "192.168.3.202" );
		machine.setUser( "root" );
		machine.setPassword( "redhat" );
		machine.setPort( 22 );

		File file = new File( "/home/daniel/Escritorio/Plan-de-negocio.docx.docx" );

		try
		{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
			System.out.println( "Inicio => " + sdf.format( cal.getTime() ) );
			infraestructuraUtil.copyFile( TipoServer.LOCAL.getTipo(), TipoServer.REMOTE.getTipo(), null, machine, file.getAbsolutePath(), servicesProperties.getPathFileAsteriskIVRSounds() );
			cal = Calendar.getInstance();
			System.out.println( "Fin => " + sdf.format( cal.getTime() ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
//	@Test
	public void copyFileServerToLocalTest()
	{
		CredencialesEquipo machine = new CredencialesEquipo();
		machine.setHost( "192.168.3.202" );
		machine.setUser( "root" );
		machine.setPassword( "redhat" );
		machine.setPort( 22 );

		try
		{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
			System.out.println( "Inicio => " + sdf.format( cal.getTime() ) );
			infraestructuraUtil.copyFile( TipoServer.REMOTE.getTipo(), TipoServer.LOCAL.getTipo(), machine, null, servicesProperties.getPathFileAsteriskIVRSounds() + "/ivr_contabilidad_opcion2.mp3", "/home/daniel/Escritorio" );
			cal = Calendar.getInstance();
			System.out.println( "Fin => " + sdf.format( cal.getTime() ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
