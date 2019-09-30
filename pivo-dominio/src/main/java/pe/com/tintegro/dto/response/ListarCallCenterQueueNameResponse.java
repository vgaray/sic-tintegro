package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadasFechas;

public class ListarCallCenterQueueNameResponse extends ResponseBase{
	
	private List<LlamadasAtendidasAbandonadasFechas> lsQueueName;

	public List<LlamadasAtendidasAbandonadasFechas> getLsQueueName() {
		return lsQueueName;
	}

	public void setLsQueueName(List<LlamadasAtendidasAbandonadasFechas> lsQueueName) {
		this.lsQueueName = lsQueueName;
	}
}
