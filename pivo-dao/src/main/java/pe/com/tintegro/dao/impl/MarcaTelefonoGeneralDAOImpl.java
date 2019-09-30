package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.MarcaTelefonoGeneralDAO;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dto.request.ListaMarcaTelefonoRequest;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;
import pe.com.tintegro.mapper.MarcaTelefonoGeneralMapper;


@Repository("marcaTelefonoGeneralDAO")
public class MarcaTelefonoGeneralDAOImpl extends DAOTintegroImpl implements MarcaTelefonoGeneralDAO {

	@Override
	public ListaMarcaTelefonoResponse listaMarcaTelefonoGeneral(ListaMarcaTelefonoRequest request) throws Exception {
		// TODO Auto-generated method stub
		List<MarcaTelefono> listMarca = new ArrayList<MarcaTelefono>();
		ListaMarcaTelefonoResponse response = new ListaMarcaTelefonoResponse();
		MarcaTelefonoGeneralMapper marcaTelMapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.MarcaTelefonoGeneralMapper.class);
		listMarca = marcaTelMapper.listaMarcaTelefonoGeneral();
		response.setMarcaTelefonoList(listMarca);
		return response;
	}

}
