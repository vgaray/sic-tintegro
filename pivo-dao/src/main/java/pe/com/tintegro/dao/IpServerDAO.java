package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarIpServerRequest;
import pe.com.tintegro.dto.response.ListarIpServerResponse;

public interface IpServerDAO {

	public ListarIpServerResponse listaipserver(ListarIpServerRequest request);
}
