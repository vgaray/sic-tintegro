package pe.com.tintegro.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.services.TimeServices;

@RestController
@RequestMapping("/time")
public class TimeController {
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	//@Resource(name="TimeServices")
	//protected TimeServices timeServices;
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Cacheable("generalCache")
	public LocalDateTime fechaActual(@RequestHeader("codUsuario") String codUsuario,@RequestHeader("token") String token) {
		
		return LocalDateTime.now();

	}
}
