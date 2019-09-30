package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.PaginaDAO;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;
import pe.com.tintegro.mapper.PaginaMapper;

@Repository("paginaDAO")
public class PaginaDAOImpl extends DAOTintegroImpl implements PaginaDAO{

	@Override
	public ListarPaginaResponse listarPagina(ListarPaginaRequest request) {		
		List<Pagina> listaPag = new ArrayList<Pagina>();
		ListarPaginaResponse response = new ListarPaginaResponse();		
		PaginaMapper mapper=this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.PaginaMapper.class);
		listaPag = mapper.listarPagina();
		response.setListaPagina(listaPag);		
		return response;
	}

	@Override
	public ListarPaginaResponse listarPaginasGP(ListarPaginaRequest request) throws Exception
	{
      List<Pagina> listaPaginaGP=new ArrayList<Pagina>();
      ListarPaginaResponse response=new ListarPaginaResponse();
      PaginaMapper mapper=this.getSqlSessionSic().getMapper(PaginaMapper.class);
      listaPaginaGP=mapper.listarPaginaGP();
      response.setListaPagina(listaPaginaGP);
		return response;
	}

	@Override
	public ListaUrlPaginaResponse listaUrlPagina(ListaUrlPaginaRequest request) throws Exception {
		List<Pagina> listaUrlPagina = new ArrayList<Pagina>();
		ListaUrlPaginaResponse response = new ListaUrlPaginaResponse();
		PaginaMapper mapper = this.getSqlSessionSic().getMapper(PaginaMapper.class);
		listaUrlPagina=mapper.listaPaginaUrl(request.getpNoComponente());
		response.setLsPaginaUrl(listaUrlPagina);
		return response;
	}
}