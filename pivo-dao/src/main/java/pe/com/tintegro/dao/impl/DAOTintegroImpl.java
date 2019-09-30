package pe.com.tintegro.dao.impl;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import pe.com.tintegro.dao.DAOTintegro;

public class DAOTintegroImpl implements DAOTintegro {

	@Resource(name = "sqlSessionSic")
	protected SqlSession sqlSessionSic;

	@Override
	public SqlSession getSqlSessionSic() {
		return sqlSessionSic;
	}

	public void setSqlSessionSid(SqlSession sqlSessionSic) {
		this.sqlSessionSic = sqlSessionSic;
	}
}
