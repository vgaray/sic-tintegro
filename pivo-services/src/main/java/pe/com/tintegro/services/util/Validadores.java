package pe.com.tintegro.services.util;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validadores
{
	public static boolean esNumero(String vars)
	{
		Pattern p = Pattern.compile("\\d+(\\.\\d{1,2})?");
		Matcher m = p.matcher(vars);
		boolean valida = true;
		if (!(m.find()))
		{
			valida = false;
		}
		return valida;
	}

	public static boolean esLetra(String vars)
	{
		Pattern p = Pattern.compile("[A-Za-z]+");
		Matcher m = p.matcher(vars);
		boolean valida = true;
		if (!(m.find()))
		{
			valida = false;
		}
		return valida;
	}

	public static void cadenaExcepciones(String vas)
	{

		String ms = "";
		try
		{
			if (vas.isEmpty())
			{
				ms += "Nada ";

			}

			if (!esNumero(vas))
			{
				ms += "No es numero";

			}
			throw new Exception(ms);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());

		}
		finally
		{
			ms = "";
		}

	}

	public static boolean probarConsecutivos(List<Integer> arreglo)
	{

		Collections.sort(arreglo);

		for (int i = 1; i < arreglo.size(); i++)
		{
			if ((arreglo.get(i) - 1) != arreglo.get(i - 1))
			{
				return false;
			}
		}

		return true;

	}

	public static boolean esNumeroDeCuatroCifras(String vars)
	{
		boolean valida = true;
		if(!(Integer.parseInt(vars)>999 && Integer.parseInt(vars)<10000)){
			valida=false;
		}
		return valida;
	}
	
	public static boolean existeRepeticiones(int[] arreglos)
	{
		boolean valida = true;
		int status = 0;
		for (int i = 0; i < arreglos.length;)
		{
			int cons = arreglos[i];
			
			for (int j = i + 1; j < arreglos.length; j++)
			{
				if (cons == arreglos[j])
				{
				
					valida=false;
					status = 1;
					break;
				}
			}
         if(status==1){
         	break;
         }
			i++;
		}
		return valida;
	}
	
	public static boolean esNumeroTelefonico(String numero){
		boolean valida=true;
		for (int i = 0; i < numero.length(); i++)
		{
			if(!Character.isDigit(numero.charAt(i))){
				valida=false;
			}
		}
		
		return valida;
	}
}
