package pe.com.tintegro.services.test;

import static org.junit.Assert.*;

import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lowagie.text.pdf.codec.Base64;

import pe.com.tintegro.dto.request.ListaTbUsuarioRequest;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.services.CargaExcelPermisosUsuarioServices;
import pe.com.tintegro.services.util.Util;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CargaExcelPermisosUsuarioServicesTest
{
	@Autowired
	CargaExcelPermisosUsuarioServices excelPermisosUsuario;
	
	@Test
	public void testDescargaExcelPermisosUsuario()
	{
		ListaTbUsuarioRequest request = new ListaTbUsuarioRequest();
		
		try
		{
			ListaTbUsuarioResponse response = excelPermisosUsuario.DescargaExcelPermisosUsuario("192.168.3.202", "jPfFl7Jg2rg=",request);
			System.out.println(response.getReporteFile());
			
			FileOutputStream fileOuputStream = new FileOutputStream( "D:\\fileReporteLlamadaUsuario.xls" );
			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);
		} catch( Exception e)
		{
			e.printStackTrace();
		}
	}
}
