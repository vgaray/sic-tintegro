package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaTbUsuarioRequest;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;

public interface CargaExcelPermisosUsuarioServices
{
	public ListaTbUsuarioResponse DescargaExcelPermisosUsuario(String codUsuario, String idInstancia,ListaTbUsuarioRequest request) throws Exception;

}
