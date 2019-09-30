package pe.com.tintegro.dto.request;

//import org.apache.ibatis.annotations.Param;

public class ListaInstanciaRequest extends RequestBase
{
	
	private Integer pIdTipdoc;
	private String pNuDocide;
	private Integer pIdCliente;
	private Integer pIdPedido;
	private Integer pIdEstadoinstancia;
	private Integer pIdPlan;
	private Integer pIdTipoEstadoPedido;
	private Integer pIdInstanciaxDesc;
	private String pIdInstanciax;
	private Integer pIdUsuario;
	private String pNoLogin; 
	
	

	public String getpIdInstanciax()
	{
		return pIdInstanciax;
	}

	public void setpIdInstanciax(String pIdInstanciax)
	{
		this.pIdInstanciax = pIdInstanciax;
	}

	
	
	public Integer getpIdInstanciaxDesc()
	{
		return pIdInstanciaxDesc;
	}

	public void setpIdInstanciaxDesc(Integer pIdInstanciaxDesc)
	{
		this.pIdInstanciaxDesc = pIdInstanciaxDesc;
	}

	public Integer getpIdUsuario()
	{
		return pIdUsuario;
	}

	public void setpIdUsuario(Integer pIdUsuario)
	{
		this.pIdUsuario = pIdUsuario;
	}

	public String getpNoLogin()
	{
		return pNoLogin;
	}

	public void setpNoLogin(String pNoLogin)
	{
		this.pNoLogin = pNoLogin;
	} 

	public Integer getpIdTipdoc()
	{
		return pIdTipdoc;
	}

	public void setpIdTipdoc(Integer pIdTipdoc)
	{
		this.pIdTipdoc = pIdTipdoc;
	}

	public String getpNuDocide()
	{
		return pNuDocide;
	}

	public void setpNuDocide(String pNuDocide)
	{
		this.pNuDocide = pNuDocide;
	}

	public Integer getpIdCliente()
	{
		return pIdCliente;
	}

	public void setpIdCliente(Integer pIdCliente)
	{
		this.pIdCliente = pIdCliente;
	}

	public Integer getpIdPedido()
	{
		return pIdPedido;
	}

	public void setpIdPedido(Integer pIdPedido)
	{
		this.pIdPedido = pIdPedido;
	}

	public Integer getpIdEstadoinstancia()
	{
		return pIdEstadoinstancia;
	}

	public void setpIdEstadoinstancia(Integer pIdEstadoinstancia)
	{
		this.pIdEstadoinstancia = pIdEstadoinstancia;
	}

	public Integer getpIdPlan()
	{
		return pIdPlan;
	}

	public void setpIdPlan(Integer pIdPlan)
	{
		this.pIdPlan = pIdPlan;
	}

	public Integer getpIdTipoEstadoPedido()
	{
		return pIdTipoEstadoPedido;
	}

	public void setpIdTipoEstadoPedido(Integer pIdTipoEstadoPedido)
	{
		this.pIdTipoEstadoPedido = pIdTipoEstadoPedido;
	}

}
