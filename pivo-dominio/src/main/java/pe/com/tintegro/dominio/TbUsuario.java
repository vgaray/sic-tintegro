package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TbUsuario implements Serializable
{

	private static final long serialVersionUID = 1L;

	private int idUsuari;
	private String noApepat;
	private String noApemat;
	private String noNombre;
	private String noPuesto;
	private String nuPin;
	private Integer tiLlamad;
	private boolean ilActivo;// ESTADO
	// private boolean ilMostrar;
	private Integer idEmpare;
	private Integer idArea;
	private String nomCentroCosto;
	// private boolean ilBolsa;
	private Integer idSip;
	private int ilfijloca;
	private int ilfijnaci;
	private int ilfijinte;
	private int ilcelloca;
	private int ilcelnaci;
	private int ilcelinte;
	private int ilcelrpm;
	private String nomSubarea;
	private String nomArea;
	private int estadoTiLlamad;
	private Integer numTotalReg;
	public int getIdUsuari()
	{
		return idUsuari;
	}

	public void setIdUsuari(int idUsuari)
	{
		this.idUsuari = idUsuari;
	}

	public String getNoApepat()
	{
		return noApepat;
	}

	public void setNoApepat(String noApepat)
	{
		this.noApepat = noApepat;
	}

	public String getNoApemat()
	{
		return noApemat;
	}

	public void setNoApemat(String noApemat)
	{
		this.noApemat = noApemat;
	}

	public String getNoNombre()
	{
		return noNombre;
	}

	public void setNoNombre(String noNombre)
	{
		this.noNombre = noNombre;
	}

	public String getNoPuesto()
	{
		return noPuesto;
	}

	public void setNoPuesto(String noPuesto)
	{
		this.noPuesto = noPuesto;
	}

	public String getNuPin()
	{
		return nuPin;
	}

	public void setNuPin(String nuPin)
	{
		this.nuPin = nuPin;
	}

	public Integer getTiLlamad()
	{
		return tiLlamad;
	}

	public void setTiLlamad(Integer tiLlamad)
	{
		this.tiLlamad = tiLlamad;
	}

	public boolean isIlActivo()
	{
		return ilActivo;
	}

	public void setIlActivo(boolean ilActivo)
	{
		this.ilActivo = ilActivo;
	}

	public Integer getIdEmpare()
	{
		return idEmpare;
	}

	public void setIdEmpare(Integer idEmpare)
	{
		this.idEmpare = idEmpare;
	}

	public Integer getIdArea()
	{
		return idArea;
	}

	public void setIdArea(Integer idArea)
	{
		this.idArea = idArea;
	}

	public String getNomCentroCosto()
	{
		return nomCentroCosto;
	}

	public void setNomCentroCosto(String nomCentroCosto)
	{
		this.nomCentroCosto = nomCentroCosto;
	}

	public Integer getIdSip()
	{
		return idSip;
	}

	public void setIdSip(Integer idSip)
	{
		this.idSip = idSip;
	}

	public int getIlfijloca()
	{
		return ilfijloca;
	}

	public void setIlfijloca(int ilfijloca)
	{
		this.ilfijloca = ilfijloca;
	}

	public int getIlfijnaci()
	{
		return ilfijnaci;
	}

	public void setIlfijnaci(int ilfijnaci)
	{
		this.ilfijnaci = ilfijnaci;
	}

	public int getIlfijinte()
	{
		return ilfijinte;
	}

	public void setIlfijinte(int ilfijinte)
	{
		this.ilfijinte = ilfijinte;
	}

	public int getIlcelloca()
	{
		return ilcelloca;
	}

	public void setIlcelloca(int ilcelloca)
	{
		this.ilcelloca = ilcelloca;
	}

	public int getIlcelnaci()
	{
		return ilcelnaci;
	}

	public void setIlcelnaci(int ilcelnaci)
	{
		this.ilcelnaci = ilcelnaci;
	}

	public int getIlcelinte()
	{
		return ilcelinte;
	}

	public void setIlcelinte(int ilcelinte)
	{
		this.ilcelinte = ilcelinte;
	}

	public int getIlcelrpm()
	{
		return ilcelrpm;
	}

	public void setIlcelrpm(int ilcelrpm)
	{
		this.ilcelrpm = ilcelrpm;
	}

	public String getNomSubarea()
	{
		return nomSubarea;
	}

	public void setNomSubarea(String nomSubarea)
	{
		this.nomSubarea = nomSubarea;
	}

	public String getNomArea()
	{
		return nomArea;
	}

	public void setNomArea(String nomArea)
	{
		this.nomArea = nomArea;
	}

	public int getEstadoTiLlamad()
	{
		return estadoTiLlamad;
	}

	public void setEstadoTiLlamad(int estadoTiLlamad)
	{
		this.estadoTiLlamad = estadoTiLlamad;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public Integer getNumTotalReg()
	{
		return numTotalReg;
	}

	public void setNumTotalReg(Integer numTotalReg)
	{
		this.numTotalReg = numTotalReg;
	}

}
