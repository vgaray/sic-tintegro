package pe.com.tintegro.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dto.request.CheckTokenRequest;

import pe.com.tintegro.dto.request.ValidaAccesoAInstanciaRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAServicioRequest;

import pe.com.tintegro.services.SeguridadServices;
import pe.com.tintegro.services.util.Util;

public class SeguridadInterceptor extends HandlerInterceptorAdapter
{

	private static final String[] ALLOWED_RESOURCES = { "springfox-swagger-ui", "swagger-resources", "api-docs", "/pivo-ws/usuario/actualizarPassword"};

	
	private static final Logger LOG = Logger.getLogger( SeguridadInterceptor.class );
	
	private static final String CLIENT_ID = "pivo-frontend";

	@Resource(name = "seguridadServices")
	protected SeguridadServices seguridadServices;
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		
		//response.setHeader("Access-Control-Allow-Origin", "*");
		//response.setHeader("Access-Control-Allow-Origin", "http://192.168.3.147:3000");
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod()))
		{
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS,PUT,DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "Authorization,x-requested-with,Content-Type,Accept,x-auth-token,x-xsrf-token,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Access-Control-Allow-Origin,Content-Type,codUsuario,token,idInstancia");
			
			return true;
		}

		String URL = request.getRequestURI();
		String codUsuario = request.getHeader("codUsuario");
		String token = request.getHeader("token");
		String idInstancia = request.getHeader("idInstancia");
		boolean flEnviaIDInstancia = idInstancia != null && !idInstancia.equals("null");

		
		boolean requestAllowed = isResourceAllowed(URL);

		if (requestAllowed)
		{
			return true;
		}
	   
		
		try
		{
			
			
			
			Confirmacion confirmacion = seguridadServices.validarIDInstancia(idInstancia);

			if (confirmacion.getID() == Constantes.ESTADO_TRAMA_OK)
			{
				CheckTokenRequest ctRequest = new CheckTokenRequest();
				ctRequest.setClientId(CLIENT_ID);
				ctRequest.setToken(token);
            ctRequest.setCodUsuario(codUsuario);
				confirmacion = seguridadServices.validarAccessToken(ctRequest).getConfirmacion();

				if (confirmacion.getID() == Constantes.ESTADO_TRAMA_OK)
				{
					ValidaAccesoAServicioRequest vasRequest = new ValidaAccesoAServicioRequest();
					vasRequest.setNoLogin(codUsuario);
					vasRequest.setNoUrl(URL);
					vasRequest.setIlIstancia(flEnviaIDInstancia);

					confirmacion = seguridadServices.validarAccesoAServicio(vasRequest).getConfirmacion();

					if (confirmacion.getID() == Constantes.ESTADO_TRAMA_OK)
					{
						if (flEnviaIDInstancia)
						{
							ValidaAccesoAInstanciaRequest vaiRequest = new ValidaAccesoAInstanciaRequest();
							vaiRequest.setIdInstancia(idInstancia);
							vaiRequest.setNoLogin(codUsuario);

							confirmacion = seguridadServices.validarAccesoAInstancia(vaiRequest).getConfirmacion();

							if (confirmacion.getID() == Constantes.ESTADO_TRAMA_OK)
							{
								return true;
							}
							else
							{
								response.sendError(HttpServletResponse.SC_UNAUTHORIZED, confirmacion.getMensaje());
								return false;
							}
						}
						else
						{
							return true;
						}
					}
					else
					{
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, confirmacion.getMensaje());
						return false;
					}
				}
				else
				{
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, confirmacion.getMensaje());
					return false;
				}
			}
			else
			{
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, confirmacion.getMensaje());
				return false;
			}
		}
		catch (Exception e)
		{
			String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			String mensaje = "Ocurrio un error en la intercepcion del servicio web.";
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.format( "%s-%s", codigoError, mensaje ) );
			LOG.error( codigoError, e );
			
			return false;
		}
	}

	private boolean isResourceAllowed(String resource)
	{
		for (String rscAllowed : ALLOWED_RESOURCES)
		{
			if (resource.indexOf(rscAllowed) != -1)
			{
				return true;
			}
		}

		return false;
	}
}
