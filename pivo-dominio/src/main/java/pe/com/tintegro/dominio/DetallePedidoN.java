package pe.com.tintegro.dominio;

public class DetallePedidoN {
	private Integer idDetallePedido;
	private String noDetallePedido;
	private Integer idPlan;
	
	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	public String getNoDetallePedido() {
		return noDetallePedido;
	}

	public void setNoDetallePedido(String noDetallePedido) {
		this.noDetallePedido = noDetallePedido;
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}
}
