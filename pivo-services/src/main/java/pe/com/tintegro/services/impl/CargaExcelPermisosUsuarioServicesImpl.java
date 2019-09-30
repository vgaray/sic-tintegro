package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.TbUsuarioDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.TbUsuario;
import pe.com.tintegro.dto.request.ListaTbUsuarioRequest;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.services.CargaExcelPermisosUsuarioServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.TbUsuarioServices;
import pe.com.tintegro.services.util.EncriptaUtils;
import pe.com.tintegro.services.util.ExcelUtil;

@Service("cargaExcelPermisosUsuarioServices")
@Transactional
public class CargaExcelPermisosUsuarioServicesImpl implements CargaExcelPermisosUsuarioServices {
	@Autowired
	InstanciaServices instanciaServices;

	@Autowired
	TbUsuarioDAO tbUsuarioDAO;

	@Autowired
	TbUsuarioServices tbUsuarioServices;

	@Value(value = "classpath:csvExcel/listaPermisoLlamada.csv")
	private org.springframework.core.io.Resource csvReportePermisoLlamada;

	@Override
	public ListaTbUsuarioResponse DescargaExcelPermisosUsuario(String codUsuario, String idInstancia, ListaTbUsuarioRequest request) throws Exception {
		ListaTbUsuarioResponse response = new ListaTbUsuarioResponse();
		List<TbUsuario> permisoLlamadaList = new ArrayList<TbUsuario>();
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		permisoLlamadaList = tbUsuarioDAO.listaUsuario(vm.getIpAsterisk()).getListaUsuario();
		for (int i = 0; i < permisoLlamadaList.size(); i++) {
			if (permisoLlamadaList.get(i).getNuPin() != null) {
				permisoLlamadaList.get(i).setNuPin(EncriptaUtils.desencriptar(permisoLlamadaList.get(i).getNuPin()));
			}
		}
		String fileString = ExcelUtil.generarExcel(csvReportePermisoLlamada, permisoLlamadaList);
		response.setReporteFile(fileString);
		return response;
	}
}