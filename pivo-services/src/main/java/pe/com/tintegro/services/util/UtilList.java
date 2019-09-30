package pe.com.tintegro.services.util;

import java.util.List;

public class UtilList
{
	public static <T, S> int frecuencyValue( T value, List<S> items, CompareCallback<T, S> callback) 
	{
		int frecuency = 0;
		
		for ( S s : items)
		{
			if( callback.compare( value, s ) )
				frecuency++;
		}
		
		return frecuency;
	}
}
