package pe.com.tintegro.dto.response;
import java.util.List;

import pe.com.tintegro.dominio.Grabacion;
public class GrabacionResponse extends ResponseBase {
	private List<Grabacion> lsAudioA;
	public List<Grabacion> getLsAudioA() {
		return lsAudioA;
	}
	public void setLsAudioA(List<Grabacion> lsAudioA) {
		this.lsAudioA = lsAudioA;
	}
}
