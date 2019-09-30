package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class IaxTrunk
{
	private Integer idIaxTrunk;
	private String nomIaxTrunk;
	private String tipoCentral;
	private Integer centralInterna;
	private String centralInternaEncript;
	private Integer idCentralExterna;
	private String puertoIax;
	private Integer llamadasConcurrentes;
	private String prefLlamadaSalientes;
	private String numEmpresa;
	private Integer anexoInterno;
	private Integer fijoLocal;
	private Integer fijoNacional;
	private Integer fijoInternacional;
	private Integer celularNacional;
	private Integer celularInternacional;
	private Integer celularRpm;
	private Integer frompstn;
	private String nomContext;
	private String secret;
	private String identificador;
	private String viewCodeIaxTrunk;

	public Integer getIdIaxTrunk()
	{
		return idIaxTrunk;
	}

	public void setIdIaxTrunk(Integer idIaxTrunk)
	{
		this.idIaxTrunk = idIaxTrunk;
	}

	public String getNomIaxTrunk()
	{
		return nomIaxTrunk;
	}

	public void setNomIaxTrunk(String nomIaxTrunk)
	{
		this.nomIaxTrunk = nomIaxTrunk;
	}

	public String getTipoCentral()
	{
		return tipoCentral;
	}

	public void setTipoCentral(String tipoCentral)
	{
		this.tipoCentral = tipoCentral;
	}

	public Integer getCentralInterna()
	{
		return centralInterna;
	}

	public void setCentralInterna(Integer centralInterna)
	{
		this.centralInterna = centralInterna;
	}

	public String getCentralInternaEncript()
	{
		return centralInternaEncript;
	}

	public void setCentralInternaEncript(String centralInternaEncript)
	{
		this.centralInternaEncript = centralInternaEncript;
	}

	public Integer getIdCentralExterna()
	{
		return idCentralExterna;
	}

	public void setIdCentralExterna(Integer idCentralExterna)
	{
		this.idCentralExterna = idCentralExterna;
	}

	public String getPuertoIax()
	{
		return puertoIax;
	}

	public void setPuertoIax(String puertoIax)
	{
		this.puertoIax = puertoIax;
	}

	public Integer getLlamadasConcurrentes()
	{
		return llamadasConcurrentes;
	}

	public void setLlamadasConcurrentes(Integer llamadasConcurrentes)
	{
		this.llamadasConcurrentes = llamadasConcurrentes;
	}

	public String getPrefLlamadaSalientes()
	{
		return prefLlamadaSalientes;
	}

	public void setPrefLlamadaSalientes(String prefLlamadaSalientes)
	{
		this.prefLlamadaSalientes = prefLlamadaSalientes;
	}

	public String getNumEmpresa()
	{
		return numEmpresa;
	}

	public void setNumEmpresa(String numEmpresa)
	{
		this.numEmpresa = numEmpresa;
	}

	public Integer getAnexoInterno()
	{
		return anexoInterno;
	}

	public void setAnexoInterno(Integer anexoInterno)
	{
		this.anexoInterno = anexoInterno;
	}

	public Integer getFijoLocal()
	{
		return fijoLocal;
	}

	public void setFijoLocal(Integer fijoLocal)
	{
		this.fijoLocal = fijoLocal;
	}

	public Integer getFijoNacional()
	{
		return fijoNacional;
	}

	public void setFijoNacional(Integer fijoNacional)
	{
		this.fijoNacional = fijoNacional;
	}

	public Integer getFijoInternacional()
	{
		return fijoInternacional;
	}

	public void setFijoInternacional(Integer fijoInternacional)
	{
		this.fijoInternacional = fijoInternacional;
	}

	public Integer getCelularNacional()
	{
		return celularNacional;
	}

	public void setCelularNacional(Integer celularNacional)
	{
		this.celularNacional = celularNacional;
	}

	public Integer getCelularInternacional()
	{
		return celularInternacional;
	}

	public void setCelularInternacional(Integer celularInternacional)
	{
		this.celularInternacional = celularInternacional;
	}

	public Integer getCelularRpm()
	{
		return celularRpm;
	}

	public void setCelularRpm(Integer celularRpm)
	{
		this.celularRpm = celularRpm;
	}

	public String getNomContext()
	{
		return nomContext;
	}

	public void setNomContext(String nomContext)
	{
		this.nomContext = nomContext;
	}

	public String getSecret()
	{
		return secret;
	}

	public void setSecret(String secret)
	{
		this.secret = secret;
	}

	public String getIdentificador()
	{
		return identificador;
	}

	public void setIdentificador(String identificador)
	{
		this.identificador = identificador;
	}

	public String getViewCodeIaxTrunk()
	{
		return viewCodeIaxTrunk;
	}

	public void setViewCodeIaxTrunk(String viewCodeIaxTrunk)
	{
		this.viewCodeIaxTrunk = viewCodeIaxTrunk;
	}

	public Integer getFrompstn() {
		return frompstn;
	}

	public void setFrompstn(Integer frompstn) {
		this.frompstn = frompstn;
	}
}
