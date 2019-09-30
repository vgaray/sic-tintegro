package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.Mascota;

public class RegistrarMascotaRequest extends RequestBase{
	
	private Mascota mascota;

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
}
