package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.UsuarioXCita;

public class ListarUsuarioCitaResponse extends ResponseBase {
	private List<UsuarioXCita> usuarioCitaList;

	public List<UsuarioXCita> getUsuarioCitaList() {
		return usuarioCitaList;
	}
	public void setUsuarioCitaList(List<UsuarioXCita> usuarioCitaList) {
		this.usuarioCitaList = usuarioCitaList;
	}

}
