package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.TbUsuario;

public class BuscarTbUsuarioResponse extends ResponseBase{

	private List<TbUsuario> lsUsuario;

	public List<TbUsuario> getLsUsuario() {
		return lsUsuario;
	}

	public void setLsUsuario(List<TbUsuario> lsUsuario) {
		this.lsUsuario = lsUsuario;
	}
}
