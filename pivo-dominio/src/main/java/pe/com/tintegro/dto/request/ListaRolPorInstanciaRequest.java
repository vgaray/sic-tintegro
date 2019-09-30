package pe.com.tintegro.dto.request;

public class ListaRolPorInstanciaRequest extends RequestBase
{
   private String idInstancia;
   private Integer idInstanciaDeco;
   
	public String getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}
   
	public Integer getIdInstanciaDeco()
	{
		return idInstanciaDeco;
	}
	
	public void setIdInstanciaDeco(Integer idInstanciaDeco)
	{
		this.idInstanciaDeco = idInstanciaDeco;
	}
   
}
