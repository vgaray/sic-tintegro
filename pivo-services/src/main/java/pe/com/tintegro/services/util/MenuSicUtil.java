package pe.com.tintegro.services.util;

import java.util.ArrayList;
import java.util.List;

import pe.com.tintegro.dominio.MenuSic;

public class MenuSicUtil
{
	  public List<MenuSic> procesarData(List<MenuSic> data){
			
			List<MenuSic> opcionList=data;
			List<MenuSic> opcionRelacionadoList=new ArrayList<MenuSic>();
			for(MenuSic opcion : opcionList){
				if(opcion.getIdPagPadre()==0){
					MenuSic encontrado=null;
					encontrado=buscarOpcionHijo(data,opcion.getIdPagina(), opcion);
					opcionRelacionadoList.add(encontrado);
				}
			}
			
			return opcionRelacionadoList;
		}
		
		public MenuSic buscarOpcionHijo(List<MenuSic> data,Integer idOpcionPadre, MenuSic opcionPadre){
			List<MenuSic> opcionList=data;
			
			for(MenuSic opcion : opcionList){
				if(opcion.getIdPagPadre()!=0){
					//System.out.println("Es "+opcion.getIdOpcionPadre()+" == "+idOpcionPadre+" ?");
					if(opcion.getIdPagPadre()!=0 && idOpcionPadre!=0){
						if(opcion.getIdPagPadre().equals(idOpcionPadre)){
							
							if(opcionPadre.getSubItem()==null)
							{opcionPadre.setSubItem(new ArrayList<MenuSic>());}
							opcionPadre.getSubItem().add(opcion);
							//System.out.println("El padre "+opcionPadre.getIdOpcion()+" ha agregado al hijo" + opcion.getIdOpcion());
							if(opcion != null)
							  {buscarOpcionHijo(data,opcion.getIdPagina(), opcion);}
							
						}
					 }
				}
			}
			
			return opcionPadre;
		}
	
}
