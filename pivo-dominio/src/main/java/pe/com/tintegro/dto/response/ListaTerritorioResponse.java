package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.Territorio;
public class ListaTerritorioResponse extends ResponseBase{
private List<Territorio> territoriolist;

public List<Territorio> getTerritoriolist() {
	return territoriolist;
}

public void setTerritoriolist(List<Territorio> territoriolist) {
	this.territoriolist = territoriolist;
}
}
