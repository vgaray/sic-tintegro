package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.ControlRolEstadoDAO;
import pe.com.tintegro.dto.request.ListaControlRolEstadoRequest;
import pe.com.tintegro.dto.response.ListaControlRolEstadoResponse;
import pe.com.tintegro.mapper.ControlMapper;

@Repository("ControlRolEstadoDAO")
public class ControlRolEstadoDAOImpl extends DAOTintegroImpl implements ControlRolEstadoDAO {

	@Override
	public ListaControlRolEstadoResponse listaControlRolEstadoDAO(ListaControlRolEstadoRequest request) throws Exception {
		ListaControlRolEstadoResponse result = new ListaControlRolEstadoResponse();
		List<String> resultado = new ArrayList<String>();
		ControlMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.ControlMapper.class);
		resultado = (List<String>) mapper.listaControlRolEstado(request.getNoLogin(), 
																request.getTiElemto(), 
																request.getIdEstadoelemento());
		result.setValidarControlResult(resultado);

		return result;
	}
}
