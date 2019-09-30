package pe.com.tintegro.dominio;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LlamadaUsuario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String noUsuario;
   private String feLlamada;
   private String hoLlamada;
   private String dst ;
   private Integer caDuraci;
   private String caDuracmin ;
   private String vaDispos ;
   private String src;
   private Integer indice;
   
	//Para listar
	private Integer total;
	private Integer cantidadPaginas;
   
   
	public Integer getTotal()
	{
		return total;
	}
	public void setTotal(Integer total)
	{
		this.total = total;
	}
	public Integer getCantidadPaginas()
	{
		return cantidadPaginas;
	}
	public void setCantidadPaginas(Integer cantidadPaginas)
	{
		this.cantidadPaginas = cantidadPaginas;
	}
	public void setHoLlamada(String hoLlamada)
	{
		this.hoLlamada = hoLlamada;
	}
	public String getNoUsuario()
	{
		return noUsuario;
	}
	public void setNoUsuario(String noUsuario)
	{
		this.noUsuario = noUsuario;
	}


	public String getFeLlamada()
	{
		return feLlamada;
	}
	public void setFeLlamada(String feLlamada)
	{
		this.feLlamada = feLlamada;
	}
	public String getHoLlamada()
	{
		return hoLlamada;
	}
	public void setHoLlamad(String hoLlamada)
	{
		this.hoLlamada = hoLlamada;
	}
	public String getDst()
	{
		return dst;
	}
	public void setDst(String dst)
	{
		this.dst = dst;
	}
	public Integer getCaDuraci()
	{
		return caDuraci;
	}
	public void setCaDuraci(Integer caDuraci)
	{
		this.caDuraci = caDuraci;
	}
	public String getCaDuracmin()
	{
		return caDuracmin;
	}
	public void setCaDuracmin(String caDuracmin)
	{
		this.caDuracmin = caDuracmin;
	}
	public String getVaDispos()
	{
		return vaDispos;
	}
	public void setVaDispos(String vaDispos)
	{
		this.vaDispos = vaDispos;
	}
	public String getSrc()
	{
		return src;
	}
	public void setSrc(String src)
	{
		this.src = src;
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
