package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.HistoriaClinicaDAO;
import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dto.request.ActualizarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.EliminarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.mapper.HistoriaClinicaMapper;

@Repository("historiaClinicaDAO")
public class HistoriaClinicaDAOImpl extends DAOTintegroImpl implements HistoriaClinicaDAO {

	@Override
	public ListarHistoriaClinicaResponse listarHistoriaClinica(ListarHistoriaClinicaRequest request) throws Exception {
		List<HistoriaClinica> result = new ArrayList<HistoriaClinica>();
		ListarHistoriaClinicaResponse response = new ListarHistoriaClinicaResponse();
		HistoriaClinicaMapper mapper = this.getSqlSessionSic().getMapper(HistoriaClinicaMapper.class);
		result = (List<HistoriaClinica>) mapper.listarHistoriaClinica(request.getpIdMascota(), request.getpNoPass(),
				request.getpTiFun());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsHistoriaClinica(result);
		return response;
	}

	@Override
	public CRUDResponse eliminarHistoriaClinica(EliminarHistoriaClinicaRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		CRUDResponse response = new CRUDResponse();
		HistoriaClinicaMapper mapper = this.getSqlSessionSic().getMapper(HistoriaClinicaMapper.class);
		result = (List<CRUDResponse>) mapper.eliminarHistoriaClinica(request.getpIdHistoriaClinica());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	@Override
	public CRUDResponse registrarHistoriaClinica(RegistrarHistoriaClinicaRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		CRUDResponse response = new CRUDResponse();
		HistoriaClinicaMapper mapper = this.getSqlSessionSic().getMapper(HistoriaClinicaMapper.class);
		result = (List<CRUDResponse>) mapper.registrarHistoriaClinica(request.getHistoriaClinica().getNoAlergias(),
				request.getHistoriaClinica().getNoAntFamiliares(), request.getHistoriaClinica().getIdMascota(),
				request.getHistoriaClinica().getIdEstadoReproductivo(), null);
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	@Override
	public CRUDResponse actualizarHistoriaClinica(ActualizarHistoriaClinicaRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		CRUDResponse response = new CRUDResponse();
		HistoriaClinicaMapper mapper = this.getSqlSessionSic().getMapper(HistoriaClinicaMapper.class);
		result = (List<CRUDResponse>) mapper.actualizarHistoriaClinica(
				request.getHistoriaClinica().getIdHistoriaClinica(), request.getHistoriaClinica().getNoAlergias(),
				request.getHistoriaClinica().getNoAntFamiliares(),
				request.getHistoriaClinica().getIdEstadoReproductivo(), null);
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}


}
