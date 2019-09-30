package pe.com.tintegro.dto.request;

public class ListarCentroCostoxAreaRequest extends RequestBase
{
  public Integer tipOpera;
  public Integer idEmpare;
  public String pNoArea;
  public String pNoCentroCosto;

public String getpNoArea() {
	return pNoArea;
}


public void setpNoArea(String pNoArea) {
	this.pNoArea = pNoArea;
}


public String getpNoCentroCosto() {
	return pNoCentroCosto;
}


public void setpNoCentroCosto(String pNoCentroCosto) {
	this.pNoCentroCosto = pNoCentroCosto;
}


public Integer getTipOpera()
{
	return tipOpera;
}


public void setTipOpera(Integer tipOpera)
{
	this.tipOpera = tipOpera;
}

public Integer getIdEmpare()
{
	return idEmpare;
}

public void setIdEmpare(Integer idEmpare)
{
	this.idEmpare = idEmpare;
}

}
