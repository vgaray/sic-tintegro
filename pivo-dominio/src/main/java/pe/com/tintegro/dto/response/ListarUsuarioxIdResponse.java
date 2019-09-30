package pe.com.tintegro.dto.response;

import java.util.ArrayList;

import pe.com.tintegro.dominio.TbUsuario;

public class ListarUsuarioxIdResponse extends ResponseBase {

	private ArrayList<TbUsuario> TbUsuarioListaxId;

	public ArrayList<TbUsuario> getTbUsuarioListaxId() {
		return TbUsuarioListaxId;
	}

	public void setTbUsuarioListaxId(ArrayList<TbUsuario> tbUsuarioListaxId) {
		TbUsuarioListaxId = tbUsuarioListaxId;
	}
	
	
}
