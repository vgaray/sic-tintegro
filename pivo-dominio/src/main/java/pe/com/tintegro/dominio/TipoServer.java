package pe.com.tintegro.dominio;

public enum TipoServer
{
	INSTANCIA_ASTERISK(1), FILE_SERVER(2), LOCAL(3), REMOTE(4);

	private int tipo;

	TipoServer(int tipo)
	{
		this.tipo = tipo;
	}

	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}
}
