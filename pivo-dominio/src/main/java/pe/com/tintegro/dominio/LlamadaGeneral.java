package pe.com.tintegro.dominio;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LlamadaGeneral implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String src;
	private String dst;
	private String clid;
	private String feLlamado;
	private String hoLlamad;
	private Integer caDuraci;
	private Integer caBilsec;
	private String caDuracimin;
	private String caBilsecmin;
	private String vaDispos;
	private Integer indice;
	
	//Para listar
	private Integer total;
	private Integer cantidadPaginas;



	public String getSrc()
	{
		return src;
	}

	public void setSrc(String src)
	{
		this.src = src;
	}

	public String getDst()
	{
		return dst;
	}

	public void setDst(String dst)
	{
		this.dst = dst;
	}

	public String getClid()
	{
		return clid;
	}

	public void setClid(String clid)
	{
		this.clid = clid;
	}

	public String getFeLlamado()
	{
		return feLlamado;
	}

	public void setFeLlamado(String feLlamado)
	{
		this.feLlamado = feLlamado;
	}

	public String getHoLlamad()
	{
		return hoLlamad;
	}

	public void setHoLlamad(String hoLlamad)
	{
		this.hoLlamad = hoLlamad;
	}

	public Integer getCaDuraci()
	{
		return caDuraci;
	}

	public void setCaDuraci(Integer caDuraci)
	{
		this.caDuraci = caDuraci;
	}

	public Integer getCaBilsec()
	{
		return caBilsec;
	}

	public void setCaBilsec(Integer caBilsec)
	{
		this.caBilsec = caBilsec;
	}

	public String getCaDuracimin()
	{
		return caDuracimin;
	}

	public void setCaDuracimin(String caDuracimin)
	{
		this.caDuracimin = caDuracimin;
	}

	public String getCaBilsecmin()
	{
		return caBilsecmin;
	}

	public void setCaBilsecmin(String caBilsecmin)
	{
		this.caBilsecmin = caBilsecmin;
	}

	public String getVaDispos()
	{
		return vaDispos;
	}

	public void setVaDispos(String vaDispos)
	{
		this.vaDispos = vaDispos;
	}

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

	public Integer getIndice()
	{
		return indice;
	}

	public void setIndice(Integer indice)
	{
		this.indice = indice;
	}

}
