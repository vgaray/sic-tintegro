package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.Mascota;



public class ListarMascotaResponse extends ResponseBase{

	private List<Mascota> lsMascota;
	private String reporteFile;
	private Graficos graficoMascota;
	
	public List<Mascota> getLsMascota() {
		return lsMascota;
	}
	public void setLsMascota(List<Mascota> lsMascota) {
		this.lsMascota = lsMascota;
	}
	public String getReporteFile() {
		return reporteFile;
	}
	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
	public Graficos getGraficoMascota() {
		return graficoMascota;
	}
	public void setGraficoMascota(Graficos graficoMascota) {
		this.graficoMascota = graficoMascota;
	}
	
	
}
