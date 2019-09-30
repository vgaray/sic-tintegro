package pe.com.tintegro.services;

import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;

public interface ConfiguracionPlanServices
{
	/**
	 * Realiza la carga inicial de anexos en una instancia.
	 * 
	 * @param codUsuario es el codigo del administración de la instancia.
	 * @return
	 * @throws Exception ocurre cuando hay un error en la inserción. Sea en el repositorio de datos o en
	 * la generacion de archivos del teléfono
	 */
	public InsertaSipBuddieResponse cargarAnexosIniciales( String codUsuario,String idInstancia ) throws Exception;
}
