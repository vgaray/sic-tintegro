package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;

public interface PivoReporteServices {

	public ListarPersonalResponse reporteListarPersonal(String codUsuario, String idInstancia,ListarPersonalRequest request)throws Exception;
	public ListarMascotaResponse reporteListarMascota(String codUsuario,ListarMascotaRequest request)throws Exception;

}
