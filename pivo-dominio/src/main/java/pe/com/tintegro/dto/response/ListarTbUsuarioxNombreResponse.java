package pe.com.tintegro.dto.response;

import java.util.ArrayList;

import pe.com.tintegro.dominio.TbUsuario;

public class ListarTbUsuarioxNombreResponse extends ResponseBase {

	
	private ArrayList<TbUsuario> TbUsuarioListxNombre;

	public ArrayList<TbUsuario> getTbUsuarioListxNombre() {
		return TbUsuarioListxNombre;
	}

	public void setTbUsuarioListxNombre(ArrayList<TbUsuario> tbUsuarioListxNombre) {
		TbUsuarioListxNombre = tbUsuarioListxNombre;
	}

	public ListarTbUsuarioxNombreResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListarTbUsuarioxNombreResponse(
			ArrayList<TbUsuario> tbUsuarioListxNombre) {
		super();
		TbUsuarioListxNombre = tbUsuarioListxNombre;
	}
	
	
	
}
