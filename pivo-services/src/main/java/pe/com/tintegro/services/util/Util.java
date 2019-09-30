package pe.com.tintegro.services.util;

import java.io.File;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util
{
	private static final String FORMATTER_DATE = "yyyy-MM-dd";

	public static final int RTF						= 3;
	public static final int	PDF						= 2;
	public static final int	EXCEL						= 1;
	
	public static final int	ADD						= 1;
	public static final int	UPDATE					= 2;
	public static final int	ELIMINAR					= 3;
	
	public static final int NO_APROV_A_APROV = 1;
	public static final int APROV_A_NO_APROV = 2;
	public static final int APROV_A_APROV = 3;
	
	public static final int	NUMBER_ANNEX_INITIAL	= 100;
		
	public static final int DATABASE_SERVICE = 1;
	public static final int OPEN_VPN_SERVICE = 2;
	public static final int FAX_SERVICE = 3;
	public static final int IMPORT_SCRIPTS_CONFIG = 4;
	public static final int IMPORT_SECURITY = 5;
	public static final int IMPORT_OPENLDAP = 6;
	public static final int IMPORT_TLSSECURITY = 7;
	
	public static final int FILES = 1;
	public static final int DIRECTORIES = 2;
	public static final int FILES_AND_DIRECTORIES = 3;
	
	public static final int IVR = 1;
	public static final int IVR_OPTION = 2;
	
	public static final int ABIERTO = 1;
	public static final int CERRADO = 2;

	public static final String NOT_PROVISIONING = "NO-APROV";
	
	private static String	ALLOWED_CHARS			= "abcdefghijklmnopqrstuvwxyzABCDEFGRHIJKLMNOPQRSTUVWXYZ0123456789_-";

	public static String eliminarExtensionDeNombreDeArchivo( String nombreArchivo )
	{
		// Obteniendo posicion de la extension del archivo
		int indexExtension = nombreArchivo.lastIndexOf( "." );
		if ( indexExtension != -1 )
		{
			nombreArchivo = nombreArchivo.substring( 0, indexExtension );
		}
		else
			nombreArchivo = "<no presenta>";
		
		return nombreArchivo;
	}
	
	public static String getCodigoErrorByDate()
	{
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String codigoError = formatter.format(new Date());

		return codigoError;
	}
	
	public static Date parseToFormater( Date date ) throws ParseException
	{
		Date dateFormatted = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat( FORMATTER_DATE );
		String strDateFormater = formatter.format(date);
		
		dateFormatted = formatter.parse( strDateFormater );
		 
		return dateFormatted;
	}

	public static String getRandomValue(int min, int max)
	{
		Random random = new Random();
		int length = random.nextInt(max - min + 1) + min;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++)
		{
			sb.append(ALLOWED_CHARS.charAt(random.nextInt(ALLOWED_CHARS.length())));
		}

		return sb.toString();
	}

	public static boolean isInteger(String s)
	{
		return isInteger(s, 10);
	}

	public static boolean isInteger(String s, int radix)
	{
		if (s.isEmpty())
			return false;
		
		for (int i = 0; i < s.length(); i++)
		{
			if (i == 0 && s.charAt(i) == '-')
			{
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		
		return true;
	}
	
	public static int determinarNroPaginas(int total,int cantidadxPag ){
		int n=0;
		int residuo=total%cantidadxPag;
		int divint=((total-residuo)/cantidadxPag);
		n=divint;
		if(residuo>0){
			n++;
		}
		
		return n;
	}
	
	
	public static String devoverCodTipoLlamada(int codTipoLlamada){
		return (codTipoLlamada==1)?"Todas":((codTipoLlamada==2)?"Entrantes":((codTipoLlamada==3)?"Salientes":""));
	}
	
	public static String getCurrentPathDirectory()
	{
		String pathDirectory = null;
		
		File currentDirFile = new File("");
		
		pathDirectory = currentDirFile.getAbsolutePath();
		
		currentDirFile.delete();
		
		return pathDirectory;
	}
//	public static String getNameFolderProvisioning( InstanciaServerAsterisk vm )
//	{
//		String nameInstanceNormalized = vm.getNoRazonSocial().replace( " ", "" ).toLowerCase();
//		String ipInstanceNormalized = vm.getIpAsterisk().replace( ".", "" );  
//		
//		int hashed = String.format( "%s%s", nameInstanceNormalized, ipInstanceNormalized ).hashCode();
//		
//		return String.format( "%d", hashed );
//	}
}
