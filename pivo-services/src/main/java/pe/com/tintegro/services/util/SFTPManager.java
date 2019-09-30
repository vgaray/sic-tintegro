package pe.com.tintegro.services.util;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPManager
{
	private JSch SFTPChannel;
	private String userName;
	private String IP;
	private int port;
	private String password;
	private Session session;
	private int timeOut;
	private Channel channel;
	
	public void commonConstructor( String userName, String password, String IP )
	{
		SFTPChannel = new JSch();
		
		this.userName = userName;
		this.password = password;
		this.IP = IP;
	}
	
	public SFTPManager( String userName, String password, String IP ) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = 22;
		this.timeOut = 60000;
	}
	
	public SFTPManager( String userName, String password, String IP, int timeOut ) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = 22;
		this.timeOut = timeOut;
	}
	
	public SFTPManager( String userName, String password, String IP, int timeOut, int port ) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = port;
		this.timeOut = timeOut;
	}
	
	public String connect() throws JSchException
	{
		String errorMessage = null;
		
		try
		{
			session = SFTPChannel.getSession( userName, IP, port );
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
	
	private void openChannel() throws JSchException
	{		
		channel = session.openChannel( "sftp" );
		channel.connect();		
	}
	
	private void closeChannel()
	{
		channel.disconnect();
	}
	
	public void getFile( String absolutePathFile, String goalPath ) throws JSchException, SftpException
	{
		openChannel();
		
		ChannelSftp channelSftp = ( ChannelSftp ) channel;
		
		try
		{
			channelSftp.get( absolutePathFile, goalPath );
		}
		catch (SftpException e)
		{
			throw e;
		}
		
		closeChannel();
	}
	
	public void deleteFile( String absolutePathFile ) throws Exception
	{
		try
		{
			openChannel();
			
			ChannelSftp channelSftp = ( ChannelSftp ) channel; 
			channelSftp.rm( absolutePathFile );			
		}
		catch (JSchException | SftpException e)
		{
			throw e;
		}
		
		closeChannel();
	}
	
	public void changeDirectory( String pathDirectory ) throws JSchException, SftpException
	{
		openChannel();
		
		ChannelSftp channelSftp = ( ChannelSftp ) channel;
		
		try
		{
			channelSftp.cd( pathDirectory );
		}
		catch (SftpException e)
		{
			throw e;
		}
		
		closeChannel();
	}
	
	public void close()
	{
		session.disconnect();
	}
}
