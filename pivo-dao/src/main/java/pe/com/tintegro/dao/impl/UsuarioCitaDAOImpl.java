package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.UsuarioCitaDAO;
import pe.com.tintegro.dominio.UsuarioXCita;
import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;
import pe.com.tintegro.mapper.UsuarioCitaMapper;
@Repository("usuarioCitaDAO")
public class UsuarioCitaDAOImpl extends DAOTintegroImpl implements UsuarioCitaDAO {

	@Override
	public ListarUsuarioCitaResponse listaUsuarioCita(ListarUsuarioCitaRequest request) {
		List<UsuarioXCita> result = new ArrayList<UsuarioXCita>();
		ListarUsuarioCitaResponse response = new ListarUsuarioCitaResponse();
		UsuarioCitaMapper mapper = this.getSqlSessionSic().getMapper(UsuarioCitaMapper.class);
		result = (List<UsuarioXCita>) mapper.listaUsuarioCita(request.getpNuDocumento());
		response.setEstado(1);
		response.setUsuarioCitaList(result);
		return response;
	}

	/*
	 * @Override public ListarUsuarioCitaResponse
	 * listaUsuarioCita(ListarUsuarioCitaRequest request) {
	 * 
	 * }
	 */
}
