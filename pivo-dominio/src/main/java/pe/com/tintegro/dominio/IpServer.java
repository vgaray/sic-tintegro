package pe.com.tintegro.dominio;

import java.io.Serializable;

public class IpServer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String noIpServer;

	public String getNoIpServer() {
		return noIpServer;
	}
	public void setNoIpServer(String noIpServer) {
		this.noIpServer = noIpServer;
	}
	
}
