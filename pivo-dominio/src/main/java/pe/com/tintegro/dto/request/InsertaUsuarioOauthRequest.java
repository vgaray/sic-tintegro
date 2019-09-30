package pe.com.tintegro.dto.request;

public class InsertaUsuarioOauthRequest extends RequestAutentificator{
	private String pNologin; 
	private String pNoPassword ; 
	private String  pNoNombres ; 
	private String  pNoApellidos ; 
	private String  pNoEmail ; 
	private String  pNoProfe ; 
	
	public String getpNologin() {
		return pNologin;
	}
	public void setpNologin(String pNologin) {
		this.pNologin = pNologin;
	}
	public String getpNoPassword() {
		return pNoPassword;
	}
	public void setpNoPassword(String pNoPassword) {
		this.pNoPassword = pNoPassword;
	}
	public String getpNoNombres() {
		return pNoNombres;
	}
	public void setpNoNombres(String pNoNombres) {
		this.pNoNombres = pNoNombres;
	}
	public String getpNoApellidos() {
		return pNoApellidos;
	}
	public void setpNoApellidos(String pNoApellidos) {
		this.pNoApellidos = pNoApellidos;
	}
	public String getpNoEmail() {
		return pNoEmail;
	}
	public void setpNoEmail(String pNoEmail) {
		this.pNoEmail = pNoEmail;
	}
	public String getpNoProfe() {
		return pNoProfe;
	}
	public void setpNoProfe(String pNoProfe) {
		this.pNoProfe = pNoProfe;
	}	
}
