package pe.com.tintegro.connection;

import java.sql.Connection;

public class PostgreSQL
{
	public Connection con;
	/*
	private static String user = "tintegro";
	private static String password = "ts1ct1nt3gr0";
	 * */
	private static String user = "postgres";
	private static String password = "postgres";
	private static String port = "5432";
	private static String database = "bd_pivo";

	public Connection conectar(String IP) throws Exception
	{
		con = SICConnection.getInstance(user, password, IP, port, database);

		return con;
	}
	
	public void cerrar() throws Exception
	{
		// Cierra la conexión para devolverlos al grupo. En lugar de connection.close();
//		Utils.closeQuietly(con);
		if( con != null )
		{
			con.close();
			con = null;
			System.out.println( "Conexion liberada." );
		}
	}
}
