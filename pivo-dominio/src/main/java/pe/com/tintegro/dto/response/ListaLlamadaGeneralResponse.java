package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.LlamadaGeneral;


public class ListaLlamadaGeneralResponse extends ResponseBase 
{
	
	private List<LlamadaGeneral> listaLlamadaGeneralList;
	private String reporteFile;
	private Integer total;
	private Integer cantidadPaginas;
	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
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

	public List<LlamadaGeneral> getListaLlamadaGeneralList()
	{
		return listaLlamadaGeneralList;
	}

	public void setListaLlamadaGeneralList(List<LlamadaGeneral> listaLlamadaGeneralList)
	{
		this.listaLlamadaGeneralList = listaLlamadaGeneralList;
	}

}
