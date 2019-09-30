package pe.com.tintegro.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.tintegro.dao.UsuarioDAO;
import pe.com.tintegro.dominio.EnvioMail;
import pe.com.tintegro.dominio.MailContent;
import pe.com.tintegro.dominio.Usuario;
import pe.com.tintegro.dto.request.ActualizaNuevaContrasenaRequest;
import pe.com.tintegro.dto.request.ActualizaUsuarioOauthRequest;
import pe.com.tintegro.dto.request.ActualizarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ConfirmarCambioContrasenaRequest;
import pe.com.tintegro.dto.request.EliminaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ActualizarPasswordRequest;
import pe.com.tintegro.dto.request.InsertaUsuarioOauthRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioPorCodigoRequest;
import pe.com.tintegro.dto.request.ValidarLoginUsuarioRequest;
import pe.com.tintegro.dto.response.ActualizaNuevaContrasenaResponse;
import pe.com.tintegro.dto.response.ActualizaUsuarioResponse;
import pe.com.tintegro.dto.response.ActualizarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.CheckTokenResponse;
import pe.com.tintegro.dto.response.ConfirmarCambioContrasenaResponse;
import pe.com.tintegro.dto.response.EliminaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ActualizarPasswordResponse;
import pe.com.tintegro.dto.response.InsertaUsuarioResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioPorCodigoResponse;
import pe.com.tintegro.dto.response.ValidarLoginUsuarioResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.UsuarioServices;
import pe.com.tintegro.services.util.EncriptaKeyUtils;
import pe.com.tintegro.services.util.EncriptaUtils;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.UtilMail;
import pe.com.tintegro.services.util.UtilMailContent;

@Service("usuarioServices")
@Transactional
public class UsuarioServicesImpl implements UsuarioServices
{
	@Resource(name = "usuarioDAO")
	protected UsuarioDAO usuarioDAO;
	@Autowired
	private ServicesProperties servicesProp;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	protected UtilMail serviceMail;

	
	@Autowired
	EncriptaKeyUtils encriptaKeyutils;
	
	


	@Override
	public ValidarLoginUsuarioResponse validaLoginUsuarioServices(ValidarLoginUsuarioRequest request) throws Exception
	{
		ValidarLoginUsuarioResponse response = new ValidarLoginUsuarioResponse();
		response = usuarioDAO.validarUsuario(request);
		return response;
	}

	@Override
	public InsertarUsuarioEstandarResponse insertarUsuarioEstandarServices(InsertarUsuarioEstandarRequest request) throws Exception
	{
		InsertarUsuarioEstandarResponse response = new InsertarUsuarioEstandarResponse();
		if (request.getIdInstancia() != null)
		{
			request.setIdInstanciadesc(instanciaServices.desincriptarIdInstancia(request.getIdInstancia()));			
		}
		else
		{
			request.setIdInstanciadesc(null);
		}
		
		InsertaUsuarioOauthRequest requestUsuario= new InsertaUsuarioOauthRequest();
		requestUsuario.setpNoCodUsuarioCreador(request.getCodUsuario());
		requestUsuario.setpTokeNCreador(request.getToken());	
		
		requestUsuario.setpNoApellidos(request.getNoApelli());
		requestUsuario.setpNoEmail(request.getEmail());
		requestUsuario.setpNologin(request.getNoLogin());
		requestUsuario.setpNoNombres(request.getNoNombre());
		requestUsuario.setpNoPassword(request.getNoPasswo());
		requestUsuario.setpNoProfe(request.getNoProfe());
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());			
		
		InsertaUsuarioResponse response1=new InsertaUsuarioResponse();
		
		String url = servicesProp.getWebOauthServer()+"/sic-oauth2-ws/oauth/usuario/registro";

		response1 = restTemplate.postForObject(url, requestUsuario, InsertaUsuarioResponse.class);	
		
		System.out.println(response1.getEstado()+ "----"+response1.getMensaje());		
		
		response = usuarioDAO.insertarUsuarioEstandar(request);
		return response;
	}

	@Override
	public ListaUsuarioEstandarResponse listaUsuarioServices(ListaUsuarioEstandarRequest request) throws Exception
	{
		ListaUsuarioEstandarResponse response = new ListaUsuarioEstandarResponse();
		if (request.getIdInstancia() != null)
		{
			request.setIdInstanciadesenc(instanciaServices.desincriptarIdInstancia(request.getIdInstancia()));
		}
		else
		{
			request.setIdInstanciadesenc(null);
		}
		response = usuarioDAO.listaUsuarioEstandar(request);
		return response;
	}

	@Override
	public EliminaUsuarioEstandarResponse eliminaUsuarioEstandarServices(EliminaUsuarioEstandarRequest request) throws Exception
	{
		EliminaUsuarioEstandarResponse response = new EliminaUsuarioEstandarResponse();
		request.setIdInstanciadesc(instanciaServices.desincriptarIdInstancia(request.getIdInstancia()));
		response = usuarioDAO.eliminarUsuarioEstandar(request);
		return response;
	}

	@Override
	public ActualizarUsuarioEstandarResponse actualizarUsuarioEstandarServices(ActualizarUsuarioEstandarRequest request) throws Exception
	{
		ActualizarUsuarioEstandarResponse response = new ActualizarUsuarioEstandarResponse();
		request.setIdInstanciadesenc(instanciaServices.desincriptarIdInstancia(request.getIdInstancia()));
		
		ActualizaUsuarioOauthRequest requestUsuario= new ActualizaUsuarioOauthRequest();
		requestUsuario.setpNoCodUsuarioCreador(request.getCodUsuario());
		requestUsuario.setpTokeNCreador(request.getToken());	
		
		requestUsuario.setpNoApellidos(request.getNoApellido());
		requestUsuario.setpNoEmail(request.getEmail());
		
		ListaUsuarioPorCodigoRequest requestUsuarioNew=new ListaUsuarioPorCodigoRequest();
		requestUsuarioNew.setpIdUsuario(request.getIdUsuario());	
		ListaUsuarioPorCodigoResponse responseUsuNew = new ListaUsuarioPorCodigoResponse();
		responseUsuNew=usuarioDAO.listarUsuarioPorCodigo(requestUsuarioNew);
		requestUsuario.setpNologin(responseUsuNew.getUsuarioList().get(0).getNoLogin()); //SERVICIO DE NOMBRE LOGIN		
		
		requestUsuario.setpNoNombres(request.getNoNombre());
		requestUsuario.setpNoPassword(request.getNoPasswo());
		requestUsuario.setpNoProfe(request.getNoProfe());
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());			
		
		ActualizaUsuarioResponse response1=new ActualizaUsuarioResponse();
		
		String url = servicesProp.getWebOauthServer()+"/sic-oauth2-ws/oauth/usuario/modificacion";

		response1 = restTemplate.postForObject(url, requestUsuario, ActualizaUsuarioResponse.class);	
		
		System.out.println(response1.getEstado()+ "----"+response1.getMensaje());			
		
		response = usuarioDAO.actualizarUsuarioEstandar(request);
		return response;
	}

	@Override
	public String encriptarIdInstancia(int idInstancia) throws Exception
	{
		String idInstanciaEncryp = "";
		idInstanciaEncryp = EncriptaUtils.encriptar(String.valueOf(idInstancia));
		return idInstanciaEncryp;
	}

	@Override
	public ActualizarPasswordResponse actualizarPassword(ActualizarPasswordRequest request) throws Exception
	{
		ActualizarPasswordResponse response = new ActualizarPasswordResponse();

		Timestamp obj = new Timestamp(new Date().getTime());
		String tokenDOS = obj.toString();
		System.out.println(obj.toString());
		String encripToken2 = encriptaKeyutils.encryptText(tokenDOS);
      
		System.out.println("Resultado:    " + encripToken2);
		EnvioMail requestMail = new EnvioMail();
		MailContent requestContent = new MailContent();
		ListaUsuarioPorCodigoRequest requestUsuario = new ListaUsuarioPorCodigoRequest();
		ListaUsuarioPorCodigoResponse responseUsu = new ListaUsuarioPorCodigoResponse();
		if (request.ispConfirmacion() == true)
		{
			requestContent.setHasTemplate(true);
			requestContent.setTipoMensaje(2);
			request.setpCodUsuario(EncriptaUtils.desencriptar(request.getpCodUsuario()));
			Timestamp conf = new Timestamp(new Date().getTime());
			String tokenTres = conf.toString();
			String encripToken3 = encriptaKeyutils.encryptText(tokenTres);
	      
			System.out.println("Resultado:    " + encripToken3);
			ConfirmarCambioContrasenaResponse responseConfirmaCambio=new ConfirmarCambioContrasenaResponse();
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			String url = servicesProp.getWebOauthServer()+"/sic-oauth2-ws/oauth/usuario/confirmacion_contrasena";
			
			ConfirmarCambioContrasenaRequest requestConfirmaCambio= new ConfirmarCambioContrasenaRequest();
			
			requestConfirmaCambio.setpCodUsuario(request.getpCodUsuario());
			requestConfirmaCambio.setpToken(request.getpToken());
			requestConfirmaCambio.setpTokenEncript(encripToken3);
			
			responseConfirmaCambio = restTemplate.postForObject(url, requestConfirmaCambio, ConfirmarCambioContrasenaResponse.class);
			System.out.println(responseConfirmaCambio.getEstado()+"---"+responseConfirmaCambio.getMensaje());
		}
		else
		{
			request.setpToken(String.valueOf(UUID.randomUUID()));
			requestContent.setHasTemplate(true);
			requestContent.setTipoMensaje(1);
			requestContent.setLink(builLink(request.getpCodUsuario(), request.getpToken()));
		}
		requestUsuario.setpCodUsuario(request.getpCodUsuario());
		responseUsu = usuarioDAO.listarUsuarioPorCodigo(requestUsuario);
		ArrayList<String> destinatarios = new ArrayList<String>();
		destinatarios.add(responseUsu.getUsuarioList().get(0).getEmail());
		requestMail.setDestinatario(destinatarios);
		requestContent.setUsuario(responseUsu.getUsuarioList().get(0).getNoNombre() + " " + responseUsu.getUsuarioList().get(0).getNoApellido());
		String mensaje = UtilMailContent.generateContent(requestMail, requestContent);
		requestMail.setContenido(mensaje);
		String enviado = "";
		response = usuarioDAO.actualizarPassword(request);
		if (response.getEstado() == 1 && request.ispConfirmacion() == false)
		{
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			String url = servicesProp.getWebOauthServer()+"/sic-oauth2-ws/oauth/usuario/nueva_contrasena";
			ActualizaNuevaContrasenaRequest requestOauthUpdate= new ActualizaNuevaContrasenaRequest();
			requestOauthUpdate.setpCodUsuario(request.getpCodUsuario());
			requestOauthUpdate.setpNewPassword(request.getpNewPassword());
			requestOauthUpdate.setpToken(request.getpToken());
			requestOauthUpdate.setpToken2(encripToken2);
			
			ActualizaNuevaContrasenaResponse responseOauthUpdate= new ActualizaNuevaContrasenaResponse();
			
			responseOauthUpdate = restTemplate.postForObject(url, requestOauthUpdate, ActualizaNuevaContrasenaResponse.class);
			
			System.out.println(responseOauthUpdate.getEstado() +"--"+ responseOauthUpdate.getMensaje());
		}
		enviado = enviarMail(requestMail);
		response.setMensaje(response.getMensaje() + enviado);
		return response;
	}

	@Override
	public String enviarMail(EnvioMail request) throws Exception {
		
		String Mensaje;
		Boolean enviado = serviceMail.envioMail(request);
		if (enviado == true) {

	
			Mensaje = "mail enviado";
		}
		else
		{
			Mensaje = "mail no enviado";
		}
		return Mensaje;
	}

	public String builLink(String codUsu, String token) throws Exception
	{
		String link = "";
		String codUsuEncryp = EncriptaUtils.encriptar(codUsu);

		String hostWeb=servicesProp.getWebServer();
		link = hostWeb+"/#!/login?codUsu="+codUsuEncryp+""+"&tokenUsu="+token;

		return link;
	}
}