package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Horario;
import pe.com.tintegro.dto.request.EditaHorarioRequest;
import pe.com.tintegro.dto.request.EliminaHorarioRequest;
import pe.com.tintegro.dto.request.InsertaHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorarioRequest;
import pe.com.tintegro.dto.request.ListaPorIdHorarioRequest;
import pe.com.tintegro.dto.response.EditaHorarioResponse;
import pe.com.tintegro.dto.response.EliminaHorarioResponse;
import pe.com.tintegro.dto.response.InsertaHorarioResponse;
import pe.com.tintegro.dto.response.ListaHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdHorarioResponse;
import pe.com.tintegro.services.HorarioServices;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.UtilFile;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" } )
public class HorarioServicesTest
{
	@Autowired
	HorarioServices	horarioServices;

	// @Test
	public void insertaHorarioTest()
	{
		try
		{
			InsertaHorarioRequest request = new InsertaHorarioRequest();
			request.setIdGrupoHor(1);
			request.setHoInicio("11");
			request.setHoFin("21:00");
			request.setNomDiaSemanaInicio("Sabado");
			request.setNomDiaSemanaFin("Domingo");
			request.setNomDiaMesInicio("lunes enero");
			request.setNomDiaMesFin("Viernes Diciembre");
			request.setNomMesInicio("enero");
			request.setNomMesFin("Diciembre");
			request.setTiHorario(1);
		//	request.setNomAudio("url//audio/registro2");
      //  request.setBase64Audio(UtilFile.);
			InsertaHorarioResponse response = horarioServices.insertaHorario("192.168.3.202", "", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
			
		}
		catch ( Exception e )
		{
			// TODO: handle exception
			System.out.println("Error" + e.getMessage());
		}

	}

	// @Test
	public void editarHorarioTest()
	{
		try
		{
			EditaHorarioRequest request = new EditaHorarioRequest();
			request.setIdHorario(1);
			request.setIdGrupoHor(1);
			request.setHoInicio("12");
			request.setHoFin("22:00");
			request.setNomDiaSemanaInicio("miercoles");
			request.setNomDiaSemanaFin("viernes");
			request.setNomDiaMesInicio("enero");
			request.setNomDiaMesFin("febrero");
			request.setNomMesInicio("enero");
			request.setNomMesFin("Julio");
			request.setTiHorario(1);
			request.setNomAudio("url//audio/editado");

			EditaHorarioResponse response = horarioServices.editaHorario("192.168.3.202", "", request);
			System.out.println(response.getMensaje());
			System.out.println(response.getResultado());
		}
		catch ( Exception e )
		{
			// TODO: handle exception
			System.out.println("Error" + e.getMessage());
		}

	}

	// @Test
	public void eliminarHorarioTest()
	{
		try
		{
			EliminaHorarioRequest request = new EliminaHorarioRequest();
			request.setIdHorario(2);

			EliminaHorarioResponse response = horarioServices.eliminaHorario("192.168.3.202", "", request);
			System.out.println(response.getMensaje());
			System.out.println(response.getResultado());
		}
		catch ( Exception e )
		{
			// TODO: handle exception
			System.out.println("Error" + e.getMessage());
		}

	}

	//@Test
	public void listaHorarioTest()

	{
		try
		{
			ListaHorarioRequest request = new ListaHorarioRequest();

			ListaHorarioResponse response = horarioServices.listaHorario("192.168.3.202", "", request);
			for (Horario horario : response.getListaHorario())
			{
				System.out.println(horario.getHoInicio() + " " + horario.getHoFin() + " " + horario.getNomDiaSemanaInicio() + " " + horario.getNomDiaSemanaFin());
			}
		}
		catch ( Exception e )
		{
			// TODO: handle exception
		}
	}

//	@Test
	public void listaPorIdHorarioTest()
	{
		try
		{
			ListaPorIdHorarioRequest request = new ListaPorIdHorarioRequest();
			request.setIdHorario(2);

			ListaPorIdHorarioResponse response = horarioServices.listaPorIdHorario("192.168.3.202", "", request);
			for (Horario horario : response.getListaPorIdHorario())
			{
				System.out.println(horario.getHoInicio() + " " + horario.getHoFin() + " " + horario.getNomDiaSemanaInicio() + " " + horario.getNomDiaSemanaFin());
			}
		}
		catch ( Exception e )
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void obtieneAudioDeServidorTest()
	{
		try
		{
			String fileBase64 = horarioServices.obtieneAudioDeServidor( "cli", "L3hv4Sm0Vro=", "essalud-tarma.wav" );
			System.out.println( fileBase64 );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
