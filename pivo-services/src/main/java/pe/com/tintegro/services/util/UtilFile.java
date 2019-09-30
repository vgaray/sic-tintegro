package pe.com.tintegro.services.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Base64;

public class UtilFile
{

	public static File writeFile(String contenido, String ruta) throws Exception
	{
		File file = null;

		try
		{
			file = new File( ruta );

			// if file doesnt exists, then create it
			if ( !file.exists() )
			{
				file.createNewFile();
			}

			FileWriter fw = new FileWriter( file.getAbsoluteFile(), true );
			BufferedWriter bw = new BufferedWriter( fw );
			bw.write( contenido );
			bw.close();

		}
		catch ( IOException e )
		{
			throw e;
		}
		
		return file;
	}

	public static void DeleteFile(String ruta) throws Exception
	{
		try
		{

			File file = new File( ruta );

			// if file doesnt exists, then create it
			if ( file.exists() )
			{
				file.delete();
			}

		}
		catch ( Exception e )
		{
			throw e;
		}
	}

	public static File leerResource(org.springframework.core.io.Resource resource, String nombreTemporal, String extension) throws Exception
	{
		InputStream inputStream = resource.getInputStream();
		File plantillaTemp = File.createTempFile( "test", extension );
		try
		{
			FileUtils.copyInputStreamToFile( inputStream, plantillaTemp );
		}
		finally
		{
			IOUtils.closeQuietly( inputStream );
		}

		return plantillaTemp;
	}

	public static byte[] decodificar(String fileBase64) throws IOException
	{
		byte[] parseBase64Binary = Base64.decodeBase64( fileBase64 );
		// parseBase64Binary=Base64.decodeBase64(fileBase64);

		return parseBase64Binary;
	}

	public static File decodificarToFile(String fileBase64, String nameFile) throws IOException
	{
		byte[] parseBase64Binary = Base64.decodeBase64( fileBase64 );
		File file = new File( nameFile );
		FileUtils.writeByteArrayToFile( file, parseBase64Binary );
		return file;

	}

	public static String codificarToBase64(File file) throws Exception
	{
		byte[] fileByteArray = new byte[( int ) file.length()];

		FileInputStream fis = new FileInputStream( file );
		fis.read( fileByteArray ); // read file into bytes[]
		fis.close();

		String fileString = new String( Base64.encodeBase64( fileByteArray ) );

		return fileString;
	}
}
