package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.IaxTrunk;

public class ViewCodeIaxTrunkResponse extends ResponseBase
{

	private List<IaxTrunk> viewCodeIaxTrunk;

	public List<IaxTrunk> getViewCodeIaxTrunk()
	{
		return viewCodeIaxTrunk;
	}

	public void setViewCodeIaxTrunk(List<IaxTrunk> viewCodeIaxTrunk)
	{
		this.viewCodeIaxTrunk = viewCodeIaxTrunk;
	}

}
