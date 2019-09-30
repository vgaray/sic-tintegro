package pe.com.tintegro.dto.response;

public class DescargaSipTelefonoResponse extends ResponseBase
{
	private String reporteFile;

	public String getReporteFile()
	{
		return reporteFile;
	}

	public void setReporteFile(String reporteFile)
	{
		this.reporteFile = reporteFile;
	}
}
