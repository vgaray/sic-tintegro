package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.EliminarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.ListarListadoProblemaResponse;
import pe.com.tintegro.dto.response.ListarVacunaResponse;

public interface HistoriaClinicaServices {
	public ListarHistoriaClinicaResponse listarHistoriaClinica(String codUsuario, ListarHistoriaClinicaRequest request)
			throws Exception;

	public CRUDResponse registrarHistoriaClininca(String codUsuario, RegistrarHistoriaClinicaRequest request)
			throws Exception;

	public CRUDResponse actualizarHistoriaClininca(String codUsuario, ActualizarHistoriaClinicaRequest request)
			throws Exception;

	public CRUDResponse eliminarHistoriaClininca(String codUsuario, EliminarHistoriaClinicaRequest request)
			throws Exception;

	//
	public ListarHistoriaClinicaServiceResponse listarHistoriaClinicaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception;
	
	public ListarConstanteFisiologicaResponse listarConstanteFisiologicaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception;
	public ListarListadoProblemaResponse listarListadoProblemaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception;
	public ListarVacunaResponse listarVacunaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception;
}
