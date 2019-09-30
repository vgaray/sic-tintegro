package pe.com.tintegro.dto.request;

public class EliminarEntradaDirectRequest extends RequestBase
{
	private Integer idEntrada;
	private Integer idGrupo;

	public Integer getIdEntrada()
	{
		return idEntrada;
	}

	public void setIdEntrada(Integer idEntrada)
	{
		this.idEntrada = idEntrada;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
}
