package pe.com.tintegro.services.test;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lowagie.text.pdf.codec.Base64;
import pe.com.tintegro.dominio.LlamadaDestino;
import pe.com.tintegro.dominio.LlamadaGeneral;
import pe.com.tintegro.dominio.LlamadaUsuario;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.VariableGeneralInstancia;
import pe.com.tintegro.dto.request.ListaAreaxLlamadaRequest;
import pe.com.tintegro.dto.request.ListaCentroCostoLlamadaRequest;
import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadaGeneralRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.request.ListarConsolidadoTiempoEsperaRequest;
import pe.com.tintegro.dto.request.ListarLlamadaDestinoRequest;
import pe.com.tintegro.dto.request.ListarLlamadasAbandonadasPorMinutoRequest;
import pe.com.tintegro.dto.request.ListarLlamadasAtendidasAbandonadasRequest;
import pe.com.tintegro.dto.request.ListarLlamadasEntrantesPorHoraRequest;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.ListaLlamadaGeneralResponse;
import pe.com.tintegro.dto.response.ListaLlamadaUsuarioResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;
import pe.com.tintegro.dto.response.ListarLlamadaDestinoResponse;
import pe.com.tintegro.dto.response.ListarLlamadasAbandonadasPorMinutoResponse;
import pe.com.tintegro.dto.response.ListarLlamadasAtendidasAbandonadasResponse;
import pe.com.tintegro.dto.response.ListarLlamadasEntrantesPorHoraResponse;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;
import pe.com.tintegro.services.RankingLlamadasServices;
import pe.com.tintegro.services.ReporteServices;
import pe.com.tintegro.services.util.Util;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ReporteServicesTest
{
	@Autowired
	ReporteServices reporteServices;
	@Autowired
	RankingLlamadasServices rankingLlamadaService;


	//Listar 
	 //@Test 
	  public void testListallamadaGeneralTest() {
		  try { 
				SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
				//Date fechaIni = dateFormatter.parse("2016-01-01");
				//Date fechaFin = dateFormatter.parse("2017-01-01");
				ListaLlamadaGeneralRequest request = new ListaLlamadaGeneralRequest();
				request.setpNoSrc("");
				request.setpNoDst("");
				request.setpNoDis("");
				request.setpFeIni("2016-01-01");
				request.setpFeFin("2017-05-29");
				request.setpHorai("00:00:00");
				request.setpHoraf("23:59:59");
				request.setpTipLlamada(0);
				request.setpRanInitie(null);
				request.setpRanFintie(null);
				request.setNumPagina(1);
				request.setCantidadxPag(50);
			  ListaLlamadaGeneralResponse response=reporteServices.ListallamadaGeneral("cli","jPfFl7Jg2rg=", request);
			  System.out.println(response.getListaLlamadaGeneralList().size()); 
			  for (LlamadaGeneral general : response.getListaLlamadaGeneralList()){
					System.out.println("Cantidad de Paginas: "+general.getTotal());
			  }
		  } catch(Exception e) 
		  {
			  e.printStackTrace(); 
		  }
	  }

	  //@Test 
	  public void testListallamadaUsuarioTest() {
		  try { 

				ListaLlamadaUsuarioRequest request = new ListaLlamadaUsuarioRequest();
				request.setIdUsuario(0);
				request.setIdExtension(0);
				request.setFeIni( "2017-05-18" );
				request.setFeFin( "2017-06-19" );
				request.setpHorai("00:00:00");
				request.setpHoraf("21:59:59");
				request.setNumPagina(2);
				request.setCantidadxPag(75);
				ListaLlamadaUsuarioResponse response=reporteServices.listaLlamadaUsuario("cli","L3hv4Sm0Vro=", request);
			  System.out.println(response.getListaLlamadaUsuario().size()); 
			  for (LlamadaUsuario usuario : response.getListaLlamadaUsuario()){
					System.out.println("Nombre del Usuario: "+ usuario.getNoUsuario()+"Cantidad de Paginas: "+usuario.getCantidadPaginas());
			  }
		  } catch(Exception e) 
		  {
			  e.printStackTrace(); 
		  }
	  }
	  
	  //@Test
	  public void testListaRankingLlamada()

	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			RankingLlamadasRequest objRanking = new RankingLlamadasRequest();
			//Date feIni = format.parse("2013-01-01");
			//Date feFin = format.parse("2016-02-21");
			objRanking.setFeIni("2017-01-01");
			objRanking.setFeFin("2017-10-29");
			objRanking.setHoraIni("00:00:00");
			objRanking.setHorafin("00:00:00");
			objRanking.setNumPagina(1);
			objRanking.setCantidadxPag(10);
			objRanking.setpIdOrden(1);

			RankingLlamadasResponse response = rankingLlamadaService.listarRankingLlamadas("cli","jPfFl7Jg2rg=", objRanking);
			System.out.println(response.getListRanking().size());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	
	 //@Test
	  public void testListaLlamadaDestino(){
		  try { 
				ListarLlamadaDestinoRequest request = new ListarLlamadaDestinoRequest();
				request.setpIdArea(25);
				request.setpIdCentcos(26);
				request.setpFeIni("2017-01-01");
				request.setpHoIni("00:00");
				request.setpFeFin("2017-09-09");
				request.setpHoFin("23:59");
				ListarLlamadaDestinoResponse response=reporteServices.listaLlamadaDestino("cli","jPfFl7Jg2rg=", request);
			  System.out.println(response.getListaLLamadasDestino().size()); 
			  for (LlamadaDestino destino : response.getListaLLamadasDestino()){
					System.out.println("Cantidad de Paginas: "+destino.getDestino());
			  }
		  } catch(Exception e) 
		  {
			  e.printStackTrace(); 
		  }
	  }
	  
	  
	  //reportes
	
	//@Test
	public void testReporteLlamadaGeneral()
	{
		try
		{

			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			ListaLlamadaGeneralRequest request = new ListaLlamadaGeneralRequest();
			request.setpNoSrc("");
			request.setpNoDst("");
			request.setpNoDis("ANSWERED");
			request.setpFeIni("2016-01-01");
			request.setpFeFin("2017-09-01");
			request.setpHorai("00:00:00");
			request.setpHoraf("23:59:00");
			request.setpTipLlamada(0);
			request.setpRanInitie(2);
			request.setpRanFintie(3);
			request.setpIdOrden(1);
			request.setTipoFile(Util.PDF);			
			ListaLlamadaGeneralResponse response = reporteServices.reporteLlamadaGeneral("cli","jPfFl7Jg2rg=", request);

			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls":".pdf";

			FileOutputStream fileOuputStream = new FileOutputStream("D:\\fileReporteLlamadaGeneral" + extension);

			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	//@Test
	public void testReporteLlamadaUsuario()
	{
		try
		{
			ListaLlamadaUsuarioRequest request = new ListaLlamadaUsuarioRequest();
			request.setIdUsuario(0);
			request.setIdExtension(0);
			request.setFeIni( "2016-01-01" );
			request.setFeFin( "2017-09-01" );
			request.setpHorai("0:00");
			request.setpHoraf("23:59");
			request.setNombreUsuario("Todos");
			request.setNombreExtension("Todas");
			request.setpIdOrden(1);
			request.setTipoFile(Util.EXCEL);

			ListaLlamadaUsuarioResponse response = reporteServices.reporteLlamadaUsuario("cli","jPfFl7Jg2rg=", request);

			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";


		//	FileOutputStream fileOuputStream = new FileOutputStream("D:\\fileReporteLlamadaUsuario." + extension);
			FileOutputStream fileOuputStream = new FileOutputStream("D:\\fileReporteLlamadaUsuario" + extension);


			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	//@Test

	public void testReporteRankingLlamada()
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			//java.util.Date																												<	 feIni = format.parse("2016-01-01");
			//java.util.Date feFin = format.parse("2017-01-01");
			RankingLlamadasRequest request = new RankingLlamadasRequest();
			request.setFeIni( "2016-01-01" );
			request.setFeFin( "2017-09-01" );
			request.setHoraIni("0:00");
			request.setHorafin("23:59");
			request.setTipoFile(Util.PDF);

			RankingLlamadasResponse response = reporteServices.reporteRankingLlamadas("cli","jPfFl7Jg2rg=", request);

			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";
			FileOutputStream fileOuputStream = new FileOutputStream("D:\\fileReporteRankingLlamadas" + extension);
			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	//@Test
	public void testReporteListAtencionCliente()
	{
		try
		{
			ListarReporteAtencionClienteCallCenterRequest request = new ListarReporteAtencionClienteCallCenterRequest();
			request.setTiReport("ANUAL");
			request.setVaTab(1);
			request.setVaNsv(2);
			request.setFeReport("");
			request.setTipoFile(Util.EXCEL);
			ListarReporteAtencionClienteCallCenterResponse response = reporteServices.reporteAtencionCliente("cli", "jPfFl7Jg2rg=", request);
			request.setNoQueue("TODAS");

			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";

			FileOutputStream fileOuputStream = new FileOutputStream("C:\\mireporte\\fileReporteAtencionCliente" + extension);

			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void testReporteConsolidadoLlamada()
	{
		try
		{
			ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request = new ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest();
			request.setQueueName("COLA1");
			request.setFeIni("2013-01-01");
			request.setFeFin("2017-07-07");
			request.setTipoFile(Util.EXCEL);
			
			ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = reporteServices.reporteConsolidadoLlamadaRecibida("cli", "jPfFl7Jg2rg=", request);


			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";

			FileOutputStream fileOuputStream = new FileOutputStream("C:\\mireporte\\fileReporteConsolidadoLlamada" + extension);

			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void testReporteLlamadaDiaHora()
	{
		try
		{
			ListarReporteLlamadaDiaHoraCallCenterRequest request = new ListarReporteLlamadaDiaHoraCallCenterRequest();
			request.setFeInicon("2016-01-02");
			request.setFeFincon("2017-01-02");
			request.setNoCola("COLA1");
			request.setTipoFile(Util.EXCEL);
			
			ListarReporteLlamadaDiaHoraCallCenterResponse response = reporteServices.reporteLlamadaDia("cli", "jPfFl7Jg2rg=", request);

			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";

			FileOutputStream fileOuputStream = new FileOutputStream("C:\\mireporte\\fileReporteLlamadaDiaHora" + extension);

			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//@Test
	public void testReporteLlamadaConsolidada()
	{
		System.out.println("paso");
		try
		{
			ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request = new ListarReporteLlamadaConsolidadaAgenteCallCenterRequest();
			
			request.setFeInicon("2010-01-02");
			request.setFeFincon("2018-01-07");
			request.setpHorai("16:00:00");
			request.setpHoraf("23:00:00");
			request.setTipoFile(Util.EXCEL);
			
			ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = reporteServices.reporteLlamadaConsolidadaAgente("cli", "jPfFl7Jg2rg=", request);
			System.out.println("aca");
			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";
			
			FileOutputStream fileOuputStream = new FileOutputStream("C:\\mireporte\\fileReporteLlamadaConsolidadaAgente" + extension);

			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void testListaReporteLlamadasAtendidasAbandonadas() {
		try {
			ListarLlamadasAtendidasAbandonadasRequest request = new ListarLlamadasAtendidasAbandonadasRequest();
			request.setCola("");
			request.setAgente(0);
			request.setFeIni("2016-01-01");
			request.setFeFin("2017-07-06");
			request.setTipoFile(Util.EXCEL);
			
			ListarLlamadasAtendidasAbandonadasResponse response = reporteServices.listarReporteLlamadasAtendidasAbandonadas("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile()== Util.EXCEL ? ".xls" : ".pdf";
			FileOutputStream fileOuputStream = new FileOutputStream("C:\\MiReporte\\reporteLlamadasAtendidasAbandonadas" + extension);
			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//@Test
	public void testListarReporteLlamadasEntrantePorHora() {
		try {
			ListarLlamadasEntrantesPorHoraRequest request = new ListarLlamadasEntrantesPorHoraRequest();
			request.setCola("COLA1");
			request.setFeIni("2016-07-14");
			request.setFeFin("2017-07-14");
			request.setTipoFile(Util.EXCEL);
			
			ListarLlamadasEntrantesPorHoraResponse response = reporteServices.listarReporteLlamadasEntrantesPorHora("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";
			FileOutputStream fileOuputStream = new FileOutputStream("C:\\MiReporte\\reporteLlamadasEntrantePorHora" + extension);
			byte[] parseBase64Binary = Base64.decode(response.getReporteFile());
			fileOuputStream.write(parseBase64Binary);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
  //@Test
	public void testListarReporteLlamadasAbandonadasPorMinuto() {
		try {
			ListarLlamadasAbandonadasPorMinutoRequest request = new ListarLlamadasAbandonadasPorMinutoRequest();
			request.setCola("");
			request.setFeIni("2016-07-14");
			request.setFeFin("2017-07-14");
			request.setTipoFile(Util.EXCEL);
			ListarLlamadasAbandonadasPorMinutoResponse response = reporteServices.listarReporteLlamadasAbandonadasPorMinuto("cli", "jPfFl7Jg2rg=", request);
			
			System.out.println(response.getReporteFile());
			String extension = request.getTipoFile() == Util.EXCEL ? ".xls" : ".pdf";
			FileOutputStream fileOuputStream = new FileOutputStream("C:\\MiReporte\\reporteLlamadasAbandonadasPorMinuto" + extension);
			byte[] parseBase64Binary = Base64.decode(response.getReporteFile()); 
			fileOuputStream.write(parseBase64Binary);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
