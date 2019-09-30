package pe.com.tintegro.dto.response;

import java.util.ArrayList;

import pe.com.tintegro.dominio.TbUsuario;


public class ListaTbUsuarioResponse extends ResponseBase {


	/**
	 * 
	 */

	private ArrayList<TbUsuario> TbUsuarioList;
	
	private String reporteFile;

	public String getReporteFile()
	{
		return reporteFile;
	}

	public void setReporteFile(String reporteFile)
	{
		this.reporteFile = reporteFile;
	}

	public ArrayList<TbUsuario> getTbUsuarioList() {
		return TbUsuarioList;
	}

	public void setTbUsuarioList(ArrayList<TbUsuario> tbUsuarioList) {
		TbUsuarioList = tbUsuarioList;
	}
	
	
}
