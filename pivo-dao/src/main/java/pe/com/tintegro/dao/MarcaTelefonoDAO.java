package pe.com.tintegro.dao;

import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;


public interface MarcaTelefonoDAO
{
 	public ListaMarcaTelefonoResponse listaMarcaTelefono(String ip) throws Exception;
	
}