package pe.com.tintegro.dto.request;

public class ListaControlRolEstadoRequest
{
private String noLogin;
private Integer tiElemto;
private Integer idEstadoelemento;

public String getNoLogin()
{
	return noLogin;
}
public void setNoLogin(String noLogin)
{
	this.noLogin = noLogin;
}
public Integer getTiElemto()
{
	return tiElemto;
}
public void setTiElemto(Integer tiElemto)
{
	this.tiElemto = tiElemto;
}
public Integer getIdEstadoelemento()
{
	return idEstadoelemento;
}
public void setIdEstadoelemento(Integer idEstadoelemento)
{
	this.idEstadoelemento = idEstadoelemento;
}


}
