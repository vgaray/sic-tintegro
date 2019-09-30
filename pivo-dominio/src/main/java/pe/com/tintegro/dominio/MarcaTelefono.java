package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase que encapsula los atributos de la marca del telefono
 * 
 * @author Carlos
 *
 */
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonInclude( value = JsonInclude.Include.NON_NULL )
public class MarcaTelefono
{
	private int			marcaId;
	private String		nomMarca;
	private Integer	ilFormatoMac;
	private Boolean	ilNeedMACForProvisioning;
	private String		noExtensionForProvisioning;

	public Integer getIlFormatoMac()
	{
		return ilFormatoMac;
	}

	public void setIlFormatoMac( Integer ilFormatoMac )
	{
		this.ilFormatoMac = ilFormatoMac;
	}

	public Boolean getIlNeedMACForProvisioning()
	{
		return ilNeedMACForProvisioning;
	}

	public void setIlNeedMACForProvisioning( Boolean ilNeedMACForProvisioning )
	{
		this.ilNeedMACForProvisioning = ilNeedMACForProvisioning;
	}

	public String getNoExtensionForProvisioning()
	{
		return noExtensionForProvisioning;
	}

	public void setNoExtensionForProvisioning( String noExtensionForProvisioning )
	{
		this.noExtensionForProvisioning = noExtensionForProvisioning;
	}

	public int getMarcaId()
	{
		return marcaId;
	}

	public void setMarcaId( int marcaId )
	{
		this.marcaId = marcaId;
	}

	public String getNomMarca()
	{
		return nomMarca;
	}

	public void setNomMarca( String nomMarca )
	{
		this.nomMarca = nomMarca;
	}
}
