package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaMarcaTelefonoRequest;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;

public interface MarcaTelefonoGeneralServices
{
	public ListaMarcaTelefonoResponse listaMarcaTelefonoGeneral(String codUsuario,ListaMarcaTelefonoRequest request) throws Exception;
}
