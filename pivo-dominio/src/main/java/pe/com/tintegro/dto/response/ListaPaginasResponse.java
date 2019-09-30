package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Pagina;

public class ListaPaginasResponse extends ResponseBase
{
	private List<Pagina> paginas;

	public List<Pagina> getPaginas()
	{
		return paginas;
	}

	public void setPaginas(List<Pagina> paginas)
	{
		this.paginas = paginas;
	}
}
