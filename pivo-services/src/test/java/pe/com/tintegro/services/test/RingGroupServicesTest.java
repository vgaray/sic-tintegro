package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.RingGroup;
import pe.com.tintegro.dto.request.ActualizarRingGroupRequest;
import pe.com.tintegro.dto.request.EliminarRingGroupRequest;
import pe.com.tintegro.dto.request.InsertarRingGroupRequest;
import pe.com.tintegro.dto.request.ListaRingGroupRequest;
import pe.com.tintegro.dto.request.ListarRingGroupxAnexoRequest;
import pe.com.tintegro.dto.request.ListarVerificacionRingGroupRequest;
import pe.com.tintegro.dto.response.ActualizarRingGroupResponse;
import pe.com.tintegro.dto.response.EliminarRingGroupResponse;
import pe.com.tintegro.dto.response.InsertarRingGroupResponse;
import pe.com.tintegro.dto.response.ListaRingGroupResponse;
import pe.com.tintegro.dto.response.ListarRingGroupxAnexoResponse;
import pe.com.tintegro.dto.response.ListarVerificacionRingGroupResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.RingGroupServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class RingGroupServicesTest
{
	@Autowired
	InstanciaServices instanciaServices;

	@Autowired
	RingGroupServices ringServices;

	@Ignore
	@Test
	public void testListaRingServices()
	{
		ListaRingGroupRequest request = new ListaRingGroupRequest();
		request.setIdGrupo(null);
		try
		{
			ListaRingGroupResponse response = new ListaRingGroupResponse();
			response = ringServices.listaGroupServices("cli", "jPfFl7Jg2rg=", request);
			List<RingGroup> rings = new ArrayList<RingGroup>();

			rings = response.getListRingGroup();

			for (RingGroup ringGroup : rings)
			{
				System.out.println(ringGroup.getNoGrupo() + "---" + ringGroup.getNuGrupo() + "---" + ringGroup.getNuAnexos());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testInsertaRingServices()
	{
		InsertarRingGroupRequest request = new InsertarRingGroupRequest();
		request.setNoGrupo("A5");
		request.setNuGrupo(89891);
		List<String> idSips = new ArrayList<String>();
		idSips.add("1238");

		request.setNuSips(idSips);
		try
		{
			InsertarRingGroupResponse response = new InsertarRingGroupResponse();
			response = ringServices.insertarRingGroupServices("cli", "jPfFl7Jg2rg=", request);
			System.out.println("Estado: "+response.getEstado());
			System.out.println("Sub Estado Error: "+response.getValResult());
			System.out.println("Mensaje: "+response.getMensaje());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//@Ignore
	@Test
	public void testActualizaRingServices()
	{
		ActualizarRingGroupRequest request = new ActualizarRingGroupRequest();
		request.setIdGrupo(104);
		request.setNoGrupo("A3");
		request.setNuGrupo(1);
		request.setIlActivo(true);
		List<String> idSips = new ArrayList<String>();
		idSips.add("1040");
		idSips.add("1006");
		idSips.add("1007");
		request.setNuSips(idSips);

		try
		{
			ActualizarRingGroupResponse response = new ActualizarRingGroupResponse();
			response = ringServices.actualizarRingGroupServices("cli", "jPfFl7Jg2rg=", request);
			
			System.out.println("Estado:"+response.getIdRasultEstado());
			System.out.println("Mensaje :"+response.getMensaje());
			
			/*
			   --- 1 no esta repetido y se realizo la actualizacion
				--- 2 el nombre y numero del grupo esta repetido
				--- 3 el numero del grupo esta repetido
				--- 4 el nombre del grupo esta repetido
			 */

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void testEliminarRingServices()
	{
		EliminarRingGroupRequest request = new EliminarRingGroupRequest();
		request.setpIdGrupo(34);
		try
		{
			EliminarRingGroupResponse response = new EliminarRingGroupResponse();
			response = ringServices.eliminarRingGroupServices("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
 
	@Ignore
	@Test
	public void testValidacionRingGroupServices(){
		ListarVerificacionRingGroupRequest request = new ListarVerificacionRingGroupRequest();
		request.setpNoGrupo(null);
		request.setpNuGrupo(8909);
		try
		{
			ListarVerificacionRingGroupResponse response = new ListarVerificacionRingGroupResponse();
			response = ringServices.verificacionRingGroup("cli", "jPfFl7Jg2rg=", request);
			List<RingGroup> rings = new ArrayList<RingGroup>();

			rings = response.getListRingGroup();

			for (RingGroup ringGroup : rings)
			{
				System.out.println("Numero de Grupo: "+ringGroup.getMensaje()+
										 "\nCodigo: "+ringGroup.getIdRasult() );
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}

	@Ignore
	@Test
	public void testFiltroRingServices()
	{
		ListarRingGroupxAnexoRequest request = new ListarRingGroupxAnexoRequest();
		request.setpAnexos("1007,1003");
		try
		{
			ListarRingGroupxAnexoResponse response = new ListarRingGroupxAnexoResponse();
			response = ringServices.filtroRingGroupServices("cli", "jPfFl7Jg2rg=", request);
			List<RingGroup> rings = new ArrayList<RingGroup>();

			rings = response.getListRingGroup();

			for (RingGroup ringGroup : rings)
			{
				System.out.println("Indice: "+ringGroup.getIndice()+" Nombre: "+ringGroup.getNoGrupo()+
						" Numero: "+ringGroup.getNuGrupo()+" Anexo: "+ringGroup.getNuAnexos()+
						" Cantidad: "+ringGroup.getCantidadAnexo());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
