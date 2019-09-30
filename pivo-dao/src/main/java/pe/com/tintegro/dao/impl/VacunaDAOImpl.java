package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.ConstanteFisiologicaDAO;
import pe.com.tintegro.dao.VacunaDAO;
import pe.com.tintegro.dominio.ConstanteFisiologica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dominio.Vacuna;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.ListarVacunaResponse;
import pe.com.tintegro.mapper.ConstanteFisiologicaMapper;
import pe.com.tintegro.mapper.HistoriaClinicaServiceMapper;
import pe.com.tintegro.mapper.VacunaMapper;

@Repository("vacunaDAO")
public class VacunaDAOImpl extends DAOTintegroImpl implements VacunaDAO {

	@Override
	public ListarVacunaResponse listaVacuna(ListarHistoriaClinicaServiceRequest request)
			throws Exception {
		List<Vacuna> result = new ArrayList<Vacuna>();
		ListarVacunaResponse response = new ListarVacunaResponse();
		VacunaMapper mapper = this.getSqlSessionSic().getMapper(VacunaMapper.class);
		result = (List<Vacuna>) mapper.listarVacuna(request.getpNuChip(),
				request.getpNoPass(), request.getpIdInstancia());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsVacuna(result);
		return response;
	}

}
