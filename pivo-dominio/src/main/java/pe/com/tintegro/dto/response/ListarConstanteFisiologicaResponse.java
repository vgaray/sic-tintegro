package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ConstanteFisiologica;

public class ListarConstanteFisiologicaResponse extends ResponseBase {

	private List<ConstanteFisiologica> lsConstante;

	public List<ConstanteFisiologica> getLsConstante() {
		return lsConstante;
	}

	public void setLsConstante(List<ConstanteFisiologica> lsConstante) {
		this.lsConstante = lsConstante;
	}
}
