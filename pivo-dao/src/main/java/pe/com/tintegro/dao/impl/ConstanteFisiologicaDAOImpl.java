package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.ConstanteFisiologicaDAO;
import pe.com.tintegro.dominio.ConstanteFisiologica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.mapper.ConstanteFisiologicaMapper;
import pe.com.tintegro.mapper.HistoriaClinicaServiceMapper;

@Repository("constanteFisiologicaDAO")
public class ConstanteFisiologicaDAOImpl extends DAOTintegroImpl implements ConstanteFisiologicaDAO {

	@Override
	public ListarConstanteFisiologicaResponse listaConstanteFisiologica(ListarHistoriaClinicaServiceRequest request)
			throws Exception {
		List<ConstanteFisiologica> result = new ArrayList<ConstanteFisiologica>();
		ListarConstanteFisiologicaResponse response = new ListarConstanteFisiologicaResponse();
		ConstanteFisiologicaMapper mapper = this.getSqlSessionSic().getMapper(ConstanteFisiologicaMapper.class);
		result = (List<ConstanteFisiologica>) mapper.listarConstanteFisiologica(request.getpNuChip(),
				request.getpNoPass(), request.getpIdInstancia());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsConstante(result);
		return response;
	}

}
