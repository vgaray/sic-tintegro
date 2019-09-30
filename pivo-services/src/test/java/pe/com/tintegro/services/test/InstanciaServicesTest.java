package pe.com.tintegro.services.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.InstanciaN;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class InstanciaServicesTest
{

	@Autowired
	InstanciaServices instanciaServices;

	 //@Test
	public void testlistarinstanciaXid()
	{
		try
		{

			ListaInstanciaxIdRequest request = new ListaInstanciaxIdRequest();
			request.setIdInstancia("jPfFl7Jg2rg=");
			ListaInstanciaxIdResponse response = instanciaServices.listarIntanciaxIdInstancia("cli", request);
			for (InstanciaServerAsterisk instancia : response.getListarInstanciaxId())
			{
				System.out.println("idInstancia " + instancia.getIdInstancia() + " " + "nombre instancia " + instancia.getNoInstancia() + " Password "+EncriptaUtils.desencriptar(instancia.getNoPasswordLdap()));
			}

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void testlistarinstanciaXidcliente()
	{
		try
		{

			ListarInstanciaxIdClienteRequest obj = new ListarInstanciaxIdClienteRequest();
			obj.setIdCliente(66);
			instanciaServices.listarIntanciaxIdCliente("", obj);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testlistarinstanciaXCASO()
	{
		try
		{

			ListarInstanciaxCasoRequest obj = new ListarInstanciaxCasoRequest();
			obj.setIdCliente(4);
			obj.setEstadoE(1);
			obj.setOcupadoE(1);
			instanciaServices.listarIntanciaxCaso("", obj);

			System.out.println("tamaño: " + instanciaServices.listarIntanciaxCaso("", obj).getListarInstaciaxCaso().size());

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testInstanciaInsertar() throws Exception
	{
		InsertarInstanciaRequest obj = new InsertarInstanciaRequest();

		obj.setIpRed("dddleoe");
		obj.setNroVLan(34654);
		obj.setIpAsterisk("dinkiwinki");
		obj.setIpMedian("d");
		obj.setMascara("d");
		obj.setIpRouter("d");
		obj.setDns1("d");
		obj.setDns2("d");
		obj.setSubnet("d");
		obj.setBroadcast("d");
		obj.setPuertoAsteriskBashCertificadoExt(123);
		obj.setIpAsteriskBash("daas");
		// obj.setIdCliente(null);
		instanciaServices.insertarInstancia("", obj);
	}

	// //@Test
	// public void testAsignarInstancia() throws Exception
	// {
	// AsignarInstanciaRequest obj=new AsignarInstanciaRequest();
	//
	// obj.setIdInstancia(25);
	// obj.setValor(1);
	// obj.setIdCliente(4);
	// instanciaServices.asignarInstancia("", obj);
	// }

	 @Test
	public void testListarInstanciaServices() throws Exception
	{
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

		ListaInstanciaResponse response = instanciaServices.listaInstancia("usuAdminis", obj);

		List<InstanciaServerAsterisk> instancias = response.getInstancias();

		for (int i = 0; i < instancias.size(); i++)
		{
			System.out.println(instancias.get(i).getIdMostrar() + "  " + instancias.get(i).getNoRazonSocial() + " " + instancias.get(i).getNoPasswordLdap());
		}
	}

	//@Test
	public void testActualizarInstancia()
	{
		try
		{
			ActualizarInstanciaRequest request = new ActualizarInstanciaRequest();
			request.setIdInstancia("jPfFl7Jg2rg=");
			request.setIpAsterisk("192.168.3.245");
			request.setNomMascaraRedLan("255.255.255.0");
			request.setNomMascaraOpenVpn("172.29.7.4");
			// request.setIdCliente(64);
			// request.setIlEstado(true);
			// request.setIlLibre(true);
			request.setIpAsteriskBash("192.168.3.254");
			request.setPuerto_ssh_asterisk(1169);
			request.setPuertoOpenVPN("1169");
			request.setPamConfInicial("trust");
			request.setSimPais("PE");
			request.setSimProvincia("LI");
			request.setFullProvincia("LIMA");
			request.setNoOrgani("T-Contacta");
			request.setEmail("soporte@t-contacta.com");
			request.setIdModelo(3);
			request.setIdMarca(1);
			// request.setInicial(10);
			// request.setIdEstadoInstancia(3);
			request.setNomInstancia("nivel service");
			ActualizarInstanciaResponse response = instanciaServices.actualizarInstancia("jpareja", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());

		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.println("aca esta el error");
			System.err.println(e);
		}
	}
	//@Test
	public void testInsertarInstancia()
	{
		try
		{
			InsertarInstanciaNRequest request = new InsertarInstanciaNRequest();
			InstanciaN obj=new InstanciaN();
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
			obj.setIp_asterisk("");
			obj.setId_estadoinst(1);
			obj.setNo_instancia("");
			obj.setNo_password_ldap("");
			obj.setInicial(20);
			obj.setId_detapedido(500);
			request.setInstanciaN(obj);
			InsertarInstanciaNResponse response = instanciaServices.insertarInstanciaN("jpareja",request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.err.print(e);
		}
	}
}
