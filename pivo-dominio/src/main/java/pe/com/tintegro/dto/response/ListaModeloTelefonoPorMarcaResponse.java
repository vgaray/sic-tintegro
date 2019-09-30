package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ModeloTelefono;

public class ListaModeloTelefonoPorMarcaResponse extends ResponseBase
{
	private List<ModeloTelefono> modeloTelefonoList;

	public List<ModeloTelefono> getModeloTelefonoList()
	{
		return modeloTelefonoList;
	}

	public void setModeloTelefonoList(List<ModeloTelefono> modeloTelefonoList)
	{
		this.modeloTelefonoList = modeloTelefonoList;
	}
}
