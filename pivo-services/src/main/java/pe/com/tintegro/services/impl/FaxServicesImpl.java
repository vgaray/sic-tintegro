package pe.com.tintegro.services.impl;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.FaxDAO;
import pe.com.tintegro.dominio.Fax;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.EliminarFaxRequest;
import pe.com.tintegro.dto.request.InsertarFaxRequest;
import pe.com.tintegro.dto.request.ListarFaxRequest;
import pe.com.tintegro.dto.response.EliminarFaxResponse;
import pe.com.tintegro.dto.response.InsertarFaxResponse;
import pe.com.tintegro.dto.response.ListarFaxResponse;
import pe.com.tintegro.services.FaxServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.UtilFile;

@Service("faxServices")
@Transactional
public class FaxServicesImpl implements FaxServices {

	@Resource(name = "faxDAO")
	protected FaxDAO faxDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Override
	public ListarFaxResponse listarFax(String codUsuario, String idInstancia, ListarFaxRequest request) throws Exception {
		ListarFaxResponse response = new ListarFaxResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = faxDAO.listarFax(ip, request);
		return response;
	}

	@Override
	public InsertarFaxResponse insertarFax(String codUsuario, String idInstancia, InsertarFaxRequest request) throws Exception {
		InsertarFaxResponse response = new InsertarFaxResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = faxDAO.insertarFax(ip, request);
		generarTxtFax(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EliminarFaxResponse eliminarFax(String codUsuario, String idInstancia, EliminarFaxRequest request) throws Exception {
		EliminarFaxResponse response = new EliminarFaxResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = faxDAO.eliminarFax(ip, request);
		generarTxtFax(codUsuario, idInstancia);
		return response;
	}

	@Override
	public String generarTxtFax(String codUsuario, String idInstancia) throws Exception {
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		ListarFaxRequest request = new ListarFaxRequest();
		ListarFaxResponse lstPlanResponse = listarFax(codUsuario, idInstancia, request);
		String contenido = writeFax(codUsuario, idInstancia, lstPlanResponse.getListado());

		File file = UtilFile.writeFile(contenido, servicesProperties.getFileNameFax());
		String fileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), file.getPath(), servicesProperties.getPathFileFax());
		file.delete();
		System.out.println(fileExport);
		try {
			LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "asterisk -rx 'dialplan reload'");
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura del archivo Fax");
		}
		return contenido;
	}

	@Override
	public String writeFax(String codUsuario, String idInstancia, List<Fax> listado) throws Exception {
		String contenido = "";
		String nomFax = "";
		try {
			for (Fax fax : listado) {
				nomFax = fax.getNoFaxVirtual();
				contenido += "[" + nomFax.trim().replace(" ", "-") + fax.getIdFax() + "]" + System.getProperty("line.separator");
				contenido += "type=friend" + System.getProperty("line.separator");
				contenido += "context=fax" + System.getProperty("line.separator");
				contenido += "context=friend" + System.getProperty("line.separator");
				contenido += "disallow=all" + System.getProperty("line.separator");
				contenido += "allow=alaw" + System.getProperty("line.separator");
				contenido += "allow=ulaw" + System.getProperty("line.separator");
				contenido += "username=" + nomFax.trim().replace(" ", "-") + fax.getIdFax() + System.getProperty("line.separator");
				contenido += "secret=" + fax.getPasswordFax() + System.getProperty("line.separator");
				contenido += "callerid=" + fax.getNoCallerId() + "<" + fax.getUnCallerId() + ">" + System.getProperty("line.separator");
				contenido += "qualify=yes" + System.getProperty("line.separator");
				contenido += "host=dynamic" + System.getProperty("line.separator");
				contenido += "requirecalltoken=auto" + System.getProperty("line.separator");
				contenido += System.getProperty("line.separator");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contenido;
	}
}