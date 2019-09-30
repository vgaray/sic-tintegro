package pe.com.tintegro.services.util;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component("servicesProperties")
public class ServicesProperties
{
	@Value("${bash_path.server_openvpn}")
	private String pathBashSeverOpenVPN;
	
	@Value("${correo_host}")
	private String correoHost;
	
	@Value("${correo_puerto}")
	private String correoPuerto;
	
	@Value("${correo_pass_remitente}")
	private String correoPassRemitente;
	
	@Value("${correo_remitente}")
	private String correoRemitente;
	
	@Value("${correo_seudonimo}")
	private String correoSeudonimo;
	
	@Value("${correo_is_Certificated}")
	private Boolean correoIsCertificated;
	
	@Value("${web_server}")
	private String webServer;

	@Value("${bash_path.crea_db_batch}")
	private String pathBashCreaDbBatch;

	@Value("${bash_path.fax_server_batch}")
	private String pathBashFaxServerBatch;

	@Value("${bash_path.files_asterisk_batch}")
	private String pathBashFilesAsteriskBatch;

	@Value("${bash_path.verify_service}")
	private String pathBashVerifyService;

	@Value("${bash_path.crear_sip}")
	private String pathBashGenerarCertificados;

	@Value("${bash_path.eliminar_sip}")
	private String pathBashEliminarCertificado;

	@Value("${bash_path.modificar_sip}")
	private String pathBashModificarCertificado;

	@Value("${bash_path.crear_sip_openvpn}")
	private String bashPathCrearSipOpenVPN;

	@Value("${path_folder_certificates.file_server}")
	private String pathFolderCertificatesFileServer;

	@Value("${path_folder_certificates.local_server}")
	private String pathFolderCertificatesLocalServer;

	@Value("${path_folder_aprovisionamiento.local_server_ftp}")
	private String pathFolderAprovisionamientoLocalServerFTP;

	@Value("${path_folder_aprovisionamiento.local_server_http}")
	private String pathFolderAprovisionamientoLocalServerHTTP;

	@Value("${instancia_asterisk.user}")
	private String instanciaAsteriskUser;

	@Value("${instancia_asterisk.password}")
	private String instanciaAsteriskPassword;

	@Value("${instancia_asterisk.port}")
	private int instanciaAsteriskPort;

	@Value("${bash_path.crear_aprovisionamiento_sip}")
	private String pathBashCrearAprovisionamiento;

	
	@Value("${file_server.dominio}")
	private String fileServerDominio;

	@Value("${file_server.user}")
	private String fileServerUser;

	@Value("${file_server.password}")
	private String fileServerPassword;

	@Value("${file_server.port}")
	private int fileServerPort;

	@Value("${file_server.host}")
	private String fileServerHost;
	
	@Value("${media_server.dominio}")
	private String mediaServerDominio;

	@Value("${media_server.user}")
	private String mediaServerUser;

	@Value("${media_server.password}")
	private String mediaServerPassword;

	@Value("${media_server.port}")
	private int mediaServerPort;

	@Value("${media_server.host}")
	private String mediaServerHost;

	@Value("${asterisk.open_vpn.dominio}")
	private String asteriskOpenVPNDominio;

	@Value("${bash_path}")
	private String pathBashName;

	@Value("${bash_path.crear_anexo_en_asterisk}")
	private String bashPathCrearAnexoEnAsterisk;

	@Value("${model_phone_not_provisioning}")
	private String modelPhoneNotProvisioning;

	@Value("${path.file.asterisk.ivr}")
	private String pathFileAsteriskIVR;

	@Value("${file.name.asterisk.ivr}")
	private String fileNameAsteriskIVR;

	@Value("${path.file.asterisk.ivr.sounds}")
	private String pathFileAsteriskIVRSounds;

	@Value("${folder.name.ivr.sounds}")
	private String folderNameIVRSounds;

	@Value("${path.file.asterisk.queue}")
	private String pathFileAsteriskQueue;

	@Value("${folder.name.queue}")
	private String folderNameQueue;

	@Value("${bash_path.registrar_correo_en_asterisk}")
	private String bashPathRegistrarCorreoEnAsterisk;

	@Value("${bash_path.monitorear_anexo_en_asterisk}")
	private String bashPathMonitorearAnexoEnAsterisk;

	@Value("${bash_path.mantener_anexo_en_asterisk}")
	private String bashPathMantenerAnexoEnAsterisk;
	
	@Value("${file.name.asterisk.queues}")
	private String fileNameAsteriskQueues;
	
	@Value("${bash_path.maintenaince_queues}")
	private String bashPathMaintenainceQueues;

	@Value("${path_download_credentials}")
	private String pathDownloadCredentials;

	@Value("${bash_path.editar_sip}")
	private String bashPathEditarSIP;

	@Value("${bash_path.eliminar_dir_sip}")
	private String bashPathEliminarDirSip;

	@Value("${bash_path.reutilizar_llaves_openvpn}")
	private String bashPathReutilizarLlavesOpenVPN;

	@Value("${bash_path.generar_certificado}")
	private String bashPathGenerarCertificado;

	@Value("${bash_path.empaquetar_not_provisioning}")
	private String bashPathEmpaquetarNotProvisioning;

	@Value("${bash_path.empaquetar_provisioning}")
	private String bashPathEmpaquetarProvisioning;

	@Value("${bash_path.status_sip}")
	private String bashPathStatusSIP;

	@Value("${path.file.sip.trunk}")
	private String pathFileSipTrunk;

	@Value("${file.name.sip.trunk}")
	private String fileNameSipTrunk;

	@Value("${file.name.custom.trunk.dundi.trunk}")
	private String fileNameCustomTrunkDundiTrunk;

	@Value("${file.name.custom.trunk.sip.trunk}")
	private String fileNameCustomTrunkSipTrunk;

	@Value("${file.name.custom.trunk.iax.trunk}")
	private String fileNameCustomTrunkIaxTrunk;

	@Value("${path.file.custom.trunk}")
	private String pathFileCustomTrunk;

	@Value("${path.file.iax.trunk}")
	private String pathFileIaxTrunk;

	@Value("${file.name.iax.trunk}")
	private String fileNameIaxTrunk;
	
	@Value("${file.name.extensions.iax}")
	private String fileNameIaxExtensions;

	public Boolean getCorreoIsCertificated() {
		return correoIsCertificated;
	}

	@Value("${path.file.grabaciones}")
	private String fileNameGrabaciones;
	
	@Value("${bash_path.generar_libreta}")
	private String bashPathGenerarLibreta;
	
	@Value("${bash_path_tlss_rtp}")
	private String bashPathTlssRtp;		
	
	@Value("${web_oauth_server}")
	private String webOauthServer;
		
	public String getWebOauthServer() {
		return webOauthServer;
	}

	public void setWebOauthServer(String webOauthServer) {
		this.webOauthServer = webOauthServer;
	}

	public String getBashPathTlssRtp() {
		return bashPathTlssRtp;
	}

	public void setBashPathTlssRtp(String bashPathTlssRtp) {
		this.bashPathTlssRtp = bashPathTlssRtp;
	}

	public String getBashPathGenerarLibreta()
	{
		return bashPathGenerarLibreta;
	}

	public void setBashPathGenerarLibreta(String bashPathGenerarLibreta)
	{
		this.bashPathGenerarLibreta = bashPathGenerarLibreta;
	}

	public String getFileNameGrabaciones() {
		return fileNameGrabaciones;
	}

	public void setFileNameGrabaciones(String fileNameGrabaciones) {
		this.fileNameGrabaciones = fileNameGrabaciones;
	}

	@Value("${path.file.plan.entrante}")
	private String pathFilePlanEntrante;

	@Value("${file.name.plan.entrante}")
	private String fileNamePlanEntrante;	

	@Value("${path.file.plan.principal}")
	private String pathFilePlanPrincipal;

	@Value("${file.name.plan.principal}")
	private String fileNamePlanPrincipal;			
	
	@Value("${path.file.queue}")
	private String pathFileQueue;

	@Value("${file.name.queue}")
	private String fileNameQueue;		
	
	@Value("${path.file.fax}")
	private String pathFileFax;

	@Value("${file.name.fax}")
	private String fileNameFax;	
	
	@Value("${path.file.asterisk.music.sounds}")
	private String pathFileAsteriskMusicSounds;
	
	@Value("${path.file.conferencia}")
	private String pathFileConferencias;
	
	@Value("${file.name.conferencia}")
	private String fileNameConferencias;
	
   @Value("${path.file.mediaserver.ivr.sounds}")
	private String pathFileMediaServerIvrSounds;
   
    @Value("${bash_path.provisioning}")
    private String pathBashProvisioning;   
    
    @Value("${bash_path.update_provisioning}")
    private String pathBashUpdateProvisioning;          
    
	@Value("${bash_path.delete_provisioning}")
	private String pathBashDeleteProvisioning;  
	
	@Value("${path_folder_aprovisionamiento.file_server}")
	private String pathFolderAprosionamientoFileServer;	
	
    public String getPathFolderAprosionamientoFileServer() {
		return pathFolderAprosionamientoFileServer;
	}

	public void setPathFolderAprosionamientoFileServer(
			String pathFolderAprosionamientoFileServer) {
		this.pathFolderAprosionamientoFileServer = pathFolderAprosionamientoFileServer;
	}

	public String getPathBashDeleteProvisioning() {
		return pathBashDeleteProvisioning;
	}

	public void setPathBashDeleteProvisioning(String pathBashDeleteProvisioning) {
		this.pathBashDeleteProvisioning = pathBashDeleteProvisioning;
	}

	public String getPathBashUpdateProvisioning() {
		return pathBashUpdateProvisioning;
	}

	public void setPathBashUpdateProvisioning(String pathBashUpdateProvisioning) {
		this.pathBashUpdateProvisioning = pathBashUpdateProvisioning;
	}

	@Value("${bash_path.create_directory_fileServer}")
    private String pathBashCreateDirectoryFileServer;
    
	public String getPathBashCreateDirectoryFileServer() {
		return pathBashCreateDirectoryFileServer;
	}

	public void setPathBashCreateDirectoryFileServer(
			String pathBashCreateDirectoryFileServer) {
		this.pathBashCreateDirectoryFileServer = pathBashCreateDirectoryFileServer;
	}

	public String getPathBashProvisioning() {
		return pathBashProvisioning;
	}

	public void setPathBashProvisioning(String pathBashProvisioning) {
		this.pathBashProvisioning = pathBashProvisioning;
	}

	@Value("${path_folder_empresa_ldif}")
	private String pathFolderEmpresaLdif;	
	
	public String getPathFolderEmpresaLdif()
	{
		return pathFolderEmpresaLdif;
	}

	public void setPathFolderEmpresaLdif(String pathFolderEmpresaLdif)
	{
		this.pathFolderEmpresaLdif = pathFolderEmpresaLdif;
	}

	public String getPathFileConferencias() {
		return pathFileConferencias;
	}

	public void setPathFileConferencias(String pathFileConferencias) {
		this.pathFileConferencias = pathFileConferencias;
	}

	public String getFileNameConferencias() {
		return fileNameConferencias;
	}

	public void setFileNameConferencias(String fileNameConferencias) {
		this.fileNameConferencias = fileNameConferencias;
	}

	public String getBashPathMaintenainceQueues()
	{
		return bashPathMaintenainceQueues;
	}

	public void setBashPathMaintenainceQueues(String bashPathMaintenainceQueues)
	{
		this.bashPathMaintenainceQueues = bashPathMaintenainceQueues;
	}

	public String getFileNameAsteriskQueues()
	{
		return fileNameAsteriskQueues;
	}

	public void setFileNameAsteriskQueues(String fileNameAsteriskQueues)
	{
		this.fileNameAsteriskQueues = fileNameAsteriskQueues;
	}


	
	public String getPathFileFax()
	{
		return pathFileFax;
	}

	public void setPathFileFax(String pathFileFax)
	{
		this.pathFileFax = pathFileFax;
	}

	public String getFileNameFax()
	{
		return fileNameFax;
	}

	public void setFileNameFax(String fileNameFax)
	{
		this.fileNameFax = fileNameFax;
	}

	public String getPathFileQueue()
	{
		return pathFileQueue;
	}

	public void setPathFileQueue(String pathFileQueue)
	{
		this.pathFileQueue = pathFileQueue;
	}

	public String getFileNameQueue()
	{
		return fileNameQueue;
	}

	public void setFileNameQueue(String fileNameQueue)
	{
		this.fileNameQueue = fileNameQueue;
	}

	public String getPathFilePlanPrincipal()
	{
		return pathFilePlanPrincipal;
	}

	public void setPathFilePlanPrincipal(String pathFilePlanPrincipal)
	{
		this.pathFilePlanPrincipal = pathFilePlanPrincipal;
	}

	public String getFileNamePlanPrincipal()
	{
		return fileNamePlanPrincipal;
	}

	public void setFileNamePlanPrincipal(String fileNamePlanPrincipal)
	{
		this.fileNamePlanPrincipal = fileNamePlanPrincipal;
	}

	public String getBashPathStatusSIP()
	{
		return bashPathStatusSIP;
	}

	public void setBashPathStatusSIP(String bashPathStatusSIP)
	{
		this.bashPathStatusSIP = bashPathStatusSIP;
	}

	public String getBashPathEmpaquetarNotProvisioning()
	{
		return bashPathEmpaquetarNotProvisioning;
	}

	public void setBashPathEmpaquetarNotProvisioning(String bashPathEmpaquetarNotProvisioning)
	{
		this.bashPathEmpaquetarNotProvisioning = bashPathEmpaquetarNotProvisioning;
	}

	public String getBashPathEmpaquetarProvisioning()
	{
		return bashPathEmpaquetarProvisioning;
	}

	public void setBashPathEmpaquetarProvisioning(String bashPathEmpaquetarProvisioning)
	{
		this.bashPathEmpaquetarProvisioning = bashPathEmpaquetarProvisioning;
	}

	public String getBashPathGenerarCertificado()
	{
		return bashPathGenerarCertificado;
	}

	public void setBashPathGenerarCertificado(String bashPathGenerarCertificado)
	{
		this.bashPathGenerarCertificado = bashPathGenerarCertificado;
	}

	public String getBashPathEliminarDirSip()
	{
		return bashPathEliminarDirSip;
	}

	public void setBashPathEliminarDirSip(String bashPathEliminarDirSip)
	{
		this.bashPathEliminarDirSip = bashPathEliminarDirSip;
	}

	public String getBashPathReutilizarLlavesOpenVPN()
	{
		return bashPathReutilizarLlavesOpenVPN;
	}

	public void setBashPathReutilizarLlavesOpenVPN(String bashPathReutilizarLlavesOpenVPN)
	{
		this.bashPathReutilizarLlavesOpenVPN = bashPathReutilizarLlavesOpenVPN;
	}

	public String getBashPathEditarSIP()
	{
		return bashPathEditarSIP;
	}

	public void setBashPathEditarSIP(String bashPathEditarSIP)
	{
		this.bashPathEditarSIP = bashPathEditarSIP;
	}

	public String getPathDownloadCredentials()
	{
		return pathDownloadCredentials;
	}

	public void setPathDownloadCredentials(String pathDownloadCredentials)
	{
		this.pathDownloadCredentials = pathDownloadCredentials;
	}

	public String getBashPathMantenerAnexoEnAsterisk()
	{
		return bashPathMantenerAnexoEnAsterisk;
	}

	public void setBashPathMantenerAnexoEnAsterisk(String bashPathMantenerAnexoEnAsterisk)
	{
		this.bashPathMantenerAnexoEnAsterisk = bashPathMantenerAnexoEnAsterisk;
	}

	public String getBashPathRegistrarCorreoEnAsterisk()
	{
		return bashPathRegistrarCorreoEnAsterisk;
	}

	public void setBashPathRegistrarCorreoEnAsterisk(String bashPathRegistrarCorreoEnAsterisk)
	{
		this.bashPathRegistrarCorreoEnAsterisk = bashPathRegistrarCorreoEnAsterisk;
	}

	public String getBashPathMonitorearAnexoEnAsterisk()
	{
		return bashPathMonitorearAnexoEnAsterisk;
	}

	public void setBashPathMonitorearAnexoEnAsterisk(String bashPathMonitorearAnexoEnAsterisk)
	{
		this.bashPathMonitorearAnexoEnAsterisk = bashPathMonitorearAnexoEnAsterisk;
	}

	public String getFolderNameIVRSounds()
	{
		return folderNameIVRSounds;
	}

	public void setFolderNameIVRSounds(String folderNameIVRSounds)
	{
		this.folderNameIVRSounds = folderNameIVRSounds;
	}

	public String getPathFileAsteriskIVRSounds()
	{
		return pathFileAsteriskIVRSounds;
	}

	public void setPathFileAsteriskIVRSounds(String pathFileAsteriskIVRSounds)
	{
		this.pathFileAsteriskIVRSounds = pathFileAsteriskIVRSounds;
	}

	public String getFileNameAsteriskIVR()
	{
		return fileNameAsteriskIVR;
	}

	public void setFileNameAsteriskIVR(String fileNameAsteriskIVR)
	{
		this.fileNameAsteriskIVR = fileNameAsteriskIVR;
	}

	public String getPathFileAsteriskIVR()
	{
		return pathFileAsteriskIVR;
	}

	public void setPathFileAsteriskIVR(String pathFileAsteriskIVR)
	{
		this.pathFileAsteriskIVR = pathFileAsteriskIVR;
	}

	public String getPathBashVerifyService()
	{
		return pathBashVerifyService;
	}

	public void setPathBashVerifyService(String pathBashVerifyService)
	{
		this.pathBashVerifyService = pathBashVerifyService;
	}

	public String getPathBashCreaDbBatch()
	{
		return pathBashCreaDbBatch;
	}

	public void setPathBashCreaDbBatch(String pathBashCreaDbBatch)
	{
		this.pathBashCreaDbBatch = pathBashCreaDbBatch;
	}

	public String getPathBashFaxServerBatch()
	{
		return pathBashFaxServerBatch;
	}

	public void setPathBashFaxServerBatch(String pathBashFaxServerBatch)
	{
		this.pathBashFaxServerBatch = pathBashFaxServerBatch;
	}

	public String getPathBashFilesAsteriskBatch()
	{
		return pathBashFilesAsteriskBatch;
	}

	public void setPathBashFilesAsteriskBatch(String pathBashFilesAsteriskBatch)
	{
		this.pathBashFilesAsteriskBatch = pathBashFilesAsteriskBatch;
	}

	public String getModelPhoneNotProvisioning()
	{
		return modelPhoneNotProvisioning;
	}

	public void setModelPhoneNotProvisioning(String modelPhoneNotProvisioning)
	{
		this.modelPhoneNotProvisioning = modelPhoneNotProvisioning;
	}

	public String getBashPathCrearSipOpenVPN()
	{
		return bashPathCrearSipOpenVPN;
	}

	public void setBashPathCrearSipOpenVPN(String bashPathCrearSipOpenVPN)
	{
		this.bashPathCrearSipOpenVPN = bashPathCrearSipOpenVPN;
	}

	public String getBashPathCrearAnexoEnAsterisk()
	{
		return bashPathCrearAnexoEnAsterisk;
	}

	public void setBashPathCrearAnexoEnAsterisk(String bashPathCrearAnexoEnAsterisk)
	{
		this.bashPathCrearAnexoEnAsterisk = bashPathCrearAnexoEnAsterisk;
	}

	public String getPathBashName()
	{
		return pathBashName;
	}

	public void setPathBashName(String pathBashName)
	{
		this.pathBashName = pathBashName;
	}

	public String getFileServerUser()
	{
		return fileServerUser;
	}

	public void setFileServerUser(String fileServerUser)
	{
		this.fileServerUser = fileServerUser;
	}

	public String getFileServerPassword()
	{
		return fileServerPassword;
	}

	public void setFileServerPassword(String fileServerPassword)
	{
		this.fileServerPassword = fileServerPassword;
	}

	public int getFileServerPort()
	{
		return fileServerPort;
	}

	public void setFileServerPort(int fileServerPort)
	{
		this.fileServerPort = fileServerPort;
	}

	public String getFileServerHost()
	{
		return fileServerHost;
	}

	public void setFileServerHost(String fileServerHost)
	{
		this.fileServerHost = fileServerHost;
	}

	public String getAsteriskOpenVPNDominio()
	{
		return asteriskOpenVPNDominio;
	}

	public void setAsteriskOpenVPNDominio(String asteriskOpenVPNDominio)
	{
		this.asteriskOpenVPNDominio = asteriskOpenVPNDominio;
	}

	public String getFileServerDominio()
	{
		return fileServerDominio;
	}

	public void setFileServerDominio(String fileServerDominio)
	{
		this.fileServerDominio = fileServerDominio;
	}

	public String getPathBashCrearAprovisionamiento()
	{
		return pathBashCrearAprovisionamiento;
	}

	public void setPathBashCrearAprovisionamiento(String pathBashCrearAprovisionamiento)
	{
		this.pathBashCrearAprovisionamiento = pathBashCrearAprovisionamiento;
	}

	public String getInstanciaAsteriskUser()
	{
		return instanciaAsteriskUser;
	}

	public void setInstanciaAsteriskUser(String instanciaAsteriskUser)
	{
		this.instanciaAsteriskUser = instanciaAsteriskUser;
	}

	public String getInstanciaAsteriskPassword()
	{
		return instanciaAsteriskPassword;
	}

	public void setInstanciaAsteriskPassword(String instanciaAsteriskPassword)
	{
		this.instanciaAsteriskPassword = instanciaAsteriskPassword;
	}

	public int getInstanciaAsteriskPort()
	{
		return instanciaAsteriskPort;
	}

	public void setInstanciaAsteriskPort(int instanciaAsteriskPort)
	{
		this.instanciaAsteriskPort = instanciaAsteriskPort;
	}

	public String getPathBashSeverOpenVPN()
	{
		return pathBashSeverOpenVPN;
	}

	public void setPathBashSeverOpenVPN(String pathBashSeverOpenVPN)
	{
		this.pathBashSeverOpenVPN = pathBashSeverOpenVPN;
	}

	public String getPathBashGenerarCertificados()
	{
		return pathBashGenerarCertificados;
	}

	public void setPathBashGenerarCertificados(String pathBashGenerarCertificados)
	{
		this.pathBashGenerarCertificados = pathBashGenerarCertificados;
	}

	public String getPathBashEliminarCertificado()
	{
		return pathBashEliminarCertificado;
	}

	public void setPathBashEliminarCertificado(String pathBashEliminarCertificado)
	{
		this.pathBashEliminarCertificado = pathBashEliminarCertificado;
	}

	public String getPathBashModificarCertificado()
	{
		return pathBashModificarCertificado;
	}

	public void setPathBashModificarCertificado(String pathBashModificarCertificado)
	{
		this.pathBashModificarCertificado = pathBashModificarCertificado;
	}

	public String getPathFolderCertificatesFileServer()
	{
		return pathFolderCertificatesFileServer;
	}

	public void setPathFolderCertificatesFileServer(String pathFolderCertificatesFileServer)
	{
		this.pathFolderCertificatesFileServer = pathFolderCertificatesFileServer;
	}

	public String getPathFolderCertificatesLocalServer()
	{
		return pathFolderCertificatesLocalServer;
	}

	public void setPathFolderCertificatesLocalServer(String pathFolderCertificatesLocalServer)
	{
		this.pathFolderCertificatesLocalServer = pathFolderCertificatesLocalServer;
	}

	public String getPathFolderAprovisionamientoLocalServerFTP()
	{
		return pathFolderAprovisionamientoLocalServerFTP;
	}

	public void setPathFolderAprovisionamientoLocalServerFTP(String pathFolderAprovisionamientoLocalServerFTP)
	{
		this.pathFolderAprovisionamientoLocalServerFTP = pathFolderAprovisionamientoLocalServerFTP;
	}

	public String getPathFolderAprovisionamientoLocalServerHTTP()
	{
		return pathFolderAprovisionamientoLocalServerHTTP;
	}

	public void setPathFolderAprovisionamientoLocalServerHTTP(String pathFolderAprovisionamientoLocalServerHTTP)
	{
		this.pathFolderAprovisionamientoLocalServerHTTP = pathFolderAprovisionamientoLocalServerHTTP;
	}

	public String getPathFileAsteriskQueue()
	{
		return pathFileAsteriskQueue;
	}

	public void setPathFileAsteriskQueue(String pathFileAsteriskQueue)
	{
		this.pathFileAsteriskQueue = pathFileAsteriskQueue;
	}

	public String getFolderNameQueue()
	{
		return folderNameQueue;
	}

	public void setFolderNameQueue(String folderNameQueue)
	{
		this.folderNameQueue = folderNameQueue;
	}

	public String getPathFileSipTrunk()
	{
		return pathFileSipTrunk;
	}

	public void setPathFileSipTrunk(String pathFileSipTrunk)
	{
		this.pathFileSipTrunk = pathFileSipTrunk;
	}

	public String getFileNameSipTrunk()
	{
		return fileNameSipTrunk;
	}

	public void setFileNameSipTrunk(String fileNameSipTrunk)
	{
		this.fileNameSipTrunk = fileNameSipTrunk;
	}

	public String getFileNameCustomTrunkDundiTrunk()
	{
		return fileNameCustomTrunkDundiTrunk;
	}

	public void setFileNameCustomTrunkDundiTrunk(String fileNameCustomTrunkDundiTrunk)
	{
		this.fileNameCustomTrunkDundiTrunk = fileNameCustomTrunkDundiTrunk;
	}

	public String getPathFileCustomTrunk()
	{
		return pathFileCustomTrunk;
	}

	public void setPathFileCustomTrunk(String pathFileCustomTrunk)
	{
		this.pathFileCustomTrunk = pathFileCustomTrunk;
	}

	public String getFileNameCustomTrunkSipTrunk()
	{
		return fileNameCustomTrunkSipTrunk;
	}

	public void setFileNameCustomTrunkSipTrunk(String fileNameCustomTrunkSipTrunk)
	{
		this.fileNameCustomTrunkSipTrunk = fileNameCustomTrunkSipTrunk;
	}

	public String getFileNameCustomTrunkIaxTrunk()
	{
		return fileNameCustomTrunkIaxTrunk;
	}

	public void setFileNameCustomTrunkIaxTrunk(String fileNameCustomTrunkIaxTrunk)
	{
		this.fileNameCustomTrunkIaxTrunk = fileNameCustomTrunkIaxTrunk;
	}

	public String getPathFileIaxTrunk()
	{
		return pathFileIaxTrunk;
	}

	public void setPathFileIaxTrunk(String pathFileIaxTrunk)
	{
		this.pathFileIaxTrunk = pathFileIaxTrunk;
	}

	public String getFileNameIaxTrunk()
	{
		return fileNameIaxTrunk;
	}

	public void setFileNameIaxTrunk(String fileNameIaxTrunk)
	{
		this.fileNameIaxTrunk = fileNameIaxTrunk;
	}

	public String getPathFilePlanEntrante()
	{
		return pathFilePlanEntrante;
	}

	public void setPathFilePlanEntrante(String pathFilePlanEntrante)
	{
		this.pathFilePlanEntrante = pathFilePlanEntrante;
	}

	public String getFileNamePlanEntrante()
	{
		return fileNamePlanEntrante;
	}

	public void setFileNamePlanEntrante(String fileNamePlanEntrante)
	{
		this.fileNamePlanEntrante = fileNamePlanEntrante;
	}

	public String getPathFileAsteriskMusicSounds()
	{
		return pathFileAsteriskMusicSounds;
	}

	public void setPathFileAsteriskMusicSounds(String pathFileAsteriskMusicSounds)
	{
		this.pathFileAsteriskMusicSounds = pathFileAsteriskMusicSounds;
	}

	public String getMediaServerDominio()
	{
		return mediaServerDominio;
	}

	public void setMediaServerDominio(String mediaServerDominio)
	{
		this.mediaServerDominio = mediaServerDominio;
	}

	public String getMediaServerUser()
	{
		return mediaServerUser;
	}

	public void setMediaServerUser(String mediaServerUser)
	{
		this.mediaServerUser = mediaServerUser;
	}

	public String getMediaServerPassword()
	{
		return mediaServerPassword;
	}

	public void setMediaServerPassword(String mediaServerPassword)
	{
		this.mediaServerPassword = mediaServerPassword;
	}

	public int getMediaServerPort()
	{
		return mediaServerPort;
	}

	public void setMediaServerPort(int mediaServerPort)
	{
		this.mediaServerPort = mediaServerPort;
	}

	public String getMediaServerHost()
	{
		return mediaServerHost;
	}

	public void setMediaServerHost(String mediaServerHost)
	{
		this.mediaServerHost = mediaServerHost;
	}

	public String getPathFileMediaServerIvrSounds()
	{
		return pathFileMediaServerIvrSounds;
	}

	public void setPathFileMediaServerIvrSounds(String pathFileMediaServerIvrSounds)
	{
		this.pathFileMediaServerIvrSounds = pathFileMediaServerIvrSounds;
	}
	public String getCorreoHost() {
		return correoHost;
	}

	public void setCorreoHost(String correoHost) {
		this.correoHost = correoHost;
	}

	public String getCorreoPuerto() {
		return correoPuerto;
	}

	public void setCorreoPuerto(String correoPuerto) {
		this.correoPuerto = correoPuerto;
	}

	public String getCorreoPassRemitente() {
		return correoPassRemitente;
	}

	public void setCorreoPassRemitente(String correoPassRemitente) {
		this.correoPassRemitente = correoPassRemitente;
	}

	public String getCorreoRemitente() {
		return correoRemitente;
	}

	public void setCorreoRemitente(String correoRemitente) {
		this.correoRemitente = correoRemitente;
	}

	public String getCorreoSeudonimo() {
		return correoSeudonimo;
	}

	public void setCorreoSeudonimo(String correoSeudonimo) {
		this.correoSeudonimo = correoSeudonimo;
	}
	public Boolean isCorreoIsCertificated() {
		return correoIsCertificated;
	}

	public void setCorreoIsCertificated(Boolean correoIsCertificated) {
		this.correoIsCertificated = correoIsCertificated;
	}
	public String getWebServer() {
		return webServer;
	}

	public void setWebServer(String webServer) {
		this.webServer = webServer;
	}
	public String getFileNameIaxExtensions() {
		return fileNameIaxExtensions;
	}

	public void setFileNameIaxExtensions(String fileNameIaxExtensions) {
		this.fileNameIaxExtensions = fileNameIaxExtensions;
	}
}