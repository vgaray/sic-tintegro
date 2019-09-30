package pe.com.tintegro.dao;

import java.util.List;

import pe.com.tintegro.dominio.Confirmacion;

public interface SeguridadDAO
{
	public List<Confirmacion> validarAccesoAServicio (String noLogin, String webServiceURL, boolean flEnviaInstancia) throws Exception;
	
	public List<Confirmacion> validarAccesoAInstancia(String noLogin, Integer idInstancia) throws Exception;
}
