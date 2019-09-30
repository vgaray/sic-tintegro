package pe.com.tintegro.services.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SCPManager
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

	public void commonConstructor(String userName, String password, String IP) throws JSchException
	{
		SSHChannel = new JSch();

		this.userName = userName;
		this.IP = IP;
		this.password = password;
	}

	public SCPManager(String userName, String password, String IP) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = 22;
		this.timeOut = 60000;
	}

	public SCPManager(String userName, String password, String IP, int timeOut) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = 22;
		this.timeOut = timeOut;
	}

	public SCPManager(String userName, String password, String IP, int timeOut, int port) throws JSchException
	{
		commonConstructor( userName, password, IP );
		this.port = port;
		this.timeOut = timeOut;
	}

	public String importFile(String srcPathFile, String destPath) throws Exception
	{
		StringBuilder outputBuffer = new StringBuilder();
		
		String prefix = null;
		
		if ( new File( destPath ).isDirectory() )
		{
			prefix = destPath + File.separator;
		}

		// exec 'scp -f rfile' remotely
		String command = "scp -f " + srcPathFile;
		Channel channel = session.openChannel( "exec" );
		( ( ChannelExec ) channel ).setCommand( command );

		// get I/O streams for remote scp
		OutputStream out = channel.getOutputStream();
		InputStream in = channel.getInputStream();

		channel.connect();

		byte[] buf = new byte[1024];

		// send '\0'
		buf[ 0 ] = 0;
		out.write( buf, 0, 1 );
		out.flush();

		while ( true )
		{
			int c = checkAck( in );
			if ( c != 'C' )
			{
				break;
			}

			// read '0644 '
			in.read( buf, 0, 5 );

			long filesize = 0L;
			while ( true )
			{
				if ( in.read( buf, 0, 1 ) < 0 )
				{
					// error
					break;
				}
				if ( buf[ 0 ] == ' ' )
					break;
				filesize = filesize * 10L + ( long ) ( buf[ 0 ] - '0' );
			}

			String file = null;
			for ( int i = 0;; i++ )
			{
				in.read( buf, i, 1 );
				if ( buf[ i ] == ( byte ) 0x0a )
				{
					file = new String( buf, 0, i );
					break;
				}
			}

			// System.out.println("filesize="+filesize+", file="+file);

			// send '\0'
			buf[ 0 ] = 0;
			out.write( buf, 0, 1 );
			out.flush();

			// read a content of lfile
			FileOutputStream fos = new FileOutputStream( prefix == null ? destPath : prefix + file );
			int foo;
			while ( true )
			{
				if ( buf.length < filesize )
					foo = buf.length;
				else
					foo = ( int ) filesize;
				foo = in.read( buf, 0, foo );
				if ( foo < 0 )
				{
					// error
					break;
				}
				fos.write( buf, 0, foo );
				filesize -= foo;
				if ( filesize == 0L )
					break;
			}
			fos.close();
			fos = null;

			if ( checkAck( in ) != 0 )
			{
				System.exit( 0 );
			}

			// send '\0'
			buf[ 0 ] = 0;
			out.write( buf, 0, 1 );
			out.flush();
		}
		
		out.close();

		channel.disconnect();

		return outputBuffer.toString();
	}

	public String exportFile(String srcPathFile, String destPath) throws JSchException, IOException
	{
		StringBuilder outputBuffer = new StringBuilder();

		boolean ptimestamp = true;

		// exec 'scp -t rfile' remotely
		String command = "scp " + ( ptimestamp ? "-p" : "" ) + " -t " + destPath;
		Channel channel = session.openChannel( "exec" );
		( ( ChannelExec ) channel ).setCommand( command );

		// get I/O streams for remote scp
		OutputStream out = channel.getOutputStream();
		InputStream in = channel.getInputStream();

		channel.connect();

		if ( checkAck( in ) != 0 )
		{
			System.exit( 0 );
		}

		File _lfile = new File( srcPathFile );

		if ( ptimestamp )
		{
			command = "T " + ( _lfile.lastModified() / 1000 ) + " 0";
			// The access time should be sent here,
			// but it is not accessible with JavaAPI ;-<
			command += ( " " + ( _lfile.lastModified() / 1000 ) + " 0\n" );
			out.write( command.getBytes() );
			out.flush();
			if ( checkAck( in ) != 0 )
			{
				System.exit( 0 );
			}
		}

		// send "C0644 filesize filename", where filename should not include
		// '/'
		long filesize = _lfile.length();
		command = "C0644 " + filesize + " ";
		if ( srcPathFile.lastIndexOf( '/' ) > 0 )
		{
			command += srcPathFile.substring( srcPathFile.lastIndexOf( '/' ) + 1 );
		}
		else
		{
			command += srcPathFile;
		}
		command += "\n";
		out.write( command.getBytes() );
		out.flush();
		if ( checkAck( in ) != 0 )
		{
			System.exit( 0 );
		}

		// send a content of lfile
		FileInputStream fis = new FileInputStream( srcPathFile );
		byte[] buf = new byte[1024];
		while ( true )
		{
			int len = fis.read( buf, 0, buf.length );
			if ( len <= 0 )
				break;
			out.write( buf, 0, len ); // out.flush();
		}
		fis.close();
		fis = null;
		// send '\0'
		buf[ 0 ] = 0;
		out.write( buf, 0, 1 );
		out.flush();
		if ( checkAck( in ) != 0 )
		{
			System.exit( 0 );
		}
		
		out.close();

		channel.disconnect();

		return outputBuffer.toString();
	}

	static int checkAck(InputStream in) throws IOException
	{
		int b = in.read();
		// b may be 0 for success,
		// 1 for error,
		// 2 for fatal error,
		// -1
		if ( b == 0 )
			return b;
		if ( b == -1 )
			return b;

		if ( b == 1 || b == 2 )
		{
			StringBuffer sb = new StringBuffer();
			int c;
			do
			{
				c = in.read();
				sb.append( ( char ) c );
			}
			while ( c != '\n' );
			if ( b == 1 )
			{ // error
				System.out.print( sb.toString() );
			}
			if ( b == 2 )
			{ // fatal error
				System.out.print( sb.toString() );
			}
		}
		return b;
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
		catch ( JSchException e )
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
