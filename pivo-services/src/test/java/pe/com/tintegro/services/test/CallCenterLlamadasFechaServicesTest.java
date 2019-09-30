package pe.com.tintegro.services.test;

import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lowagie.text.pdf.codec.Base64;

import pe.com.tintegro.dominio.LlamadaAgente;
import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadasFechas;
import pe.com.tintegro.dominio.LlamadasContestadas;
import pe.com.tintegro.dominio.ReporteAbandonos;
import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.request.ListarCallCenterQueueNameRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;
import pe.com.tintegro.dto.response.ListarCallCenterQueueNameResponse;
import pe.com.tintegro.services.CallCenterLlamadasFechaServices;
import pe.com.tintegro.services.util.Util;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CallCenterLlamadasFechaServicesTest {

	@Autowired
	CallCenterLlamadasFechaServices callCenterLlamadasFechaServices;
	
	//	reportes.llamada_abandonas_minutos_rango_fecha
	//@Test
	public void testListaLlamadasAtendidasAbandonadas(){

		ListaLlamadasAtendidasAbandonadasFechaRequest request = new ListaLlamadasAtendidasAbandonadasFechaRequest();
		request.setpQueuename("");
		request.setpFeIni("2008-09-09");
		request.setpFeFin("2017-09-09");
		request.setpNuPagina(1);
		request.setpNuReg(10);
		try {
			//List<LlamadasAtendidasAbandonadas> lsLlamadas = new ArrayList<>();
			ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
			response = callCenterLlamadasFechaServices.listaLlamadaAtendidasAbandonadas("cli", "jPfFl7Jg2rg=",request);
			//lsLlamadas = response.getListaLlamadasAtendidasAbandonadas();
			//int i = 0; i <= lsLlamadas.size(); i++ 
			System.out.println(response.getListaLlamadasAtendidasAbandonadas().size());
			for( LlamadasAtendidasAbandonadasFechas lsLlamadas : response.getListaLlamadasAtendidasAbandonadas() ){
				System.out.println("idLlamada: " + lsLlamadas.getIdLlamada() + 
								   "Fecha Rango: " + lsLlamadas.getFecha() + 
								   "Num Llamadas: " + lsLlamadas.getAtendidas() +
								   "Abandonadas menor a min: " + lsLlamadas.getAbandonadasMenor() + 
								   "Abandonadas mayor a min: " + lsLlamadas.getAbandonadasMayor());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//@Test
	public void TestListaLlamadasContestadas(){
		ListaLlamadasContestadasRequest request = new ListaLlamadasContestadasRequest();
		request.setVaQueue("");
		request.setIdAgente(0);
		request.setFeIniCon("2009-09-09");
		request.setFeFinCon("2017-09-09");
		request.setHoraIniC("00:00");
		request.setHoraFinC("00:00");
		request.setpNuPagina(1);
		request.setpNuReg(3);
		
		try {
			ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
			response = callCenterLlamadasFechaServices.listaLlamadaContestada("cli", "jPfFl7Jg2rg=", request);
			for(LlamadasContestadas lsLContestadas : response.getLsLContestadas()){
				System.out.println(" N: " + lsLContestadas.getIdLlamadaC() + 
						 		   " Cola: " + lsLContestadas.getNoCola() + 
						 		   " Agente: " + lsLContestadas.getNoAgente() +
						 		   " Fecha: " + lsLContestadas.getFecha() +
						 		   " Hora: "  + lsLContestadas.getHora() +
						 		   " Numero: " + lsLContestadas.getNumero() +
						 		   " Duracion: " + lsLContestadas.getDuracion() + 
						 		   "Registros: " + lsLContestadas.getNuTotalReg());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//@Test
	public void TestListaLlamadaAgente(){
		ListaLlamadaAgenteRequest request = new ListaLlamadaAgenteRequest();
		request.setIdAgente(0);
		request.setFeIniCon("2009-09-09");
		request.setFeFinCon("2017-09-09");
		request.setHoraI("00:00");
		request.setHoraF("00:00");
		try {
			ListaLlamadaAgenteResponse response = new ListaLlamadaAgenteResponse();
			response = callCenterLlamadasFechaServices.listaLlamadaAgente("cli", "jPfFl7Jg2rg=", request);
			for( LlamadaAgente lsAgente : response.getLsLAgente() ){
				System.out.println(" Agente: " + lsAgente.getNoAgente() + 
								   " LLamadas Atendidas: " + lsAgente.getLlamadasAtendidas() +
								   " Llamadas Cul Cli: " + lsAgente.getLlamadasCulCli() +
								   " Llamadas Cul Ag: "  + lsAgente.getLlamadasCulAge() +
								   " T. Hablado: " + lsAgente.getTiempoHablado() +
								   " T. Prom Hab: " + lsAgente.gettPromHablado() +
								   " T. Min Hab: " + lsAgente.gettMinHablado() +
								   " T. Max Hab: " + lsAgente.gettMaxHablado());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//@Test
	public void TestListaReporteAbandonos(){
		ListaReporteAbandonosRequest request = new ListaReporteAbandonosRequest();
		request.setNoQueue("");
		request.setFeIniCon("2009-09-09");
		request.setFeFinCon("2017-09-09");
		try {
			ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
			response = callCenterLlamadasFechaServices.listaReporteAbandonos("cli", "jPfFl7Jg2rg=", request);
			for( ReporteAbandonos lsRAbandono : response.getLsReporteAbandonos()){
				System.out.println(" Cola:  " + lsRAbandono.getQueueName() + 
						   " Fecha: " + lsRAbandono.getFecha() + 
						   " Hora: "  + lsRAbandono.getqTime() +				
						   " Tiempo Aband Seg: " + lsRAbandono.getInfo3() +
						   " Tiempo Aband Min: " + lsRAbandono.getNuMin() +
						   " Número: " + lsRAbandono.getNumero());
			}						
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
