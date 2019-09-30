package pe.com.tintegro.dto.response;
import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.RankingLlamadas;
public class RankingLlamadasResponse extends ResponseBase{
	List<RankingLlamadas> listRanking;
	private String reporteFile;
	 private Graficos graficoRanking;
	public Graficos getGraficoRanking() {
		return graficoRanking;
	}

	public void setGraficoRanking(Graficos graficoRanking) {
		this.graficoRanking = graficoRanking;
	}

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

	public List<RankingLlamadas> getListRanking() {
		return listRanking;
	}

	public void setListRanking(List<RankingLlamadas> listRanking) {
		this.listRanking = listRanking;
	}

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	} 
	
}
