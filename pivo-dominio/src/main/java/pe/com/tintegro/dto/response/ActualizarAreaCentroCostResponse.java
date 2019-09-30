package pe.com.tintegro.dto.response;


public class ActualizarAreaCentroCostResponse extends ResponseBase  {
private int actualizado;
private String validar;

public String getValidar()
{
	return validar;
}

public void setValidar(String validar)
{
	this.validar = validar;
}


public int getActualizado() {
	return actualizado;
}

public void setActualizado(int actualizado) {
	this.actualizado = actualizado;
}


}
