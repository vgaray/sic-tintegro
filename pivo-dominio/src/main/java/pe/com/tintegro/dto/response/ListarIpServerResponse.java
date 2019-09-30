package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.IpServer;

public class ListarIpServerResponse extends ResponseBase{

	private List<IpServer> ipServerLis;

	public List<IpServer> getIpServerLis() {
		return ipServerLis;
	}

	public void setIpServerLis(List<IpServer> ipServerLis) {
		this.ipServerLis = ipServerLis;
	}
}
