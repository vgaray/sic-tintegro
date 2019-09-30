package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.LlamadaUsuario;

public class ListaLlamadaUsuarioResponse extends ResponseBase
{
	private List<LlamadaUsuario> listaLlamadaUsuario;
	private String reporteFile;
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

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public List<LlamadaUsuario> getListaLlamadaUsuario()
	{
		return listaLlamadaUsuario;
	}

	public void setListaLlamadaUsuario(List<LlamadaUsuario> listaLlamadaUsuario)
	{
		this.listaLlamadaUsuario = listaLlamadaUsuario;
	}
}
