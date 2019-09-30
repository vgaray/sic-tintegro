package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.ConstanteFisiologicaDAO;
import pe.com.tintegro.dao.HistoriaClinicaDAO;
import pe.com.tintegro.dao.HistoriaClinicaServiceDAO;
import pe.com.tintegro.dao.ListadoProblemaDAO;
import pe.com.tintegro.dao.VacunaDAO;
import pe.com.tintegro.dto.request.ActualizarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.EliminarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.ListarListadoProblemaResponse;
import pe.com.tintegro.dto.response.ListarVacunaResponse;
import pe.com.tintegro.services.HistoriaClinicaServices;
import pe.com.tintegro.services.InstanciaServices;

@Service("historiaClinicaServices")
@Transactional
public class HistoriaClinicaServicesImpl implements HistoriaClinicaServices {
	@Resource(name = "historiaClinicaDAO")
	protected HistoriaClinicaDAO historiaClinicaDAO;
	@Resource(name = "historiaClinicaServiceDAO")
	protected HistoriaClinicaServiceDAO historiaClinicaServiceDAO;
	@Resource(name = "constanteFisiologicaDAO")
	protected ConstanteFisiologicaDAO constanteDAO;
	@Resource(name = "listadoProblemaDAO")
	protected ListadoProblemaDAO problemaDAO;
	@Resource(name = "vacunaDAO")
	protected VacunaDAO vacunaDAO;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListarHistoriaClinicaResponse listarHistoriaClinica(String codUsuario, ListarHistoriaClinicaRequest request)
			throws Exception {
		ListarHistoriaClinicaResponse response = new ListarHistoriaClinicaResponse();
		response = historiaClinicaDAO.listarHistoriaClinica(request);
		return response;
	}

	@Override
	public CRUDResponse registrarHistoriaClininca(String codUsuario, RegistrarHistoriaClinicaRequest request)
			throws Exception {
		CRUDResponse response = new CRUDResponse();
		response = historiaClinicaDAO.registrarHistoriaClinica(request);
		return response;
	}

	@Override
	public CRUDResponse actualizarHistoriaClininca(String codUsuario, ActualizarHistoriaClinicaRequest request)
			throws Exception {
		CRUDResponse response = new CRUDResponse();
		response = historiaClinicaDAO.actualizarHistoriaClinica(request);
		return response;
	}

	@Override
	public CRUDResponse eliminarHistoriaClininca(String codUsuario, EliminarHistoriaClinicaRequest request)
			throws Exception {
		CRUDResponse response = new CRUDResponse();
		response = historiaClinicaDAO.eliminarHistoriaClinica(request);
		return response;
	}

	@Override
	public ListarHistoriaClinicaServiceResponse listarHistoriaClinicaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception {
		ListarHistoriaClinicaServiceResponse response = new ListarHistoriaClinicaServiceResponse();
		request.setpIdInstancia(instanciaServices.desincriptarIdInstancia(idInstancia));
		response = historiaClinicaServiceDAO.listarHistoriaClinicaService(request);
		return response;
	}

	@Override
	public ListarConstanteFisiologicaResponse listarConstanteFisiologicaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception {
		ListarConstanteFisiologicaResponse response = new ListarConstanteFisiologicaResponse();
		request.setpIdInstancia(instanciaServices.desincriptarIdInstancia(idInstancia));
		response = constanteDAO.listaConstanteFisiologica(request);
		return response;
	}

	@Override
	public ListarListadoProblemaResponse listarListadoProblemaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception {
		ListarListadoProblemaResponse response = new ListarListadoProblemaResponse();
		request.setpIdInstancia(instanciaServices.desincriptarIdInstancia(idInstancia));
		response = problemaDAO.listaListadoProblema(request);
		return response;
	}

	@Override
	public ListarVacunaResponse listarVacunaService(String idInstancia, String codUsuario,
			ListarHistoriaClinicaServiceRequest request) throws Exception {
		ListarVacunaResponse response = new ListarVacunaResponse();
		request.setpIdInstancia(instanciaServices.desincriptarIdInstancia(idInstancia));
		response = vacunaDAO.listaVacuna(request);
		return response;
	}

}
