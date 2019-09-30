package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.TipoDocumento;

public class ListarTipoDocumentoResponse extends ResponseBase { 

	private List<TipoDocumento> lsTipoDocumento;

	
	public List<TipoDocumento> getLsTipoDocumento() {
		return lsTipoDocumento;
	}

	public void setLsTipoDocumento(List<TipoDocumento> lsTipoDocumento) {
		this.lsTipoDocumento = lsTipoDocumento;
	}

}
