package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.TbUsuario;

public class ListarUsuarioResponse extends ResponseBase{

	private List<TbUsuario> listaUsuario;

	public List<TbUsuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<TbUsuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
}
