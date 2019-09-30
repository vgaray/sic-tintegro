package pe.com.tintegro.services.util;

import org.springframework.stereotype.Component;

import pe.com.tintegro.dominio.EnvioMail;
import pe.com.tintegro.dominio.MailContent;

@Component
public class UtilMailContent {


	public static String generateContent(EnvioMail mail,MailContent content )
			throws Exception {
		String htmlMessage = "";
		boolean hasTemplate=content.isHasTemplate();
		String nombre=content.getUsuario();
		Integer tipoMensaje=content.getTipoMensaje();
		String link=content.getLink();
		switch (tipoMensaje) {
		case 1:
			mail.setAsunto("Cambio de Contraseña");
			break;
		case 2:
			mail.setAsunto("Notificación");
			break;

		default:
			break;
		}
		Integer tipoFirma=content.getTipoFirma();
		if (hasTemplate == true) {
			// 1:recuperación contraseña;
			// 2:notificación de incidente
			htmlMessage = UtilMailTemplate.obtenerMensajePredeterminado(tipoMensaje, nombre,link);
		} else {
			if (tipoFirma != null && tipoFirma > 0) { 
				// 1:firma a nombre de T-Integro;
				// 2:firma a nombre de xxx;
				htmlMessage = mail.getContenido()
						+ UtilMailTemplate.obtenerFirmaEmpresa(tipoFirma);
			} else {
				htmlMessage = mail.getContenido();
			}
		}
		return htmlMessage;
	}
}
