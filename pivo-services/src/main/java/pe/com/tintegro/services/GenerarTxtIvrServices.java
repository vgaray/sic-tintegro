package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.GenerarTxtIvr;
import pe.com.tintegro.dominio.IvrOpcion;

public interface GenerarTxtIvrServices
{
	public String generarSeccionIVR(String codUsuario, List< IvrOpcion > lsIvrOptions) throws Exception;

	public String generarHorarioIVR(String codUsuario, List< GenerarTxtIvr > listaH) throws Exception;
	
	public String generarArchivoIVREnServidorAsterisk( String codUsuario, String idInstancia ) throws Exception;
}
