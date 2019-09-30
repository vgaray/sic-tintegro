package pe.com.tintegro.dto.request;

public class ListarVerificacionRingGroupRequest extends RequestBase
{
	private String pNoGrupo;
	private int pNuGrupo;
	public String getpNoGrupo()
	{
		return pNoGrupo;
	}
	public void setpNoGrupo(String pNoGrupo)
	{
		this.pNoGrupo = pNoGrupo;
	}
	public int getpNuGrupo()
	{
		return pNuGrupo;
	}
	public void setpNuGrupo(int pNuGrupo)
	{
		this.pNuGrupo = pNuGrupo;
	}
	
}
