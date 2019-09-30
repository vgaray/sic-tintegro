package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.GrupoHorario;
import pe.com.tintegro.dto.request.EditaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.EliminaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.InsertaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaPorIdGrupoHorarioRequest;
import pe.com.tintegro.dto.response.EditaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.EliminaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.InsertaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdGrupoHorarioResponse;
import pe.com.tintegro.services.GrupoHorarioServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GrupoHorarioServicesTest
{
	@Autowired
	GrupoHorarioServices grupoHorarioServices;

	// @Test
	public void agregarGrupoHorarioTest()
	{
		try
		{
			InsertaGrupoHorarioRequest request = new InsertaGrupoHorarioRequest();

			request.setNomGrupoHor("prueba");
			InsertaGrupoHorarioResponse response = grupoHorarioServices.insertaGrupoHorario("192.168.3.202","", request);

			System.out.println("resultado" + response.getResultado());
		}
		catch (Exception ex)
		{
			System.out.println("error" + ex.getMessage());
		}
	}

	// @Test
	public void editarGrupoHorarioTest()
	{
		try
		{
			EditaGrupoHorarioRequest request = new EditaGrupoHorarioRequest();
			request.setIdGrupoHor(1);
			request.setNomGrupoHor("pruebita");
			EditaGrupoHorarioResponse response = grupoHorarioServices.editaGrupoHorario("192.168.3.202","", request);

			System.out.println("resusltado" + response.getResultado());
		}
		catch (Exception ex)
		{
			System.out.println("error" + ex.getMessage());
		}
	}

	// @Test
	public void eliminaGrupoHorarioTest()
	{
		try
		{
			EliminaGrupoHorarioRequest request = new EliminaGrupoHorarioRequest();
			request.setIdGrupoHor(2);
			EliminaGrupoHorarioResponse response = grupoHorarioServices.eliminaGrupoHorario("192.168.3.202","", request);

			System.out.println("resusltado" + response.getResultado());
		}
		catch (Exception ex)
		{
			System.out.println("error" + ex.getMessage());
		}
	}

	 @Test
	public void listaGrupoHorarioTest()
	{
		try
		{
			ListaHorariosLibresRequest request = new ListaHorariosLibresRequest();

			ListaGrupoHorarioResponse response = grupoHorarioServices.listaGrupoHorario("192.168.3.202",null, request);
			// GrupoHorario grupoHorario = new GrupoHorario();
			for (GrupoHorario grupoHorario : response.getListaGrupoHorario())
			{
				System.out.println(grupoHorario.getIdGrupoHor() + " " + grupoHorario.getNomGrupoHor());
			}

			// System.out.println(response);
		}
		catch (Exception ex)
		{
			System.out.println("error" + ex.getMessage());
		}
	}

//	@Test
	public void listaPorIdGrupoHorarioTest()
	{
		try
		{
			ListaPorIdGrupoHorarioRequest request = new ListaPorIdGrupoHorarioRequest();
			request.setIdGrupoHor(1);
			ListaPorIdGrupoHorarioResponse response = grupoHorarioServices.listaPorIdGrupoHorario("192.168.3.202","", request);
			// GrupoHorario grupoHorario = new GrupoHorario();
			for (GrupoHorario grupoHorario : response.getListaPorIdGrupoHorario())
			{
				System.out.println(grupoHorario.getIdGrupoHor() + " " + grupoHorario.getNomGrupoHor());
			}

			// System.out.println(response);
		}
		catch (Exception ex)
		{
			System.out.println("error" + ex.getMessage());
		}
	}
}
