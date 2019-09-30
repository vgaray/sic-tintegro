package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.ClienteN;

public class ActualizarClienteNRequest extends RequestBase{
	private ClienteN clienteN;

	public ClienteN getClienteN() {
		return clienteN;
	}

	public void setClienteN(ClienteN clienteN) {
		this.clienteN = clienteN;
	}
}
