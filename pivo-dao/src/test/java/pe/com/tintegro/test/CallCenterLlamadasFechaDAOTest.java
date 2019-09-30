package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.CallCenterLlamadasFechaDAO;
import pe.com.tintegro.dominio.LlamadaAgente;
import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadasFechas;
import pe.com.tintegro.dominio.LlamadasContestadas;
import pe.com.tintegro.dominio.ReporteAbandonos;
import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CallCenterLlamadasFechaDAOTest {
		
	@Autowired
	CallCenterLlamadasFechaDAO callCenterLlamadasFechaDAO;
	//	reportes.llamada_abandonas_minutos_rango_fecha
	//@Test
	public void TestListaLlamadasAtendidasAbandonadas(){
		try{
			ListaLlamadasAtendidasAbandonadasFechaRequest request = new ListaLlamadasAtendidasAbandonadasFechaRequest();
			request.setpQueuename("");
			request.setpFeIni("2009-09-09");
			request.setpFeFin("2017-09-09");
			request.setpNuPagina(1);
			request.setpNuReg(10);
			ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
			response = callCenterLlamadasFechaDAO.listaLlamadasAbandonadas("192.168.3.202", request);
			System.out.println("Cant registros: " + response.getListaLlamadasAtendidasAbandonadas().size());
			for(LlamadasAtendidasAbandonadasFechas llamadasAA : response.getListaLlamadasAtendidasAbandonadas()){
				System.out.println("idLlamada " + llamadasAA.getIdLlamada() + 
						           " Fecha Rango: " + llamadasAA.getFecha() + 
						           " Llamadas Atendidas " + llamadasAA.getAtendidas() +
								   " Abandonadas Menor " + llamadasAA.getAbandonadasMenor() + 
								   " Abandonadas Mayor: " + llamadasAA.getAbandonadasMayor() +
								   " Registros: " + llamadasAA.getNuTotalReg());
			}
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//	reportes.llamada_contestada_ac
	//@Test
	public void TestListaLlamadasContestadas(){
		try {
			ListaLlamadasContestadasRequest request = new ListaLlamadasContestadasRequest();
			request.setVaQueue("");
			request.setIdAgente(0);
			request.setFeIniCon("2009-09-09");
			request.setFeFinCon("2017-09-09");
			request.setHoraIniC("00:00");
			request.setHoraFinC("00:00");
			request.setpNuPagina(1);
			request.setpNuReg(2);
			ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
			response = callCenterLlamadasFechaDAO.listaLlamadasContestadas("192.168.3.202", request);
			System.out.println("Cant registros: " + response.getLsLContestadas().size());
			for(LlamadasContestadas lsContestadas : response.getLsLContestadas()){
				System.out.println("idLlamada: " + lsContestadas.getIdLlamadaC()+ 
						           " Nombre Cola: " + lsContestadas.getNoCola() + 
						           " Nombre Agente: "+ lsContestadas.getNoAgente() + 
						           " Fecha: " + lsContestadas.getFecha() + 
						           " Hora: " + lsContestadas.getHora() +
						           " Numero: " + lsContestadas.getNumero()+
						           " Duracion: " + lsContestadas.getDuracion() + 
						           "Registros: " + lsContestadas.getNuTotalReg());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//	reportes.llamada_agente
	//@Test
	public void TestListaLlamadaAgente(){
		try {
			ListaLlamadaAgenteRequest request = new ListaLlamadaAgenteRequest();
			request.setIdAgente(0);
			request.setFeIniCon("2009-09-09");
			request.setFeFinCon("2017-09-09");
			request.setHoraI("00:00");
			request.setHoraF("00:00");
			
			ListaLlamadaAgenteResponse response = new ListaLlamadaAgenteResponse();
			response = callCenterLlamadasFechaDAO.listaLlamadaAgente("192.168.3.202", request);
			System.out.println("Cant Registros: " + response.getLsLAgente().size());
			for(LlamadaAgente lsAgente : response.getLsLAgente() ){
				System.out.println("Nombre Agente: " + lsAgente.getNoAgente() +
								   "Llamadas Atendidas:  "+ lsAgente.getLlamadasAtendidas() + 
								   "Llamadas Cul Cliente: " + lsAgente.getLlamadasCulCli()  +
								   "Llamadas Cul Agente: "  + lsAgente.getLlamadasCulAge()  +
								   "Tiempo Hablado: " + lsAgente.getTiempoHablado() +
								   "T. Promedio Hablado: "+ lsAgente.gettPromHablado() +
								   "T. Min. Hablado: " + lsAgente.gettMinHablado() +
								   "T. Max. Hablado: " + lsAgente.gettMaxHablado());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//	reportes.reporte_abandonos
	//@Test
	public void TestListaReporteAbandonados(){
		try {
			ListaReporteAbandonosRequest request = new ListaReporteAbandonosRequest();
			request.setNoQueue("");
			request.setFeIniCon("2009-09-09");
			request.setFeFinCon("2017-09-09");
			
			ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
			response = callCenterLlamadasFechaDAO.listaReporteAbandono("192.168.3.202", request);
			System.out.println("Cant. Registros: " + response.getLsReporteAbandonos().size());
			for(ReporteAbandonos lsRAbandonados : response.getLsReporteAbandonos()){
				System.out.println(" Cola:  " + lsRAbandonados.getQueueName() + 
								   " Fecha: " + lsRAbandonados.getFecha() + 
								   " Hora: "  + lsRAbandonados.getqTime() +
								   " Tiempo Aband Seg: " + lsRAbandonados.getInfo3() +
								   " Tiempo Aband Min: " + lsRAbandonados.getNuMin() +
								   " Número: " + lsRAbandonados.getNumero());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//Reportes Excel Test
	@Test
	public void TestListaReporteLlamadasAtendidasAbandonadas(){
		try{
			ListaLlamadasAtendidasAbandonadasFechaRequest request = new ListaLlamadasAtendidasAbandonadasFechaRequest();
			request.setpQueuename("");
			request.setpFeIni("2009-09-09");
			request.setpFeFin("2017-09-09");
			ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
			response = callCenterLlamadasFechaDAO.listaReporteLlamadasAtAbFecha("192.168.3.202", request);
			System.out.println("Cant registros: " + response.getListaLlamadasAtendidasAbandonadas().size());
			for(LlamadasAtendidasAbandonadasFechas llamadasAA : response.getListaLlamadasAtendidasAbandonadas()){
				System.out.println("idLlamada " + llamadasAA.getIdLlamada() + 
						           " Fecha Rango: " + llamadasAA.getFecha() + 
						           " Llamadas Atendidas " + llamadasAA.getAtendidas() +
								   " Abandonadas Menor " + llamadasAA.getAbandonadasMenor() + 
								   " Abandonadas Mayor: " + llamadasAA.getAbandonadasMayor());
			}
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	//@Test
	public void TestListaReporteEAbandonados(){
		try {
			ListaReporteAbandonosRequest request = new ListaReporteAbandonosRequest();
			request.setNoQueue("");
			request.setFeIniCon("2009-09-09");
			request.setFeFinCon("2017-09-09");
			
			ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
			response = callCenterLlamadasFechaDAO.listaReporteEAbandonos("192.168.3.202", request);
			System.out.println("Cant. Registros: " + response.getLsReporteAbandonos().size());
			for(ReporteAbandonos lsRAbandonados : response.getLsReporteAbandonos()){
				System.out.println(" Cola:  " + lsRAbandonados.getQueueName() + 
								   " Fecha: " + lsRAbandonados.getFecha() + 
								   " Hora: "  + lsRAbandonados.getqTime() +
								   " Tiempo Aband Seg: " + lsRAbandonados.getInfo3() +
								   " Tiempo Aband Min: " + lsRAbandonados.getNuMin() +
								   " Número: " + lsRAbandonados.getNumero());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}