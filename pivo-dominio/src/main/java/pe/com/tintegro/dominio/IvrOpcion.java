package pe.com.tintegro.dominio;

public class IvrOpcion
{
	private Integer idIvrCop;
	private Integer pIdPadre;
	private String pNoDescripcion;
	private String pNoAudio;
	private String pNuAnexo;
	private Integer pIdtipo;
	private String pNoValor;
	private String pNoNombre;
	private Integer pIdGrupo;
	private String pNoAnexoTiempo;
	private Integer pVuelveInicioTiempo;
	private Integer pVuelveInicioIncorrecto;
	private String pNoAnexoIncorrecto;
	private Integer pMarcaAnexo;
	private Integer pOperadora;
	private Integer pTiempoEspera;
	private boolean disponible;
	
	
	private Integer id;
	private Integer parent;
	private String text;
	private String type;

	public boolean isDisponible()
	{
		return disponible;
	}

	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getParent()
	{
		return parent;
	}

	public void setParent(Integer parent)
	{
		this.parent = parent;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Integer getIdIvrCop()
	{
		return idIvrCop;
	}

	public void setIdIvrCop(Integer idIvrCop)
	{
		this.idIvrCop = idIvrCop;
	}

	public Integer getpIdPadre()
	{
		return pIdPadre;
	}

	public void setpIdPadre(Integer pIdPadre)
	{
		this.pIdPadre = pIdPadre;
	}

	public String getpNoDescripcion()
	{
		return pNoDescripcion;
	}

	public void setpNoDescripcion(String pNoDescripcion)
	{
		this.pNoDescripcion = pNoDescripcion;
	}

	public String getpNoAudio()
	{
		return pNoAudio;
	}

	public void setpNoAudio(String pNoAudio)
	{
		this.pNoAudio = pNoAudio;
	}

	public String getpNuAnexo()
	{
		return pNuAnexo;
	}

	public void setpNuAnexo(String pNuAnexo)
	{
		this.pNuAnexo = pNuAnexo;
	}

	public Integer getpIdtipo()
	{
		return pIdtipo;
	}

	public void setpIdtipo(Integer pIdtipo)
	{
		this.pIdtipo = pIdtipo;
	}

	public String getpNoValor()
	{
		return pNoValor;
	}

	public void setpNoValor(String pNoValor)
	{
		this.pNoValor = pNoValor;
	}

	public String getpNoNombre()
	{
		return pNoNombre;
	}

	public void setpNoNombre(String pNoNombre)
	{
		this.pNoNombre = pNoNombre;
	}

	public Integer getpIdGrupo()
	{
		return pIdGrupo;
	}

	public void setpIdGrupo(Integer pIdGrupo)
	{
		this.pIdGrupo = pIdGrupo;
	}

	public String getpNoAnexoTiempo()
	{
		return pNoAnexoTiempo;
	}

	public void setpNoAnexoTiempo(String pNoAnexoTiempo)
	{
		this.pNoAnexoTiempo = pNoAnexoTiempo;
	}

	public Integer getpVuelveInicioTiempo()
	{
		return pVuelveInicioTiempo;
	}

	public void setpVuelveInicioTiempo(Integer pVuelveInicioTiempo)
	{
		this.pVuelveInicioTiempo = pVuelveInicioTiempo;
	}

	public Integer getpVuelveInicioIncorrecto()
	{
		return pVuelveInicioIncorrecto;
	}

	public void setpVuelveInicioIncorrecto(Integer pVuelveInicioIncorrecto)
	{
		this.pVuelveInicioIncorrecto = pVuelveInicioIncorrecto;
	}

	public String getpNoAnexoIncorrecto()
	{
		return pNoAnexoIncorrecto;
	}

	public void setpNoAnexoIncorrecto(String pNoAnexoIncorrecto)
	{
		this.pNoAnexoIncorrecto = pNoAnexoIncorrecto;
	}

	public Integer getpMarcaAnexo()
	{
		return pMarcaAnexo;
	}

	public void setpMarcaAnexo(Integer pMarcaAnexo)
	{
		this.pMarcaAnexo = pMarcaAnexo;
	}

	public Integer getpOperadora()
	{
		return pOperadora;
	}

	public void setpOperadora(Integer pOperadora)
	{
		this.pOperadora = pOperadora;
	}

	public Integer getpTiempoEspera()
	{
		return pTiempoEspera;
	}

	public void setpTiempoEspera(Integer pTiempoEspera)
	{
		this.pTiempoEspera = pTiempoEspera;
	}

}
