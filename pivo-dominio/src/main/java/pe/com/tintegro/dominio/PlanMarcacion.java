package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PlanMarcacion implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6624303026899017538L;
	private Integer  idPlanEntrante;
	private Integer idFax;
	private Integer idGrupoHorario;
	private Integer idSip;
	private Integer idIvrCop;
	private String noContexto;
	private Integer flListaNegra;
	private String noBuzon;
	
	public Integer getIdPlanEntrante()
	{
		return idPlanEntrante;
	}
	public void setIdPlanEntrante(Integer idPlanEntrante)
	{
		this.idPlanEntrante = idPlanEntrante;
	}
	public Integer getIdFax()
	{
		return idFax;
	}
	public void setIdFax(Integer idFax)
	{
		this.idFax = idFax;
	}
	public Integer getIdSip()
	{
		return idSip;
	}
	public void setIdSip(Integer idSip)
	{
		this.idSip = idSip;
	}
	
	public Integer getIdIvrCop()
	{
		return idIvrCop;
	}
	public void setIdIvrCop(Integer idIvrCop)
	{
		this.idIvrCop = idIvrCop;
	}
	public String getNoContexto()
	{
		return noContexto;
	}
	public void setNoContexto(String noContexto)
	{
		this.noContexto = noContexto;
	}

	public Integer getFlListaNegra()
	{
		return flListaNegra;
	}
	public void setFlListaNegra(Integer flListaNegra)
	{
		this.flListaNegra = flListaNegra;
	}
	public Integer getIdGrupoHorario()
	{
		return idGrupoHorario;
	}
	public void setIdGrupoHorario(Integer idGrupoHorario)
	{
		this.idGrupoHorario = idGrupoHorario;
	}
	public String getNoBuzon()
	{
		return noBuzon;
	}
	public void setNoBuzon(String noBuzon)
	{
		this.noBuzon = noBuzon;
	}


	
   	
}
