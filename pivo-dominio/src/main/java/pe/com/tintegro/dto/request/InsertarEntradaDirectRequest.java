package pe.com.tintegro.dto.request;

public class InsertarEntradaDirectRequest extends RequestBase
{
	private Integer nuTelefonico;
	private String nuAnexo;
	private String noNombre;
	private String noPrefijo;
	private Integer idGrupo;
	private String noDescripcion;
	public Integer getNuTelefonico()
	{
		return nuTelefonico;
	}
	public void setNuTelefonico(Integer nuTelefonico)
	{
		this.nuTelefonico = nuTelefonico;
	}
	public String getNuAnexo()
	{
		return nuAnexo;
	}
	public void setNuAnexo(String nuAnexo)
	{
		this.nuAnexo = nuAnexo;
	}
	public String getNoNombre()
	{
		return noNombre;
	}
	public void setNoNombre(String noNombre)
	{
		this.noNombre = noNombre;
	}
	public String getNoPrefijo()
	{
		return noPrefijo;
	}
	public void setNoPrefijo(String noPrefijo)
	{
		this.noPrefijo = noPrefijo;
	}
	public Integer getIdGrupo()
	{
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo)
	{
		this.idGrupo = idGrupo;
	}
	public String getNoDescripcion() {
		return noDescripcion;
	}
	public void setNoDescripcion(String noDescripcion) {
		this.noDescripcion = noDescripcion;
	}
	
	
}
