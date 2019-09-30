package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;


public class ListarInstanciaxCasoResponse extends ResponseBase {
	
	private List<ListarInstanciaxCasoRequest> listarInstaciaxCaso;

	public List<ListarInstanciaxCasoRequest> getListarInstaciaxCaso() {
		return listarInstaciaxCaso;
	}

	public void setListarInstaciaxCaso(
			List<ListarInstanciaxCasoRequest> listarInstaciaxCaso) {
		this.listarInstaciaxCaso = listarInstaciaxCaso;
	}

	

}
