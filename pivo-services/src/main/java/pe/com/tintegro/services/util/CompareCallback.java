package pe.com.tintegro.services.util;

public interface CompareCallback<X,Y>
{
	boolean compare( X itemX, Y itemY );
}
