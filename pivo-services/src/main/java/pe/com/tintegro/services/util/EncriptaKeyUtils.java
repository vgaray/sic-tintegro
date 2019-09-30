package pe.com.tintegro.services.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component("encriptaKey")
public class EncriptaKeyUtils
{
	private Cipher cipher;

	@Value("classpath:privateKey")
	private Resource privateKey;
	
	public EncriptaKeyUtils()
	{

		// Inicialización de la llave
		try
		{
			cipher = Cipher.getInstance("RSA");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public PrivateKey getPrivate(String filename) throws Exception {
		
		 
//	   URL url=privateKey.getURL();
//		System.out.println(url.toString());
		
		InputStream inputStream = privateKey.getInputStream();
		File plantillaTemp = File.createTempFile("test", "");
		
		try {
			FileUtils.copyInputStreamToFile(inputStream, plantillaTemp);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
		
		byte[] keyBytes = Files.readAllBytes(plantillaTemp.toPath());
		
//		File f= privateKey.getFile();
//		byte[] keyBytes = Files.readAllBytes(f.toPath());
		
		System.out.println(keyBytes.toString());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		
		
		
		return kf.generatePrivate(spec);
	}
	
	
	public String encryptText(String msg) throws Exception{
		
		
		PrivateKey key = getPrivate("privateKey");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return Base64.encodeBase64String(cipher.doFinal(msg.getBytes("UTF-8")));
	}
}
