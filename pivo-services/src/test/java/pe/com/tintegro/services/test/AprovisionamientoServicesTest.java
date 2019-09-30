package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.services.AprovisionamientoServices;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.util.ServicesProperties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class AprovisionamientoServicesTest
{
	@Autowired
	AprovisionamientoServices	aprovisionamientoServices;
	
	@Autowired
	ServicesProperties servicesProperties;

	@Autowired
	SipBuddieServices sipBuddieServices;

	@Test
	public void testGeneradorMacCFG()
	{
		try
		{

			InstanciaServerAsterisk instanciaServerAsterisk = new InstanciaServerAsterisk();
			SipBuddie sipBuddie = new SipBuddie();
			SipTelefono sipTelefono = new SipTelefono();

			// Datos de Red
//			instanciaServerAsterisk.setIpRed("172.29.61.0");
//			instanciaServerAsterisk.setSubnet("172.29.7.0");
//			instanciaServerAsterisk.setIpRouter("172.29.7.4");
//			instanciaServerAsterisk.setDns1("172.20.0.175");
//			instanciaServerAsterisk.setDns2("172.20.0.227");
			instanciaServerAsterisk.setNomMascaraRedLan("255.255.255.0");
			instanciaServerAsterisk.setNomMascaraOpenVpn("172.29.7.255");
			instanciaServerAsterisk.setIpAsterisk("172.29.7.7");
//			instanciaServerAsterisk.setIpMedian("172.29.7.7");

			// Datos de Sip
			sipTelefono.setNomModelo("T21");
			sipTelefono.setNomMarca("Yealink");
			sipBuddie.setName("5000");
			sipBuddie.setCallerid("5000");
			sipBuddie.setUsername("5000");
			sipBuddie.setSecret("5000");
			sipTelefono.setNomMac("EB:12:M2:NM:3B");

			// boolean response =
			// aprovisionamientoServices.generarArchivoMacCFG(instanciaServerAsterisk,
			// sipBuddie, sipTelefono);
			// System.out.println(response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
//	@Test
	public void generateProvisioning()
	{
		SipBuddie sipBuddie = new SipBuddie();
		SipTelefono sipTelefono = new SipTelefono();
		InstanciaServerAsterisk vm = new InstanciaServerAsterisk();
		
		sipBuddie.setName( "5336");
		sipBuddie.setUsername( "Anexo5334" );
		sipBuddie.setSecret( "233");
		sipBuddie.setCallerid( "233");

		vm.setIpAsterisk( "192.168.3.254" );
		vm.setPuertoOpenVPN( "1194" );
		vm.setIpAsteriskBash( "192.168.3.254" );
		
//		sipTelefono.setNomMarca( "AKUVOX" );
//		sipTelefono.setNomModelo( "SPR52P" );
		sipTelefono.setMarcaId( null );
		sipTelefono.setModeloId( null );
		sipTelefono.setCallerId( "5336" );
		sipTelefono.setClaveUsuario( "asdga235347" );
//		sipTelefono.setNomMac( "001565233bfb" );
		
		try
		{
			aprovisionamientoServices.generateProvisioning( "cli", 1194, sipBuddie, sipTelefono, vm );
		}
		catch ( Exception e )
		{
			System.err.println( e.getMessage() );
		}
	}
}
