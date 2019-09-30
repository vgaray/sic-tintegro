package pe.com.tintegro.dao;

import pe.com.tintegro.dominio.Bash;

public interface BashDAO
{
	public Bash loadBashById( Integer idBash ) throws Exception;
}
