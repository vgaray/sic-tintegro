package pe.com.tintegro.mapper;

import java.util.List;

import pe.com.tintegro.dominio.Bash;

public interface BashMapper
{
	public List< Bash > loadBashById( Integer idBash );
}
