package pe.com.tintegro.dto.response;

import java.util.ArrayList;


public class ListaExtensionResponse extends ResponseBase {



	private ArrayList<pe.com.tintegro.dominio.Extension> extensionList;

	public ArrayList<pe.com.tintegro.dominio.Extension> getExtensionList() {
		return extensionList;
	}

	public void setExtensionList(
			ArrayList<pe.com.tintegro.dominio.Extension> extensionList) {
		this.extensionList = extensionList;
	}

	
	
}
