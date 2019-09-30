package pe.com.tintegro.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.PaginaDAO;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;
import pe.com.tintegro.services.PaginaService;
import pe.com.tintegro.services.RolServices;
import pe.com.tintegro.services.util.PaginaUtil;

@Service("paginaServices")
@Transactional
public class PaginaServiceImpl implements PaginaService {
	
	@Resource(name = "paginaDAO")
	protected PaginaDAO paginaDAO;

	@Autowired
	RolServices rolServices;
	
	//@Autowired
	//PaginaService paginaService;

	@Override
	public ListarPaginaResponse listarPaginaServices(ListarPaginaRequest request) throws Exception {
		ListarPaginaResponse responseListaAll = new ListarPaginaResponse();

		responseListaAll = paginaDAO.listarPagina(request);
		List<Pagina> listaPaginasResult = null;

		if (request.getIdRol() != null) {
			ListaPaginasRequest listaPaginaSeleccionadoRequest = new ListaPaginasRequest();
			listaPaginaSeleccionadoRequest.setCodUsuario(request.getCodUsuario());
			listaPaginaSeleccionadoRequest.setIdRol(request.getIdRol());
			ListaPaginasResponse responseListSeleccionado = rolServices.listaPaginasPorRolServices(listaPaginaSeleccionadoRequest);
			listaPaginasResult = PaginaUtil.interseccion(responseListSeleccionado.getPaginas(), responseListaAll.getListaPagina());
		} else {
			listaPaginasResult = responseListaAll.getListaPagina();
		}

		PaginaUtil paginaUtil = new PaginaUtil();
		responseListaAll.setListaPagina(paginaUtil.procesarData(listaPaginasResult));

		return responseListaAll;
	}

	@Override
	public ListarPaginaResponse listarPaginaServicesGP(ListarPaginaRequest request) throws Exception {
		ListarPaginaResponse responseListaAll = new ListarPaginaResponse();
		responseListaAll = paginaDAO.listarPaginasGP(request);
		List<Pagina> listaPaginasResult = null;

		if (request.getIdRol() != null) {
			ListaPaginasRequest listaPaginaSeleccionadoRequest = new ListaPaginasRequest();
			listaPaginaSeleccionadoRequest.setCodUsuario(request.getCodUsuario());
			listaPaginaSeleccionadoRequest.setIdRol(request.getIdRol());
			ListaPaginasResponse responseListSeleccionado = rolServices.listaPaginasPorRolServices(listaPaginaSeleccionadoRequest);
			listaPaginasResult = PaginaUtil.interseccion(responseListSeleccionado.getPaginas(), responseListaAll.getListaPagina());
		} else {
			listaPaginasResult = responseListaAll.getListaPagina();
		}

		PaginaUtil paginaUtil = new PaginaUtil();
		responseListaAll.setListaPagina(paginaUtil.procesarData(listaPaginasResult));
		return responseListaAll;
	}

	@Override
	public ListaUrlPaginaResponse listaUrlPaginaResponse(ListaUrlPaginaRequest request) throws Exception {
		ListaUrlPaginaResponse response = new ListaUrlPaginaResponse();
		response = paginaDAO.listaUrlPagina(request);		
		
		return response;
	}

}
