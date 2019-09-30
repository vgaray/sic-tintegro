package pe.com.tintegro.services.util;

import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHManager
{
	private JSch SSHChannel;
	private String userName;
	private String IP;
	private int port;
	private String password;
	private Session session;
	private int timeOut;
	
	public static final int TIME_OUT_DEFAULT = 60000;
	public static final int PORT_DEFAULT = 22;
		
	public void commonConstructor( String userName, String password, String IP ) throws JSchException
	{
		SSHChannel = new JSch();
		
		this.userName = userName;
		this.IP = IP;
		this.password = password;
	}
	
	public SSHManager( String userName, String password, String IP ) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = 22;
		this.timeOut = 60000;
	}
	
	public SSHManager( String userName, String password, String IP, int timeOut ) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = 22;
		this.timeOut = timeOut;
	}
	
	public SSHManager( String userName, String password, String IP, int timeOut, int port ) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = port;
		this.timeOut = timeOut;
	}
	
	public String sendCommand( String command ) throws Exception
	{
		StringBuilder outputBuffer = new StringBuilder();
		
		Channel channel = session.openChannel( "exec" );
		( (ChannelExec) channel ).setCommand( command );
		InputStream commandOutput = channel.getInputStream();
		channel.connect();
		int readByte = commandOutput.read();
		
		while ( readByte != 0xffffffff )
		{
			outputBuffer.append( ( char ) readByte );
			readByte = commandOutput.read();
		}
		
		System.out.println( outputBuffer );
		
		channel.disconnect();
				
		return outputBuffer.toString();
	}
	
	public String connect() throws JSchException
	{
		String errorMessage = null;
		
		try
		{
			session = SSHChannel.getSession( userName, IP, port );
			session.setPassword( password );
			Properties config = new Properties();
			config.put( "StrictHostKeyChecking", "no" );
			session.setConfig( config );
			session.connect( timeOut );
		}
		catch (JSchException e)
		{
			errorMessage = e.getMessage();
			throw e;
		}
		
		return errorMessage;
	}
	
	public void close()
	{
		session.disconnect();
	}
}
