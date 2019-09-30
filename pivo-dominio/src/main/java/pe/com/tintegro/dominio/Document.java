package pe.com.tintegro.dominio;

import java.io.Serializable;

public class Document implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String file64;
	private String extensionFile;
	public String getFile64() {
		return file64;
	}
	public void setFile64(String file64) {
		this.file64 = file64;
	}
	public String getExtensionFile() {
		return extensionFile;
	}
	public void setExtensionFile(String extensionFile) {
		this.extensionFile = extensionFile;
	}
	
}
