package pe.com.tintegro.services;

import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dto.request.CheckTokenRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAInstanciaRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAServicioRequest;
import pe.com.tintegro.dto.response.ValidaAccesoAInstanciaResponse;
import pe.com.tintegro.dto.response.ValidaAccesoAServicioResponse;
import pe.com.tintegro.dto.response.ValidaAccessTokenResponse;

public interface SeguridadServices
{
	public ValidaAccesoAServicioResponse validarAccesoAServicio(ValidaAccesoAServicioRequest request) throws Exception;

	public ValidaAccesoAInstanciaResponse validarAccesoAInstancia(ValidaAccesoAInstanciaRequest request) throws Exception;

	public ValidaAccessTokenResponse validarAccessToken(CheckTokenRequest request) throws Exception;
	
	public Confirmacion validarIDInstancia( String idInstancia ) throws Exception;
}
