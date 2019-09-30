package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.AutoCompletarSipTelefonoRequest;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.response.AutoCompletarSipTelefonoResponse;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.DescargaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.services.SipTelefonoServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SipTelefonoServicesTest
{
	@Autowired
	SipTelefonoServices sipTelefonoServices;

	//@Test
	public void sipTelefonoList()
	{
		try
		{
			ListaSipTelefonoResponse response = sipTelefonoServices
					.listaSipTelefono("codusuariox","1");
			for(SipTelefono sip: response.getSipTelefonoList()){
				System.out.println(sip.getNomUsuario()+" "+sip.getCallerId()+ " "+sip.getEmail());
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	@Test
	public void sipTelefonoBuscaId()
	{	try
		{BuscaSipBuddieIdRequest request = new BuscaSipBuddieIdRequest();
			request.setNomUsuario("5334");
			BuscaSipBuddieIdResponse response = sipTelefonoServices
					.buscaSipBuddieId("192.168.3.202", request);
			System.out.println(response.getSipTelefonoList().size());
		} catch (Exception e)
		{e.printStackTrace();
		}}*/
	
	@Test
	public void AutoCompletarSipTelefono()
	{
		try{
			AutoCompletarSipTelefonoRequest request = new AutoCompletarSipTelefonoRequest();
			request.setpNuAnexo("1");
			AutoCompletarSipTelefonoResponse response = sipTelefonoServices.AutoCompletarSipTelefono("","jPfFl7Jg2rg=", request);
			System.out.println(response.getListaAnexos().size());
		}catch(Exception e){	e.printStackTrace();}
	}
}
