package pe.com.tintegro.dto.response;

public class InsertaTipTelClaveResponse extends ResponseBase
{
	private int insertado;
	
	public InsertaTipTelClaveResponse() {
		// TODO Auto-generated constructor stub
	}

	public InsertaTipTelClaveResponse(int insertado) {
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
