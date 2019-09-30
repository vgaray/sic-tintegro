package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.GrupoHorarioDAO;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GrupoHorarioDAOTest
{
	@Autowired
	GrupoHorarioDAO grupoHorarioDAO;

	// @Test
	public void agregarGrupoHorarioTest()
	{
		try
		{
			InsertaGrupoHorarioRequest request = new InsertaGrupoHorarioRequest();

			request.setNomGrupoHor("prueba");
			InsertaGrupoHorarioResponse response = grupoHorarioDAO.insertaGrupoHorario("192.168.3.202", request);

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
			EditaGrupoHorarioResponse response = grupoHorarioDAO.editaGrupoHorario("192.168.3.202", request);

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
			EliminaGrupoHorarioResponse response = grupoHorarioDAO.eliminaGrupoHorario("192.168.3.202", request);

			System.out.println("resusltado" + response.getResultado());
		}
		catch (Exception ex)
		{
			System.out.println("error" + ex.getMessage());
		}
	}

	// @Test
	public void listaGrupoHorarioTest()
	{
		try
		{
			ListaHorariosLibresRequest request = new ListaHorariosLibresRequest();

			ListaGrupoHorarioResponse response = grupoHorarioDAO.listaGrupoHorario("192.168.3.202", request);
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

	@Test
	public void listaPorIdGrupoHorarioTest()
	{
		try
		{
			ListaPorIdGrupoHorarioRequest request = new ListaPorIdGrupoHorarioRequest();
			request.setIdGrupoHor(1);
			ListaPorIdGrupoHorarioResponse response = grupoHorarioDAO.listaPorIdGrupoHorario("192.168.3.202", request);
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
