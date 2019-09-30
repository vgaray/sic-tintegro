package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.GenerarTxtIvr;

public class GenerarTxtIvrResponse extends ResponseBase {
	List<GenerarTxtIvr> listGenerarTxtIvr;

	public List<GenerarTxtIvr> getListGenerarTxtIvr() {
		return listGenerarTxtIvr;
	}

	public void setListGenerarTxtIvr(List<GenerarTxtIvr> listGenerarTxtIvr) {
		this.listGenerarTxtIvr = listGenerarTxtIvr;
	}
}
