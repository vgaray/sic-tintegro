package pe.com.tintegro.services.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;

@Component
public class InfraestructuraUtil
{
	private SCPManager scpManager;
	
	@Autowired
	private ServicesProperties servicesProperties;
		
	public String copyFile(int typeServerSrc, int typeServerDest, CredencialesEquipo machineSrc, CredencialesEquipo machineDest, String pathFileSrc, String pathDest) throws Exception
	{
		String salida = null;
		
		if ( typeServerSrc == TipoServer.LOCAL.getTipo() && ( typeServerDest == TipoServer.REMOTE.getTipo() || typeServerDest == TipoServer.INSTANCIA_ASTERISK.getTipo() || typeServerDest == TipoServer.FILE_SERVER.getTipo() ) )
		{
			scpManager = new SCPManager( machineDest.getUser(), machineDest.getPassword(), machineDest.getHost(), SCPManager.TIME_OUT_DEFAULT, machineDest.getPort() );
			scpManager.connect();
			salida = scpManager.exportFile( pathFileSrc, pathDest );
			scpManager.close();
		}
		else if ( typeServerSrc == TipoServer.REMOTE.getTipo() || typeServerSrc == TipoServer.INSTANCIA_ASTERISK.getTipo() || typeServerSrc == TipoServer.FILE_SERVER.getTipo() )
		{
			if( typeServerDest == TipoServer.LOCAL.getTipo() )
			{
				scpManager = new SCPManager( machineSrc.getUser(), machineSrc.getPassword(), machineSrc.getHost(), SCPManager.TIME_OUT_DEFAULT, machineSrc.getPort() );
				scpManager.connect();
				salida = scpManager.importFile( pathFileSrc, pathDest );
				scpManager.close();
			}
			else if( typeServerSrc == TipoServer.REMOTE.getTipo() || typeServerSrc == TipoServer.INSTANCIA_ASTERISK.getTipo() || typeServerSrc == TipoServer.FILE_SERVER.getTipo() )
			{
				
			}
		}
		
		return salida;
	}
	
	public CredencialesEquipo getCredentialsConnectionFileServer()
	{
		CredencialesEquipo equipo = new CredencialesEquipo();
		
		equipo.setHost( servicesProperties.getFileServerHost() );
		equipo.setUser( servicesProperties.getFileServerUser() );
		equipo.setPassword( servicesProperties.getFileServerPassword() );
		equipo.setPort( servicesProperties.getFileServerPort() );
		
		return equipo;
	}
	
	public CredencialesEquipo getCredentialsConnectionMediaServer()
	{
		CredencialesEquipo equipo = new CredencialesEquipo();
		
		equipo.setHost( servicesProperties.getMediaServerHost() );
		equipo.setUser( servicesProperties.getMediaServerUser() );
		equipo.setPassword( servicesProperties.getMediaServerPassword() );
		equipo.setPort( servicesProperties.getMediaServerPort() );
		
		return equipo;
	}

	public CredencialesEquipo instanciaACredencialesEquipo( InstanciaServerAsterisk vm ) throws Exception
	{
		CredencialesEquipo equipo = new CredencialesEquipo();
		
		equipo.setHost( vm.getIpAsterisk() );
		equipo.setUser( servicesProperties.getInstanciaAsteriskUser() );
		equipo.setPassword( servicesProperties.getInstanciaAsteriskPassword() );
		equipo.setPort( vm.getPuerto_ssh_asterisk() );
		
		return equipo;
	}
	
	public List< String > listarDesdeCarpeta( CredencialesEquipo machine, String folderPath, int typeFiles, String[] allowedExtensions ) throws Exception
	{
		List< String > lsArchivos = new ArrayList< String >();
		
		scpManager = new SCPManager( machine.getUser(), machine.getPassword(), machine.getHost(), SCPManager.TIME_OUT_DEFAULT, machine.getPort() );
		scpManager.connect();
		
		String linuxCommand = String.format( "( cd %s && %s )", folderPath, typeFiles == Util.FILES_AND_DIRECTORIES ? "ls" : typeFiles == Util.FILES ? "ls -F | grep -v '/$'" : "ls -F | grep '/$'" );
		
		String listarArchivos = LinuxUtil.executeCommand( TipoServer.REMOTE.getTipo(), machine, String.format( "%s", linuxCommand ) );
		
		scpManager.close();
		
		StringTokenizer tokenizer = new StringTokenizer( listarArchivos, "\n" );

		String nameFile;
		while( tokenizer.hasMoreTokens() )
		{
			nameFile = tokenizer.nextToken();
			if( allowedExtensions.length == 0 || ( allowedExtensions.length != 0 && esArchivoPermitido( nameFile, allowedExtensions ) ) )
				lsArchivos.add( nameFile );
		}
		
		return lsArchivos;
	}
	
	private boolean esArchivoPermitido( String nombreArchivo, String[] extensionesPermitidas )
	{
		boolean esPermitida = false;
			
		String itemExtension = null;
		
		for ( int i = 0; i < extensionesPermitidas.length && !esPermitida; i++ )
		{
			itemExtension = extensionesPermitidas[ i ];
			
			if( nombreArchivo.indexOf( itemExtension ) != -1 )
			{
				esPermitida = true;
			}
		}
		
		return esPermitida;
	}
	
	
}
