package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;

public interface RankingLlamadasServices {
	public RankingLlamadasResponse listarRankingLlamadas(String codUsuario,String idInstancia, RankingLlamadasRequest request)  throws Exception;
	public RankingLlamadasResponse listarReporteRankingLlamadas(String codUsuario,String idInstancia, RankingLlamadasRequest request)  throws Exception;
		}

