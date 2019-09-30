package pe.com.tintegro.dto.response;

public class PaginacionResponseBase extends ResponseBase{

	private int numerodePaginas;
    private int totalRegistros;
    
	public int getNumerodePaginas() {
		return numerodePaginas;
	}
	public void setNumerodePaginas(int numerodePaginas) {
		this.numerodePaginas = numerodePaginas;
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
    
    
}
