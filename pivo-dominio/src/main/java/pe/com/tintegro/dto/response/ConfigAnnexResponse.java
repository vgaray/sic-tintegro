package pe.com.tintegro.dto.response;

public class ConfigAnnexResponse extends ResponseBase
{
	private String	linkProvisioning;
	private String	nameFile;
	private String	fileProvisioningBase64;

	public String getNameFile()
	{
		return nameFile;
	}

	public void setNameFile( String nameFile )
	{
		this.nameFile = nameFile;
	}

	public String getLinkProvisioning()
	{
		return linkProvisioning;
	}

	public void setLinkProvisioning( String linkProvisioning )
	{
		this.linkProvisioning = linkProvisioning;
	}

	public String getFileProvisioningBase64()
	{
		return fileProvisioningBase64;
	}

	public void setFileProvisioningBase64( String fileProvisioningBase64 )
	{
		this.fileProvisioningBase64 = fileProvisioningBase64;
	}
}
