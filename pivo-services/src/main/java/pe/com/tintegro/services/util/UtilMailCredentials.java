package pe.com.tintegro.services.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
public class UtilMailCredentials {
	@Autowired
	ServicesProperties servicesProp;
	public String dameCredenciales(int tipo){
		List<String> credenciales=new ArrayList<String>();
		credenciales.add(servicesProp.getCorreoRemitente());//REMITENTE
		credenciales.add(servicesProp.getCorreoPassRemitente());//PASSWORD(DEL REMITENTE)
		credenciales.add(servicesProp.getCorreoSeudonimo());//SEUDONIMO
		credenciales.add(servicesProp.getCorreoHost());//HOST
		credenciales.add(servicesProp.getCorreoPuerto());//PUERTO
		return credenciales.get(tipo-1);
	}
}
