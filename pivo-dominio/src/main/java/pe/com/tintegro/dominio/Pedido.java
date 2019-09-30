package pe.com.tintegro.dominio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Pedido implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6898575652647072308L;
	private Integer idPedido;
	private String dePedido;
	private String coPedido;
	private String fePedido;
	private Integer idCliente;
	private Integer idEstadPedido;
	private String estadoPedido;
	private Integer idTipoPedido;
	private String tiPedido;
	private Integer idPlan;
	private String plan;
	private String tipoDetalle;
	private Integer idTipoDetalle;
    private List<DetallePedido> destallesList;
	
    
    
	
	public Integer getIdTipoDetalle() {
		return idTipoDetalle;
	}
	public void setIdTipoDetalle(Integer idTipoDetalle) {
		this.idTipoDetalle = idTipoDetalle;
	}
	public Integer getIdTipoPedido() {
		return idTipoPedido;
	}
	public void setIdTipoPedido(Integer idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}
	public Integer getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}
	public String getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getTiPedido() {
		return tiPedido;
	}
	public void setTiPedido(String tiPedido) {
		this.tiPedido = tiPedido;
	}
	public String getDePedido() {
		return dePedido;
	}
	public void setDePedido(String dePedido) {
		this.dePedido = dePedido;
	}
	public String getCoPedido() {
		return coPedido;
	}
	public void setCoPedido(String coPedido) {
		this.coPedido = coPedido;
	}
	public Integer getIdPedido()
	{
		return idPedido;
	}
	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}
	
	String DATE_FORMAT = "dd/MM/yyyy";
    // Create object of SimpleDateFormat and pass the desired date format.
    
    
	public String getFePedido() throws ParseException
	{
		String s;
		s = fePedido;
		String fFechAnterior="yyyy-MM-dd";
		String fFechaActual="dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(fFechAnterior);
		Date d = sdf.parse(s);
		sdf.applyPattern(fFechaActual);
		String fechaTrans = sdf.format(d);
		return fechaTrans;
	}

	public void setFePedido(String fePedido)
	{
		this.fePedido = fePedido;
	}

	public Integer getIdCliente()
	{
		return idCliente;
	}

	public void setIdCliente(Integer idCliente)
	{
		this.idCliente = idCliente;
	}

	public List<DetallePedido> getDestallesList()
	{
		return destallesList;
	}

	public void setDestallesList(List<DetallePedido> destallesList)
	{
		this.destallesList = destallesList;
	}

	public Integer getIdEstadPedido()
	{
		return idEstadPedido;
	}

	public void setIdEstadPedido(Integer idEstadPedido)
	{
		this.idEstadPedido = idEstadPedido;
	}

	public String getTipoDetalle()
	{
		return tipoDetalle;
	}
	
	public void setTipoDetalle(String tipoDetalle)
	{
		this.tipoDetalle = tipoDetalle;
	}

}
