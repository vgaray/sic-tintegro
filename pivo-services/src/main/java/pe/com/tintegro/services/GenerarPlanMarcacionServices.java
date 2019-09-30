package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.PlanPrincipal;
import pe.com.tintegro.dominio.PlanSaliente;

public interface GenerarPlanMarcacionServices
{
	public String generarTxtPlanMarcacion(String codUsuario,String idInstancia)throws Exception;
	public String writePlanMarcacion(String codUsuario,String idInstancia,List<PlanSaliente> listadoSaliente,List<PlanPrincipal> listadoPrincipal)throws Exception;	
}
