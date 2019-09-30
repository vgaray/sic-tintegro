package pe.com.tintegro.dto.request;

public class MenuSicRequest extends RequestBase
{
	private String nomLogin;
	private Integer tipoMenu;
	
	public String getNomLogin()
	{
		return nomLogin;
	}
	public void setNomLogin(String nomLogin)
	{
		this.nomLogin = nomLogin;
	}
	public Integer getTipoMenu()
	{
		return tipoMenu;
	}
	public void setTipoMenu(Integer tipoMenu)
	{
		this.tipoMenu = tipoMenu;
	}
	 
	
	
}
