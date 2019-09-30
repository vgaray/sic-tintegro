package pe.com.tintegro.connection;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PostgreSQLTest
{
	private PostgreSQL datasource;

	@Before
	public void preTest()
	{
		datasource = new PostgreSQL();
	}

	@Test
	@Ignore
	public void conectarTest()
	{
		try
		{
			Connection connection = datasource.conectar("127.0.0.0");
			System.out.println("Hashcode: " + connection.hashCode());
			System.out.println("JDBC Driver: " + connection.getMetaData().getDriverName());
			System.out.println("URI DB: " + connection.getMetaData().getURL());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void cerrarTest()
	{
		try
		{
			datasource.cerrar();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
