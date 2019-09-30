package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.RingGroupDAO;
import pe.com.tintegro.dominio.RingGroup;
import pe.com.tintegro.dto.request.ActualizarRingGroupRequest;
import pe.com.tintegro.dto.request.EliminarRingGroupRequest;
import pe.com.tintegro.dto.request.InsertarRingGroupRequest;
import pe.com.tintegro.dto.request.ListaRingGroupRequest;
import pe.com.tintegro.dto.request.ListarRingGroupxAnexoRequest;
import pe.com.tintegro.dto.request.ListarVerificacionRingGroupRequest;
import pe.com.tintegro.dto.response.ActualizarRingGroupResponse;
import pe.com.tintegro.dto.response.EliminarRingGroupResponse;
import pe.com.tintegro.dto.response.InsertarRingGroupResponse;
import pe.com.tintegro.dto.response.ListaRingGroupResponse;
import pe.com.tintegro.dto.response.ListarRingGroupxAnexoResponse;
import pe.com.tintegro.dto.response.ListarVerificacionRingGroupResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class RingGroupDAOTest {

	@Autowired
	RingGroupDAO ringGroupDAO;

	@Ignore
	@Test
	public void testListar() {
		ListaRingGroupRequest request = new ListaRingGroupRequest();
		request.setIdGrupo(null);
		try {
			ListaRingGroupResponse response = new ListaRingGroupResponse();
			response = ringGroupDAO.listaRingGroupDAO("192.168.3.202", request);
			List<RingGroup> rings = new ArrayList<RingGroup>();

			rings = response.getListRingGroup();

			for (RingGroup ringGroup : rings) {
				System.out.println("Indice: " + ringGroup.getIndice() + "Nombre: " + ringGroup.getNoGrupo() + "Numero: " + ringGroup.getNuGrupo() + "Anexo: " + ringGroup.getNuAnexos() + "Cantidad: " + ringGroup.getCantidadAnexo());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Ignore
	@Test
	public void testInsertar() {
		InsertarRingGroupRequest request = new InsertarRingGroupRequest();
		request.setNoGrupo("Grupo23");
		request.setNuGrupo(89022);
		request.setNuSipL("1239, 1004,1005");

		try {
			InsertarRingGroupResponse response = new InsertarRingGroupResponse();
			response = ringGroupDAO.insertarRingGroupDAO("192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testActualizar() {
		ActualizarRingGroupRequest request = new ActualizarRingGroupRequest();
		request.setIdGrupo(8);
		request.setNoGrupo("Grupo 8");
		request.setNuGrupo(8678);
		request.setIlActivo(false);
		request.setIdSip("25, 27, 62, 42");

		try {
			ActualizarRingGroupResponse response = new ActualizarRingGroupResponse();
			response = ringGroupDAO.actualizarRingGroupDAO("192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testEliminar() {
		EliminarRingGroupRequest request = new EliminarRingGroupRequest();
		request.setpIdGrupo(29);
		try {
			EliminarRingGroupResponse response = new EliminarRingGroupResponse();
			response = ringGroupDAO.eliminarRingGroupDAO("192.168.3.202", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void ValidarRingGruop() {
		ListarVerificacionRingGroupRequest request = new ListarVerificacionRingGroupRequest();
		request.setpNoGrupo("Grupo 6");
		request.setpNuGrupo(0);
		try {
			ListarVerificacionRingGroupResponse response = new ListarVerificacionRingGroupResponse();
			response = ringGroupDAO.verificacionRingGroupDAO("192.168.3.202", request);
			for (RingGroup grupos : response.getListRingGroup()) {
				System.out.println("Numero de Grupo: " + grupos.getIdRasult() + "\nNombre de Grupo: " + grupos.getMensaje());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testFiltro() {
		ListarRingGroupxAnexoRequest request = new ListarRingGroupxAnexoRequest();
		request.setpAnexos("1008");
		try {
			ListarRingGroupxAnexoResponse response = new ListarRingGroupxAnexoResponse();
			response = ringGroupDAO.filtroRingGroupDAO("192.168.3.202", request);
			List<RingGroup> rings = new ArrayList<RingGroup>();

			rings = response.getListRingGroup();

			for (RingGroup ringGroup : rings) {
				System.out.println("Indice: " + ringGroup.getIndice() + "Nombre: " + ringGroup.getNoGrupo() + "Numero: " + ringGroup.getNuGrupo() + "Anexo: " + ringGroup.getNuAnexos() + "Cantidad: " + ringGroup.getCantidadAnexo());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
