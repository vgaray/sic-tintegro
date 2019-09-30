package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.BuscaPinRequest;
import pe.com.tintegro.dto.request.EliminarTbPinRequest;
import pe.com.tintegro.dto.request.FlagTbPinRequest;
import pe.com.tintegro.dto.request.FlagTbUsuarioRequest;
import pe.com.tintegro.dto.request.InsertaTbPinRequest;
import pe.com.tintegro.dto.response.BuscaPinResponse;
import pe.com.tintegro.dto.response.EliminarTbPinResponse;
import pe.com.tintegro.dto.response.FlagTbPinResponse;
import pe.com.tintegro.dto.response.FlagUsuarioResponse;
import pe.com.tintegro.dto.response.InsertaTbPinResponse;
import pe.com.tintegro.services.TbPinServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class TbPinServicesTest {

	
	@Autowired
	TbPinServices tbPinServices; 
	
	@Test
	 public void testModificarFlagPin() {
		 try {
			 FlagTbPinRequest request = new FlagTbPinRequest();
				request.setIdUsupin(875);
				request.setIdClave(3);
				request.setIdTiptel(1);
				
				request.setEstado(1);
				
			 
			FlagTbPinResponse response=tbPinServices.modificarFlagTbPin("cli","jPfFl7Jg2rg=",request);
			System.out.println(response.getConfirma());
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			System.out.println( exception.getMessage() );
		}
	 }

	public void buscaPin(){
		try
		{
			BuscaPinRequest request = new BuscaPinRequest();
			request.setNumPin("1114");
			BuscaPinResponse response = tbPinServices.buscaPin("192.168.3.202","e", request);
			System.out.println("cantidad de registros "+response.getIlExistePin());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println( e.getMessage() );
		}
	}
}
