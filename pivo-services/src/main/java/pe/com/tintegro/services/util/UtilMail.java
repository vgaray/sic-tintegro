package pe.com.tintegro.services.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.pdf.codec.Base64;

import pe.com.tintegro.dominio.EnvioMail;

@Component("UtilMail")
public class UtilMail {
	@Autowired
	private ServicesProperties servicesProp;
	public boolean envioMail(EnvioMail datosMail) throws Exception {
		boolean enviado = false;
		// Datos Iniciales
		ArrayList<String> para = datosMail.getDestinatario();
		String asunto = datosMail.getAsunto();
		String contenido = datosMail.getContenido();

		String remitente = servicesProp.getCorreoRemitente();
		String passRemitente = servicesProp.getCorreoPassRemitente();
		String seudonimo = servicesProp.getCorreoSeudonimo();
		 //conexion
		String host = servicesProp.getCorreoHost();
		String port = servicesProp.getCorreoPuerto();
		boolean isCertificated = servicesProp.isCorreoIsCertificated();
		
		System.out.println("flag:" +isCertificated);
		//

		/*
		 * String remitente = servicesProp.getCorreoRemitente(); String
		 * passRemitente = servicesProp.getCorreoPassRemitente(); String
		 * seudonimo = servicesProp.getCorreoSeudonimo();
		 * 
		 * // conexion String host = servicesProp.getCorreoHost(); String port =
		 * servicesProp.getCorreoPuerto();
		 */
		

		//boolean isCertified = false;
		
		Properties propiedades = new Properties();
		if (isCertificated == true) {
			propiedades.put("mail.smtp.host", host);
			propiedades.put("mail.smtp.port", port);
			propiedades.put("mail.smtp.starttls.enable", "true");
			propiedades.put("mail.smtp.auth", "true");
			//propiedades.put("mail.smtp.user", remitente);
			//propiedades.put("mail.smtp.socketFactory.port", port); // SSL Port
			propiedades.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			
		} else {
			propiedades.put("mail.smtp.host", host); // SMTP Host
			propiedades.put("mail.smtp.socketFactory.port", port); // SSL Port
			propiedades.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
			propiedades.put("mail.smtp.auth", "true"); // Enabling SMTP
														// Authentication
			propiedades.put("mail.smtp.port", port); // SMTP Port
		}
		//System.getProperty("file.encoding");
		Session sesion = Session.getInstance(propiedades, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente,
						passRemitente);
			}
		});
		sesion.setDebug(true);
		try {
			MimeMessage mail = new MimeMessage(sesion);
			mail.setFrom(new InternetAddress(remitente));
			Address[] destinos = new Address[para.size()];
			Iterator<String> it = para.iterator();
			for (int i = 0; i < destinos.length; i++) {
				destinos[i] = new InternetAddress(it.next());
			}
			mail.addRecipients(Message.RecipientType.TO, destinos);
			mail.setSubject(asunto);
			Multipart multiparte = new MimeMultipart();
			// Contenido en html
			BodyPart htmlBodyPart = new MimeBodyPart(); // 4
			htmlBodyPart.setContent(contenido, "text/html"); // 5
			multiparte.addBodyPart(htmlBodyPart);

			// Adjuntar Archivo1
			if (datosMail.getLsDocumentos() == null) {
			} else {
				for (int i = 0; i < datosMail.getLsDocumentos().size(); i++) {
					BodyPart archivoAdjunto = new MimeBodyPart();
					archivoAdjunto.setText("");
					archivoAdjunto = new MimeBodyPart();
					String documento64 = datosMail.getLsDocumentos().get(i)
							.getFile64();
					byte[] parseBase64Binary1 = Base64.decode(documento64);
					File file = new File(datosMail.getLsDocumentos().get(i)
							.getExtensionFile());
					FileUtils.writeByteArrayToFile(file, parseBase64Binary1);
					DataSource fuente1 = new FileDataSource(
							file.getAbsolutePath());
					archivoAdjunto.setDataHandler(new DataHandler(fuente1));
					archivoAdjunto.setFileName(fuente1.getName());
					multiparte.addBodyPart(archivoAdjunto);
				}
			}
			// Salida
			mail.setContent(multiparte);
			Transport transport = sesion.getTransport("smtp");
			transport.connect(host, remitente, passRemitente);
			transport.sendMessage(mail, mail.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		enviado = true;
		return enviado;
	}
}
