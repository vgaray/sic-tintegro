package pe.com.tintegro.services.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;

import com.jcraft.jsch.JSchException;

@Component
public class LinuxUtil
{
	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private InstanciaServices instanciaServices;

	private String codUsuario;
	private String idInstancia;

	public CredencialesEquipo getServer(int tipoServer, InstanciaServerAsterisk vmAsk) throws Exception
	{
		CredencialesEquipo server = new CredencialesEquipo();

		if ( tipoServer == TipoServer.INSTANCIA_ASTERISK.getTipo() && vmAsk == null )
		{

			InstanciaServerAsterisk vm = instanciaServices.buscarInstancia( codUsuario, idInstancia );

//			server.setHost( vm.getIpAsteriskBash() );
			server.setHost( vm.getIpAsterisk() );
			server.setUser( servicesProperties.getInstanciaAsteriskUser() );
			server.setPassword( servicesProperties.getInstanciaAsteriskPassword() );
			server.setPort( servicesProperties.getInstanciaAsteriskPort() );
		}
		else
		{
			if ( tipoServer == TipoServer.INSTANCIA_ASTERISK.getTipo() && vmAsk != null )
			{
				server.setHost( vmAsk.getIpAsterisk() );
//				server.setHost( vmAsk.getIpAsteriskBash() );
				server.setUser( servicesProperties.getInstanciaAsteriskUser() );
				server.setPassword( servicesProperties.getInstanciaAsteriskPassword() );
				server.setPort( servicesProperties.getInstanciaAsteriskPort() );
			}
			else
			{
				if ( tipoServer == TipoServer.FILE_SERVER.getTipo() )
				{
					server.setHost( servicesProperties.getFileServerHost() );
					server.setUser( servicesProperties.getFileServerUser() );
					server.setPassword( servicesProperties.getFileServerPassword() );
					server.setPort( servicesProperties.getFileServerPort() );
				}
			}
		}

		return server;
	}

	public String ejecutarComando(int tipoServer, InstanciaServerAsterisk vmAsk, String linuxCommand) throws Exception
	{
		String output = null;

		final int TIME_OUT = 60000;

		CredencialesEquipo server = getServer( tipoServer, vmAsk );

		SSHManager sshManager;

		try
		{
			sshManager = new SSHManager( server.getUser(), server.getPassword(), server.getHost(), TIME_OUT, server.getPort() );
			sshManager.connect();
			output = sshManager.sendCommand( linuxCommand );
			sshManager.close();
		}
		catch ( JSchException e )
		{
			throw e;
		}
		catch ( IOException e )
		{
			throw e;
		}

		return output;
	}

	public static String executeCommand(int typeMachine, CredencialesEquipo machine, String linuxCommand) throws Exception
	{
		String output = "";

		if ( typeMachine == TipoServer.LOCAL.getTipo() )
		{
			String s;
			Process p;
			try
			{
				p = Runtime.getRuntime().exec( linuxCommand );
				BufferedReader br = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
				
				while ( ( s = br.readLine() ) != null )
					output += s;
				
				p.waitFor();
				
				System.out.println( "exit: " + p.exitValue() );
				
				p.destroy();
			}
			catch ( Exception e )
			{
				throw e;
			}
		}
		else 
		{
			SSHManager sshManager;

			try
			{
				sshManager = new SSHManager( machine.getUser(), machine.getPassword(), machine.getHost(), SSHManager.TIME_OUT_DEFAULT, machine.getPort() );
				sshManager.connect();
				output = sshManager.sendCommand( linuxCommand );
				sshManager.close();
			}
			catch ( Exception e )
			{
				throw e;
			}
		}

		return output;
	}

	public String generateClientID( InstanciaServerAsterisk vm, SipBuddie sipBuddie )
	{
		return vm.getIpAsterisk().replace( ".", "_" ) + "_" + sipBuddie.getName();
	}

	public String getCodUsuario()
	{
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario)
	{
		this.codUsuario = codUsuario;
	}

	public String getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}
}
