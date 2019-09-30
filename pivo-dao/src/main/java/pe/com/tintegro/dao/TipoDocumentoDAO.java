package pe.com.tintegro.dao;

import pe.com.tintegro.dto.response.ListarTipoDocumentoResponse;

public interface TipoDocumentoDAO {

	public ListarTipoDocumentoResponse listarTipoDocumento(String ip)throws Exception;
}
