package pe.com.tintegro.dominio;

public class EntradaDirectorio
{
	private Integer idEntrada;
	private Integer nuTelefonico;
	private String nuAnexo;
	private String callerId;
	private String noNombre;
	private String noPrefijo;
	private Integer idGrupo;
	private String noDescripcion;
	
	public Integer getIdEntrada()
	{
		return idEntrada;
	}
	public void setIdEntrada(Integer idEntrada)
	{
		this.idEntrada = idEntrada;
	}
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
	public String getCallerId() {
		return callerId;
	}
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}
	public String getNoDescripcion() {
		return noDescripcion;
	}
	public void setNoDescripcion(String noDescripcion) {
		this.noDescripcion = noDescripcion;
	}
	
	
}
