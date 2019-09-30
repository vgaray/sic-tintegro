package pe.com.tintegro.dto.request;

public class ActualizarPasswordRequest extends RequestBase {
	
	private String pCodUsuario;
	private String pNewPassword;
	private boolean pConfirmacion;
	private String pToken;
	public String getpNewPassword() {
		return pNewPassword;
	}

	public void setpNewPassword(String pNewPassword) {
		this.pNewPassword = pNewPassword;
	}

	public String getpCodUsuario() {
		return pCodUsuario;
	}

	public void setpCodUsuario(String pCodUsuario) {
		this.pCodUsuario = pCodUsuario;
	}

	public boolean ispConfirmacion() {
		return pConfirmacion;
	}

	public void setpConfirmacion(boolean pConfirmacion) {
		this.pConfirmacion = pConfirmacion;
	}

	public String getpToken() {
		return pToken;
	}

	public void setpToken(String pToken) {
		this.pToken = pToken;
	}

}
