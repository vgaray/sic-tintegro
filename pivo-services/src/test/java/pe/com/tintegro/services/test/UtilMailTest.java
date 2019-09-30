package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Document;
import pe.com.tintegro.dominio.EnvioMail;
import pe.com.tintegro.dominio.MailContent;
import pe.com.tintegro.services.util.UtilMailContent;
import pe.com.tintegro.services.util.UtilMailTemplate;
import pe.com.tintegro.services.util.UtilMail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class UtilMailTest {
	@Autowired
	UtilMail utilMail;
	UtilMailTemplate templateMail;
	@Test
	public void testEnviarMail() {
		try {
			//*********************************************************************//
			ArrayList<String> listaDestinos = new ArrayList<String>();
			listaDestinos.add("victor.garay@bitel.com.pe");
			//*********************************************************************//
			Document documento1 = new Document();
			documento1.setFile64("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ZG9iago5IDAgb2JqCjw8L01vZERhdGUoRDoyMDE3MDMyMDE1MTQxOS0wNScwMCcpL0NyZWF0b3IoSmFzcGVyUmVwb3J0cyBcKHJlcG9ydFJhbmtpbmdMbGFtYWRhc1wpKS9DcmVhdGlvbkRhdGUoRDoyMDE3MDMyMDE1MTQxOS0wNScwMCcpL1Byb2R1Y2VyKGlUZXh0IDIuMS43IGJ5IDFUM1hUKT4+CmVuZG9iagp4cmVmCjAgMTAKMDAwMDAwMDAwMCA2NTUzNSBmIAowMDAwMDAxMTk2IDAwMDAwIG4gCjAwMDAwMDE0NjUgMDAwMDAgbiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDAxNTUzIDAwMDAwIG4gCjAwMDAwMDE0MzAgMDAwMDAgbiAKMDAwMDAwMTYxNiAwMDAwMCBuIAowMDAwMDAxNjcwIDAwMDAwIG4gCjAwMDAwMDE3MDIgMDAwMDAgbiAKMDAwMDAwMTgwNSAwMDAwMCBuIAp0cmFpbGVyCjw8L0luZm8gOSAwIFIvSUQgWzxjMjA3Y2YxYTQ5ZTRmNWE1NjYyZmYxY2MwNTE1ZjVlOD48N2RkY2M1N2NiZmIyZWQyN2RmMWU0ZjZiYjhiZTc1YzQ+XS9Sb290IDggMCBSL1NpemUgMTA+PgpzdGFydHhyZWYKMTk3NgolJUVPRgo=");
			documento1.setExtensionFile("prueba.pdf");
			Document documento2 = new Document();
			documento2.setFile64("0M8R4KGxGuEAAAAAAAAAAAAAAAAAAAAAOwADAP7/CQAGAAAAAAAAAAAAAAABAAAACQAAAAAAAAAAEAAA/v///wAAAAD+////AAAAAAoAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8JCBAAAAYFANMQzAdBAAAABgAAAOEAAgCwBMEAAgAAAOIAAABcAHAADQAATWlndWVsX01hc2NjbyAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIEIAAgCwBGEBAgAAAD0BAgAAAJwAAgAOABkAAgAAABIAAgAAABMAAgAAAK8BAgAAALwBAgAAAD0AEgBoAQ4BXDq+IzgAAAAAAAEAWAJAAAIAAACNAAIAAAAiAAIAAAAOAAIAAQC3AQIAAADaAAIAAAAxABUAyAAAAP9/kAEAAAAAAAAFAEFyaWFsMQAVAMgAAAD/f5ABAAAAAAAABQBBcmlhbDEAFQDIAAAA/3+QAQAAAAAAAAUAQXJpYWwxABUAyAAAAP9/kAEAAAAAAAAFAEFyaWFsMQAZAPAAAAAJALwCAAAAAAAACQBTYW5z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AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIAAAD///////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgAAAP///////////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEAAAACAAAAAwAAAAQAAAAFAAAABgAAAAcAAAAIAAAA/v////7////+////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			documento2.setExtensionFile("prueba.xls");
			ArrayList<Document> listaDocumentos = new ArrayList<Document>();
			listaDocumentos.add(documento1);
			listaDocumentos.add(documento2);
			//*********************************************************************//
			EnvioMail mail = new EnvioMail();
			//mail.setRemitente("tintegro@t-integro.com");
			//mail.setPassRemitente("t1ntegr0s4c");
			mail.setDestinatario(listaDestinos);
			mail.setContenido("TODO OK");
			mail.setAsunto("Nuevo");
			mail.setSeudonimo("Pivo");
			mail.setLsDocumentos(listaDocumentos);
			MailContent content = new MailContent();
			content.setHasTemplate(false);
			content.setUsuario("Victor Hugo Garay");
			content.setTipoMensaje(2);
			content.setTipoFirma(2);
			String mensaje=UtilMailContent.generateContent(mail, content);
			mail.setContenido(mensaje);
			
		boolean enviado = utilMail.envioMail(mail);//hacer estático el método envioMail
			System.out.println("Intento");
			if (enviado) {
				System.out.println("Exitoso");
			} else
				System.out.println("Fallido");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
}