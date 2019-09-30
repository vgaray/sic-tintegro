package pe.com.tintegro.services.impl;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.SipBuddieDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.request.ConfigAnnexRequest;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.GeneraClaveAnexoSipRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.ConfigAnnexResponse;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.services.AprovisionamientoServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.SipTelefonoServices;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.UtilFile;

@Service("sipBuddieServices")
@Transactional
public class SipBuddieServicesImpl implements SipBuddieServices {
	@Resource(name = "sipBuddieDAO")
	protected SipBuddieDAO sipBuddieDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "aprovisionamientoServices")
	protected AprovisionamientoServices aprovisionamientoServices;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private SipTelefonoServices sipTelefonoServices;

	@Autowired
	private LinuxUtil linuxUtil;

	@Autowired
	InfraestructuraUtil infraestructuraUtil;

	@Override
	public InsertaSipBuddieResponse insertarSipBuddie(String codUsuario,
			String idInstancia, InsertaSipBuddieRequest request)
			throws Exception {
		InsertaSipBuddieResponse response = new InsertaSipBuddieResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(
				codUsuario, idInstancia);

		SipBuddie buddie = new SipBuddie();
		SipTelefono sipTelefono = new SipTelefono();

		/**
		 * Matcheo de objeto request con anexo SIP.
		 */
		buddie.setName(request.getNomUsuario());
		buddie.setCallerid(request.getCallerId());
		sipTelefono.setCallerId(request.getCallerId());
		buddie.setUsername(request.getNomUsuario());
		buddie.setSecret(request.getClaveUsuario());
		sipTelefono.setClaveUsuario(request.getClaveUsuario());
		buddie.setMailbox(request.getBuzonBox());
		buddie.setVoicemail(request.getCorreoBox());
		sipTelefono.setNomIpDominio(servicesProperties
				.getAsteriskOpenVPNDominio());
		request.setIpDominio(servicesProperties.getAsteriskOpenVPNDominio());
		sipTelefono.setMarcaId(request.getMarcaId());
		sipTelefono.setNomMarca(request.getNomMarca());
		sipTelefono.setModeloId(request.getModeloId());
		sipTelefono.setNomModelo(request.getNomModelo());
		sipTelefono.setNomMac(request.getMac());

		try {
			generateCertificate(codUsuario, idInstancia, vm, buddie);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			String mensajeError = "Error en el empaquetamiento de llaves.";
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setCodError(Constantes.ID_ERROR_APP);
			response.setMensaje(mensajeError);
			throw new Exception(mensajeError);
		}

		/**
		 * Se determina si el anexo necesita aprovisionamiento
		 */
		boolean needProvisioning = request.getMarcaId() != null
				&& request.getModeloId() != null && request.getMac() != null
				&& request.getMarcaId() != 0 && request.getModeloId() != 0
				&& !request.getMac().equals("");

		try {
			packageCertificates(codUsuario, idInstancia, needProvisioning, vm,
					buddie, sipTelefono);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			String mensajeError = "Error en el empaquetamiento de llaves.";
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setCodError(Constantes.ID_ERROR_APP);
			response.setMensaje(mensajeError);
			throw new Exception(mensajeError);
		}

//		try {
//			redirectKeysToFileServer(codUsuario, idInstancia, vm, buddie,
//					sipTelefono, needProvisioning);
//		} catch (Exception e) {
//			System.err.println("Error: " + e.getMessage());
//			String mensajeError = "Error en el redireccionamiento de las llaves.";
//			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
//			response.setCodError(Constantes.ID_ERROR_APP);
//			response.setMensaje(mensajeError);
//			throw new Exception(mensajeError);
//		}
//		
		ListaInstanciaRequest requestIns = new ListaInstanciaRequest();
		requestIns.setpIdInstanciaxDesc(instanciaServices.desincriptarIdInstancia(idInstancia));
		requestIns.setCodUsuario(codUsuario);
		ListaInstanciaResponse responseIns=new ListaInstanciaResponse();
		responseIns=instanciaServices.listaInstancia(codUsuario, requestIns);
		try {
			bastTlssRtp(codUsuario, idInstancia, vm, "10.10.37.1", instanciaServices.listaInstancia(codUsuario, requestIns)
					.getInstancias().get(0).getNoOrgani(), instanciaServices.listaInstancia(codUsuario, requestIns)
					.getInstancias().get(0).getNoPasswordLdap(), request.getNomUsuario());			
			if(needProvisioning){
				bashProvisioning(responseIns.getInstancias().get(0).getTipoInstancia(),
						responseIns.getInstancias().get(0).getIsTls(),
						request.getNomMarca()+"-"+request.getNomModelo(),
						request.getMac(), request.getNomUsuario(),
						request.getCallerId().replace(" ", "-"), request.getClaveUsuario(), "10.10.37.1",
						responseIns.getInstancias().get(0).getZonaHoraria(),
						responseIns.getInstancias().get(0).getNoOrgani(), idInstancia,
						responseIns.getInstancias().get(0).getNoPasswordLdap(),vm);				
			}
			generateLibreta(codUsuario, idInstancia, Util.ADD, vm, buddie);
			crudAnnexInAsterisk(codUsuario, idInstancia, Util.ADD, buddie,requestIns,needProvisioning);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			String mensajeError = "Error en el mantenimiento del anexo en el servidor asterisk.";
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setCodError(Constantes.ID_ERROR_APP);
			response.setMensaje(mensajeError);
			throw new Exception(mensajeError);
		}
		response = sipBuddieDAO.insertaSipBuddie(ip, request);
		return response;
	}

	@Override
	public EditaSipBuddieResponse editarSipBuddie(String codUsuario,
			String idInstancia, EditaSipBuddieRequest request, boolean esCarga)
			throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(
				codUsuario, idInstancia);

		SipBuddie buddie = new SipBuddie();
		SipTelefono sipTelefono = new SipTelefono();

		/**
		 * Matcheo de objeto request con anexo SIP.
		 */
		buddie.setName(request.getNomUsuario());
		buddie.setCallerid(request.getCallerId());
		sipTelefono.setCallerId(request.getCallerId());
		buddie.setUsername(request.getNomUsuario());
		buddie.setSecret(request.getClaveUsuario());
		sipTelefono.setClaveUsuario(request.getClaveUsuario());
		buddie.setMailbox(request.getBuzonBox());
		buddie.setVoicemail(request.getCorreoBox());
		sipTelefono.setNomIpDominio(servicesProperties
				.getAsteriskOpenVPNDominio());
		request.setIpDominio(servicesProperties.getAsteriskOpenVPNDominio());
		sipTelefono.setMarcaId(request.getMarcaId());
		sipTelefono.setNomMarca(request.getNomMarca());
		sipTelefono.setModeloId(request.getModeloId());
		sipTelefono.setNomModelo(request.getNomModelo());
		sipTelefono.setNomMac(request.getMac());

		boolean needProvisioning = request.getMarcaId() != 0
				&& request.getModeloId() != 0 && request.getMac() != null
				&& request.getMarcaId() != 0 && request.getModeloId() != 0
				&& !request.getMac().equals("");

		SipTelefono currentSIP = sipTelefonoServices
				.obtenerSipTelelefonoPorNumeroAnexo(codUsuario, idInstancia,
						buddie.getName());

		MarcaTelefono marca = null;
		ModeloTelefono modelo = null;

		if (currentSIP != null && currentSIP.getMarcaId() != null) {
			marca = sipTelefonoServices.obtenerMarcaPorNumeroDeAnexo(
					codUsuario, idInstancia, buddie.getName());
			modelo = sipTelefonoServices.obtenerModeloPorMarcaDeTelefono(
					codUsuario, idInstancia, sipTelefono);
			currentSIP.setNomMarca(marca.getNomMarca());
			currentSIP.setNomModelo(modelo.getNomModelo());

			if (currentSIP.getNomMac() != null
					&& !currentSIP.getNomMac().equals(request.getMac())
					|| currentSIP.getNomMarca() != null
					&& !currentSIP.getNomMarca().equals(request.getNomMarca())
					|| currentSIP.getNomModelo() != null
					&& !currentSIP.getNomModelo()
							.equals(request.getNomModelo())) {
				deleteKeysOnFileServer(codUsuario, idInstancia,
						getStatusSIP(codUsuario, idInstancia, vm, buddie), vm,
						buddie);
				deleteKeysDirectory(codUsuario, idInstancia, buddie.getName(),
						vm);
				packageCertificates(codUsuario, idInstancia, needProvisioning,
						vm, buddie, sipTelefono);
				redirectKeysToFileServer(codUsuario, idInstancia, vm, buddie,
						sipTelefono, needProvisioning);
			}
		}

		/**
		 * Actualizar archivos de configuración en Asterisk
		 */
		ListaInstanciaRequest requestIns = new ListaInstanciaRequest();
		requestIns.setpIdInstanciaxDesc(instanciaServices
				.desincriptarIdInstancia(idInstancia));
		requestIns.setCodUsuario(codUsuario);		
		
		crudAnnexInAsterisk(codUsuario, idInstancia, Util.UPDATE, buddie, requestIns,needProvisioning);
		
		BuscaSipBuddieIdRequest buscaSipRequest = new BuscaSipBuddieIdRequest();
		buscaSipRequest.setNomUsuario(request.getNomUsuario());			
		
		BuscaSipBuddieIdResponse buscaSipResponse = sipTelefonoServices
				.buscaSipBuddieId(codUsuario, idInstancia, buscaSipRequest);
		SipTelefono sipTelefono1 = buscaSipResponse.getSipTelefonoList().get(0);		
		
		//obtener callerid
		ListaInstanciaResponse responseIns=new ListaInstanciaResponse();
		responseIns=instanciaServices.listaInstancia(codUsuario, requestIns);				
		
		if(needProvisioning){				
			
			//elimina el cfg y el pem				
			String commandDeleteFileConfig = String
					.format("rm -rf %s/%s/%s.cfg",
							servicesProperties.getPathFolderAprosionamientoFileServer(),
							idInstancia, currentSIP.getNomMac());
			linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(),
					null, commandDeleteFileConfig);
			System.out.println("Eliminacion cfg: "+commandDeleteFileConfig);
			
			String commandDeleteFileConfig2 = String
					.format("rm -rf %s/%s/%s.pem",
							servicesProperties.getPathFolderAprosionamientoFileServer(),
							idInstancia, buddie.getName());
			linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(),
					null, commandDeleteFileConfig2);
			System.out.println("Eliminacion pem: "+commandDeleteFileConfig2);			
			//
			
			String pcallerId=buddie.getCallerid().replace(" ", "-");
			String ppassAnexo=buddie.getSecret();
			
			bashProvisioning(responseIns.getInstancias().get(0).getTipoInstancia(),
					responseIns.getInstancias().get(0).getIsTls(),
					request.getNomMarca()+"-"+request.getNomModelo(),
					request.getMac(), request.getNomUsuario(),
					request.getCallerId().replace(" ", "-"), request.getClaveUsuario(), "10.10.37.1",
					responseIns.getInstancias().get(0).getZonaHoraria(),
					responseIns.getInstancias().get(0).getNoOrgani(), idInstancia,
					responseIns.getInstancias().get(0).getNoPasswordLdap(),vm);			
			
			if (!(sipTelefono1.getCallerId().replace(" ", "-")).equals(pcallerId) || 
					!sipTelefono1.getClaveUsuario().equals(ppassAnexo)) {
				
				bashDeleteProvisioning(buddie.getName(), vm);				
				
				if ((sipTelefono1.getCallerId()).equals(pcallerId)) {
					pcallerId=null;
				}else if ((sipTelefono1.getClaveUsuario()).equals(ppassAnexo)) {
					ppassAnexo=null;
				}						
				bashUpdateProvisioning(buddie.getName(), pcallerId, 
						ppassAnexo,idInstancia, vm);									
			}
						
		}		
		
		//obtener pass de instancia
		ListaInstanciaxIdRequest request_inst = new ListaInstanciaxIdRequest();
		request_inst.setIdInstancia(idInstancia);		
		ListaInstanciaxIdResponse response = instanciaServices.listarIntanciaxIdInstancia(codUsuario, request_inst);
		String pass=response.getListarInstanciaxId().get(0).getNoPasswordLdap();		
		
		updateOpenLdap(sipTelefono1.getCallerId().replace(" ", "-"), pass, 
				idInstancia, responseIns.getInstancias().get(0).getNoOrgani().replace(" ", "-"), vm);
		
		generateLibreta(codUsuario, idInstancia, Util.UPDATE, vm, buddie);
		return sipBuddieDAO.editaSipBuddie(ip, request);
	}

	@Override
	public EliminaSipBuddieResponse eliminaSipBuddie(String codUsuario,
			String idInstancia, EliminaSipBuddieRequest request)
			throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);

		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(
				codUsuario, idInstancia);

		BuscaSipBuddieIdRequest buscaSipRequest = new BuscaSipBuddieIdRequest();
		buscaSipRequest.setNomUsuario(request.getNomUsuario());

		BuscaSipBuddieIdResponse buscaSipResponse = sipTelefonoServices
				.buscaSipBuddieId(codUsuario, idInstancia, buscaSipRequest);
		SipTelefono sipTelefono = buscaSipResponse.getSipTelefonoList().get(0);

		boolean isProvisioned = sipTelefono.getMarcaId() != null
				&& sipTelefono.getModeloId() != null
				&& sipTelefono.getNomMac() != null
				&& sipTelefono.getMarcaId() != 0
				&& sipTelefono.getModeloId() != 0
				&& !sipTelefono.getNomMac().equals("");

		try {
			String commandDeleteAnnex = String.format("sh %s %s",
					servicesProperties.getPathBashEliminarCertificado(),
					request.getNomUsuario());
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					vm, commandDeleteAnnex);

			if (isProvisioned) {
				//elimina el cfg y el pem				
				String commandDeleteFileConfig = String
						.format("rm -rf %s/%s/%s.cfg",
								servicesProperties.getPathFolderAprosionamientoFileServer(),
								idInstancia, sipTelefono.getNomMac());
				linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(),
						null, commandDeleteFileConfig);
				System.out.println("Eliminacion cfg: "+commandDeleteFileConfig);
				
				String commandDeleteFileConfig2 = String
						.format("rm -rf %s/%s/%s.pem",
								servicesProperties.getPathFolderAprosionamientoFileServer(),
								idInstancia, sipTelefono.getNomUsuario());
				linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(),
						null, commandDeleteFileConfig2);
				System.out.println("Eliminacion pem: "+commandDeleteFileConfig2);				
			}

			SipBuddie buddie = new SipBuddie();
			buddie.setName(request.getNomUsuario());
			buddie.setCallerid(sipTelefono.getCallerId());
			buddie.setMailbox(sipTelefono.getMailbox());
			buddie.setVoicemail(sipTelefono.getEmail());
			buddie.setSecret(sipTelefono.getClaveUsuario());

			deleteKeysOnFileServer(codUsuario, idInstancia, isProvisioned, vm,
					buddie);

			ListaInstanciaRequest requestIns = new ListaInstanciaRequest();
			requestIns.setpIdInstanciaxDesc(instanciaServices
					.desincriptarIdInstancia(idInstancia));
			requestIns.setCodUsuario(codUsuario);			
			
			crudAnnexInAsterisk(codUsuario, idInstancia, Util.ELIMINAR, buddie,requestIns,isProvisioned);

			generateLibreta(codUsuario, idInstancia, Util.ELIMINAR, vm, buddie);
		} catch (Exception e) {
			throw new Exception(
					"Error en la eliminación de Anexos SIP en servidor.");
		}

		return sipBuddieDAO.eliminaSipBuddie(ip, request);
	}

	@Override
	public String generateAnnexID(String codUsuario, String idInstancia,
			GeneraClaveAnexoSipRequest request) throws Exception {
		String clave = null;
		int minCaracteres = 25;
		int maxCaracteres = 25;
		clave = Util.getRandomValue(minCaracteres, maxCaracteres);
		return clave;
	}

	@Override
	public void crudAnnexInAsterisk(String codUsuario, String idInstancia,
			int tipoOperacion, SipBuddie buddie,ListaInstanciaRequest requestIns,Boolean needProvisioning) throws Exception {
		linuxUtil.setCodUsuario(codUsuario);
		linuxUtil.setIdInstancia(idInstancia);

		try {
			/**
			 * Registrando anexos en sip_extensions.conf
			 */
			String need_tls="1";
			if(instanciaServices.listaInstancia(codUsuario, requestIns)
					.getInstancias().get(0).getIsTls()){
				need_tls="2";
			}
			if(!needProvisioning){
				need_tls="1";
			}
				
			String cmdSipExtensionsJar = String.format(
					"sh %s %d %s %s %s %s %s %s",
					servicesProperties.getBashPathCrearAnexoEnAsterisk(),
					tipoOperacion,
					buddie.getName(),
//					buddie.getCallerid().indexOf(" ") != -1 ? String.format(
//							"\"%s\"", buddie.getCallerid()) : buddie
//							.getCallerid()					
					buddie.getCallerid().replace(" ", "-"), buddie.getMailbox(), buddie
							.getSecret(), buddie.getVoicemail(),need_tls);

			System.out.println("sip_extensions.conf: "+cmdSipExtensionsJar);
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					null, cmdSipExtensionsJar);
			
			/**
			 * Mantenimiento de anexos en extensions_anexos.conf
			 */
			String cmdExtensionsAnexosJar = String.format("sh %s %d %s",
					servicesProperties.getBashPathMantenerAnexoEnAsterisk(),
					tipoOperacion, buddie.getName());
			System.out.println(cmdExtensionsAnexosJar);
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					null, cmdExtensionsAnexosJar);

			/**
			 * Reestructurando el archivo de monitoreo.
			 */
			String cmdExtensionsHintJar = String.format("sh %s %d %s",
					servicesProperties.getBashPathMonitorearAnexoEnAsterisk(),
					tipoOperacion, buddie.getName());
			System.out.println(cmdExtensionsHintJar);
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					null, cmdExtensionsHintJar);

			/**
			 * Registrando correo del usuario SIP.
			 */
			if (buddie.getVoicemail() != null
					&& !buddie.getVoicemail().equals("")) {
				String cmdVoicemailJar = String.format(
						"sh %s %d %s %s %s",
						servicesProperties
								.getBashPathRegistrarCorreoEnAsterisk(),
						tipoOperacion,
						buddie.getName(),
						buddie.getCallerid().replace(" ", "-"), buddie.getVoicemail());
				System.out.println(cmdVoicemailJar);
				linuxUtil.ejecutarComando(
						TipoServer.INSTANCIA_ASTERISK.getTipo(), null,
						cmdVoicemailJar);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public ConfigAnnexResponse getCredentials(String codUsuario,
			String idInstancia, ConfigAnnexRequest request) throws Exception {
		ConfigAnnexResponse response = new ConfigAnnexResponse();

		if (request != null) {
			InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(
					codUsuario, idInstancia);

			/**
			 * Se obtienen los datos del teléfono SIP
			 */
			SipTelefono sipTelefono = sipTelefonoServices
					.obtenerSipTelelefonoPorNumeroAnexo(codUsuario,
							idInstancia, request.getNomUsuario());

			/**
			 * Se verifica si se trata de un anexo no aprovisionado
			 */

			System.out.println("Marca " + request.getNomMarca());
			if (request.getNomMarca().equals(Util.NOT_PROVISIONING)) {
				SipBuddie sipBuddie = new SipBuddie();
				sipBuddie.setName(request.getNomUsuario());

				/**
				 * Se obtiene el nombre del archivo comprimido a devolver
				 */
				String nameFileCompressed = String.format("client-%s-%s.zip",
						idInstancia,
						sipBuddie.getName());				
//				String nameFileCompressed = String.format("client-%s-%s.zip",
//						linuxUtil.generateClientID(vm, sipBuddie),
//						sipBuddie.getName());

				/**
				 * Se crea una carpeta temporal con nombre aleatorio
				 */
				String nameFolderTemp = Util.getRandomValue(10, 20);
				System.out.println("ruta mkdir: " + nameFolderTemp);
				System.out.println(Util.getCurrentPathDirectory() + "/"
						+ nameFolderTemp);
				System.out.println(nameFileCompressed);
				// File directorio=new File("D://"+nameFolderTemp);
				// directorio.mkdir();

				LinuxUtil.executeCommand(TipoServer.LOCAL.getTipo(), null,
						String.format("mkdir %s", nameFolderTemp));

				String __dirname = Util.getCurrentPathDirectory() + "/"
						+ nameFolderTemp;

				/**
				 * Se copia el archivo del servidor hasta nuestra carpeta
				 * temporal creada recientemente.
				 */
				System.out.println("src: "+servicesProperties
										.getPathFolderAprovisionamientoLocalServerHTTP()
										+ "/"
										+ sipBuddie.getName()
										+ "/"
										+ nameFileCompressed);
				infraestructuraUtil
						.copyFile(
								TipoServer.REMOTE.getTipo(),
								TipoServer.LOCAL.getTipo(),
								infraestructuraUtil.instanciaACredencialesEquipo(vm),
//								infraestructuraUtil
//										.getCredentialsConnectionFileServer(),
								null,
								servicesProperties
										.getPathFolderAprovisionamientoLocalServerHTTP()
										+ "/"
//										+ idInstancia
										+ sipBuddie.getName()
										+ "/"
										+ nameFileCompressed, __dirname);

				/**
				 * Se instancia el archivo copiado recientemente.
				 */
				File fileZip = new File(__dirname + File.separator
						+ nameFileCompressed);
				System.out.println("fileZip: " + __dirname + File.separator+ nameFileCompressed);
				System.out.println("dirname: " + __dirname);
				System.out.println("nameFileCompressed: " + nameFileCompressed);
				System.out.println(fileZip.exists());

				if (fileZip.exists() && !fileZip.isDirectory()) {
					/**
					 * Se convierte el archivo a un formato de base 64
					 */
					String fileProvisioningBase64 = UtilFile
							.codificarToBase64(fileZip);

					/**
					 * Se elimina la carpeta temporal con el archivo dentro para
					 * liberar espacio.
					 */
					LinuxUtil.executeCommand(TipoServer.LOCAL.getTipo(), null,
							String.format("rm -rf %s", nameFolderTemp));

					/**
					 * Se setea el nombre del archivo comprimido
					 */
					response.setNameFile(nameFileCompressed);

					/**
					 * Se setea el valor del archivo en base 64
					 */
					response.setFileProvisioningBase64(fileProvisioningBase64);
				} else {
					throw new Exception(
							"No presenta archivo de aprovisionamiento");
				}
			} else {
				/**
				 * Se obtienen los datos de la marca del teléfono SIP
				 */
				MarcaTelefono marca = sipTelefonoServices
						.obtenerMarcaPorNumeroDeAnexo(codUsuario, idInstancia,
								request.getNomUsuario());

				String pathCredentiales;

				/**
				 * Se verifica si el teléfono en cuestión necesita de su MAC
				 * para ser aprovisionado y de acuerdo al resultado se obtiene
				 * el enlace que hace referencia su archivo de configuración.
				 */
				if (marca.getIlNeedMACForProvisioning())
					pathCredentiales = String.format("%s/%s/%s%s",
							servicesProperties.getPathDownloadCredentials(),
							idInstancia, sipTelefono.getNomMac(),
							marca.getNoExtensionForProvisioning());
				else
					pathCredentiales = String.format("%s/%s/",
							servicesProperties.getPathDownloadCredentials(),
							idInstancia);

				/**
				 * Se setea el enlace al servidor del archivo de configuración
				 * del anexo.
				 */
				response.setLinkProvisioning(pathCredentiales);
			}
		}

		return response;
	}

	@Override
	public void generateKeys(String codUsuario, InstanciaServerAsterisk vm,
			SipBuddie sipBuddie, SipTelefono sipTelefono,
			boolean needProvisioning) throws Exception {
		String idCliente = generateClientID(vm, sipBuddie);
		String linuxCommand = null;

		if (needProvisioning) {
			linuxCommand = String.format(
					"sh %s %s %s %s %s %s-%s %s %s %s %s",
					servicesProperties.getPathBashCrearAprovisionamiento(),
					vm.getIpAsterisk(),
					vm.getPuertoOpenVPN(),
					sipBuddie.getName(),
					idCliente,
					sipTelefono.getNomMarca(),
					sipTelefono.getNomModelo(),
					sipTelefono.getNomMac(),
					sipTelefono.getCallerId().replace(" ", "-"), sipTelefono
							.getClaveUsuario(), servicesProperties
							.getFileServerDominio());
		} else {
			linuxCommand = String.format("sh %s %s %s %s %s %s %s",
					servicesProperties.getBashPathCrearSipOpenVPN(),
					vm.getIpAsterisk(), vm.getPuertoOpenVPN(),
					sipBuddie.getName(), idCliente,
					servicesProperties.getModelPhoneNotProvisioning(),
					servicesProperties.getFileServerDominio());
		}

		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
				infraestructuraUtil.instanciaACredencialesEquipo(vm),
				linuxCommand);
	}

	@Override
	public void redirectKeysToFileServer(String codUsuario, String idInstancia,
			InstanciaServerAsterisk vm, SipBuddie buddie,
			SipTelefono sipTelefono, boolean needProvisioning) throws Exception {
		String cmdRedirectMACCfg;
		String cmdRedirectKeys;
		String nameFileCompressed;

		if (needProvisioning) {
			String nomMac = sipTelefono.getNomMac();
			cmdRedirectMACCfg = String.format("ln -s %s/%s.cfg %s/%s/%s.cfg",
					servicesProperties
							.getPathFolderAprovisionamientoLocalServerFTP(),
					nomMac, servicesProperties
							.getPathFolderAprovisionamientoLocalServerHTTP(),
					idInstancia, nomMac);

			LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
					infraestructuraUtil.getCredentialsConnectionFileServer(),
					cmdRedirectMACCfg);

			nameFileCompressed = String.format("openvpn-%s-%s.tar",
					generateClientID(vm, buddie), buddie.getName());
		} else {
			nameFileCompressed = String.format("client-%s-%s.zip",
					generateClientID(vm, buddie), buddie.getName());
		}

		cmdRedirectKeys = String.format("ln -s %s/%s %s/%s/%s",
				servicesProperties
						.getPathFolderAprovisionamientoLocalServerFTP(),
				nameFileCompressed, servicesProperties
						.getPathFolderAprovisionamientoLocalServerHTTP(),
				idInstancia, nameFileCompressed);

		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
				infraestructuraUtil.getCredentialsConnectionFileServer(),
				cmdRedirectKeys);
	}

	@Override
	public String generateClientID(InstanciaServerAsterisk vm,
			SipBuddie sipBuddie) {
		return vm.getIpAsterisk().replace(".", "_") + "_" + sipBuddie.getName();
	}

	@Override
	public void deleteKeysDirectory(String codUsuario, String idInstancia,
			String numAnexo, InstanciaServerAsterisk vm) throws Exception {
		String linuxCommand = String.format("sh %s %s",
				servicesProperties.getBashPathEliminarDirSip(), numAnexo);

		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
				infraestructuraUtil.instanciaACredencialesEquipo(vm),
				linuxCommand);
	}

	@Override
	public void generateCertificate(String codUsuario, String idInstancia,
			InstanciaServerAsterisk vm, SipBuddie sipBuddie) throws Exception {
		String linuxCommand = String.format("sh %s %s",
				servicesProperties.getBashPathGenerarCertificado(),
				sipBuddie.getName());

		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
				infraestructuraUtil.instanciaACredencialesEquipo(vm),
				linuxCommand);
	}

	@Override
	public void packageCertificates(String codUsuario, String idInstancia,
			boolean needProvisioned, InstanciaServerAsterisk vm,
			SipBuddie sipBuddie, SipTelefono sipTelefono) throws Exception {
		String bashPath = needProvisioned ? servicesProperties
				.getBashPathEmpaquetarProvisioning() : servicesProperties
				.getBashPathEmpaquetarNotProvisioning();

		String device = needProvisioned ? String.format("%s-%s",
				sipTelefono.getNomMarca(), sipTelefono.getNomModelo())
				: servicesProperties.getModelPhoneNotProvisioning();

		String linuxCommand = null;

		if (!needProvisioned) {
			linuxCommand = String.format("sh %s %s %s %s %s %s %s", bashPath,
					vm.getIpAsterisk(), vm.getPuertoOpenVPN(), device,
					sipBuddie.getName(), idInstancia,
					servicesProperties.getFileServerDominio());
		} else {
			linuxCommand = String.format(
					"sh %s %s %s %s %s %s %s %s %s %s",
					bashPath,
					vm.getIpAsterisk(),
					vm.getPuertoOpenVPN(),
					device,
					sipBuddie.getName(),
					sipTelefono.getCallerId().replace(" ", "-"), sipBuddie.getSecret(),
					sipTelefono.getNomMac(), idInstancia,
					servicesProperties.getFileServerDominio());
		}

		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
				infraestructuraUtil.instanciaACredencialesEquipo(vm),
				linuxCommand);
	}

	@Override
	public boolean getStatusSIP(String codUsuario, String idInstancia,
			InstanciaServerAsterisk vm, SipBuddie buddie) throws Exception {
		String linuxCommand = String.format("sh %s %s",
				servicesProperties.getBashPathStatusSIP(), buddie.getName());

		boolean statusSIP = Boolean
				.parseBoolean(linuxCommand.replace("\n", ""));

		return statusSIP;
	}

	@Override
	public void deleteKeysOnFileServer(String codUsuario, String idInstancia,
			boolean isProvisioned, InstanciaServerAsterisk vm, SipBuddie buddie)
			throws Exception {
		String nameFileCompressed = isProvisioned ? String.format(
				"openvpn-%s-%s.tar", idInstancia,
				buddie.getName()) : String.format("client-%s-%s.zip",
						idInstancia, buddie.getName());
//		String nameFileCompressed = isProvisioned ? String.format(
//				"openvpn-%s-%s.tar", linuxUtil.generateClientID(vm, buddie),
//				buddie.getName()) : String.format("client-%s-%s.zip",
//				linuxUtil.generateClientID(vm, buddie), buddie.getName());
				

		String commandDeleteFileCompressedFTP = String.format("rm -rf %s/%s",
				servicesProperties
						.getPathFolderAprosionamientoFileServer(),
				nameFileCompressed);
		linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(), null,
				commandDeleteFileCompressedFTP);

		String commandDeleteFileCompressedHTTP = String.format(
				"rm -rf %s/%s/%s", servicesProperties
						.getPathFolderAprosionamientoFileServer(),
				idInstancia, nameFileCompressed);
		linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(), null,
				commandDeleteFileCompressedHTTP);
	}

	@Override
	public void generateLibreta(String codUsuario, String idInstancia,
			Integer tipoOperacion, InstanciaServerAsterisk vm,
			SipBuddie sipBuddie) throws Exception {
		try {
			System.out.println("Inst: " + idInstancia);
			ListaInstanciaxIdRequest request = new ListaInstanciaxIdRequest();
			request.setIdInstancia(idInstancia);

			ListaInstanciaxIdResponse response = instanciaServices
					.listarIntanciaxIdInstancia(codUsuario, request);
			String empresa = response.getListarInstanciaxId().get(0)
					.getNoRazonSocial().trim().replace(" ", "-");

			if (tipoOperacion == 1 || tipoOperacion == 2) {
				System.out.println("razon:. "
						+ response.getListarInstanciaxId().get(0)
								.getNoRazonSocial());
				System.out.println("Ruta Bsh: "
						+ servicesProperties.getPathFolderEmpresaLdif()
						+ empresa + "/" + sipBuddie.getName() + ".ldif");

				LinuxUtil.executeCommand(
						TipoServer.REMOTE.getTipo(),
						infraestructuraUtil.instanciaACredencialesEquipo(vm),
						"mkdir -p "
								+ servicesProperties.getPathFolderEmpresaLdif()
								+ empresa + "/directorio-" + empresa + "/");

				String contenido = "";

				contenido += "dn: uid="
						+ sipBuddie.getCallerid().trim().replace(" ", "-")
						+ ",ou=" + "directorio-" + empresa + ",dc=" + empresa
						+ ",dc=com" + System.lineSeparator();
				contenido += "objectClass: inetorgperson"
						+ System.lineSeparator();
				contenido += "uid: "
						+ sipBuddie.getCallerid().trim().replace(" ", "-")
						+ System.lineSeparator();
				contenido += "sn: "
						+ sipBuddie.getCallerid().trim().replace(" ", "-")
						+ System.lineSeparator();
				contenido += "cn: "
						+ sipBuddie.getCallerid().trim().replace(" ", "-")
						+ System.lineSeparator();
				contenido += "initials: a8" + System.lineSeparator();
				contenido += "givenName: "
						+ sipBuddie.getCallerid().trim().replace(" ", "-")
						+ System.lineSeparator();
				contenido += "homePhone: " + sipBuddie.getName()
						+ System.lineSeparator();

				File file = UtilFile.writeFile(contenido, sipBuddie.getName()
						+ ".ldif");
				String fileExport = infraestructuraUtil.copyFile(
						TipoServer.LOCAL.getTipo(),
						TipoServer.INSTANCIA_ASTERISK.getTipo(), null,
						infraestructuraUtil.instanciaACredencialesEquipo(vm),
						file.getPath(),
						servicesProperties.getPathFolderEmpresaLdif() + empresa
								+ "/directorio-" + empresa);
				file.delete();
				System.out.println(fileExport);

				LinuxUtil.executeCommand(
						TipoServer.INSTANCIA_ASTERISK.getTipo(),
						infraestructuraUtil.instanciaACredencialesEquipo(vm),
						"ldapadd -f /var/lib/ldap/"
								+ empresa
								+ "/directorio-"
								+ empresa
								+ "/"
								+ sipBuddie.getName()
								+ ".ldif -D cn=Manager,dc="
								+ empresa
								+ ",dc=com -w "
								+ response.getListarInstanciaxId().get(0)
										.getNoPasswordLdap());

				String linuxCommand = String.format("expect %s %s %s %s",
						servicesProperties.getBashPathGenerarLibreta(),
						response.getListarInstanciaxId().get(0)
								.getNoPasswordLdap(), empresa, "/var/lib/ldap/"
								+ empresa + "/directorio-" + empresa + "/"
								+ sipBuddie.getName() + ".ldif");
				LinuxUtil.executeCommand(
						TipoServer.INSTANCIA_ASTERISK.getTipo(),
						infraestructuraUtil.instanciaACredencialesEquipo(vm),
						linuxCommand);

			} else if (tipoOperacion == 3) {
				String deleteFileConf = String.format(
						"rm %s",
						servicesProperties.getPathFolderEmpresaLdif() + empresa
								+ "/directorio-" + empresa + "/"
								+ sipBuddie.getName() + ".ldif");
				LinuxUtil.executeCommand(
						TipoServer.INSTANCIA_ASTERISK.getTipo(),
						infraestructuraUtil.instanciaACredencialesEquipo(vm),
						deleteFileConf);
			}
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura del archivo");
		}

	}

	@Override
	public void bashProvisioning(Integer tipoProduct, boolean tlsSecurity,
			String marcaTelef, String MacTelef, String anexo, String callerId,
			String passAnexo, String ipOpen, String timeZone, String empNom,
			String hashDirEmp, String passLdap,InstanciaServerAsterisk vm) throws Exception {
			String tipoBash="0";
		    final String file_server="fileserver.com";
			switch (tipoProduct) {
			case 1:
				//cloud
				if(tlsSecurity==true){
					tipoBash="3";
				}else tipoBash="1";
				break;
			case 2:
				//inhouse
				tipoBash="2";
				break;
			case 3:
				//hibrido
				if(tlsSecurity==true){
					tipoBash="3";
				}else tipoBash="1";
				break;
			default:
				break;
			}
	
			String provisioning = String.format(
					"sh %s %s %s %s %s %s %s %s %s %s %s %s %s",
					servicesProperties.getPathBashProvisioning(),tipoBash,marcaTelef,MacTelef,
					anexo,callerId,passAnexo,ipOpen,timeZone,empNom,hashDirEmp,passLdap,file_server);
			LinuxUtil.executeCommand(
					TipoServer.INSTANCIA_ASTERISK.getTipo(),
					infraestructuraUtil.instanciaACredencialesEquipo(vm),
					provisioning);
			System.out.println("generate_conf: "+provisioning);
	}
	
	public void bashUpdateProvisioning(String anexo, String callerId,
			String passAnexo,String idInstancia,InstanciaServerAsterisk vm) throws Exception {
			final String file_server="fileserver.com";
			
			String provisioning = String.format(
					"sh %s %s %s %s %s %s",
					servicesProperties.getPathBashUpdateProvisioning(),anexo,callerId,passAnexo,
					idInstancia, file_server);
			LinuxUtil.executeCommand(
					TipoServer.INSTANCIA_ASTERISK.getTipo(),
					infraestructuraUtil.instanciaACredencialesEquipo(vm),
					provisioning);
			System.out.println("update_conf: "+provisioning);
	}	

	public void updateOpenLdap(String callerId,String passAnexo,String idInstancia,String empresa,
			InstanciaServerAsterisk vm) throws Exception {		
			LinuxUtil.executeCommand(
					TipoServer.INSTANCIA_ASTERISK.getTipo(),
					infraestructuraUtil.instanciaACredencialesEquipo(vm),
												   "ldapdelete -D 'cn=Manager,dc="+empresa+",dc=com' -w "+passAnexo+" 'uid="+callerId+",ou=directorio-"+empresa+",dc="+empresa+",dc=com'");
			
			System.out.println("update_openldap: "+"ldapdelete -D 'cn=Manager,dc="+empresa+",dc=com' -w "+passAnexo+" 'uid="+callerId+",ou=directorio-"+empresa+",dc="+empresa+",dc=com'");
	}		
	
	public void bashDeleteProvisioning(String anexo,InstanciaServerAsterisk vm) throws Exception {
			
			String provisioning = String.format(
					"sh %s %s",
					servicesProperties.getPathBashDeleteProvisioning(),anexo);
			LinuxUtil.executeCommand(
					TipoServer.INSTANCIA_ASTERISK.getTipo(),
					infraestructuraUtil.instanciaACredencialesEquipo(vm),
					provisioning);
			System.out.println("delete_conf: "+provisioning);
	}
	
	@Override
	public void bastTlssRtp(String codUsuario, String idInstancia,
			InstanciaServerAsterisk vm,  String ipOpen,
			 String empNom,String passLdap,String anexo) throws Exception {
		ListaInstanciaRequest requestIns = new ListaInstanciaRequest();
		
		requestIns.setpIdInstanciaxDesc(instanciaServices.desincriptarIdInstancia(idInstancia));
		requestIns.setCodUsuario(codUsuario);
		
		if(instanciaServices.listaInstancia(codUsuario, requestIns)
				.getInstancias().get(0).getIsTls()){
			
			String provisioning = String.format(
					"python %s -c %s %s %s %s",
					servicesProperties.getBashPathTlssRtp(),ipOpen,empNom,passLdap,anexo);
			LinuxUtil.executeCommand(
					TipoServer.INSTANCIA_ASTERISK.getTipo(),
					infraestructuraUtil.instanciaACredencialesEquipo(vm),
					provisioning);			
		}				
	}

}
