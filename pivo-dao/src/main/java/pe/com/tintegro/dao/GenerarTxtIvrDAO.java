package pe.com.tintegro.dao;


import pe.com.tintegro.dto.request.GenerarTxtIvrReques;
import pe.com.tintegro.dto.response.GenerarTxtIvrResponse;

public interface GenerarTxtIvrDAO {
	public GenerarTxtIvrResponse listarGenerarTxtIvr(String ip, GenerarTxtIvrReques reques) throws Exception;
}
