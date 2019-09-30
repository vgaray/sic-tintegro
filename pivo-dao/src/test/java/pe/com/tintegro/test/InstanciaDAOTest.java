package pe.com.tintegro.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.InstanciaDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.InstanciaN;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.StatusBash;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.AsignarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciasPorEmpresaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciasPorEmpresaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxIdClienteResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class InstanciaDAOTest {

	@Autowired
	InstanciaDAO instanciaDAO;

	// @Test
	public void testInstanciaListar() {
		List<InstanciaServerAsterisk> listas = instanciaDAO.listarInstancia();

		for (InstanciaServerAsterisk isa : listas) {
			System.out.println(isa.getIdMostrar());
		}
		Assert.assertNotNull(listas);
	}

	// @Test
	public void testInstanciaListarxValor() throws Exception {
		ListarInstanciaxCasoRequest obj = new ListarInstanciaxCasoRequest();

		obj.setValor(4);

		// instanciaDAO.listarInstanciaxvalor(obj);
		//
		// // for (InstanciaServerAsterisk usuario :
		// // instanciaDAO.listarInstanciaxvalor(obj)) {
		//
		// System.out.println("tamño: " +
		// instanciaDAO.listarInstanciaxvalor(obj).getListarInstaciaxCaso().size());

		// }
	}

	// @Test
	public void testInstanciaListarxCaso() throws Exception {
		ListarInstanciaxCasoRequest obj = new ListarInstanciaxCasoRequest();

		obj.setIdCliente(4);
		obj.setEstadoE(null);
		obj.setOcupadoE(1);

		instanciaDAO.listarInstanciaxCaso(obj);

		for (ListarInstanciaxCasoRequest usuario : instanciaDAO.listarInstanciaxCaso(obj).getListarInstaciaxCaso()) {

			System.out.println("cliente: " + usuario.getIdCliente());

		}
	}

	// @Test
	public void testInstanciaInsertar() throws Exception {
		InsertarInstanciaRequest obj = new InsertarInstanciaRequest();

		obj.setIpRed("miercoles");
		obj.setNroVLan(null);
		obj.setIpAsterisk("booolt");
		obj.setIpMedian("booolt");
		obj.setMascara("booolt");
		obj.setIpRouter("booolt");
		obj.setDns1("booolt");
		obj.setDns2("booolt");
		obj.setSubnet("booolt");
		obj.setBroadcast("booolt");
		obj.setPuertoAsteriskBashCertificadoExt(123);
		obj.setIpAsteriskBash("booolt");
		// obj.setIdCliente(null);
		instanciaDAO.insertarInstancia(obj);
	}

	// @Test
	public void testAsignarInstancia() throws Exception {
		AsignarInstanciaRequest obj = new AsignarInstanciaRequest();

		obj.setIdInstancia(26);
		obj.setValor(0);
		obj.setIdCliente(3);
		// instanciaDAO.asignarInstancia(obj);
	}

	// @Test
	public void testInstanciaxId() throws Exception {
		// ListaInstanciaxIdRequest obj=new ListaInstanciaxIdRequest();
		ListaInstanciaxIdRequest request = new ListaInstanciaxIdRequest();

		request.setIdInstanciaDesc(53);
		ListaInstanciaxIdResponse response = new ListaInstanciaxIdResponse();

		response = instanciaDAO.listarInstanciaxId(request);

		for (InstanciaServerAsterisk inst : response.getListarInstanciaxId()) {
			System.out.println("tamaño: " + inst.getIdInstancia() + " " + inst.getNoInstancia());
		}
	}

	// @Test
	public void testInstanciaxIdCliente() throws Exception {
		ListarInstanciaxIdClienteRequest obj = new ListarInstanciaxIdClienteRequest();
		obj.setIdCliente(4);
		ListarInstanciaxIdClienteResponse response = new ListarInstanciaxIdClienteResponse();
		response = instanciaDAO.listarInstanciaxIdCliente(obj);

		System.out.println("tamaño: " + response.getListarInstanciaxIdcliente().size());

	}

	 @Test
	public void testListarInstancia() throws Exception {
		ListaInstanciaRequest obj = new ListaInstanciaRequest();

		obj.setpIdTipdoc(null);
		obj.setpNuDocide(null);
		obj.setpIdCliente(null);
		obj.setpIdPedido(null);
		obj.setpIdEstadoinstancia(null);
		obj.setpIdPlan(null);
		obj.setpIdTipoEstadoPedido(null);

		obj.setpIdInstanciaxDesc(169);
		obj.setpIdUsuario(null);
		obj.setpNoLogin("usuAdminis");

		ListaInstanciaResponse response = instanciaDAO.listarInstancia(obj);

		List<InstanciaServerAsterisk> instancias = response.getInstancias();

		for (int i = 0; i < instancias.size(); i++) {
			System.out.println(instancias.get(i).getIdInstancia() + instancias.get(i).getIdMostrar() + "  " + instancias.get(i).getNoRazonSocial() + " " + instancias.get(i).getNoPasswordLdap());
		}
	}

	// @Test
	public void notifyExecuteBashConfigInitialTest() {
		CRUDResponse response = null;
		Integer idBash = 4;
		Integer idInstance = 73;

		try {
			response = instanciaDAO.notifyExecuteBashConfigInitial("cli", idBash, idInstance, Constantes.EXECUTE_COMAND_SUCESS);
			Assert.assertNotNull(response);
			System.out.println(response.getMensajeValidacion());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void loadStatusConfigInitialInstanceTest() {
		String codUser = "cli";
		Integer idInstance = 83;
		try {
			List<StatusBash> lsStatusBash = instanciaDAO.loadStatusConfigInitialInstance(codUser, idInstance);
			Assert.assertNotNull(lsStatusBash);

			String statusBashStr = null;

			for (StatusBash statusBash : lsStatusBash) {
				statusBashStr = String.format("%-20s %-10s %s", statusBash.getNoDescripBash(), statusBash.getNoStatusBash(), statusBash.getNoServicioEjecucion());
				System.out.println(statusBashStr);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void testActualizarInstancia() {
		try {
			ActualizarInstanciaRequest request = new ActualizarInstanciaRequest();

			request.setIdInstanciaDesc(87);
			request.setIpAsterisk("192.168.3.245");
			request.setNomMascaraRedLan("");
			request.setNomMascaraOpenVpn("");
			// request.setIdCliente(64);
			request.setIlEstado(true);
			// request.setIlLibre(true);
			request.setIpAsteriskBash("");
			request.setPuerto_ssh_asterisk(122);
			request.setPuertoOpenVPN("");
			request.setPamConfInicial("");
			request.setSimPais("");
			request.setSimProvincia("");
			request.setFullProvincia("");
			request.setNoOrgani("");
			request.setEmail("");
			request.setIdModelo(3);
			request.setIdMarca(11);
			// request.setInicial(10);
			// request.setIdEstadoInstancia(1);
			request.setNomInstancia("modificado");
			ActualizarInstanciaResponse response = instanciaDAO.actualizarInstancia(request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		} catch (Exception e) {
			System.err.print(e);
		}
	}

	//@Test
	public void testInsertarInstancia() {
		try {
			InsertarInstanciaNRequest request = new InsertarInstanciaNRequest();
			InstanciaN obj = new InstanciaN();
			obj.setIp_asterisk("");
			obj.setNo_mascara_red_lan("");
			obj.setNo_mascara_open_vpn("");
			obj.setId_cliente(64);
			obj.setIl_estado(true);
			obj.setIl_libre(true);
			obj.setPuerto_ssh_asterisk(2);
			obj.setPuerto_openvpn("");
			obj.setSim_pais("");
			obj.setSim_provincia("");
			obj.setFull_provincia("");
			obj.setNo_organi("");
			obj.setNo_email("vgaray");
			obj.setIp_asterisk("");
			obj.setId_estadoinst(1);
			obj.setNo_instancia("");
			obj.setNo_password_ldap("");
			obj.setInicial(20);
			request.setInstanciaN(obj);
			InsertarInstanciaNResponse response = instanciaDAO.insertarInstanciaN(request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		} catch (Exception e) {
			System.err.print(e);
		}
	}

	// @Test
	public void testInstanciaxEmpresas() throws Exception {
		// ListaInstanciaxIdRequest obj=new ListaInstanciaxIdRequest();
		ListaInstanciasPorEmpresaRequest request = new ListaInstanciasPorEmpresaRequest();
		ListaInstanciasPorEmpresaResponse response = new ListaInstanciasPorEmpresaResponse();
		request.setIdInstanciaDesc(83);
		response = instanciaDAO.listaInstanciasPorEmpresa(request);
		for (InstanciaServerAsterisk inst : response.getListaInstanciaEmpresa()) {
			System.out.println("tamaño: " + inst.getIdInstancia() + " " + inst.getIpAsterisk() + " " + inst.getIdCliente() + " " + inst.getNoRazonSocial());
		}
	}
}
