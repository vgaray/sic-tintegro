package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.LlamadaDestino;


public class ListarLlamadaDestinoResponse extends ResponseBase
{
 private List <LlamadaDestino> listaLLamadasDestino;
private String reporteFile;


public String getReporteFile()
{
	return reporteFile;
}

public void setReporteFile(String reporteFile)
{
	this.reporteFile = reporteFile;
}

public List<LlamadaDestino> getListaLLamadasDestino()
{
	return listaLLamadasDestino;
}

public void setListaLLamadasDestino(List<LlamadaDestino> listaLLamadasDestino)
{
	this.listaLLamadasDestino = listaLLamadasDestino;
}
 

}
