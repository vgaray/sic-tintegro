package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.EliminarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;

public interface HistoriaClinicaDAO {
	public ListarHistoriaClinicaResponse listarHistoriaClinica(ListarHistoriaClinicaRequest request) throws Exception;

	public CRUDResponse eliminarHistoriaClinica(EliminarHistoriaClinicaRequest request) throws Exception;

	public CRUDResponse registrarHistoriaClinica(RegistrarHistoriaClinicaRequest request) throws Exception;

	public CRUDResponse actualizarHistoriaClinica(ActualizarHistoriaClinicaRequest request) throws Exception;


}
