package pe.com.tintegro.dto.response;



public class InsertarAreaCentroCostResponse extends ResponseBase {
	 
	private int insertar;
	private String validar;

	public String getValidar()
	{
		return validar;
	}

	public void setValidar(String validar)
	{
		this.validar = validar;
	}

	public int getInsertar() {
		return insertar;
	}

	public void setInsertar(int insertar) {
		this.insertar = insertar;
	}


	 

}
