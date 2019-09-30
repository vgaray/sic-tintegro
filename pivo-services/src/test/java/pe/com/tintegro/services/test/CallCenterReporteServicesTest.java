package pe.com.tintegro.services.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.ReporteConsolidadoLlamadaRecibidaCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaConsolidadaAgenteCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaDiaHoraCallCenter;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.services.CallCenterReporteServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CallCenterReporteServicesTest {

	@Autowired
	 protected CallCenterReporteServices callCenterService;
	//@Test
	public void testListAtencionCliente()
	{
		try
		{
			ListarReporteAtencionClienteCallCenterRequest request = new ListarReporteAtencionClienteCallCenterRequest();
			request.setTiReport("ANUAL");
			request.setVaTab(1);
			request.setVaNsv(2);
			request.setFeReport("2017-06-10 00:00:00");
			ListarReporteAtencionClienteCallCenterResponse response = callCenterService.listaReporteAtencionCliente("cli", "jPfFl7Jg2rg=", request);
			request.setNoQueue("TODAS");
			for (ReporteAtencionClienteCallCenter general : response.getLsreporteAtencionCliente()) {
				System.out.println("Año: "+ general.getFeLlamad());
				System.out.println("Cant llamada entr : "+ general.getLlaEntra());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
		public void testListLlamadaDiaHora()
		{
			try
			{
				ListarReporteLlamadaDiaHoraCallCenterRequest request = new ListarReporteLlamadaDiaHoraCallCenterRequest();
				request.setNoCola("COLA1");
				request.setFeInicon("2016-01-01");
				request.setFeFincon("2017-01-01");
				
				ListarReporteLlamadaDiaHoraCallCenterResponse response = callCenterService.listaReporteLlamadaDiaHora("cli", "jPfFl7Jg2rg=", request);
				System.out.println("Tamaño de lista:"+response.getLsreporteLlamadaDiaHora().size());
				for (ReporteLlamadaDiaHoraCallCenter general : response.getLsreporteLlamadaDiaHora())
				{
					System.out.println(general.getLlama00());
					System.out.println(general.getLlama01());
					System.out.println(general.getLlama02());
					System.out.println(general.getLlama03());
					System.out.println(general.getLlama04());
				}
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				
			}
		}
	//@Test
	public void testListLlamadaConsolidadaAgente()
	{
		try
		{	ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request = new ListarReporteLlamadaConsolidadaAgenteCallCenterRequest();
			request.setFeInicon("2017-01-02");
			request.setFeFincon("2017-01-02");
			request.setpHorai("00:00:00");
			request.setpHoraf("00:00:00");
			request.setpNuPagina(2);
			request.setpNuRegMostras(3);
			
			ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = callCenterService.listaReporteLlamadaConsolidadaAgente("cli", "jPfFl7Jg2rg=", request);
			System.out.println("Tamaño de lista:"+response.getLsreporteLlamadaConsolidadaAgente().size());
			for (ReporteLlamadaConsolidadaAgenteCallCenter general : response.getLsreporteLlamadaConsolidadaAgente())
			{
				System.out.println(general.getAnexo());
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e.getMessage());
		}
	}
	//@Test
	public void testListConsolidadoLlamadaRecibida()
	{
		try
		{	ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request = new ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest();
		
			request.setQueueName("COLA1");
			request.setFeIni("2013-01-01");
			request.setFeFin("2017-07-07");
			
			ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = callCenterService.listaReporteConsolidadoLlamada("cli", "jPfFl7Jg2rg=", request);
			System.out.println("Tamaño de lista:"+response.getLsreporteConsolidadoLlamadaRecibida().size());
			for (ReporteConsolidadoLlamadaRecibidaCallCenter general : response.getLsreporteConsolidadoLlamadaRecibida())
			{
				System.out.println(general.getNoDia());
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e.getMessage());
		}
	}
}
