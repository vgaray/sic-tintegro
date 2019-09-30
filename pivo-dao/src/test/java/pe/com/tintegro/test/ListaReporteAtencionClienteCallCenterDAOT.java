package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.ListaReporteCallCenterDAO;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.ReporteConsolidadoLlamadaRecibidaCallCenter;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dominio.ReporteLlamadaDiaHoraCallCenter;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.dominio.ReporteLlamadaConsolidadaAgenteCallCenter;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ListaReporteAtencionClienteCallCenterDAOT {
	
	@Autowired
	ListaReporteCallCenterDAO listareporteCallCenterDao;
	
	
	@Test
	public void testListaReporteAtencionClienteCallCenter()
	{
		try
		{	ListarReporteAtencionClienteCallCenterRequest request = new ListarReporteAtencionClienteCallCenterRequest();
			request.setTiReport("ANUAL");
			request.setVaTab(1);
			request.setVaNsv(2);
			request.setFeReport("2017-06-10 00:00:00");
			request.setNoQueue("COLA1");
			ListarReporteAtencionClienteCallCenterResponse response = listareporteCallCenterDao.listaReporteAtencionClienteCallCenter("192.168.3.202", request);
			System.out.println("Tamaño de lista"+response.getLsreporteAtencionCliente().size());
			for (ReporteAtencionClienteCallCenter general : response.getLsreporteAtencionCliente())
			{
				System.out.println(general.getFeLlamad());
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e.getMessage());
		}
	  }
	//@Test
	public void testListaReporteLlamadaDiaHoraCallCenter()
	{
		try
		{	ListarReporteLlamadaDiaHoraCallCenterRequest request = new ListarReporteLlamadaDiaHoraCallCenterRequest();
			request.setNoCola("COLA1");
			request.setFeInicon("2016-01-01");
			request.setFeFincon("2017-01-02");
			
			ListarReporteLlamadaDiaHoraCallCenterResponse response = listareporteCallCenterDao.listaReporteLlamadaDiaHoraCallCenter("192.168.3.202", request);
			System.out.println("Tamaño de lista:"+response.getLsreporteLlamadaDiaHora().size());
			for (ReporteLlamadaDiaHoraCallCenter general : response.getLsreporteLlamadaDiaHora())
			{
				System.out.println(general.getDia());
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e.getMessage());
		}
	}
	//@Test
		public void testListaReporteLlamadaConsolidadaAgenteCallCenter()
		{
			try
			{	ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request = new ListarReporteLlamadaConsolidadaAgenteCallCenterRequest();
				request.setFeInicon("2017-01-02");
				request.setFeFincon("2017-07-02");
				request.setpHorai("00:00:00");
				request.setpHoraf("00:00:00");
				request.setpNuPagina(2);
				request.setpNuRegMostras(3);
				
				ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = listareporteCallCenterDao.listarReporteLlamadaConsolidadaAgenteCallCenter("192.168.3.202", request);
				System.out.println("Tamaño de lista:"+response.getLsreporteLlamadaConsolidadaAgente().size());
				for (ReporteLlamadaConsolidadaAgenteCallCenter general : response.getLsreporteLlamadaConsolidadaAgente())
				{
					System.out.println("Anexo:"+general.getAnexo());
					System.out.println("No contestadas:"+general.geteNoContestada());
					System.out.println("tiempo Out:"+general.getTotalOuthablando2());
				}
			}
			catch (Exception e)
			{
				System.out.println(""+e.getMessage());
			}
		}
		//@Test
		public void testListaReporteConsolidadoLlamadaRecibidaCallCenter()
		{
			try
			{	ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request = new ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest();
			
				request.setQueueName("COLA1");
				request.setFeIni("2013-01-01");
				request.setFeFin("2017-07-07");
				 
				ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = listareporteCallCenterDao.listarReporteConsolidadoLlamadaRecibidaCallCenter("192.168.3.202", request);
				for (ReporteConsolidadoLlamadaRecibidaCallCenter general : response.getLsreporteConsolidadoLlamadaRecibida())
				{
					System.out.println(general.getNoDia());
					System.out.println(general.getNoQueuename());
				}
				System.out.println("Tamaño de lista:"+response.getLsreporteConsolidadoLlamadaRecibida().size());
				
			}
			catch (Exception e)
			{
				System.out.println(""+e.getMessage());
			}
		}
}
