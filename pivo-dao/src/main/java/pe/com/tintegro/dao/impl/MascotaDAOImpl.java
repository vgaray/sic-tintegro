package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.MascotaDAO;
import pe.com.tintegro.dominio.Mascota;
import pe.com.tintegro.dto.request.ActualizarMascotaRequest;
import pe.com.tintegro.dto.request.EliminarMascotaRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarMascotaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.mapper.MascotaMapper;

@Repository("mascotaDAO")
public class MascotaDAOImpl extends DAOTintegroImpl implements MascotaDAO {
	
	@Override
	public ListarMascotaResponse listarMascota(ListarMascotaRequest request) throws Exception {
		List<Mascota> result = new ArrayList<Mascota>();
		ListarMascotaResponse response = new ListarMascotaResponse();
		MascotaMapper mapper = this.getSqlSessionSic().getMapper(MascotaMapper.class);
		result = (List<Mascota>) mapper.listarMascota(request.getpIdMascota(),
													  request.getpCodUsuario(),
													  request.getpNuChip(),
													  request.getpTiFun());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsMascota(result);
		return response;
	}

	@Override
	public CRUDResponse registrarMascota(RegistrarMascotaRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		CRUDResponse response=new CRUDResponse();
		MascotaMapper mapper = this.getSqlSessionSic().getMapper(MascotaMapper.class);
		result = (List<CRUDResponse>) mapper.registrarMascota(request.getMascota().getNoNombre(),
															  request.getMascota().getNoColor(),
															  request.getMascota().getNoSeniasParticulares(),
															  request.getMascota().getNoSexo(),
															  request.getMascota().getNuEdad(),
															  request.getMascota().getNuChip(),
															  request.getMascota().getFeNacimiento(),
															  request.getMascota().getCodUsuario(),
															  request.getMascota().getIdEspecie(),
															  request.getMascota().getIdRaza());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}
	
	@Override
	public CRUDResponse actualizarMascota(ActualizarMascotaRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		CRUDResponse response=new CRUDResponse();
		MascotaMapper mapper = this.getSqlSessionSic().getMapper(MascotaMapper.class);
		result = (List<CRUDResponse>) mapper.actualizarMascota(request.getMascota().getIdMascota(),
															  request.getMascota().getNoNombre(),
															  request.getMascota().getNoColor(),
															  request.getMascota().getNoSeniasParticulares(),
															  request.getMascota().getNoSexo(),
															  request.getMascota().getNuEdad(),
															  request.getMascota().getNuChip(),
															  request.getMascota().getFeNacimiento(),
															  request.getMascota().getCodUsuario(),
															  request.getMascota().getIdEspecie(),
															  request.getMascota().getIdRaza());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}
	
	@Override
	public CRUDResponse eliminarMascota(EliminarMascotaRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		CRUDResponse response=new CRUDResponse();
		MascotaMapper mapper = this.getSqlSessionSic().getMapper(MascotaMapper.class);
		result = (List<CRUDResponse>) mapper.eliminarMascota(request.getpIdMascota());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	

}
