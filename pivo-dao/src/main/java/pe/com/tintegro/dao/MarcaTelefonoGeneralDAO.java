package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaMarcaTelefonoRequest;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;

public interface MarcaTelefonoGeneralDAO
{
	public ListaMarcaTelefonoResponse listaMarcaTelefonoGeneral(ListaMarcaTelefonoRequest request) throws Exception;
}
