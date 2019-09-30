package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.PersonalDAO;
import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.EliminarPersonalRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.PersonalServices;
import pe.com.tintegro.services.transformers.TransformerPersonal;

@Service("personalServices")
@Transactional
public class PersonalServicesImpl implements PersonalServices {

	@Resource(name = "personalDAO")
	protected PersonalDAO personalDAO;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListarPersonalResponse listarPersonal(String codUsuario, String idInstancia, ListarPersonalRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		ListarPersonalResponse response = new ListarPersonalResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = personalDAO.listarPersonal(ip, request);
		//
		if(response.getLsPersonal().size()>0)
		{
			TransformerPersonal obj = new TransformerPersonal();
			Graficos graf = obj.transformerTo(response.getLsPersonal());
			response.setGraficoPersonal(graf);
		}
		//
		return response;
	}

	@Override
	public CRUDResponse eliminarPersonal(String codUsuario, String idInstancia, EliminarPersonalRequest request)
			throws Exception {
		CRUDResponse response = new CRUDResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = personalDAO.eliminarPersonal(ip, request);
		return response;
	}

	@Override
	public CRUDResponse registrarPersonal(String codUsuario, String idInstancia, RegistrarPersonalRequest request)
			throws Exception {
		CRUDResponse response = new CRUDResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = personalDAO.registrarPersonal(ip, request);
		return response;
	}

	@Override
	public CRUDResponse actualizarPersonal(String codUsuario, String idInstancia, ActualizarPersonalRequest request)
			throws Exception {
		CRUDResponse response = new CRUDResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = personalDAO.actualizarPersonal(ip, request);
		// TODO Auto-generated method stub
		return response;
	}

}
