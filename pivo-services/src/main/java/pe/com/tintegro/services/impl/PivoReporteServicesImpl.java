package pe.com.tintegro.services.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.MascotaServices;
import pe.com.tintegro.services.PersonalServices;
import pe.com.tintegro.services.PivoReporteServices;
import pe.com.tintegro.services.util.Util;

@Service("pivoReporteServices")
@Transactional
public class PivoReporteServicesImpl implements PivoReporteServices{

	@Resource(name = "personalServices")
	protected PersonalServices personalServices;
	@Resource(name = "mascotaServices")
	protected MascotaServices mascotaServices;
	@Value(value = "classpath:plantillaReporte/reportePersonal.jrxml")
	private org.springframework.core.io.Resource plantillaReportePersonal;
	@Value(value = "classpath:plantillaReporte/reporteMascotas.jrxml")
	private org.springframework.core.io.Resource plantillaReporteMascotas;
	
	
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
	public ListarPersonalResponse reporteListarPersonal(String codUsuario, String idInstancia,
			ListarPersonalRequest request) throws Exception {
		ListarPersonalResponse response = personalServices.listarPersonal(codUsuario, idInstancia, request);
		Map parameters = new HashMap();
		parameters.put("pIdPersonal", request.getpIdPersonal());
		parameters.put("pNuDocumento", request.getpNuDocumento());
		parameters.put("pNoNombreApellido", request.getpNoNombreApellido());
		parameters.put("pIdTipoDocumento", request.getpIdTipoDocumento());
		parameters.put("pIlActivo", request.getpIlActivo());
		
		String fileString = "";
		if (response.getLsPersonal().size() > 0) {
			fileString = generarReporte(plantillaReportePersonal,parameters, response.getLsPersonal(), "ReportePersonal", request.getTipoFile());
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
	public ListarMascotaResponse reporteListarMascota(String codUsuario, ListarMascotaRequest request)
			throws Exception {
		ListarMascotaResponse response=mascotaServices.listarMascota(codUsuario, request);
		// TODO Auto-generated method stub
		String fileString = "";
		if (response.getLsMascota().size() > 0) {
			fileString = generarReporte(plantillaReporteMascotas,null, response.getLsMascota(), "ReporteMascotas", request.getTipoFile());
			response.setMensaje("ok");
		} else {
			fileString = "";
			response.setMensaje("Lista Vacia");
			System.out.println("Lista Vacia");
		}
		response.setReporteFile(fileString);

		return response;
	}

}
