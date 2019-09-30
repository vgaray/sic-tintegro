package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase que encapsula los atributos del modelo del telefono
 * 
 * @author Carlos
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ModeloTelefono
{
	private int modeloId;
	private String nomModelo;
	private int marcaId;
	
	public int getModeloId()
	{
		return modeloId;
	}
	public void setModeloId(int modeloId)
	{
		this.modeloId = modeloId;
	}
	public String getNomModelo()
	{
		return nomModelo;
	}
	public void setNomModelo(String nomModelo)
	{
		this.nomModelo = nomModelo;
	}
	public int getMarcaId()
	{
		return marcaId;
	}
	public void setMarcaId(int marcaId)
	{
		this.marcaId = marcaId;
	}

	 

}
