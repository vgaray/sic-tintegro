package pe.com.tintegro.dao.impl;

import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.BashDAO;
import pe.com.tintegro.dominio.Bash;
import pe.com.tintegro.mapper.BashMapper;

@Repository("bashDAO")
public class BashDAOImpl extends DAOTintegroImpl implements BashDAO {
	@Override
	public Bash loadBashById(Integer idBash) throws Exception {
		Bash bash = new Bash();
		BashMapper mapper = this.getSqlSessionSic().getMapper(BashMapper.class);
		bash = mapper.loadBashById(idBash).get(0);
		return bash;
	}
}
