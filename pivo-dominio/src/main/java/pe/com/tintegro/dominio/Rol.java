package pe.com.tintegro.dominio;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Rol implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6937380444794475118L;

	private Integer idRol;
	private String noRol;
	private String noDescri;	
	private boolean ilActivo;
	private Integer idTipoRol;
	private String noTipoRol;
	private Integer idInstancia;
	
	public boolean isIlActivo() {
		return ilActivo;
	}

	public void setIlActivo(boolean ilActivo) {
		this.ilActivo = ilActivo;
	}

	public Integer getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}	
	
	
	
	public Integer getIdRol()
	{
		return idRol;
	}

	public void setIdRol(Integer idRol)
	{
		this.idRol = idRol;
	}

	public String getNoRol()
	{
		return noRol;
	}

	public void setNoRol(String noRol)
	{
		this.noRol = noRol;
	}

	public String getNoDescri()
	{
		return noDescri;
	}

	public void setNoDescri(String noDescri)
	{
		this.noDescri = noDescri;
	}


	public Integer getIdTipoRol()
	{
		return idTipoRol;
	}

	public void setIdTipoRol(Integer idTipoRol)
	{
		this.idTipoRol = idTipoRol;
	}

	public String getNoTipoRol()
	{
		return noTipoRol;
	}

	public void setNoTipoRol(String noTipoRol)
	{
		this.noTipoRol = noTipoRol;
	}

	
	
}
