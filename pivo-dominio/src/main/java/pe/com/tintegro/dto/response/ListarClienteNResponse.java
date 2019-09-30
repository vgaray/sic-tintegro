package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ClienteN;

public class ListarClienteNResponse extends ResponseBase{

	private List<ClienteN> lsClientesN;
	
	public List<ClienteN> getLsClientesN() {
		return lsClientesN;
	}

	public void setLsClientesN(List<ClienteN> lsClientesN) {
		this.lsClientesN = lsClientesN;
	}


}
