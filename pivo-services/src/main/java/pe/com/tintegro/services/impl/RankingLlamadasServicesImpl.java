package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.RankingLlamadasDAO;
import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.RankingLlamadasServices;
import pe.com.tintegro.services.transformers.TransformerReporteRankingLlamadas;
import pe.com.tintegro.services.util.Util;

@Service("rankingLlamadasServices")
@Transactional
public class RankingLlamadasServicesImpl implements RankingLlamadasServices {

	@Resource(name = "rankingLlamadasDAO")
	protected RankingLlamadasDAO rankingLlamadasDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public RankingLlamadasResponse listarReporteRankingLlamadas(String codUsuario, String idInstancia, RankingLlamadasRequest request) throws Exception {
		RankingLlamadasResponse response = new RankingLlamadasResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = rankingLlamadasDAO.listarReporteRankingLlamadas(ip, request);
		return response;
	}

	@Override
	public RankingLlamadasResponse listarRankingLlamadas(String codUsuario, String idInstancia, RankingLlamadasRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		RankingLlamadasResponse response = rankingLlamadasDAO.listarRankingLlamadas(ip, request);
		if (response.getListRanking().size() > 0) {
			int total = response.getListRanking().get(0).getTotal();
			response.setTotal(total);
			int cantidadPaginas = Util.determinarNroPaginas(total, request.getCantidadxPag());
			//
			TransformerReporteRankingLlamadas obj = new TransformerReporteRankingLlamadas();
			obj.getTipo(request.getpIdOrden());
			Graficos graf = obj.transformerTo(response.getListRanking());
			response.setGraficoRanking(graf);
			//
			response.setCantidadPaginas(cantidadPaginas);
		}
		return response;
	}
}
