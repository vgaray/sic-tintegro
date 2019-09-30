package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.TerritorioDAO;
import pe.com.tintegro.dominio.Territorio;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;
import pe.com.tintegro.mapper.TerritorioMapper;
import pe.com.tintegro.mapper.UsuarioCitaMapper;

@Repository("territorioDAO")
public class TerritorioDAOImpl extends DAOTintegroImpl implements TerritorioDAO {
	@Override
	public ListaTerritorioResponse listaTerritorio(ListaTerritorioRequest request) throws Exception {
		List<Territorio> result = new ArrayList<Territorio>();
		ListaTerritorioResponse response = new ListaTerritorioResponse();
		TerritorioMapper mapper = this.getSqlSessionSic().getMapper(TerritorioMapper.class);
		result = (List<Territorio>) mapper.listarTerritorio(request.getpCoPais());
		response.setEstado(1);
		response.setTerritoriolist(result);
		return response;
	}

}
