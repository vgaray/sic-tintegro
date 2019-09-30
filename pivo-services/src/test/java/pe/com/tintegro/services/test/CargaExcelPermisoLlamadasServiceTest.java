package pe.com.tintegro.services.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.CargaExcelPermisoLlamadasRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.services.CargaExcelPermisoLlamadasServices;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.UtilFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CargaExcelPermisoLlamadasServiceTest {
	@Autowired
	CargaExcelPermisoLlamadasServices cargaExcelPermisoLlamadasService;
	//@Test
	public void CargarExcelPermisoLlamadasTest() throws Exception{
		List<InsertarUsuarioRequest> ListaCarga = new ArrayList<InsertarUsuarioRequest>();
		InsertarUsuarioRequest objCarga = new InsertarUsuarioRequest();
		
		objCarga.setNoApemat("Rojas");
		objCarga.setNoApepat("Rojas");
		objCarga.setNoNombre("Mirian");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("");
		objCarga.setNoCentCosto("");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Marino");
		objCarga.setNoApepat("CubA");
		objCarga.setNoNombre("Luis");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("");
		objCarga.setNoCentCosto("");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Rioz");
		objCarga.setNoApepat("Riquelme");
		objCarga.setNoNombre("Monika");
		objCarga.setNoPuesto("Redes");
		objCarga.setNoArea("Area Redes");
		objCarga.setNoCentCosto("Centro Redes");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Rojas");
		objCarga.setNoApepat("Reyes");
		objCarga.setNoNombre("Mirian");
		objCarga.setNoPuesto("Contabilidad");
		objCarga.setNoArea("Contabilidad");
		objCarga.setNoCentCosto("Centro Conta I");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Orope");
		objCarga.setNoApepat("Araujo");
		objCarga.setNoNombre("Laydi");
		objCarga.setNoPuesto("Contabilidad");
		objCarga.setNoArea("Contabilidad II");
		objCarga.setNoCentCosto("Centro Conta II");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Reina");
		objCarga.setNoApepat("Lesma");
		objCarga.setNoNombre("Carlos");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("Area Pueba II");
		objCarga.setNoCentCosto("");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Rojas");
		objCarga.setNoApepat("Rojas");
		objCarga.setNoNombre("Omar");
		objCarga.setNoPuesto("Contabilidad");
		objCarga.setNoArea("Area Contabilidad II");
		objCarga.setNoCentCosto("Centro Conta II");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Carmen");
		objCarga.setNoApepat("Olivera");
		objCarga.setNoNombre("Lucero");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("Area Pueba II");
		objCarga.setNoCentCosto("Centro Prueba II");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Fuentes");
		objCarga.setNoApepat("Orellana");
		objCarga.setNoNombre("Marta");
		objCarga.setNoPuesto("Redes");
		objCarga.setNoArea("Area Redes");
		objCarga.setNoCentCosto("Centro Redes");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Castro");
		objCarga.setNoApepat("Marales");
		objCarga.setNoNombre("Sandra");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("Area Pueba II");
		objCarga.setNoCentCosto("");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Villa");
		objCarga.setNoApepat("Resta");
		objCarga.setNoNombre("Macarena");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("Desarrollo");
		objCarga.setNoCentCosto("Centro Desarrollo");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Hilo");
		objCarga.setNoApepat("Dental");
		objCarga.setNoNombre("Estefani");
		objCarga.setNoPuesto("Redes");
		objCarga.setNoArea("Redes");
		objCarga.setNoCentCosto("Centro Redes");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Boca");
		objCarga.setNoApepat("Chica");
		objCarga.setNoNombre("Margo");
		objCarga.setNoPuesto("Redes");
		objCarga.setNoArea("Redes II");
		objCarga.setNoCentCosto("Centro Redes");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Mela");
		objCarga.setNoApepat("Chupas");
		objCarga.setNoNombre("Ami");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("Area Pueba II");
		objCarga.setNoCentCosto("Centro Prueba II");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Tearrin");
		objCarga.setNoApepat("Cono");
		objCarga.setNoNombre("Luz");
		objCarga.setNoPuesto("Cableado");
		objCarga.setNoArea("Cableado");
		objCarga.setNoCentCosto("Centro Cableado");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Cornejo");
		objCarga.setNoApepat("Roto");
		objCarga.setNoNombre("Pablo");
		objCarga.setNoPuesto("Programador");
		objCarga.setNoArea("Area Pueba II");
		objCarga.setNoCentCosto("Centro Prueba II");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Barja");
		objCarga.setNoApepat("Hilarion");
		objCarga.setNoNombre("Lizbeth");
		objCarga.setNoPuesto("Redes");
		objCarga.setNoArea("Redes");
		objCarga.setNoCentCosto("Centro Redes");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);
		
		objCarga = new InsertarUsuarioRequest();
		objCarga.setNoApemat("Hurtado");
		objCarga.setNoApepat("Mamani");
		objCarga.setNoNombre("Ester");
		objCarga.setNoPuesto("Contabilidad");
		objCarga.setNoArea("Contabilidad");
		objCarga.setNoCentCosto("Centro Conta");
		objCarga.setTiLlamad(120); 
		
		ListaCarga.add(objCarga);		
		InsertarUsuarioResponse response = new InsertarUsuarioResponse();
		response= cargaExcelPermisoLlamadasService.CargaExcelPermisoLlamadas("cli","L3hv4Sm0Vro=", ListaCarga);
		
		for(int i = 0; i<ListaCarga.size(); i++){
			System.out.println(ListaCarga.get(i).getNoNombre());
		}
		System.out.println(response.getInsertado());
	}
	
	
	@Test
	public void testCargaExcel(){
		CargaExcelPermisoLlamadasRequest request=new CargaExcelPermisoLlamadasRequest();
		File f;
		String excelb64String;
		try
		{
			f=new File("C:\\pruebas\\pruebaPermisoLlamada.xls");
			excelb64String=UtilFile.codificarToBase64(f);
			request.setExcelBase64(excelb64String);
			InsertarUsuarioResponse response=new InsertarUsuarioResponse();
			response=cargaExcelPermisoLlamadasService.SubirExcelPermisoLlamadas("cli", "jPfFl7Jg2rg=", request);
			System.out.println();
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		   System.out.println(response.getListaErrores());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
