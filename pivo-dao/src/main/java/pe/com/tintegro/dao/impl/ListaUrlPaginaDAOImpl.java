package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.ListaUrlPaginaDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;

import org.springframework.stereotype.Repository;

@Repository("listaUrlPagina")
public class ListaUrlPaginaDAOImpl implements ListaUrlPaginaDAO{

	@Override
	public ListaUrlPaginaResponse listaUrlPaginaResponse(String ip, ListaUrlPaginaRequest request) throws Exception {
		ListaUrlPaginaResponse response = new ListaUrlPaginaResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "oauth.sp_lista_url_instancia_menu";
			Object[][] params = {
					{request.getpNoComponente(),String.class}
			};
			Map<String,String> mapCol = new HashMap<String,String>();
			mapCol.put("id_pagina", "idPagina");
			mapCol.put("no_pagina", "noPagina");
			mapCol.put("no_componente", "noComponente");
			mapCol.put("no_url", "noUrl");
			mapCol.put("id_pag_padre", "idPadre");
			
			Response<Pagina> responseT = BaseDao.baseData(storedProcedureName, params, db.con, Pagina.class, mapCol);
			if(responseT.getCodigo() !=Constantes.ESTADO_TRAMA_OK){
				throw responseT.getException();
			}else{
				response.setMensaje(MensajeError.OK);
				response.setLsPaginaUrl(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		}finally{
			db.cerrar();
		}		
		return response;
	}

}
