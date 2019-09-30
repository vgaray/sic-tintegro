package pe.com.tintegro.dto.response;


public class InsertaTbPinResponse extends  ResponseBase {

	private int insertado;
  
	public InsertaTbPinResponse() {
		
		// TODO Auto-generated constructor stub
	}
	public InsertaTbPinResponse(int insertado) {
		super();
		this.insertado = insertado;
	}
	
	public int getInsertado() {
		return insertado;
	}

	public void setInsertado(int insertado) {
		this.insertado = insertado;
	}

	
	
	
	
}
