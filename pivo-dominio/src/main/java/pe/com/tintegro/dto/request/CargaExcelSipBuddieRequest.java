package pe.com.tintegro.dto.request;

public class CargaExcelSipBuddieRequest extends RequestBase {

	private String excelBase64;

	public String getExcelBase64() {
		return excelBase64;
	}

	public void setExcelBase64(String excelBase64) {
		this.excelBase64 = excelBase64;
	}
}
