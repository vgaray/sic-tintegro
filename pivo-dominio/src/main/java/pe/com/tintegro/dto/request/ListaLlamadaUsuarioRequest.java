package pe.com.tintegro.dto.request;

public class ListaLlamadaUsuarioRequest extends RequestBase
{
	private Integer pIdAreaCentro;
	private String pNoAreaCentro;
	private String pTipoNoAreaCentro;
	private String pNoCentroCosto;
	private String pTipoNoCentroCosto;
	private Integer idUsuario;
	private Integer idExtension;
	private String feIni;
	private String feFin;
	private String pHorai;
	private String pHoraf;
	private String nombreUsuario;
	private String nombreExtension;
	private int tipoFile;
	//Parametros para listar
  	private Integer	numPagina; 
  	private Integer	cantidadxPag;
  	private Integer pIdOrden;
  	
  	public String getpNoCentroCosto() {
		return pNoCentroCosto;
	}

	public void setpNoCentroCosto(String pNoCentroCosto) {
		this.pNoCentroCosto = pNoCentroCosto;
	}
	public String getpTipoNoCentroCosto() {
		return pTipoNoCentroCosto;
	}

	public void setpTipoNoCentroCosto(String pTipoNoCentroCosto) {
		this.pTipoNoCentroCosto = pTipoNoCentroCosto;
	}

  	public Integer getpIdAreaCentro() {
		return pIdAreaCentro;
	}

	public void setpIdAreaCentro(Integer pIdAreaCentro) {
		this.pIdAreaCentro = pIdAreaCentro;
	}
	public String getpNoAreaCentro() {
		return pNoAreaCentro;
	}

	public void setpNoAreaCentro(String pNoAreaCentro) {
		this.pNoAreaCentro = pNoAreaCentro;
	}
	
	public String getpTipoNoAreaCentro() {
		return pTipoNoAreaCentro;
	}

	public void setpTipoNoAreaCentro(String pTipoNoAreaCentro) {
		this.pTipoNoAreaCentro = pTipoNoAreaCentro;
	}
	public Integer getNumPagina()
	{
		return numPagina;
	}

	public void setNumPagina(Integer numPagina)
	{
		this.numPagina = numPagina;
	}

	public Integer getCantidadxPag()
	{
		return cantidadxPag;
	}

	public void setCantidadxPag(Integer cantidadxPag)
	{
		this.cantidadxPag = cantidadxPag;
	}

	public String getFeIni()
	{
		return feIni;
	}

	public void setFeIni(String feIni)
	{
		this.feIni = feIni;
	}

	public String getFeFin()
	{
		return feFin;
	}

	public void setFeFin(String feFin)
	{
		this.feFin = feFin;
	}

	public Integer getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public Integer getIdExtension()
	{
		return idExtension;
	}

	public void setIdExtension(Integer idExtension)
	{
		this.idExtension = idExtension;
	}

	public String getpHorai()
	{
		return pHorai;
	}

	public void setpHorai(String pHorai)
	{
		this.pHorai = pHorai;
	}

	public String getpHoraf()
	{
		return pHoraf;
	}

	public void setpHoraf(String pHoraf)
	{
		this.pHoraf = pHoraf;
	}

	public int getTipoFile()
	{
		return tipoFile;
	}

	public void setTipoFile(int tipoFile)
	{
		this.tipoFile = tipoFile;
	}

	public Integer getpIdOrden()
	{
		return pIdOrden;
	}

	public void setpIdOrden(Integer pIdOrden)
	{
		this.pIdOrden = pIdOrden;
	}

	public String getNombreUsuario()
	{
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario)
	{
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreExtension()
	{
		return nombreExtension;
	}

	public void setNombreExtension(String nombreExtension)
	{
		this.nombreExtension = nombreExtension;
	}
	
	
}
