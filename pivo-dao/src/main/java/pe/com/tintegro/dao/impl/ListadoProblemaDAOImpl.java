package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.ConstanteFisiologicaDAO;
import pe.com.tintegro.dao.ListadoProblemaDAO;
import pe.com.tintegro.dominio.ConstanteFisiologica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dominio.ListadoProblema;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.ListarListadoProblemaResponse;
import pe.com.tintegro.mapper.ConstanteFisiologicaMapper;
import pe.com.tintegro.mapper.HistoriaClinicaServiceMapper;
import pe.com.tintegro.mapper.ListadoProblemaMapper;

@Repository("listadoProblemaDAO")
public class ListadoProblemaDAOImpl extends DAOTintegroImpl implements ListadoProblemaDAO {

	@Override
	public ListarListadoProblemaResponse listaListadoProblema(ListarHistoriaClinicaServiceRequest request)
			throws Exception {
		List<ListadoProblema> result = new ArrayList<ListadoProblema>();
		ListarListadoProblemaResponse response = new ListarListadoProblemaResponse();
		ListadoProblemaMapper mapper = this.getSqlSessionSic().getMapper(ListadoProblemaMapper.class);
		result = (List<ListadoProblema>) mapper.listarListadoProblema(request.getpNuChip(), request.getpNoPass(),
				request.getpIdInstancia());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsListadoProblema(result);
		return response;
	}

}
