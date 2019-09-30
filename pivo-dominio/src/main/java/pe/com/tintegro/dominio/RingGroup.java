package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RingGroup implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 897024045514899570L;
   private Integer idGrupo;
	private String noGrupo;
	private Integer nuGrupo;
	private String nuAnexos;
	private Integer idRasult;
	private String mensaje;
	private Integer indice;
	private Integer cantidadAnexo;
	
	public Integer getIdGrupo()
	{
		return idGrupo;
	}
	
	public void setIdGrupo(Integer idGrupo)
	{
		this.idGrupo = idGrupo;
	}
	public String getNoGrupo()
	{
		return noGrupo;
	}

	public void setNoGrupo(String noGrupo)
	{
		this.noGrupo = noGrupo;
	}

	public Integer getNuGrupo()
	{
		return nuGrupo;
	}

	public void setNuGrupo(Integer nuGrupo)
	{
		this.nuGrupo = nuGrupo;
	}

	public String getNuAnexos()
	{
		return nuAnexos;
	}

	public void setNuAnexos(String nuAnexos)
	{
		this.nuAnexos = nuAnexos;
	}

	public Integer getIdRasult()
	{
		return idRasult;
	}

	public void setIdRasult(Integer idRasult)
	{
		this.idRasult = idRasult;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public Integer getIndice()
	{
		return indice;
	}

	public void setIndice(Integer indice)
	{
		this.indice = indice;
	}

	public Integer getCantidadAnexo()
	{
		return cantidadAnexo;
	}

	public void setCantidadAnexo(Integer cantidadAnexo)
	{
		this.cantidadAnexo = cantidadAnexo;
	}
	
	
}
