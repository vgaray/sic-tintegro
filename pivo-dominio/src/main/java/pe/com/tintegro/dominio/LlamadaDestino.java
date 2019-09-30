package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)

public class LlamadaDestino implements Serializable
{
	private static final long serialVersionUID = 1L;
   private String destino ;
   private String minutos;
   private String horas;
   private Integer canLlamadas;
   private String promedio;
   private String minimoConver;
   private String maximoConver;
   private Integer indice;
	public String getDestino()
	{
		return destino;
	}
	public void setDestino(String destino)
	{
		this.destino = destino;
	}
	public String getMinutos()
	{
		return minutos;
	}
	public void setMinutos(String minutos)
	{
		this.minutos = minutos;
	}
	public String getHoras()
	{
		return horas;
	}
	public void setHoras(String horas)
	{
		this.horas = horas;
	}
	public Integer getCanLlamadas()
	{
		return canLlamadas;
	}
	public void setCanLlamadas(Integer canLlamadas)
	{
		this.canLlamadas = canLlamadas;
	}
	public String getPromedio()
	{
		return promedio;
	}
	public void setPromedio(String promedio)
	{
		this.promedio = promedio;
	}
	public String getMinimoConver()
	{
		return minimoConver;
	}
	public void setMinimoConver(String minimoConver)
	{
		this.minimoConver = minimoConver;
	}
	public String getMaximoConver()
	{
		return maximoConver;
	}
	public void setMaximoConver(String maximoConver)
	{
		this.maximoConver = maximoConver;
	}
	public Integer getIndice()
	{
		return indice;
	}
	public void setIndice(Integer indice)
	{
		this.indice = indice;
	}
	
   	
}
