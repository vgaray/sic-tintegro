package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.IpServerDAO;
import pe.com.tintegro.dominio.IpServer;
import pe.com.tintegro.dto.request.ListarIpServerRequest;
import pe.com.tintegro.dto.response.ListarIpServerResponse;
import pe.com.tintegro.mapper.IpServerMapper;
@Repository("ipServerDAO")
public class IpServerDAOImpl extends DAOTintegroImpl implements IpServerDAO {

	@Override
	public ListarIpServerResponse listaipserver(ListarIpServerRequest request) {
		List<IpServer> result = new ArrayList<IpServer>();
		ListarIpServerResponse response = new ListarIpServerResponse();
		IpServerMapper mapper = this.getSqlSessionSic().getMapper(IpServerMapper.class);
		result=(List<IpServer>)mapper.listaipserver(request.getpIdTipodetalle());
		response.setEstado(1);
		response.setIpServerLis(result);
		return response;
	}

}
