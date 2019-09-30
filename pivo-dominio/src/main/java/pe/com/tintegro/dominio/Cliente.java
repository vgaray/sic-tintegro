package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Cliente implements Serializable
{
	private static final long serialVersionUID = 1L;
	// variables
	private Integer confirmacion;
	private Integer estadoAc;// 1:ACTIVADO----0:DESACTIVADO
	private Integer resultado;

	public Integer getResultado()
	{
		return resultado;
	}

	public void setResultado(Integer resultado)
	{
		this.resultado = resultado;
	}

	public Integer getConfirmacion()
	{
		return confirmacion;
	}

	public void setConfirmacion(Integer confirmacion)
	{
		this.confirmacion = confirmacion;
	}

	public Integer getEstadoAc()
	{
		return estadoAc;
	}

	public void setEstadoAc(Integer estadoAc)
	{
		this.estadoAc = estadoAc;
	}

	// campos entidad
	private Integer idCliente;
	private String noRazonSocial;
	private String nuDocIde;
	private String ruc;
	private String direcc;
	private String telef;
	private String correoEle;
	private String personRef;
	private boolean estado;
	private Integer idTipoDoc;

	public Integer getIdCliente()
	{
		return idCliente;
	}

	public void setIdCliente(Integer idCliente)
	{
		this.idCliente = idCliente;
	}

	public String getNoRazonSocial()
	{
		return noRazonSocial;
	}

	public void setNoRazonSocial(String noRazonSocial)
	{
		this.noRazonSocial = noRazonSocial;
	}

	public String getNuDocIde()
	{
		return nuDocIde;
	}

	public void setNuDocIde(String nuDocIde)
	{
		this.nuDocIde = nuDocIde;
	}

	public String getRuc()
	{
		return ruc;
	}

	public void setRuc(String ruc)
	{
		this.ruc = ruc;
	}

	public String getDirecc()
	{
		return direcc;
	}

	public void setDirecc(String direcc)
	{
		this.direcc = direcc;
	}

	public String getTelef()
	{
		return telef;
	}

	public void setTelef(String telef)
	{
		this.telef = telef;
	}

	public String getCorreoEle()
	{
		return correoEle;
	}

	public void setCorreoEle(String correoEle)
	{
		this.correoEle = correoEle;
	}

	public String getPersonRef()
	{
		return personRef;
	}

	public void setPersonRef(String personRef)
	{
		this.personRef = personRef;
	}

	public boolean isEstado()
	{
		return estado;
	}

	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}

	public Integer getIdTipoDoc()
	{
		return idTipoDoc;
	}

	public void setIdTipoDoc(Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
	}

}
