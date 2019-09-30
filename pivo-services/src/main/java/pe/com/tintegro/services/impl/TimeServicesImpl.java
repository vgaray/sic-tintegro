package pe.com.tintegro.services.impl;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.services.TimeServices;
@Service("TimeServices")
@Transactional
public class TimeServicesImpl implements TimeServices{

	@Override
	//@CachePut(value = "second")
	@Cacheable("generalCache")
	public LocalDateTime fechaActual() {
		// TODO Auto-generated method stub
	
		return LocalDateTime.now();
	}

}
