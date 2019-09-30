package pe.com.tintegro.dao.impl;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.SeguridadDAO;
import pe.com.tintegro.dominio.*;
import pe.com.tintegro.mapper.SeguridadMapper;

@Repository("seguridadDAO")
@Transactional
public class SeguridadDAOImpl extends DAOTintegroImpl implements SeguridadDAO {
	@Override
	public List<Confirmacion> validarAccesoAServicio(String noLogin, String webServiceURL, boolean flEnviaInstancia) throws Exception {
		List<Confirmacion> confirmacionList = new ArrayList<>();

		SeguridadMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.SeguridadMapper.class);
		confirmacionList = mapper.validarAccesoAServicio(noLogin, webServiceURL, flEnviaInstancia);

		return confirmacionList;
	}

	@Override
	public List<Confirmacion> validarAccesoAInstancia(String noLogin, Integer idInstancia) throws Exception {
		List<Confirmacion> confirmacionList = new ArrayList<>();

		SeguridadMapper mapper = getSqlSessionSic().getMapper(SeguridadMapper.class);
		confirmacionList = mapper.validarAccesoAInstancia(noLogin, idInstancia);

		return confirmacionList;
	}
}
