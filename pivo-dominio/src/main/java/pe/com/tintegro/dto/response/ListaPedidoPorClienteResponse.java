package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.PedidoPorCliente;

public class ListaPedidoPorClienteResponse extends ResponseBase 
{
	private List<PedidoPorCliente>  pedidoxClienteList;
 
public List<PedidoPorCliente> getPedidoxClienteList()
{
	return pedidoxClienteList;
}

public void setPedidoxClienteList(List<PedidoPorCliente> pedidoxClienteList)
{
	this.pedidoxClienteList = pedidoxClienteList;
}


  
  
}
