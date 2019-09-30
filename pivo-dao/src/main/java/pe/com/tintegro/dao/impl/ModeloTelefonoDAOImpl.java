package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.ModeloTelefonoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;

@Repository("modeloTelefonoDAO")
public class ModeloTelefonoDAOImpl implements ModeloTelefonoDAO {

	@Override
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarca(String ip, ListaModeloTelefonoPorMarcaRequest request) throws Exception {
		ListaModeloTelefonoPorMarcaResponse response = new ListaModeloTelefonoPorMarcaResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			/*
			 * Nombre del funcion que devuelve lista de todas las marcas de
			 * telefono
			 */
			String storedProcedureName = "asterisk.fn_lista_todo_modelo";

			/* Parametros */
			Object[][] params = { { request.getMarcaId(), Integer.class } };

			/* Mapeamos para mostrar los campos */
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_modelo", "modeloId");
			mapColumnToAttributte.put("no_modelo", "nomModelo");
			mapColumnToAttributte.put("id_marca", "marcaId");

			Response<ModeloTelefono> responseT = BaseDao.baseData(storedProcedureName, params, db.con, ModeloTelefono.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setModeloTelefonoList(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}
}