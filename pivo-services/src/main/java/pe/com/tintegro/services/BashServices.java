package pe.com.tintegro.services;

import pe.com.tintegro.dominio.Bash;
import pe.com.tintegro.dto.response.EjecutarBashResponse;

public interface BashServices
{
	 public Bash loadBashById( String codUsuario, Integer idBash ) throws Exception;
	
    public EjecutarBashResponse ejecutarBash(String codUsuario,String idInstancia) throws Exception;
}
