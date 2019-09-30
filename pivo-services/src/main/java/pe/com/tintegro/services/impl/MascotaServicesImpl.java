package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.MascotaDAO;
import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dto.request.ActualizarMascotaRequest;
import pe.com.tintegro.dto.request.EliminarMascotaRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarMascotaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.services.MascotaServices;
import pe.com.tintegro.services.transformers.TransformerMascota;
import pe.com.tintegro.services.transformers.TransformerPersonal;

@Service("mascotaServices")
@Transactional
public class MascotaServicesImpl implements MascotaServices {
	@Resource(name = "mascotaDAO")
	protected MascotaDAO mascotaDAO;

	@Override
	public ListarMascotaResponse listarMascota(String codUsuario, ListarMascotaRequest request) throws Exception {
		ListarMascotaResponse response = new ListarMascotaResponse();
		response = mascotaDAO.listarMascota(request);
		//
		TransformerMascota obj = new TransformerMascota();
		Graficos graf = obj.transformerTo(response.getLsMascota());
		response.setGraficoMascota(graf);
		//
		return response;
	}

	@Override
	public CRUDResponse registrarMascota(String codUsuario, RegistrarMascotaRequest request) throws Exception {
		// TODO Auto-generated method stub
		CRUDResponse response = new CRUDResponse();
		response=mascotaDAO.registrarMascota(request);
		return response;
	}
	
	@Override
	public CRUDResponse actualizarMascota(String codUsuario, ActualizarMascotaRequest request) throws Exception {
		// TODO Auto-generated method stub
		CRUDResponse response=new CRUDResponse();
		response=mascotaDAO.actualizarMascota(request);
		return response;
	}

	@Override
	public CRUDResponse eliminarMascota(String codUsuario, EliminarMascotaRequest request) throws Exception {
		// TODO Auto-generated method stub
		CRUDResponse response=new CRUDResponse();
		response=mascotaDAO.eliminarMascota(request);
		return response;
	}

}
