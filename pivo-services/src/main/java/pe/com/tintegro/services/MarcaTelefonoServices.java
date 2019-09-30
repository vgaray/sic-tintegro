package pe.com.tintegro.services;

import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;

public interface MarcaTelefonoServices
{
	public ListaMarcaTelefonoResponse listaMarcaTelefono( String codUsuario, String idInstancia ) throws Exception;
}
