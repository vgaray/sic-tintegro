package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PlanSaliente
{
	private Integer idPlanSaliente;
	private String noNombre;
	private Integer ilListaNegra;
	private Integer ilClaveUsuario;
	private Integer iltemporizado;
	private Integer ilHorarioLlamada;
	private String hoTemporizado;
	private String feInicio;
	private String feFin;
	private String hoInicio;
	private String hoFin;
	private String noPrefijo;
	private String noPatron;
	private Integer nuQuitarPrefijo;
	private Integer nuQuitarSufijo;
	private String noSufijo;
	private String noTroncal;
	private String noDescripcion;
	private Integer nuTipo;
	private Integer idTroncal;
	
	public Integer getIdPlanSaliente()
	{
		return idPlanSaliente;
	}
	public void setIdPlanSaliente(Integer idPlanSaliente)
	{
		this.idPlanSaliente = idPlanSaliente;
	}
	public String getNoNombre()
	{
		return noNombre;
	}
	public void setNoNombre(String noNombre)
	{
		this.noNombre = noNombre;
	}
	public Integer getIlListaNegra()
	{
		return ilListaNegra;
	}
	public void setIlListaNegra(Integer ilListaNegra)
	{
		this.ilListaNegra = ilListaNegra;
	}
	public Integer getIlClaveUsuario()
	{
		return ilClaveUsuario;
	}
	public void setIlClaveUsuario(Integer ilClaveUsuario)
	{
		this.ilClaveUsuario = ilClaveUsuario;
	}
	public Integer getIltemporizado()
	{
		return iltemporizado;
	}
	public void setIltemporizado(Integer iltemporizado)
	{
		this.iltemporizado = iltemporizado;
	}
	public Integer getIlHorarioLlamada()
	{
		return ilHorarioLlamada;
	}
	public void setIlHorarioLlamada(Integer ilHorarioLlamada)
	{
		this.ilHorarioLlamada = ilHorarioLlamada;
	}
	public String getFeInicio()
	{
		return feInicio;
	}
	public void setFeInicio(String feInicio)
	{
		this.feInicio = feInicio;
	}
	public String getFeFin()
	{
		return feFin;
	}
	public void setFeFin(String feFin)
	{
		this.feFin = feFin;
	}
	public String getHoInicio()
	{
		return hoInicio;
	}
	public void setHoInicio(String hoInicio)
	{
		this.hoInicio = hoInicio;
	}
	public String getHoFin()
	{
		return hoFin;
	}
	public void setHoFin(String hoFin)
	{
		this.hoFin = hoFin;
	}
	public String getNoPrefijo()
	{
		return noPrefijo;
	}
	public void setNoPrefijo(String noPrefijo)
	{
		this.noPrefijo = noPrefijo;
	}
	public String getNoPatron()
	{
		return noPatron;
	}
	public void setNoPatron(String noPatron)
	{
		this.noPatron = noPatron;
	}
	public Integer getNuQuitarPrefijo()
	{
		return nuQuitarPrefijo;
	}
	public void setNuQuitarPrefijo(Integer nuQuitarPrefijo)
	{
		this.nuQuitarPrefijo = nuQuitarPrefijo;
	}
	public Integer getNuQuitarSufijo()
	{
		return nuQuitarSufijo;
	}
	public void setNuQuitarSufijo(Integer nuQuitarSufijo)
	{
		this.nuQuitarSufijo = nuQuitarSufijo;
	}
	public String getNoSufijo()
	{
		return noSufijo;
	}
	public void setNoSufijo(String noSufijo)
	{
		this.noSufijo = noSufijo;
	}
	public String getNoTroncal()
	{
		return noTroncal;
	}
	public void setNoTroncal(String noTroncal)
	{
		this.noTroncal = noTroncal;
	}
	public String getNoDescripcion()
	{
		return noDescripcion;
	}
	public void setNoDescripcion(String noDescripcion)
	{
		this.noDescripcion = noDescripcion;
	}
	public String getHoTemporizado()
	{
		return hoTemporizado;
	}
	public void setHoTemporizado(String hoTemporizado)
	{
		this.hoTemporizado = hoTemporizado;
	}
	public Integer getNuTipo()
	{
		return nuTipo;
	}
	public void setNuTipo(Integer nuTipo)
	{
		this.nuTipo = nuTipo;
	}
	public Integer getIdTroncal() {
		return idTroncal;
	}
	public void setIdTroncal(Integer idTroncal) {
		this.idTroncal = idTroncal;
	}

	
	
	
}
