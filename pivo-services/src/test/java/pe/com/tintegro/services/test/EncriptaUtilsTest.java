package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.services.util.EncriptaUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class EncriptaUtilsTest 
{	
	@Test
	public void encriptarTest()
	{
		String textEncriptado;
		try
		{
			textEncriptado = EncriptaUtils.encriptar( "180" );
			System.out.println( textEncriptado );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@Test
	public void desencriptarTest()
	{
		try 
		{
			String textDesencriptado = EncriptaUtils.desencriptar( "jPfFl7Jg2rg=" );
			System.out.println( textDesencriptado );
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
