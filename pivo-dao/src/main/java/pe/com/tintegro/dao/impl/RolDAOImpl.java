package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.RolDAO;
import pe.com.tintegro.dominio.Rol;
import pe.com.tintegro.dto.request.ActualizarRolRequest;
import pe.com.tintegro.dto.request.AsignarPaginaRolRequest;
import pe.com.tintegro.dto.request.ListaRolPorInstanciaRequest;
import pe.com.tintegro.dto.request.ListaRolSinInstanciaRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.request.RolRequest;
import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaRolPorInstanciaResponse;
import pe.com.tintegro.dto.response.ListaRolSinInstanciaResponse;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.dto.response.RolResponse;
import pe.com.tintegro.mapper.RolMapper;

@Repository("rolDAO")
public class RolDAOImpl extends DAOTintegroImpl implements RolDAO {
	@Override
	public ListarRolPorTipoRolResponse listarRolPorTipo(ListarRolPorTipoRolRequest request) throws Exception {
		ListarRolPorTipoRolResponse response = new ListarRolPorTipoRolResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.RolMapper.class);
		List<Rol> roles = (List<Rol>) mapper.listarRolesPorRol(request.getIdTipoRol());
		response.setListaRoles(roles);

		return response;
	}

	@Override
	public ListaRolSinInstanciaResponse listaRolSinInstancia(ListaRolSinInstanciaRequest request) throws Exception {
		ListaRolSinInstanciaResponse response = new ListaRolSinInstanciaResponse();

		List<Rol> roles = new ArrayList<Rol>();
		RolMapper mapper = this.getSqlSessionSic().getMapper(RolMapper.class);
		roles = (List<Rol>) mapper.listaRolSinInstancia();
		response.setRoles(roles);

		return response;
	}

	@Override
	public RolResponse crearRol(RolRequest request) throws Exception {
		RolResponse objRol = new RolResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.RolMapper.class);
		objRol = mapper.crearRol(request.getNoRol(), request.getNoDescri(), request.getIlActivo(), request.getIdTipoRol(), request.getIdInstancia());

		return objRol;
	}

	@Override
	public RolResponse AsignarPaginaPorRol(AsignarPaginaRolRequest request) throws Exception {
		RolResponse objRol = new RolResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.RolMapper.class);
		objRol = mapper.AsignarPaginaPorRol(request.getIdRol(), request.getIdPagina());

		return objRol;
	}

	@Override
	public RolResponse actualizarRol(ActualizarRolRequest request) throws Exception {
		RolResponse objRol = new RolResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.RolMapper.class);
		objRol = mapper.actualizarRol(request.getIdRol(), request.getNoRol(), request.getNoDescri(), request.getIlActivo(), request.getIdTipoRol(), request.getIdInstancia());

		return objRol;
	}

	@Override
	public RolResponse eliminarPaginaPorRol(AsignarPaginaRolRequest request) throws Exception {
		RolResponse objRol = new RolResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.RolMapper.class);
		objRol = mapper.eliminarPaginaPorRol(request.getIdRol());

		return objRol;
	}

	public ListaRolPorInstanciaResponse listarRolPorPagina(ListaRolPorInstanciaRequest request) throws Exception {
		ListaRolPorInstanciaResponse response = new ListaRolPorInstanciaResponse();
		List<Rol> roles = new ArrayList<Rol>();
		RolMapper mapper = this.getSqlSessionSic().getMapper(RolMapper.class);

		roles = (List<Rol>) mapper.listaRolesPorInstancia(request.getCodUsuario(), request.getIdInstanciaDeco());
		response.setRoles(roles);

		return response;
	}

	@Override
	public ListaPaginasResponse listaPaginasPorRol(ListaPaginasRequest request) throws Exception {
		ListaPaginasResponse response = new ListaPaginasResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(RolMapper.class);
		List<Pagina> paginas = (List<Pagina>) mapper.listaPaginaPorIdRol(request.getCodUsuario(), request.getIdRol());
		response.setPaginas(paginas);

		return response;
	}

	@Override
	public RolResponse eliminarRol(AsignarPaginaRolRequest request) throws Exception {
		RolResponse response = new RolResponse();

		RolMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.RolMapper.class);
		response = mapper.eliminarRol(request.getIdRol());

		return response;
	}

	@Override
	public List<Confirmacion> eliminarRol(Integer idInstancia, Integer idRol) throws Exception {
		List<Confirmacion> confirmacionList = new ArrayList<>();

		RolMapper mapper = getSqlSessionSic().getMapper(RolMapper.class);
		confirmacionList = mapper.eliminarRol(idInstancia, idRol);

		return confirmacionList;
	}
}
