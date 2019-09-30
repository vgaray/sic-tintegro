package pe.com.tintegro.dto.request;

public class RankingLlamadasRequest extends RequestBase {

	 private String feIni;
	 private String feFin ; 
	 private String horaIni; 
	 private String horafin;	 
	 private int tipoFile;
	 
	//Parametros para listar
		
	  	private Integer	numPagina; 
	  	private Integer	cantidadxPag;
		private Integer pIdOrden;
	  		  		 
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
	public String getFeIni() {
		return feIni;
	}
	public void setFeIni(String feIni) {
		this.feIni = feIni;
	}
	public String getFeFin() {
		return feFin;
	}
	public void setFeFin(String feFin) {
		this.feFin = feFin;
	}
	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}
	public String getHorafin() {
		return horafin;
	}
	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
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
			
}
