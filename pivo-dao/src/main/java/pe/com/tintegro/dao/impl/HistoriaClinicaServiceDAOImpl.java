package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.HistoriaClinicaDAO;
import pe.com.tintegro.dao.HistoriaClinicaServiceDAO;
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
import pe.com.tintegro.mapper.HistoriaClinicaServiceMapper;

@Repository("historiaClinicaServiceDAO")
public class HistoriaClinicaServiceDAOImpl extends DAOTintegroImpl implements HistoriaClinicaServiceDAO {

	@Override
	public ListarHistoriaClinicaServiceResponse listarHistoriaClinicaService(
			ListarHistoriaClinicaServiceRequest request) throws Exception {
		List<HistoriaClinicaService> result = new ArrayList<HistoriaClinicaService>();
		ListarHistoriaClinicaServiceResponse response = new ListarHistoriaClinicaServiceResponse();
		HistoriaClinicaServiceMapper mapper = this.getSqlSessionSic().getMapper(HistoriaClinicaServiceMapper.class);
		result = (List<HistoriaClinicaService>) mapper.listarHistoriaClinicaService(request.getpNuChip(),
				request.getpNoPass(), request.getpIdInstancia());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsHistoriaClinica(result);
		return response;
	}

}
