package pe.com.tintegro.services;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.SipTelefono;

public interface AprovisionamientoServices
{
	public boolean generateProvisioning( String codUsuario, Integer puertoOpenVPN, SipBuddie sipBuddie, SipTelefono sipTelefono, InstanciaServerAsterisk vm ) throws Exception;
	
	public boolean redirectFileConfigurationSip( String codUsuario , SipTelefono sipTelefono , String idInstancia  ) throws Exception;
	
	public boolean redirectKeysOpenVPN( String codUsuario , SipBuddie buddie , SipTelefono sipTelefono , boolean isProvisioning , InstanciaServerAsterisk vm , String idInstancia  ) throws Exception;
}
