package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.MenuSic;

public class MenuSicResponse extends ResponseBase
{
 private List<MenuSic> menuLista;

public List<MenuSic> getMenuLista()
{
	return menuLista;
}

public void setMenuLista(List<MenuSic> menuLista)
{
	this.menuLista = menuLista;
}
 
 
 
}
