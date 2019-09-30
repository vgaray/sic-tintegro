package pe.com.tintegro.dto.request;

public class ListarEntradaDirectRequest extends RequestBase
{
	private Integer idEntrada;
	private Integer idGrupo;
	private Integer pOpcion;
	
	public Integer getIdEntrada()
	{
		return idEntrada;
	}
	public void setIdEntrada(Integer idEntrada)
	{
		this.idEntrada = idEntrada;
	}
	public Integer getIdGrupo()
	{
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo)
	{
		this.idGrupo = idGrupo;
	}
	public Integer getpOpcion() {
		return pOpcion;
	}
	public void setpOpcion(Integer pOpcion) {
		this.pOpcion = pOpcion;
	}
	
	
}
