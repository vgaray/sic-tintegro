package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Item;

public class ListaItemResponse extends ResponseBase
{
	private List< Item > lsItems;

	public List< Item > getLsItems()
	{
		return lsItems;
	}

	public void setLsItems(List< Item > lsItems)
	{
		this.lsItems = lsItems;
	}
}
