package pe.com.tintegro.dominio;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * clase para controlar el menu de navegacion
 * 
 * @author Carlos
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MenuSic
{
	private Integer idPagina;
	private String nomPagina;
	private String nomComponente;
	private String nomUrl;
	private String nomIcono;
	private Integer idTipoMenu;
	private Integer idPagPadre;
	private String idInstancia;
	private List<MenuSic> subItem;
	
	public Integer getIdPagina(){
		return idPagina;
	}
	public void setIdPagina(Integer idPagina){
		this.idPagina =idPagina;
	}
	public String getNomPagina()
	{
		return nomPagina;
	}
	public void setNomPagina(String nomPagina)
	{
		this.nomPagina = nomPagina;
	}
	public String getNomComponente()
	{
		return nomComponente;
	}
	public void setNomComponente(String nomComponente)
	{
		this.nomComponente = nomComponente;
	}
	public String getNomUrl()
	{
		return nomUrl;
	}
	public void setNomUrl(String nomUrl)
	{
		this.nomUrl = nomUrl;
	}
	public String getNomIcono()
	{
		return nomIcono;
	}
	public void setNomIcono(String nomIcono)
	{
		this.nomIcono = nomIcono;
	}
	public Integer getIdTipoMenu()
	{
		return idTipoMenu;
	}
	public void setIdTipoMenu(Integer idTipoMenu)
	{
		this.idTipoMenu = idTipoMenu;
	}
	public Integer getIdPagPadre()
	{
		return idPagPadre;
	}
	public void setIdPagPadre(Integer idPagPadre)
	{
		this.idPagPadre = idPagPadre;
	}
	public String getIdInstancia()
	{
		return idInstancia;
	}
	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}
	public List<MenuSic> getSubItem()
	{
		return subItem;
	}
	public void setSubItem(List<MenuSic> subItem)
	{
		this.subItem = subItem;
	}
	 

	 

}
