package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;

public interface RankingLlamadasDAO{
	public RankingLlamadasResponse listarRankingLlamadas (String ip, RankingLlamadasRequest request) throws Exception;
	public RankingLlamadasResponse listarReporteRankingLlamadas (String ip, RankingLlamadasRequest request) throws Exception;
}
