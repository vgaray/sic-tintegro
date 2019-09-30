package pe.com.tintegro.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.export.JRRtfExporter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.LlamadaDestinoDAO;
import pe.com.tintegro.dao.LlamadaGeneralDAO;
import pe.com.tintegro.dao.TbUsuarioDAO;
import pe.com.tintegro.dominio.LlamadaAgente;
import pe.com.tintegro.dominio.LlamadaDestino;
import pe.com.tintegro.dominio.LlamadaGeneral;
import pe.com.tintegro.dominio.LlamadaUsuario;
import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadasFechas;
import pe.com.tintegro.dominio.LlamadasContestadas;
import pe.com.tintegro.dominio.LlamadasAbandonadasPorMinuto;
import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadas;
import pe.com.tintegro.dominio.LlamadasEntrantesPorHora;
import pe.com.tintegro.dominio.RankingLlamadas;
import pe.com.tintegro.dominio.ReporteAbandonos;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.ReporteConsolidadoLlamadaRecibidaCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaConsolidadaAgenteCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaDiaHoraCallCenter;
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
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
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
import pe.com.tintegro.services.CallCenterLlamadasFechaServices;
import pe.com.tintegro.services.CallCenterReporteServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.RankingLlamadasServices;
import pe.com.tintegro.services.ReporteServices;
import pe.com.tintegro.services.util.Util;

@Service("reporteServices")
@Transactional
public class ReporteServicesImpl implements ReporteServices {

	@Resource(name = "llamadaDestinoDAO")
	protected LlamadaDestinoDAO llamadaDestinoDAO;

	@Resource(name = "llamadaGeneralDAO")
	protected LlamadaGeneralDAO llamadaGeneralDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "rankingLlamadasServices")
	protected RankingLlamadasServices rankingLlamadasServices;

	@Resource(name = "tbUsuarioDAO")
	protected TbUsuarioDAO tbUsuarioDAO;

	@Resource(name = "callCenterLlamadasFechaServices")
	protected CallCenterLlamadasFechaServices listallamadaAbandonadaFechaServices;


	@Resource(name = "callCenterService")
	protected CallCenterReporteServices callCenterReporteServices;

	@Value(value = "classpath:plantillaReporte/reporteLlamadaDestino.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadaDestino;

	@Value(value = "classpath:plantillaReporte/reporteLlamadaUsuario.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadaUsuario;

	@Value(value = "classpath:plantillaReporte/reporteLlamadas.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamada;

	@Value(value = "classpath:plantillaReporte/reporteCentroCostoLlamada.jrxml")
	private org.springframework.core.io.Resource plantillaReporteCentroCostoLlamadas;

	@Value(value = "classpath:plantillaReporte/reportRankingLlamadas.jrxml")
	private org.springframework.core.io.Resource plantillaReporteRankingLlamadas;

	@Value(value = "classpath:plantillaReporte/reporteAreaLlamada.jrxml")
	private org.springframework.core.io.Resource plantillaReporteAreaLlamadas;

	@Value(value = "classpath:plantillaReporte/reporteLlamadasAtendidasAbandonadasAgente.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadasAtendidasAbandonadasAgente;

	@Value(value = "classpath:plantillaReporte/reporteLlamadasEntrantePorHora.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadaEntrantePorHora;

	@Value(value = "classpath:plantillaReporte/reporteLlamadasAbandonadasPorMinuto.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadasAbandonadasPorMinuto;

	@Value(value = "classpath:plantillaReporte/reportLlamadasAtAbFechas.jrxml")
	private org.springframework.core.io.Resource plantillaLlamadaAtAbFecha;

	@Value(value = "classpath:plantillaReporte/reporteLlamadasContestadas.jrxml")
	private org.springframework.core.io.Resource plantillaLlamadasContestadas;

	@Value(value = "classpath:plantillaReporte/reporteLlamadasAgente.jrxml")
	private org.springframework.core.io.Resource plantllaLlamadasAgente;

	@Value(value = "classpath:plantillaReporte/reporteListaReporteAbandonos.jrxml")
	private org.springframework.core.io.Resource plantillaReporteAbandonos;

	@Value(value = "classpath:plantillaReporte/reporteConsolidadoTiempoEspera.jrxml")
	private org.springframework.core.io.Resource plantillaReporteConsolidadoTiempoEspera;

	// reporte Call Center
	@Value(value = "classpath:plantillaReporte/reporteAtencionCliente.jrxml")
	private org.springframework.core.io.Resource plantillaReporteAtencionCliente;

	@Value(value = "classpath:plantillaReporte/reporteConsolidadoLlamadaRecibida.jrxml")
	private org.springframework.core.io.Resource plantillaReporteConsolidadoLlamadaRecibida;

	@Value(value = "classpath:plantillaReporte/reporteLlamadaHora.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadaHora;

	@Value(value = "classpath:plantillaReporte/reporteLlamadasConsolidadas.jrxml")
	private org.springframework.core.io.Resource plantillaReporteLlamadasConsolidadas;

	// Listar
	@Override
	public ListaLlamadaGeneralResponse ListallamadaGeneral(String codUsuario, String idInstancia, ListaLlamadaGeneralRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		ListaLlamadaGeneralResponse response = llamadaGeneralDAO.listallamadaGeneral(ip, request);
		if (response.getListaLlamadaGeneralList().size() > 0) {
			int total = response.getListaLlamadaGeneralList().get(0).getTotal();
			response.setTotal(total);
			int cantidadPaginas = Util.determinarNroPaginas(total, request.getCantidadxPag());
			response.setCantidadPaginas(cantidadPaginas);
		}
		return response;
	}

	@Override
	public ListaLlamadaUsuarioResponse listaLlamadaUsuario(String codUsuario, String idInstancia, ListaLlamadaUsuarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		ListaLlamadaUsuarioResponse response = tbUsuarioDAO.ListaLlamadaUsuario(ip, request);
		if (response.getListaLlamadaUsuario().size() > 0) {
			int total = response.getListaLlamadaUsuario().get(0).getTotal();
			response.setTotal(total);
			int cantidadPaginas = Util.determinarNroPaginas(total, request.getCantidadxPag());
			response.setCantidadPaginas(cantidadPaginas);
		}
		return response;

		// String ip = instanciaServices.determinarIp(idInstancia);
		// return tbUsuarioDAO.ListaLlamadaUsuario(ip, request);
	}

	// Listar para los reportes

	@Override
	public ListaLlamadaGeneralResponse ListaReportellamadaGeneral(String codUsuario, String idInstancia, ListaLlamadaGeneralRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return llamadaGeneralDAO.listaReportellamadaGeneral(ip, request);
	}

	@Override
	public ListaLlamadaUsuarioResponse listaReporteLlamadaUsuario(String codUsuario, String idInstancia, ListaLlamadaUsuarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.ListaReporteLlamadaUsuario(ip, request);
	}

	// Reportes
	@Override
	public ListaLlamadaGeneralResponse reporteLlamadaGeneral(String codUsuario, String idInstancia, ListaLlamadaGeneralRequest request) throws Exception {
		ListaLlamadaGeneralResponse response = ListaReportellamadaGeneral(codUsuario, idInstancia, request);
		List<LlamadaGeneral> llamadaGeneralList = response.getListaLlamadaGeneralList();

		Map<String, Object> parameters = new HashMap();
		parameters.put("origen", request.getpNoSrc());
		parameters.put("destino", request.getpNoDst());

		String disposicion = "";
		if (request.getpNoDis().equals("")) {
			disposicion = "Todos";
		} else if (request.getpNoDis().equals("ANSWERED")) {
			disposicion = "Contestado";
		} else if (request.getpNoDis().equals("NO ANSWER")) {
			disposicion = "No Contestado";
		} else if (request.getpNoDis().equals("FAILED")) {
			disposicion = "Fallido";
		} else if (request.getpNoDis().equals("BUSY")) {
			disposicion = "No valido";
		}
		parameters.put("disposicion", disposicion);
		parameters.put("fechaInicial", request.getpFeIni());
		parameters.put("fechaFinal", request.getpFeFin());
		parameters.put("horaInicial", request.getpHorai());
		parameters.put("horaFinal", request.getpHoraf());

		String tipoLlamada = "";
		if (request.getpTipLlamada().equals(0)) {
			tipoLlamada = "Todos";
		} else if (request.getpTipLlamada().equals(1)) {
			tipoLlamada = "Entrantes";
		} else if (request.getpTipLlamada().equals(2)) {
			tipoLlamada = "Salientes";
		} else if (request.getpTipLlamada().equals(3)) {
			tipoLlamada = "Entre Anexos";
		}
		parameters.put("tipoLlamada", tipoLlamada);

		String duracionInicial = "";
		if (request.getpRanInitie() == null || request.equals("")) {
			duracionInicial = "Todos";
		} else {
			duracionInicial = request.getpRanInitie() + " minutos";
		}
		parameters.put("duracionInicial", duracionInicial);

		String duracionFinal = "";
		if (request.getpRanFintie() == null || request.equals("")) {
			duracionFinal = "Todos";
		} else {
			duracionFinal = request.getpRanFintie() + " minutos";
		}
		parameters.put("duracionFinal", duracionFinal);
		parameters.put("orden", request.getpIdOrden());
		String fileString = "";
		if (response.getListaLlamadaGeneralList().size() > 0) {
			fileString = generarReporte(plantillaReporteLlamada, parameters, response.getListaLlamadaGeneralList(), "reporteLlamadas", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;

	}

	public ListaLlamadaUsuarioResponse reporteLlamadaUsuario(String codUsuario, String idInstancia, ListaLlamadaUsuarioRequest request) throws Exception {
		ListaLlamadaUsuarioResponse response = listaReporteLlamadaUsuario(codUsuario, idInstancia, request);
		List<LlamadaUsuario> llamadaUsuarioList = new ArrayList<LlamadaUsuario>();
		LlamadaUsuario llamadaUsuario1 = new LlamadaUsuario();
		Map parameters = new HashMap();
		parameters.put("usuario", request.getNombreUsuario());
		parameters.put("extension", request.getNombreExtension());
		parameters.put("fechaInicial", request.getFeIni());
		parameters.put("fechaFinal", request.getFeFin());
		parameters.put("horaInicial", request.getpHorai());
		parameters.put("horaFinal", request.getpHoraf());
		parameters.put("noAreaCentro", request.getpNoAreaCentro());
		parameters.put("noTipoAreaCentro", request.getpTipoNoAreaCentro());
		parameters.put("noCentroCosto", request.getpNoCentroCosto());
		parameters.put("noTipoCentroCosto", request.getpTipoNoCentroCosto());
		String fileString = "";
		if (response.getListaLlamadaUsuario().size() > 0) {
			fileString = generarReporte(plantillaReporteLlamadaUsuario, parameters, response.getListaLlamadaUsuario(), "reporteLlamadaUsuario", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	@Override
	public RankingLlamadasResponse reporteRankingLlamadas(String codUsuario, String idInstancia, RankingLlamadasRequest request) throws Exception {
		RankingLlamadasResponse response = rankingLlamadasServices.listarReporteRankingLlamadas(codUsuario, idInstancia, request);
		List<RankingLlamadas> rankingLlamadasList = response.getListRanking();
		RankingLlamadas rll = new RankingLlamadas();

		Map parameters = new HashMap();
		parameters.put("fechaInicial", request.getFeIni());
		parameters.put("fechaFinal", request.getFeFin());
		parameters.put("horaInicial", request.getHoraIni());
		parameters.put("horaFinal", request.getHorafin());
		//orden
		parameters.put("pIdOrden", request.getpIdOrden().intValue());

		String fileString = "";
		if (response.getListRanking().size() > 0) {
			fileString = generarReporte(plantillaReporteRankingLlamadas, parameters, response.getListRanking(), "ReporteRankingLlamadas", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);

		return response;
	}


	private String generarReporte(org.springframework.core.io.Resource plantilla, Map parameters, List<?> objectList, String fileName, int tipoFile) throws Exception {

		InputStream inputStream = plantilla.getInputStream();
		File plantillaTemp = File.createTempFile("test", ".jrxml");
		try {
			FileUtils.copyInputStreamToFile(inputStream, plantillaTemp);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}

		JasperDesign jasDesign = JRXmlLoader.load(plantillaTemp.getPath());
		JasperReport reporte = JasperCompileManager.compileReport(jasDesign);

		JasperPrint jasperPrint;
		if (objectList.size() > 0) {
			jasperPrint = JasperFillManager.fillReport(reporte, parameters, new JRBeanCollectionDataSource(objectList));
		} else {
			jasperPrint = JasperFillManager.fillReport(reporte, parameters, new JREmptyDataSource());
		}
		String pathAbsoluteFile = String.format("%s", fileName);
		File filex = new File(pathAbsoluteFile);

		if (tipoFile == Util.EXCEL) {
			JRExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(fileName + ".xls"));
			exporter.exportReport();
			filex = new File(pathAbsoluteFile + ".xls");

		}

		if (tipoFile == Util.PDF) {
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(fileName + ".pdf"));
			exporter.exportReport();
			filex = new File(pathAbsoluteFile + ".pdf");
		}

		if (tipoFile == Util.RTF) {

			JRExporter exporter = new JRRtfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(fileName + ".rtf"));

			exporter.exportReport();

			filex = new File(pathAbsoluteFile + ".rtf");

		}

		byte[] fileByteArray = new byte[(int) filex.length()];

		FileInputStream fis = new FileInputStream(filex);
		fis.read(fileByteArray); // read file into bytes[]
		fis.close();

		String fileString = new String(Base64.encodeBase64(fileByteArray));
		return fileString;
	}

	@Override
	public ListarLlamadaDestinoResponse listaLlamadaDestino(String codUsuario, String idInstancia, ListarLlamadaDestinoRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return llamadaDestinoDAO.listaLlamadaDestino(ip, request);
	}

	@Override
	public ListarLlamadaDestinoResponse reporteLlamadaDestino(String codUsuario, String idInstancia, ListarLlamadaDestinoRequest request) throws Exception {

		ListarLlamadaDestinoResponse response = listaLlamadaDestino(codUsuario, idInstancia, request);
		List<LlamadaDestino> llamadaDestinoList = response.getListaLLamadasDestino();

		Map parameters = new HashMap();

		parameters.put("fechaInicial", request.getpFeIni());
		parameters.put("fechaFinal", request.getpFeFin());
		parameters.put("horaInicial", request.getpHoIni());
		parameters.put("horaFinal", request.getpHoFin());
		parameters.put("area", request.getNomArea());
		parameters.put("centro", request.getNomCentro());

		String fileString = "";
		if (response.getListaLLamadasDestino().size() > 0) {
			fileString = generarReporte(plantillaReporteLlamadaDestino, parameters, response.getListaLLamadasDestino(), "reporteLlamadaDestino", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	@Override
	public ListaLlamadasAtendidasAbandonadasFechaResponse reporteLlamadaAtendidaAbandonadaFecha(String codUsuario, String idInstancia, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception {
		ListaLlamadasAtendidasAbandonadasFechaResponse response = listallamadaAbandonadaFechaServices.listaReporteLlamadaAtendidasAbandonadas(codUsuario, idInstancia, request);
		List<LlamadasAtendidasAbandonadasFechas> listas = response.getListaLlamadasAtendidasAbandonadas();
		Map parameters = new HashMap();
		String fileString = "";
		if (response.getListaLlamadasAtendidasAbandonadas().size() > 0) {
			fileString = generarReporte(plantillaLlamadaAtAbFecha, parameters, listas, "ReporteListaLlamadasAtAbFecha", request.getTipoFile());
			response.setMensaje("ok");
			response.setEstado(1);
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		return null;
	}

	public ListaLlamadasContestadasResponse reporteLlamadasContestadas(String codUsuario, String idInstancia, ListaLlamadasContestadasRequest request) throws Exception {
		ListaLlamadasContestadasResponse response = listallamadaAbandonadaFechaServices.listaReporteLlamadasContestadas(codUsuario, idInstancia, request);
		List<LlamadasContestadas> listas = response.getLsLContestadas();
		Map parameters = new HashMap();
		String fileString = "";
		if (response.getLsLContestadas().size() > 0) {
			fileString = generarReporte(plantillaLlamadasContestadas, parameters, listas, "ReporteListasLlamadasContestadas", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	@Override
	public ListaLlamadaAgenteResponse reporteListaLlamadasAgente(String codUsuario, String idInstancia, ListaLlamadaAgenteRequest request) throws Exception {
		ListaLlamadaAgenteResponse response = listallamadaAbandonadaFechaServices.listaLlamadaAgente(codUsuario, idInstancia, request);
		List<LlamadaAgente> listas = response.getLsLAgente();
		Map parameters = new HashMap();

		String fileString = "";
		if (response.getLsLAgente().size() > 0) {
			fileString = generarReporte(plantllaLlamadasAgente, parameters, listas, "ReporteListasLlamadasAgente", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	@Override
	public ListaReporteAbandonosResponse reporteListaReporteAbandonos(String codUsuario, String idInstancia, ListaReporteAbandonosRequest request) throws Exception {
		ListaReporteAbandonosResponse response = listallamadaAbandonadaFechaServices.listaReporteEAbandonos(codUsuario, idInstancia, request);
		List<ReporteAbandonos> listas = response.getLsReporteAbandonos();
		Map parameters = new HashMap();

		String fileString = "";
		if (response.getLsReporteAbandonos().size() > 0) {
			fileString = generarReporte(plantillaReporteAbandonos, parameters, listas, "ReporteListaReporteAbandonos", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	

	@Override
	public ListarReporteAtencionClienteCallCenterResponse reporteAtencionCliente(String codUsuario, String idInstancia, ListarReporteAtencionClienteCallCenterRequest request) throws Exception {

		ListarReporteAtencionClienteCallCenterResponse response = callCenterReporteServices.listaReporteAtencionCliente(codUsuario, idInstancia, request);
		List<ReporteAtencionClienteCallCenter> llamadaAtencionlist = response.getLsreporteAtencionCliente();

		Map parameters = new HashMap();
		// String fileString = generarReporte(plantillaReporteLlamada,
		// parameters,
		// response.getListaLlamadaGeneralList(), "reporteLlamadas",
		// request.getTipoFile());
		// response.setReporteFile(fileString);
		// return response;
		String fileString = "";
		if (response.getLsreporteAtencionCliente().size() > 0) {
			fileString = generarReporte(plantillaReporteAtencionCliente, parameters, llamadaAtencionlist, "reporteAtencionCliente", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");

		}
		response.setReporteFile(fileString);
		return response;
	}

	

	@Override
	public ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse reporteConsolidadoLlamadaRecibida(String codUsuario, String idInstancia, ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request) throws Exception {

		ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = callCenterReporteServices.listaReporteConsolidadoLlamada(codUsuario, idInstancia, request);
		List<ReporteConsolidadoLlamadaRecibidaCallCenter> consolidadoLlamadalist = response.getLsreporteConsolidadoLlamadaRecibida();
		Map parameters = new HashMap();
		// String fileString = generarReporte(plantillaReporteLlamada,
		// parameters,
		// response.getListaLlamadaGeneralList(), "reporteLlamadas",
		// request.getTipoFile());
		// response.setReporteFile(fileString);
		// return response;
		String fileString = "";
		if (response.getLsreporteConsolidadoLlamadaRecibida().size() > 0) {
			fileString = generarReporte(plantillaReporteConsolidadoLlamadaRecibida, parameters, consolidadoLlamadalist, "reporteConsolidadoLlamada", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");

		}
		response.setReporteFile(fileString);
		return response;
	}

		public ListarReporteLlamadaDiaHoraCallCenterResponse reporteLlamadaDia(String codUsuario, String idInstancia, ListarReporteLlamadaDiaHoraCallCenterRequest request) throws Exception {

		ListarReporteLlamadaDiaHoraCallCenterResponse response = callCenterReporteServices.listaReporteLlamadaDiaHora(codUsuario, idInstancia, request);
		List<ReporteLlamadaDiaHoraCallCenter> LlamadaDialist = response.getLsreporteLlamadaDiaHora();
		Map parameters = new HashMap();
		// String fileString = generarReporte(plantillaReporteLlamada,
		// parameters,
		// response.getListaLlamadaGeneralList(), "reporteLlamadas",
		// request.getTipoFile());
		// response.setReporteFile(fileString);
		// return response;
		String fileString = "";
		if (response.getLsreporteLlamadaDiaHora().size() > 0) {
			fileString = generarReporte(plantillaReporteLlamadaHora, parameters, LlamadaDialist, "reporteLlamadaHora", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	
	@Override
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse reporteLlamadaConsolidadaAgente(String codUsuario, String idInstancia, ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request) throws Exception {
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = callCenterReporteServices.reporteLlamadaConsolidadaAgente(codUsuario, idInstancia, request);
		List<ReporteLlamadaConsolidadaAgenteCallCenter> LlamadaDialist = response.getLsreporteLlamadaConsolidadaAgente();
		Map parameters = new HashMap();

		String fileString = "";
		if (response.getLsreporteLlamadaConsolidadaAgente().size() > 0) {
			fileString = generarReporte(plantillaReporteLlamadasConsolidadas, parameters, LlamadaDialist, "reporteLlamadaConsolidada", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);
		return response;
	}

	@Override
	public ListarLlamadasAtendidasAbandonadasResponse listarReporteLlamadasAtendidasAbandonadas(String codUsuario,
			String instancia, ListarLlamadasAtendidasAbandonadasRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListarLlamadasEntrantesPorHoraResponse listarReporteLlamadasEntrantesPorHora(String codUsuario,
			String instancia, ListarLlamadasEntrantesPorHoraRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListarLlamadasAbandonadasPorMinutoResponse listarReporteLlamadasAbandonadasPorMinuto(String codUsuario,
			String instancia, ListarLlamadasAbandonadasPorMinutoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
