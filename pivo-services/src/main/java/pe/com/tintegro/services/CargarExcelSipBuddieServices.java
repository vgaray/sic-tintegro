package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.CargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.DescargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.CargaExcelSipBuddieResponse;
import pe.com.tintegro.dto.response.DescargaSipTelefonoResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.dto.response.ValidaExcelResponse;

public interface CargarExcelSipBuddieServices
{
	public InsertaSipBuddieResponse cargarSipBuddieList(String codUsuario, String idInstancia, List< InsertaSipBuddieRequest > ListSipBuddie) throws Exception;

	public CargaExcelSipBuddieResponse cargarExcelSipBuddie(String codUsuario, String idInstancia, CargaExcelSipBuddieRequest request) throws Exception;

	public DescargaSipTelefonoResponse descargaSipTelefono(String codUsuario, String idInstancia, DescargaExcelSipBuddieRequest request) throws Exception;

	public ValidaExcelResponse validarExcelSipTelefono(String fileStringBase64) throws Exception;

	public ValidaExcelResponse validaCantidadAnexos(List<SipTelefono> lsSIPTelefonoActual, List< InsertaSipBuddieRequest > listaSip, String codUsuario, String idInstancia) throws Exception;
}
