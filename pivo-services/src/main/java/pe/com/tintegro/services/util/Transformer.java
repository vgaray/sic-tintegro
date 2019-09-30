package pe.com.tintegro.services.util;

public abstract class Transformer<X,Y>
{
	public abstract Y transformerTo( X object );
	public abstract void getTipo(int request);
}
