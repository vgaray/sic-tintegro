package pe.com.tintegro.services.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.SipTelefonoDAO;
import pe.com.tintegro.dto.request.CargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.DescargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.response.CargaExcelSipBuddieResponse;
import pe.com.tintegro.dto.response.DescargaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaExcelResponse;
import pe.com.tintegro.services.CargarExcelSipBuddieServices;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.util.ExcelUtil;
import pe.com.tintegro.services.util.UtilFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CargarExcelSipBuddieServivceTest
{
	@Autowired
	CargarExcelSipBuddieServices cargasipBuddieService;

	@Autowired
	SipTelefonoDAO sipTelefonoDAO;

	//@Test
	public void CargarExcelSipBuddieTest() throws Exception
	{
		List<EditaSipBuddieRequest> ListaSipBuddie = new ArrayList<EditaSipBuddieRequest>();
		EditaSipBuddieRequest objSipBuddie = new EditaSipBuddieRequest();

		objSipBuddie.setNomUsuario("1010");
		objSipBuddie.setCallerId("AdministracionII");
		objSipBuddie.setCorreoBox("usuario@call.com");

		ListaSipBuddie.add(objSipBuddie);

		
		//FileInputStream file = new FileInputStream(
		File file = new File("D:\\listaSip - copia.xls");
		


		// FileInputStream file = new FileInputStream(



		String base64 = UtilFile.codificarToBase64(file);
		String codUsuario = "cli";
		String idInstancia = "jPfFl7Jg2rg=";
		CargaExcelSipBuddieRequest request = new CargaExcelSipBuddieRequest();

		request.setExcelBase64(base64);
		cargasipBuddieService.cargarExcelSipBuddie(codUsuario, idInstancia, request);
		System.out.print(ListaSipBuddie.size());
	}

	// @Test
	public void DescargaSipTelefonoResponse()
	{
		DescargaExcelSipBuddieRequest request = new DescargaExcelSipBuddieRequest();
		try
		{
			DescargaSipTelefonoResponse response = cargasipBuddieService.descargaSipTelefono("codusuariox", "1", request);
			System.out.println(response.getReporteFile());

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	//@Test
	public void validarExcelSipTelefono() 
	{
		File file = new File("C:\\pruebas\\lista.xls");
		
	
		
		
		try
		{

			String base64 = UtilFile.codificarToBase64(file);
			ValidaExcelResponse response=cargasipBuddieService.validarExcelSipTelefono(base64);	
			System.out.println(response.getEstado());
			System.out.println(response.getListaErrores());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		
		}
		
	}

	@Test
	public void testCargarDataList(){
		File f;
		CargaExcelSipBuddieRequest request=new CargaExcelSipBuddieRequest();
		

			f=new File ("D:\\listaSip - copia.xls");
			String excelb64String;


			try
			{
				excelb64String = UtilFile.codificarToBase64(f);
				request.setExcelBase64(excelb64String);

				CargaExcelSipBuddieResponse response=cargasipBuddieService.cargarExcelSipBuddie("cli", "jPfFl7Jg2rg=", request);
				
				System.out.println();
				System.out.println(response.getEstado());
				System.out.println(response.getMensaje());
			   System.out.println(response.getListaErrores());
			   
				System.out.println(request.getExcelBase64());
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		
	}
	
}
